package me.flyray.rest.controller.crm;

import java.util.HashMap;
import java.util.List;
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
import me.flyray.crm.api.CustomerRelationsService;
import me.flyray.crm.api.WeixinCommonService;
import me.flyray.crm.model.CustomerBase;
import me.flyray.crm.model.CustomerRelations;
import me.flyray.rest.util.ResponseHelper;

/** 
* @author: bolei
* @date：Jun 14, 2017 7:23:31 AM 
* @description：客户信息
*/

@Controller
@RequestMapping("/customer")
public class CustomerController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WeixinCommonService weixinCommonService;
	@Autowired
	private CustomerAuthService customerAuthService;
	@Autowired
	private CustomerRelationsService customerRelationsService;
	
	/**
	 * 查询客户信息
	 * query
	 */
	@ResponseBody
	@RequestMapping(value="/queryCustomerInfo", method = RequestMethod.GET)
	public Map<String, Object> queryCustomerInfo(@RequestBody Map<String, String> param){
		
		//
		
		return null;
	}
	
	/**
	 * 生成客户邀请码
	 * 邀请码是一个带有会员编号的url链接
	 * Invite QR Code
	 */
	@ResponseBody
	@RequestMapping(value="/createInvieQrCode", method = RequestMethod.POST)
	public Map<String, Object> createInvieQrCode(@RequestBody Map<String, String> param){
		
		//
		
		return null;
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
		String merchantNo = param.get("merchantNo");
		String inviterNo = param.get("inviter");
		String orgNo = param.get("orgNo");
		Map<String, Object> requestMap = new HashMap<>();
		requestMap.put("code", code);
		requestMap.put("merchantNo", merchantNo);
		Map<String, Object> userMap = weixinCommonService.getOauthUserInfo(requestMap);
		logger.info("通过code获取用户授权信息------end------{}",userMap);
		if (userMap == null) {
			return ResponseHelper.success(userMap, "01", "调用微信授权失败");
		}
		
		/*wxMpUser.getCity() wxMpUser.getCountry()
		wxMpUser.getGroupId() wxMpUser.getHeadImgUrl() wxMpUser.getLanguage() wxMpUser.getNickname()
		wxMpUser.getOpenId() wxMpUser.getProvince() wxMpUser.getRemark() wxMpUser.getSex()
		wxMpUser.getSubscribe() wxMpUser.getTagIds() wxMpUser.getUnionId()*/
		
		CustomerBase customerBase = customerAuthService.customerAuth(userMap);
		userMap.put("customerNo", customerBase.getCustomerNo());
		//将新用户与邀请人关联
		//判断邀请人属于哪级分销
		List<CustomerRelations> customerRelationses = customerRelationsService.queryByCustomerNo(inviterNo);
		if (customerRelationses == null ) {
			//说明邀请人是顶级分销 受要人是一级分销
			CustomerRelations invitedCustomer = new CustomerRelations();
			invitedCustomer.setCustomerNo(customerBase.getCustomerNo());
			invitedCustomer.setFxLevel("1");
			invitedCustomer.setParentNo(inviterNo);
			customerRelationsService.save(invitedCustomer);
		}else {
			int sz = customerRelationses.size();
			if (sz == 1) {
				//说明客户是一级分销 受邀人是二级分销需要写两条条记录
				CustomerRelations invitedCustomer = new CustomerRelations();
				invitedCustomer.setCustomerNo(customerBase.getCustomerNo());
				invitedCustomer.setFxLevel("1");
				invitedCustomer.setParentNo(inviterNo);
				customerRelationsService.save(invitedCustomer);
				//受邀人
				CustomerRelations ic = new CustomerRelations();
				ic.setCustomerNo(customerBase.getCustomerNo());
				ic.setFxLevel("2");
				ic.setParentNo(inviterNo);
				customerRelationsService.save(invitedCustomer);
			}else if (sz == 2) {
				//说明客户是二级分销 受邀人是三级分销需要写三条条记录
				CustomerRelations invitedCustomer = new CustomerRelations();
				invitedCustomer.setCustomerNo(customerBase.getCustomerNo());
				invitedCustomer.setFxLevel("1");
				invitedCustomer.setParentNo(inviterNo);
				customerRelationsService.save(invitedCustomer);
				//查询出邀请人的parentId
				for (CustomerRelations customerRelations : customerRelationses) {
					String parentNo = customerRelations.getParentNo();
					//判断邀请人的上级位于三级分销中第几级
					CustomerRelations ic = new CustomerRelations();
					if ("1" == customerRelations.getFxLevel()) {
						ic.setFxLevel("2");
					}else if ("2" == customerRelations.getFxLevel()) {
						ic.setFxLevel("3");
					}
					ic.setCustomerNo(customerBase.getCustomerNo());
					ic.setParentNo(parentNo);
					customerRelationsService.save(invitedCustomer);
				}
			}else if (sz == 3) {
				//说明客户是三级分销 受邀人是邀请人的一级分销需要写一条记录
				CustomerRelations invitedCustomer = new CustomerRelations();
				invitedCustomer.setCustomerNo(customerBase.getCustomerNo());
				invitedCustomer.setFxLevel("1");
				invitedCustomer.setParentNo(inviterNo);
				customerRelationsService.save(invitedCustomer);
			}
		}
		return userMap;
	}
	
	
	
}
