package me.flyray.crm.api;

import me.flyray.common.service.BaseService;
import me.flyray.crm.model.CustomerBilling;

/** 
* @author: bolei
* @date：Jul 9, 2017 11:17:47 AM 
* @description：客户账单处理
*/

public interface CustomerBillingService extends BaseService{

	void save(CustomerBilling customerBilling);
}
