package me.flyray.rest.controller.crm;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
* @author: bolei
* @date：Jun 14, 2017 4:00:51 PM 
* @description：客户账户信息
*/

@Controller
@RequestMapping("/customerAccount")
public class CustomerAccountController {

	/**
	 * 账户充值
	 * 包括积分、红包、余额
	 * recharge
	 */
	@ResponseBody
	@RequestMapping(value="/recharge", method = RequestMethod.POST)
	public Map<String, Object> recharge(@RequestBody Map<String, String> param) {
		return null;
	}
	
	/**
	 * 账户消费
	 * 包括积分、红包、余额
	 * consumer
	 */
	@ResponseBody
	@RequestMapping(value="/consumer", method = RequestMethod.POST)
	public Map<String, Object> consumer(@RequestBody Map<String, String> param) {
		return null;
	}
	
	/**
	 * 账户金额冻结
	 * 包括积分、红包、余额
	 * Amount freeze
	 */
	@ResponseBody
	@RequestMapping(value="/amountFreeze", method = RequestMethod.POST)
	public Map<String, Object> amountFreeze(@RequestBody Map<String, String> param) {
		return null;
	}
	
}
