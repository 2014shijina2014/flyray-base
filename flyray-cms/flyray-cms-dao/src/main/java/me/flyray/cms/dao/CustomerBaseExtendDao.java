package me.flyray.cms.dao;

import java.util.List;
import java.util.Map;

import me.flyray.cms.model.CustomerBaseExtend;

/** 
* @author: bolei
* @date：2017年3月7日 下午8:42:10 
* @description：类说明 
*/

public interface CustomerBaseExtendDao {

	public List<CustomerBaseExtend> queryAll();
	
	public List<CustomerBaseExtend> query(Map<String,Object> map);
	
	public CustomerBaseExtend findById(String id);
	
	public int insert(CustomerBaseExtend photoFile);
	
}
