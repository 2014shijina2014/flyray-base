package me.flyray.crm.api;

import java.util.Map;

import me.flyray.crm.model.MerchantAcount;

/** 
* @author: bolei
* @date：2017年3月25日 上午1:57:07 
* @description：商户账户处理
*/

public interface MerchantAccountService {
	
	/**
	 * 商户开户
	 * 成功返回账户号
	 * @param customerAccount
	 */
	public void openAccount(MerchantAcount merchantAcount);
	
	/**
	 * 商户入金
	 * @param customerAccount
	 */
	public void deposit(MerchantAcount merchantAcount);
	
	/**
	 * 商户出金
	 * @param customerAccount
	 */
	public void withdraw(MerchantAcount merchantAcount);
	
	/**
	 * 商户转账
	 * 转账给商户
	 * 转账给个人
	 * @param Map
	 */
	public void transfer(Map<String, Object> param);
}
