package me.flyray.rest.controller.crm;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.zxing.WriterException;

import me.flyray.common.utils.ImageBase64;
import me.flyray.common.utils.ImageGeneralUtils;
import me.flyray.common.utils.ImageHelper;
import me.flyray.common.utils.QrCodeCreateUtil;
import me.flyray.crm.api.CustomerAccountService;
import me.flyray.crm.api.CustomerAuthService;
import me.flyray.crm.api.CustomerBaseService;
import me.flyray.crm.api.CustomerRelationsService;
import me.flyray.crm.api.CustomerRoleRelationsService;
import me.flyray.crm.api.CustomerRoleService;
import me.flyray.crm.api.WeixinCommonService;
import me.flyray.crm.enums.AccountType;
import me.flyray.crm.model.CustomerAccount;
import me.flyray.crm.model.CustomerBase;
import me.flyray.crm.model.CustomerRelations;
import me.flyray.rest.util.BeanUtil;
import me.flyray.rest.util.ResponseHelper;

/** 
* @author: bolei
* @date：Jun 14, 2017 7:23:31 AM 
* @description：客户信息
*/

@Controller
@RequestMapping("/api/crm/customer")
public class CustomerController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WeixinCommonService weixinCommonService;
	@Autowired
	private CustomerAuthService customerAuthService;
	@Autowired
	private CustomerRelationsService customerRelationsService;
	@Autowired
	private CustomerBaseService customerBaseService;
	@Autowired
	private CustomerAccountService customerAccountService;
	@Autowired
	private CustomerRoleService customerRoleService;
	@Autowired
	private CustomerRoleRelationsService customerRoleRelationsService;
	@Value("${rest_invite_imgPath}")
	private String imgPath;
	@Value("${rest_invite_imgHttpPath}")
	private String imgHttpPath;
	@Value("${fontPath}")
	private String fontPath;
	
	
	/**
	 * 查询客户信息
	 * 包括客户账户信息
	 * query
	 */
	@ResponseBody
	@RequestMapping(value="/query", method = RequestMethod.POST)
	public Map<String, Object> queryCustomerInfo(@RequestBody Map<String, String> param){
		logger.info("查询客户信息------start------{}",param);
		Map<String, Object> resultMap = new HashMap<>();
		String customerId = param.get("customerId");
		//查询客户基本信息
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("id", customerId);
		Map<String, Object> customerBaseMap = customerBaseService.queryObject(queryMap);
		resultMap.put("customerBase", customerBaseMap);
		//查询客户授权信息
		queryMap.put("customerId", customerId);
		Map<String, Object> customerAuthMap = customerAuthService.queryObject(queryMap);
		resultMap.put("customerAuth", customerAuthMap);
		//查询客户账户信息
		queryMap.put("accountType", AccountType.POINTS.getCode());
		Map<String, Object> customerAccountMap = customerAccountService.queryObject(queryMap);
		resultMap.put("customerAccount", customerAccountMap);
		//客户角色
		Map<String, Object> queryRoleRltMap = new HashMap<String, Object>();
		queryRoleRltMap.put("orgId", param.get("orgId"));
		queryRoleRltMap.put("merchantId", param.get("merchantId"));
		queryRoleRltMap.put("customerId", param.get("customerId"));
		Map<String, Object> resultRoleRlt = customerRoleRelationsService.queryObject(queryRoleRltMap);
		if (null != resultRoleRlt) {
			Map<String, Object> queryRoleMap = new HashMap<String, Object>();
			queryRoleMap.put("id", resultRoleRlt.get("customerRoleId"));
			Map<String, Object> customerRoleMap = customerRoleService.queryObject(queryRoleMap);
			resultMap.put("customerRole", customerRoleMap);
		}
		//查询改用户邀请的人数
		int todayInvitedTotle = customerRelationsService.queryTodayInvitedTotle(customerId);
		int allInvitedTotle = customerRelationsService.queryAllInvitedTotle(customerId);
		
		resultMap.put("todayInvitedTotle", String.valueOf(todayInvitedTotle));
		resultMap.put("allInvitedTotle", String.valueOf(allInvitedTotle));
		logger.info("查询客户信息------end------{}",resultMap);
		return ResponseHelper.success(resultMap,null, "00", "查询成功");
	}
	
	/**
	 * 生成客户邀请码
	 * 邀请码是一个带有会员编号的url链接
	 * 暂时将图片base64保存在数据库
	 * Invite QR Code
	 */
	@ResponseBody
	@RequestMapping(value="/createInviteQrCode", method = RequestMethod.POST)
	public Map<String, Object> createInvieQrCode(@RequestBody Map<String, String> param){
		logger.info("查询客户信息------end------{}",param);
		String customerId = param.get("customerId");
		String imgNo = param.get("imgNo");
		Map<String, Object> resultMap = new HashMap<>();
		OutputStream outputStream;
		//二维码地址
		String qrImgFile = imgPath+ File.separator + customerId+".jpg";
		//String qrImgFile = "F:/assets/test/"+customerId+".jpg";
		try {
			File qrImgF = new File(qrImgFile);
			if (!qrImgF.getParentFile().exists()) {
				qrImgF.setWritable(true, false);
				qrImgF.getParentFile().mkdirs();
        	}
			outputStream = new FileOutputStream(qrImgF);
			//测试
			String redirect_uri = "http://qingwei.flyray.me/api/cms/me/inviteGetWxCode/"+customerId;
			StringBuilder content = new StringBuilder("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx0f6fa56da5e7fb62&redirect_uri="+redirect_uri+"&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect");
			//StringBuilder content = new StringBuilder("http://192.168.2.106:3000/api/cms/me/inviteGetWxCode？inviter=124935467304235008&code=32323");
			QrCodeCreateUtil.createQrCode(outputStream,content.toString(),1600,"JPEG");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*Map<String, Object> sendParam = new HashMap<>();
		sendParam.put("openId", "o-rSJ08RGemk_BQH1PBi1kzOcSnA");
		sendParam.put("templateId", "u_WXJy7zqkUfCpJQ9-H8FfRzCymdzYO9Cuv-MIWd688");
		sendParam.put("url", "http://qingwei.flyray.me/#/");
		sendParam.put("openId", "o-rSJ08RGemk_BQH1PBi1kzOcSnA");
		List<Map<String, Object>> listData = new ArrayList<>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("keyword1", "322323");
		dataMap.put("keyword2", "322323");
		dataMap.put("keyword3", "haode");
		listData.add(dataMap);
		sendParam.put("listData", listData);
		weixinCommonService.sendWxMpMessage(sendParam);*/
		
		ImageGeneralUtils tt = new ImageGeneralUtils();
		//此处随机取一张图片
		imgNo = imgNo != null ? imgNo : "1";
        BufferedImage d = tt.loadImageLocal(imgPath + File.separator + "invite" + File.separator +imgNo+".jpg");  
        //往图片上写文件 
        logger.info("查询客户基本信息------start------");
        Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("id", param.get("customerId"));
		Map<String, Object> customerBaseMap = customerBaseService.queryObject(queryMap);
		logger.info("查询客户基本信息------start------{}",customerBaseMap);
		String avatar = (String)customerBaseMap.get("avatar");
		//将头像下载到本地
        BufferedImage bf = tt.loadImageUrl(avatar);
        String avatarPath = imgPath + File.separator + "avatar" + customerId + ".png" ;  
		tt.writeImageLocal(avatarPath,bf);
		//压缩后的头像地址
		String scaleAvatar = imgPath+ File.separator + "scale-avatar"+customerId+".jpg";
		ImageHelper.scaleImage(avatarPath, scaleAvatar, 0.2, "JPEG");
		//将头像写入卡片上
		BufferedImage avatarB = tt.loadImageLocal(scaleAvatar);
		String avatarPlusImg = imgPath+ File.separator +"resul-"+customerId+".jpg";
        tt.writeImageLocal(avatarPlusImg, tt.modifyImagetogeter(avatarB, d, 300, 70)); 
        //将昵称写入卡片上
		BufferedImage avatarPlusB = tt.loadImageLocal(avatarPlusImg);
        String imgAndStr = imgPath+ File.separator +"imgAndStr-"+customerId+".jpg";
	    tt.writeImageLocal(imgAndStr,tt.modifyImage(avatarPlusB,customerBaseMap.get("nickname"),260,250,fontPath));
	    BufferedImage b = tt.loadImageLocal(imgAndStr);
	    //将生成的二维码图片压缩成所需比例
	    String scaleQrcode = imgPath+ File.separator + "scale-qrcode"+customerId+".jpg";
	    //源地址  改变大小后图片的地址 
	    ImageHelper.scaleImage(qrImgFile, scaleQrcode, 0.2, "JPEG");
	    BufferedImage c = tt.loadImageLocal(scaleQrcode);
        //将多张图片合在一起  
	    String resultImg = imgPath+ File.separator +"resul-"+customerId+".jpg";
        tt.writeImageLocal(resultImg, tt.modifyImagetogeter(c, b, 200, 450)); 
		String imgStr = ImageBase64.getImgStr(resultImg);
		logger.info("查询客户信息------end------{}",resultMap);
		resultMap.put("img", imgStr);
		return ResponseHelper.success(resultMap,null, "00", "生产邀请二维码成功");
	}
	
	/**
	 * 所邀请用户信息
	 * 所邀请的用户也需要微信授权登陆
	 * get Invited Customer
	 */
	@ResponseBody
	@RequestMapping(value="/invited", method = RequestMethod.POST)
	public Map<String, Object> invited(@RequestBody Map<String, String> param){
		//
		logger.info("通过code获取用户授权信息------start------{}",param);
		String code = param.get("code");
		//邀请人id
		String inviterId = param.get("inviter");
		String orgId = param.get("orgId");
		Map<String, Object> requestMap = new HashMap<>();
		requestMap.put("code", code);
		Map<String, Object> userMap = weixinCommonService.getOauthUserInfo(requestMap);
		logger.info("通过code获取用户授权信息------end------{}",userMap);
		if (userMap == null) {
			return ResponseHelper.success(userMap,null, "01", "调用微信授权失败");
		}
		//判断用户是否邀请过 如果customerAuth表中已存在该记录，则说明用户已经是会员或是被邀请过，给用户提示
		Map<String, Object> queryUserMap = new HashMap<String, Object>();
		queryUserMap.put("credential", userMap.get("openId"));
		Map<String, Object> customerAuth = customerAuthService.queryObject(queryUserMap);
		logger.info("查实该用户是否被邀请过------{}",customerAuth);
		logger.info("查实该用户是否被邀请过------{}",customerAuth != null);
		if (customerAuth != null ) {
			return ResponseHelper.success(customerAuth,null, "01", "用户已经是会员不能被重复邀请");
		}
		CustomerBase customerBase = customerAuthService.customerAuth(userMap);
		userMap.put("customerId", customerBase.getId());
		//将新用户与邀请人关联
		//判断邀请人属于哪级分销
		List<CustomerRelations> customerRelationses = customerRelationsService.queryByCustomerId(inviterId);
		//相等说明自己邀请自己
		if(inviterId == customerBase.getId()){
			return ResponseHelper.success(userMap,null, "00", "邀请成功");
		}
		int sz = customerRelationses.size();
		Date invitedTime = new Date();
		logger.info("邀请关系层级数------{}",sz);
		if (sz == 0) {
			//说明邀请人是顶级分销不是被邀请过的人 受要人是一级分销
			CustomerRelations invitedCustomer = new CustomerRelations();
			invitedCustomer.setWxId(orgId);
			invitedCustomer.setCustomerId(customerBase.getId());
			invitedCustomer.setFxLevel("1");
			invitedCustomer.setParentId(Long.valueOf(inviterId));
			invitedCustomer.setInvitedTime(invitedTime);
			customerRelationsService.insert(invitedCustomer);
		}else if(sz == 1) {
			//说明邀请人是一级分销 受邀人是二级分销需要写两条条记录
			CustomerRelations invitedCustomer = new CustomerRelations();
			invitedCustomer.setWxId(orgId);
			invitedCustomer.setCustomerId(customerBase.getId());
			invitedCustomer.setFxLevel("1");
			invitedCustomer.setParentId(Long.valueOf(inviterId));
			invitedCustomer.setInvitedTime(invitedTime);
			customerRelationsService.insert(invitedCustomer);
			//受邀人
			CustomerRelations ic = new CustomerRelations();
			ic.setWxId(orgId);
			ic.setCustomerId(customerBase.getId());
			ic.setFxLevel("2");
			ic.setParentId(Long.valueOf(inviterId));
			ic.setInvitedTime(invitedTime);
			customerRelationsService.insert(ic);
		}else if (sz == 2) {
			//说明邀请人是二级分销 受邀人是三级分销需要写三条条记录
			CustomerRelations invitedCustomer = new CustomerRelations();
			invitedCustomer.setWxId(orgId);
			invitedCustomer.setCustomerId(customerBase.getId());
			invitedCustomer.setFxLevel("1");
			invitedCustomer.setParentId(Long.valueOf(inviterId));
			invitedCustomer.setInvitedTime(invitedTime);
			customerRelationsService.insert(invitedCustomer);
			//查询出邀请人的parentId
			for (CustomerRelations customerRelations : customerRelationses) {
				Long parentId = customerRelations.getParentId();
				//判断邀请人的上级位于三级分销中第几级
				CustomerRelations ic = new CustomerRelations();
				ic.setWxId(orgId);
				if ("1" == customerRelations.getFxLevel()) {
					ic.setFxLevel("2");
				}else if ("2" == customerRelations.getFxLevel()) {
					ic.setFxLevel("3");
				}
				ic.setCustomerId(customerBase.getId());
				ic.setParentId(parentId);
				ic.setInvitedTime(invitedTime);
				customerRelationsService.insert(ic);
			}
		}else if (sz == 3) {
			//说明邀请人是三级分销 受邀人是邀请人的一级分销需要写一条记录
			CustomerRelations invitedCustomer = new CustomerRelations();
			invitedCustomer.setWxId(orgId);
			invitedCustomer.setCustomerId(customerBase.getId());
			invitedCustomer.setFxLevel("1");
			invitedCustomer.setParentId(Long.valueOf(inviterId));
			invitedCustomer.setInvitedTime(invitedTime);
			customerRelationsService.insert(invitedCustomer);
		}
		
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setAccountType(AccountType.POINTS.getCode());
		customerAccount.setCustomerId(inviterId);
		customerAccountService.deposit(customerAccount, "5");
		return ResponseHelper.success(userMap,null, "00", "邀请成功");
	}
	
	/**
	 * 查询客户邀请人数
	 */
	@ResponseBody
	@RequestMapping(value="/queryInviteeCount", method = RequestMethod.POST)
	public Map<String, Object> queryInviteeCount(@RequestBody Map<String, String> param){
		logger.info("查询客户邀请人数------start------{}",param);
		Map<String, Object> resultMap = new HashMap<>();
		//查询客户基本信息
		String customerId = param.get("customerId");
		Map<String, Object> queryAllMap = new HashMap<String, Object>();
		queryAllMap.put("customerId", customerId);
		int InviteeCount = customerRelationsService.queryInviteeCount(queryAllMap);
		Map<String, Object> queryMap = new HashMap<String, Object>();
		Date taday = new Date();
		SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd");  
		Date udate = null;
		System.out.println(fmt.format(taday));  
        try {
			udate = fmt.parse(fmt.format(taday));
		} catch (ParseException e) {
			e.printStackTrace();
		}   
		queryMap.put("startTime", udate);
		queryMap.put("endTime", udate);
		int todayInviteeCount = customerRelationsService.queryInviteeCount(queryMap);
		resultMap.put("inviteeCount", InviteeCount);
		resultMap.put("todayInviteeCount", todayInviteeCount);
		logger.info("查询客户邀请人数------end------{}",resultMap);
		return ResponseHelper.success(resultMap,null, "00", "查询成功");
	}
	
}
