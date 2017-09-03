package me.flyray.cms.api;

import java.util.List;

import me.flyray.cms.model.Activity;

/** 
* @author: bolei
* @date：2017年3月15日 下午10:54:42 
* @description：活动服务接口
*/

public interface ActivityService {
	
	/**
	 * 添加活动服务
	 * @author centerroot
	 * @time 创建时间:2017年8月26日下午1:43:44
	 * @param activity
	 */
	public void insert(Activity activity);
	
	/**
	 * 更新活动记录信息
	 * @author centerroot
	 * @time 创建时间:2017年8月26日下午1:43:47
	 * @param activity
	 */
	public void updateById(Activity activity);
	
	/**
	 * 根据输入字段作为条件查询活动信息列表
	 * @author centerroot
	 * @time 创建时间:2017年8月26日下午1:43:50
	 * @param activity
	 * @return
	 */
	public List<Activity> selectByBizKeys(Activity activity);

}
