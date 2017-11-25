package me.flyray.cms.service;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.cms.api.ActivityService;
import me.flyray.cms.dao.ActivityDao;
import me.flyray.cms.model.Activity;
import me.flyray.common.service.AbstractBaseService;
import me.flyray.common.utils.BeanUtils;
import me.flyray.crm.api.CustomerBaseService;

/**
 * 
 * @author centerroot
 * @time 创建时间:2017年8月26日下午3:44:31
 * @description : 活动信息逻辑处理服务
 */
@Service("activityService")
public class ActivityServiceImpl extends AbstractBaseService<Activity> implements ActivityService{

	@Autowired
	private ActivityDao activityDao;
	/**
	 * 添加活动服务
	 * @author centerroot
	 * @time 创建时间:2017年8月26日下午1:47:15
	 * (non-Javadoc)
	 * @see me.flyray.cms.api.ActivityService#insert(me.flyray.cms.model.Activity)
	 */
	@Override
	public void insert(Activity activity) {
		activityDao.insert(activity);
	}

	/**
	 * 更新活动记录信息
	 * @author centerroot
	 * @time 创建时间:2017年8月26日下午1:47:20
	 * (non-Javadoc)
	 * @see me.flyray.cms.api.ActivityService#updateById(me.flyray.cms.model.Activity)
	 */
	@Override
	public void updateById(Activity activity) {
		activityDao.update(activity);
	}

	/**
	 * 根据输入字段作为条件查询活动信息列表
	 * @author centerroot
	 * @time 创建时间:2017年8月26日下午1:47:24
	 * (non-Javadoc)
	 * @see me.flyray.cms.api.ActivityService#selectByBizKeys(me.flyray.cms.model.Activity)
	 */
	@Override
	public List<Activity> selectByBizKeys(Activity activity) {
		return activityDao.selectByBizKeys(activity);
	}

	/**
	 * 根据机构号和商户号，查询商户下推荐活动列表
	 * @author centerroot
	 * @time 创建时间:2017年9月2日下午5:13:12
	 * (non-Javadoc)
	 * @see me.flyray.cms.api.ActivityService#selectRecommendActivity(java.lang.Long, java.lang.Long)
	 */
	@Override
	public List<Activity> selectRecommendActivity(Map<String, Object> map) {
		return activityDao.selectRecommendActivity(map);
	}

	/**
	 * 根据活动状态查询活动总条数
	 * @author centerroot
	 * @time 创建时间:2017年10月7日下午1:55:01
	 * (non-Javadoc)
	 * @see me.flyray.cms.api.ActivityService#queryGroupActTotal(java.util.Map)
	 */
	@Override
	public int queryGroupActTotal(Map<String, Object> map) {
		String actStatus = (String) map.get("actStatus");
		map.put("currentTime", new Timestamp(System.currentTimeMillis()));
		if ("1".equals(actStatus)) {
			return activityDao.selectStartActTotal(map);
		} else if ("2".equals(actStatus)) {
			return activityDao.selectProcessActTotal(map);
		} else if ("3".equals(actStatus)) {
			return activityDao.selectEndActTotal(map);
		} else {
			return 0;
		}
	}

	/**
	 * 根据活动状态查询活动列表
	 * 1、当前时间小于活动开始时间，属于可参加的活动
	 * 2、当前时间大于活动开始时间小于活动结束时间，属于活动进行中
	 * 3、当前时间大于活动结束时间，属于活动已结束
	 * @author centerroot
	 * @time 创建时间:2017年10月7日下午1:55:06
	 * (non-Javadoc)
	 * @see me.flyray.cms.api.ActivityService#queryGroupActList(java.util.Map)
	 */
	@Override
	public List<Activity> queryGroupActList(Map<String, Object> map) {
		String actStatus = (String) map.get("actStatus");
		map.put("currentTime", new Timestamp(System.currentTimeMillis()));
		if ("1".equals(actStatus)) {
			return activityDao.selectStartActivity(map);
		} else if ("2".equals(actStatus)) {
			return activityDao.selectProcessActivity(map);
		} else if ("3".equals(actStatus)) {
			return activityDao.selectEndActivity(map);
		} else {
			return null;
		}
	}

	/**
	 * 根据条件查询活动详情
	 * @author centerroot
	 * @time 创建时间:2017年10月7日下午5:14:08
	 * (non-Javadoc)
	 * @see me.flyray.cms.api.ActivityService#queryEntity(me.flyray.cms.model.Activity)
	 */
	@Override
	public Activity queryEntity(Activity activity) {
		return activityDao.queryEntity(activity);
	}

	@Override
	public List<Map<String, Object>> selectByMapKey(Map<String, Object> map) {
		List<Map<String, Object>> respList = new ArrayList<>();
		
		try {
			Activity activity = (Activity) BeanUtils.mapToObject(map, Activity.class);
			List<Activity> actList = activityDao.selectByBizKeys(activity);
			respList = (List<Map<String, Object>>) BeanUtils.objectToMap(actList) ;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return respList;
	}

}
