package me.flyray.rest.controller.crm;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.flyray.crm.api.CustomerAccountService;
import me.flyray.crm.api.CustomerBillingService;
import me.flyray.crm.enums.BillingType;
import me.flyray.crm.model.CustomerAccount;
import me.flyray.crm.model.CustomerBilling;
import me.flyray.rest.util.ResponseHelper;

/** 
* @author: bolei
* @date：Jun 14, 2017 4:00:51 PM 
* @description：客户账户信息
*/

@Controller
@RequestMapping("/api/crm/customerAccount")
public class CustomerAccountController {

	@Autowired
	private CustomerAccountService customerAccountService;
	@Autowired
	private CustomerBillingService customerBillingService;
	
	
	/**
	 * 账户充值
	 * 包括积分、红包、余额
	 * recharge
	 */
	@ResponseBody
	@RequestMapping(value="/recharge", method = RequestMethod.POST)
	public Map<String, Object> recharge(@RequestBody Map<String, String> param) {
		
		//选择账户类型 和账户号
		String accountType = param.get("accountType");
		
		//根据账户类型 写账单表
		CustomerBilling customerBilling = new CustomerBilling();
		customerBilling.setBillingType(BillingType.RECHARGE.getCode());
		customerBillingService.save(customerBilling);
		
		
		//判断该账户是否存在 不存在则先开户
		CustomerAccount customerAccount =new CustomerAccount();
		customerAccount.setAccountType(accountType);
		String amt = param.get("amt");
		customerAccountService.deposit(customerAccount, amt);
		
		return ResponseHelper.success(null,null, "00", "请求数据成功");
	}
	
	/**
	 * 账户消费 提现
	 * 包括积分、红包、余额
	 * consumer
	 */
	@ResponseBody
	@RequestMapping(value="/consumer", method = RequestMethod.POST)
	public Map<String, Object> consumer(@RequestBody Map<String, String> param) {
		//选择账户类型 和账户号
		String accountType = param.get("accountType");
		//判断该账户是否存在
		CustomerAccount customerAccount =new CustomerAccount();
		customerAccount.setAccountType(accountType);
		String amt = param.get("amt");
		customerAccountService.withdraw(customerAccount, amt);
		return ResponseHelper.success(null,null, "00", "请求数据成功");
	}
	
}
