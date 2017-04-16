package me.flyray.common.dao;

import java.util.List;
import java.util.Map;

/** 
* @author: bolei
* @date：2017年4月16日 下午9:34:37 
* @description：dao公共类
*/

public interface BaseDao<T> {

	T queryObject(T t);
	
	List<T> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	Map<String, Object> queryById(Long id);
	
	void save(T t);
	
	void update(T t);
	
	void deleteBatch(Long[] ids);
}
