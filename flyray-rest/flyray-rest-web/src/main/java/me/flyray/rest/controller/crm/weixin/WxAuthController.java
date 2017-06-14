package me.flyray.rest.controller.crm.weixin;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.flyray.crm.api.CustomerAuthService;
import me.flyray.crm.api.CustomerBaseService;
import me.flyray.crm.api.WeixinCommonService;
import me.flyray.crm.model.CustomerAuth;
import me.flyray.crm.model.CustomerBase;
import me.flyray.rest.util.ResponseHelper;
import me.flyray.rest.util.UUIDGenerator;

/** 
* @author: bolei
* @date：2017年3月11日 下午10:55:05 
* @description：微信授权
*/

@Controller
public class WxAuthController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WeixinCommonService weixinCommonService;
	@Autowired
	private CustomerAuthService customerAuthService;
	@Autowired
	private CustomerBaseService customerBaseService;
	
	/**
	 * 通过code获取用户授权信息
	 * 获取到微信授权重定向时的参数
	 * 同时建立微信openid与机构商户的关系
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/weixin/getWxUser", method = RequestMethod.POST)
	public Map<String, Object> getWxCode(@RequestBody Map<String, String> param) throws Exception {
		logger.info("通过code获取用户授权信息------start------{}",param);
		String code = param.get("code");
		String merchantNo = param.get("merchantNo");
		String orgNo = param.get("orgNo");
		Map<String, Object> requestMap = new HashMap<>();
		requestMap.put("code", code);
		requestMap.put("merchantNo", merchantNo);
		Map<String, Object> userMap = weixinCommonService.getOauthUserInfo(requestMap);
		logger.info("通过code获取用户授权信息------end------{}",userMap);
		if (userMap == null) {
			return ResponseHelper.success(userMap, "01", "调用微信授权是吧");
		}
		
		/*wxMpUser.getCity()
		wxMpUser.getCountry()
		wxMpUser.getGroupId()
		wxMpUser.getHeadImgUrl()
		wxMpUser.getLanguage()
		wxMpUser.getNickname()
		wxMpUser.getOpenId()
		wxMpUser.getProvince()
		wxMpUser.getRemark()
		wxMpUser.getSex()
		wxMpUser.getSubscribe()
		wxMpUser.getTagIds()
		wxMpUser.getUnionId()*/
		
		//保存会员信息
		String customerNo = UUIDGenerator.getUUID();//商户号crc自校验数据 目的防止伪造造成脏数据
		CustomerBase customerBase = new CustomerBase();
		customerBase.setCustomerNo(customerNo);
		customerBase.setAddress(userMap.get("country")+"-"+userMap.get("province")+"-"+userMap.get("city"));
		customerBase.setAge((String)userMap.get("country"));
		customerBase.setAvatar((String)userMap.get("headImgUrl"));
		//customerBase.setBirthday((String)userMap.get("country"));
		//customerBase.setCustName((String)userMap.get("country"));
		customerBase.setNickname((String)userMap.get("nickname"));
		customerBase.setMerchantNo(merchantNo);
		customerBase.setOrgNo(orgNo);
		//customerBase.setPhone(phone);
		customerBase.setSex((String)userMap.get("sex"));
		customerBaseService.save(customerBase);
		
		//保存微信授权信息
		CustomerAuth customerAuth = new CustomerAuth();
		customerAuth.setCredential((String)userMap.get("openId"));		//密码凭证（站内的保存密码，站外的不保存或保存token）
		customerAuth.setCustomerNo(customerNo);		//客户（会员）编号
		customerAuth.setIdentifier((String)userMap.get("unionId"));		//标识（手机号 邮箱 用户名或第三方应用的唯一标识）
		customerAuth.setIdentityType("weixin");	//登录类型（手机号 邮箱 用户名）或第三方应用名称（微信 微博等）
		customerAuthService.save(customerAuth);
		userMap.put("customerNo", customerNo);
		return ResponseHelper.success(userMap, "00", "请求数据成功");
	} 
	
	
}
