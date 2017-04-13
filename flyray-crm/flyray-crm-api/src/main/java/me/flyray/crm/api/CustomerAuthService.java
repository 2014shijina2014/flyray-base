package me.flyray.crm.api;

import java.util.List;
import java.util.Map;

import me.flyray.crm.model.CustomerAuth;

/** 
* @author: bolei
* @date：2017年3月15日 下午10:57:30 
* @description：客户登录授权
*/

public interface CustomerAuthService {
	
	List<Map<String, Object>> queryList(Map<String, Object> map);
	
	Map<String, Object> queryObject(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Map<String, Object> map);
	
	void update(Map<String, Object> map);
	
	void deleteBatch(Long[] ids);

}
