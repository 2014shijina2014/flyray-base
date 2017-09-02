package me.flyray.cms.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.cms.api.ActivityService;
import me.flyray.cms.dao.ActivityDao;
import me.flyray.cms.model.Activity;

/**
 * 
 * @author centerroot
 * @time 创建时间:2017年8月26日下午3:44:31
 * @description : 活动信息逻辑处理服务
 */
@Service("activityService")
public class ActivityServiceImpl implements ActivityService{

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
	public List<Activity> selectRecommendActivity(Long orgId, Long merchantId) {
		return activityDao.selectRecommendActivity(orgId, merchantId);
	}

}
