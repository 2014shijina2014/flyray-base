package me.flyray.crm.api;

import java.util.List;

import me.flyray.common.service.BaseService;
import me.flyray.crm.model.CustomerRelations;

/** 
* @author: bolei
* @date：Jul 9, 2017 2:11:06 PM 
* @description：客户三级分销关系
*/

public interface CustomerRelationsService extends BaseService{

	void save(CustomerRelations customerRelations);

	List<CustomerRelations> queryByCustomerNo(String customerNo);
}
