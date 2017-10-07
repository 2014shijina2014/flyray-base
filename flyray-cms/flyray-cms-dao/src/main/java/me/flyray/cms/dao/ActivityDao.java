package me.flyray.cms.dao;

import java.util.List;
import java.util.Map;

import me.flyray.cms.model.Activity;
import me.flyray.common.dao.BaseDao;

/** 
* @author: bolei
* @date：2017年3月7日 下午8:42:10 
* @description：类说明 
*/

public interface ActivityDao extends BaseDao<Activity>{

	public void insert(Activity activity);
	public List<Activity> selectByBizKeys(Activity activity);
	public List<Activity> selectRecommendActivity(Map<String, Object> map);
	
	public int selectStartActTotal(Map<String, Object> map);
	public int selectEndActTotal(Map<String, Object> map);
	public int selectProcessActTotal(Map<String, Object> map);
	
	public List<Activity> selectStartActivity(Map<String, Object> map);
	public List<Activity> selectEndActivity(Map<String, Object> map);
	public List<Activity> selectProcessActivity(Map<String, Object> map);
}
