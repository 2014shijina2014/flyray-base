package me.flyray.cms.dao;

import java.util.List;
import java.util.Map;

import me.flyray.cms.model.CustomerProficient;

/**
 * 
 * 专家信息
 * @author huo.xq
 *
 */
public interface CustomerProficientDao {

	
	CustomerProficient queryObject(Long customerId);
	
	List<CustomerProficient> queryList(Map<String, Object> map);
	
	List<CustomerProficient> query(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CustomerProficient customerProficient);
	
	void update(CustomerProficient customerProficient);
}
