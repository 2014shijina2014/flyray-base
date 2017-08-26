package me.flyray.cms.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.cms.api.InterestGroupService;
import me.flyray.cms.dao.InterestGroupDao;
import me.flyray.cms.model.InterestGroup;

/**
 * 
 * @author centerroot
 * @time 创建时间:2017年8月26日下午3:44:23
 * @description : 兴趣小组信息逻辑处理服务
 */
@Service("interestGroupService")
public class InterestGroupServiceImpl implements InterestGroupService{

	@Autowired
	private InterestGroupDao interestGroupDao;
	/**
	 * 添加兴趣小组服务
	 * @author centerroot
	 * @time 创建时间:2017年8月26日下午1:47:29
	 * (non-Javadoc)
	 * @see me.flyray.cms.api.InterestGroupService#insert(me.flyray.cms.model.InterestGroup)
	 */
	@Override
	public void insert(InterestGroup group) {
		interestGroupDao.insert(group);
	}

	/**
	 * 更新兴趣小组记录
	 * @author centerroot
	 * @time 创建时间:2017年8月26日下午1:47:31
	 * (non-Javadoc)
	 * @see me.flyray.cms.api.InterestGroupService#updateById(me.flyray.cms.model.InterestGroup)
	 */
	@Override
	public void updateById(InterestGroup group) {
		interestGroupDao.update(group);
		
	}
	
	/**
	 * 根据输入字段作为条件查询兴趣小组列表
	 * @author centerroot
	 * @time 创建时间:2017年8月26日下午1:47:35
	 * (non-Javadoc)
	 * @see me.flyray.cms.api.InterestGroupService#selectByBizKeys(me.flyray.cms.model.InterestGroup)
	 */
	@Override
	public List<InterestGroup> selectByBizKeys(InterestGroup group) {
		return interestGroupDao.selectByBizKeys(group);
	}

}
