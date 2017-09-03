package me.flyray.cms.dao;

import java.util.List;

import me.flyray.cms.model.Activity;

/** 
* @author: bolei
* @date：2017年3月7日 下午8:42:10 
* @description：类说明 
*/

public interface ActivityDao {

	public void insert(Activity activity);
	public void update(Activity activity);
	public List<Activity> selectByBizKeys(Activity activity);
	
}
