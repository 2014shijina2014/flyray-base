package me.flyray.crm.service;

import org.springframework.stereotype.Service;

import me.flyray.common.service.AbstractBaseService;
import me.flyray.crm.api.CustomerBillingService;
import me.flyray.crm.model.CustomerBilling;

/** 
* @author: bolei
* @date：Jul 9, 2017 11:19:09 AM 
* @description：客户账单处理
*/

@Service("customerBillingService")
public class CustomerBillingServiceImpl extends AbstractBaseService<CustomerBilling> implements CustomerBillingService{

	@Override
	public void save(CustomerBilling customerBilling) {
		// TODO Auto-generated method stub
	}

}
