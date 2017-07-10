package me.flyray.crm.dao;

import me.flyray.common.dao.BaseDao;
import me.flyray.crm.model.CustomerAccount;

/** 
* @author: bolei
* @date：Jul 9, 2017 9:09:21 AM 
* @description：客户账户信息
*/

public interface CustomerAccountDao extends BaseDao<CustomerAccount>{
	
	CustomerAccount queryByCustomerAccountNo(String CustomerAccountNo);
}
