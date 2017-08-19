package me.flyray.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import me.flyray.common.service.AbstractBaseService;
import me.flyray.crm.api.CustomerRelationsService;
import me.flyray.crm.model.CustomerRelations;

/** 
* @author: bolei
* @date：Jul 9, 2017 2:12:55 PM 
* @description：类描述
*/

@Service("customerRelationsService")
public class CustomerRelationsServiceImpl extends AbstractBaseService<CustomerRelations> implements CustomerRelationsService{

	@Override
	public void save(CustomerRelations customerRelations) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CustomerRelations> queryByCustomerNo(String customerNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
