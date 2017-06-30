package me.flyray.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.common.service.AbstractBaseService;
import me.flyray.crm.api.CustomerAuthService;
import me.flyray.crm.dao.CustomerAuthDao;
import me.flyray.crm.model.CustomerAuth;

/** 
* @author: bolei
* @date：2017年4月6日 下午10:24:22 
* @description：类说明 
*/

@Service("customerAuthService")
public class CustomerAuthServiceImpl extends AbstractBaseService<CustomerAuth> implements CustomerAuthService{

	@Autowired
	private CustomerAuthDao customerAuthDao;

	@Override
	public void save(CustomerAuth customerAuth) {
		customerAuthDao.save(customerAuth);
	}
	
	
}
