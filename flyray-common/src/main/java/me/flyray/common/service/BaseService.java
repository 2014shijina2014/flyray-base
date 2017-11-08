package me.flyray.common.service;

import java.util.List;
import java.util.Map;

/** 
* @author: bolei
* @date：2017年4月16日 下午9:13:16 
* @description：类说明 
*/

public interface BaseService {

	List<Map<String, Object>> queryList(Map<String, Object> map);
	
	Map<String, Object> queryObject(Map<String, Object> map);
	
	Map<String, Object> queryById(Long id);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Map<String, Object> map);
	
	void update(Map<String, Object> map);
	
	void deleteBatch(List<Long> ids);
	
}
