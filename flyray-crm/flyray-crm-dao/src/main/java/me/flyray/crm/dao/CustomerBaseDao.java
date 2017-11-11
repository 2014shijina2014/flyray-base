package me.flyray.crm.dao;

import me.flyray.common.dao.BaseDao;
import me.flyray.crm.model.CustomerBaseExtend;
import me.flyray.crm.model.CustomerBase;

/** 
* @author: bolei
* @date：2017年3月12日 下午5:13:00 
* @description：客户基础信息
*/

public interface CustomerBaseDao extends BaseDao<CustomerBase>{
	void updateExtent(CustomerBaseExtend extent);
	void saveExtend(CustomerBaseExtend extent);
	void deleteBaseAndExtend(Long id);
	void delete(Long id);
	CustomerBase queryByCustomerId(String id);
	CustomerBase queryByCustomerNo(String customerNo);
}
