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

	List<Map<String, Object>> queryList(Map<String, Object> map);
	
	Map<String, Object> queryObject(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Map<String, Object> map);
	
	void update(Map<String, Object> map);
	
	void deleteBatch(Long[] ids);
}
