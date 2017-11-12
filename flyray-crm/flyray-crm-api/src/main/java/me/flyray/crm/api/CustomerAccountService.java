package me.flyray.crm.api;

import java.util.Map;

import me.flyray.common.service.BaseService;
import me.flyray.crm.model.CustomerAccount;

/** 
* @author: bolei
* @date：2017年3月25日 上午2:02:04 
* @description：个人账户处理
*/

public interface CustomerAccountService extends BaseService{
	
	/**
	 * 个人账户开户
	 * 成功返回账户号
	 * @param customerAccount
	 */
	public String openAccount(CustomerAccount customerAccount);
	
	/**
	 * 个人账户入金
	 * @param customerAccount
	 */
	public void deposit(CustomerAccount customerAccount,String amt);
	
	/**
	 * 个人账户出金
	 * @param customerAccount
	 */
	public void withdraw(CustomerAccount customerAccount,String amt);
	
	/**
	 * 个人转账
	 * 转账给商家
	 * 转账给个人
	 * @param Map
	 */
	public void transfer(Map<String, Object> param);

	public void save(CustomerAccount customerAccount);
	
}
