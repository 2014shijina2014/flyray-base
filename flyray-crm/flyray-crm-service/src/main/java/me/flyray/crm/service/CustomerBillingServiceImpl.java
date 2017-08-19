package me.flyray.crm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.common.service.AbstractBaseService;
import me.flyray.crm.api.CustomerBillingService;
import me.flyray.crm.dao.CustomerBillingDao;
import me.flyray.crm.model.CustomerBilling;

/** 
* @author: bolei
* @date：Jul 9, 2017 11:19:09 AM 
* @description：客户账单处理
*/

@Service("customerBillingService")
public class CustomerBillingServiceImpl extends AbstractBaseService<CustomerBilling> implements CustomerBillingService{

private static final Logger logger = LoggerFactory.getLogger(CustomerBillingServiceImpl.class);
	
	@Autowired
	private CustomerBillingDao CustomerBillingDao;
	
	@Override
	public void save(CustomerBilling customerBilling) {
		// TODO Auto-generated method stub
	}

}
