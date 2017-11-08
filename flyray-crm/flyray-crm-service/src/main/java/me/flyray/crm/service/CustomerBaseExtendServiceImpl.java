package me.flyray.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.common.service.AbstractBaseService;
import me.flyray.crm.api.CustomerBaseExtendService;
import me.flyray.crm.dao.CustomerAuthDao;
import me.flyray.crm.dao.CustomerBaseExtendDao;
import me.flyray.crm.model.CustomerBase;
import me.flyray.crm.model.CustomerBaseExtend;

/** 
* @author: bolei
* @date：2017年11月6日 下午4:22:41
* @description：类说明 
*/

@Service("customerBaseExtendService")
public class CustomerBaseExtendServiceImpl extends AbstractBaseService<CustomerBaseExtend> implements CustomerBaseExtendService{

	@Autowired
	private CustomerBaseExtendDao customerBaseExtendDao;
	
	@Override
	public void save(CustomerBaseExtend customerBaseExtend) {
		customerBaseExtendDao.save(customerBaseExtend);
	}

}
