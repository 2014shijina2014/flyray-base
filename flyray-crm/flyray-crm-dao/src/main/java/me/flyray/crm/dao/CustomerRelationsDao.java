package me.flyray.crm.dao;

import java.util.List;
import java.util.Map;

import me.flyray.common.dao.BaseDao;
import me.flyray.crm.model.CustomerRelations;

/** 
* @author: bolei
* @date：Jul 9, 2017 3:21:07 PM 
* @description：三级分销关系
*/

public interface CustomerRelationsDao extends BaseDao<CustomerRelations>{

	List<CustomerRelations> queryByCustomerId(String customerId);

	int queryInviteeCount(Map<String, Object> queryMap);

	int queryTodayInvitedTotle(String customerId);

	int queryAllInvitedTotle(String customerId);

}
