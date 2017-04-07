package me.flyray.crm.api;

import java.util.List;
import java.util.Map;

import me.flyray.crm.model.CustomerBase;

/** 
* @author: bolei
* @date：2017年3月12日 下午4:48:44 
* @description：客户基本信息
*/

public interface CustomerBaseService {

	CustomerBase queryObject(Long customerId);
	
	List<CustomerBase> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CustomerBase customerBase);
	
	void update(CustomerBase customerBase);
	
	void deleteBatch(Long[] customerIds);
}
