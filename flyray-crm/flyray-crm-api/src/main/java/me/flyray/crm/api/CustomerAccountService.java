package me.flyray.crm.api;

import me.flyray.crm.model.CustomerAccount;

/** 
* @author: bolei
* @date：2017年3月25日 上午2:02:04 
* @description：个人账户处理
*/

public interface CustomerAccountService {
	
	/**
	 * 个人账户开户
	 * 成功返回账户号
	 * @param customerAccount
	 */
	public void openAccount(CustomerAccount customerAccount);
}
