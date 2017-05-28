package me.flyray.crm.api;

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
}
