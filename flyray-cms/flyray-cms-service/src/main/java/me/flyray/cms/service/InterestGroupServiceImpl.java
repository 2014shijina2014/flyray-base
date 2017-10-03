package me.flyray.cms.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.cms.api.InterestGroupService;
import me.flyray.cms.dao.InterestGroupDao;
import me.flyray.cms.model.InterestGroup;
import me.flyray.common.service.AbstractBaseService;

/**
 * 
 * @author centerroot
 * @time 创建时间:2017年8月26日下午3:44:23
 * @description : 兴趣小组信息逻辑处理服务
 */
@Service("interestGroupService")
public class InterestGroupServiceImpl extends AbstractBaseService<InterestGroup> implements InterestGroupService{

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
	@Override
	public List<InterestGroup> query(Map<String, Object> queryGroupMap) {
		return interestGroupDao.queryList(queryGroupMap);
	}
	
}
