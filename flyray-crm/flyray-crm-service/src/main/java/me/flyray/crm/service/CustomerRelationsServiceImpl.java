package me.flyray.crm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.common.service.AbstractBaseService;
import me.flyray.crm.api.CustomerRelationsService;
import me.flyray.crm.dao.CustomerBaseDao;
import me.flyray.crm.dao.CustomerRelationsDao;
import me.flyray.crm.model.CustomerRelations;

/** 
* @author: bolei
* @date：Jul 9, 2017 2:12:55 PM 
* @description：类描述
*/

@Service("customerRelationsService")
public class CustomerRelationsServiceImpl extends AbstractBaseService<CustomerRelations> implements CustomerRelationsService{

	@Autowired
	private CustomerRelationsDao customerRelationsDao;
	
	@Override
	public List<CustomerRelations> queryByCustomerId(String customerId) {
		return customerRelationsDao.queryByCustomerId(customerId);
	}

	@Override
	public void insert(CustomerRelations invitedCustomer) {
		customerRelationsDao.save(invitedCustomer);
	}

	@Override
	public int queryInviteeCount(Map<String, Object> queryMap) {
		return customerRelationsDao.queryInviteeCount(queryMap);
	}

	@Override
	public int queryTodayInvitedTotle(String parentId) {
		return customerRelationsDao.queryTodayInvitedTotle(parentId);
	}

	@Override
	public int queryAllInvitedTotle(String parentId) {
		return customerRelationsDao.queryAllInvitedTotle(parentId);
	}

}
