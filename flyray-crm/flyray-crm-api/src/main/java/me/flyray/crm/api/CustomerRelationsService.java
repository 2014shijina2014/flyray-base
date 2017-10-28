package me.flyray.crm.api;

import java.util.List;
import java.util.Map;

import me.flyray.common.service.BaseService;
import me.flyray.crm.model.CustomerRelations;

/** 
* @author: bolei
* @date：Jul 9, 2017 2:11:06 PM 
* @description：客户三级分销关系
*/

public interface CustomerRelationsService extends BaseService{

	List<CustomerRelations> queryByCustomerId(String customerId);

	void insert(CustomerRelations invitedCustomer);

	int queryInviteeCount(Map<String, Object> queryMap);
}
