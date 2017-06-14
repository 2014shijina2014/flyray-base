package me.flyray.rest.controller.crm;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
* @author: bolei
* @date：Jun 14, 2017 7:23:31 AM 
* @description：客户信息
*/

@Controller
@RequestMapping("/customer")
public class CustomerController {

	/**
	 * 查询客户信息
	 * query
	 */
	
	/**
	 * 生成客户邀请码
	 * Invite QR Code
	 */
	@ResponseBody
	@RequestMapping(value="/createInvieQrCode", method = RequestMethod.POST)
	public Map<String, Object> createInvieQrCode(@RequestBody Map<String, String> param){
		
		return null;
	}
	
	/**
	 * 所邀请用户信息
	 * get Invited Customer
	 */
	
	
}
