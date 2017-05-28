package me.flyray.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.flyray.crm.api.CustomerAccountService;
import me.flyray.crm.dao.CustomerAuthDao;
import me.flyray.crm.dao.CustomerBaseDao;
import me.flyray.crm.model.CustomerAccount;
import me.flyray.crm.model.CustomerAuth;
import me.flyray.crm.model.CustomerBase;

/** 
* @author: bolei
* @date：2017年4月15日 上午2:09:29 
* @description：类说明 
*/
@Service("customerAccountService")
public class CustomerAccountServiceImpl implements CustomerAccountService{

	@Autowired
	private CustomerAuthDao customerAuthDao;
	@Autowired
	private CustomerBaseDao customerBaseDao;
	
	@Override
	public void openAccount(CustomerAccount customerAccount) {
		// TODO Auto-generated method stub
		
		CustomerBase customerBase = new CustomerBase();
		customerBase.setAddress("333");
		customerBase.setAge("33");
		customerBaseDao.save(customerBase);
		
		CustomerAuth customerAuth = new CustomerAuth();
		customerAuth.setCredential("test");
		customerAuth.setCustomerNo("343");
		customerAuthDao.save(customerAuth);
	}

}
