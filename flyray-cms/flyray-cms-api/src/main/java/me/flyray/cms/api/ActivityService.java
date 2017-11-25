package me.flyray.cms.api;

import java.util.List;
import java.util.Map;

import me.flyray.cms.model.Activity;
import me.flyray.common.service.BaseService;

/** 
* @author: bolei
* @date：2017年3月15日 下午10:54:42 
* @description：活动服务接口
*/

public interface ActivityService extends BaseService{
	
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
	
	/**
	 * 根据机构号和商户号，查询商户下推荐活动列表
	 * @author centerroot
	 * @time 创建时间:2017年9月2日下午5:11:11
	 * @param map
	 * @return
	 */
	public List<Activity> selectRecommendActivity(Map<String, Object> map);
	
	/**
	 * 根据活动状态查询活动总条数
	 * @author centerroot
	 * @time 创建时间:2017年10月7日下午1:54:20
	 * @param map
	 * @return
	 */
	public int queryGroupActTotal(Map<String, Object> map);
	
	/**
	 * 根据活动状态查询活动列表
	 * @author centerroot
	 * @time 创建时间:2017年10月6日下午6:09:16
	 * @param map
	 * @return
	 */
	public List<Activity> queryGroupActList(Map<String, Object> map);
	
	/**
	 * 根据条件查询活动详细信息
	 * @author centerroot
	 * @time 创建时间:2017年10月7日下午5:13:19
	 * @param activity
	 * @return
	 */
	public Activity queryEntity(Activity activity);
	
	/**
	 * 
	 * @author centerroot
	 * @time 创建时间:2017年11月25日上午11:08:03
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> selectByMapKey(Map<String, Object> map);
}
