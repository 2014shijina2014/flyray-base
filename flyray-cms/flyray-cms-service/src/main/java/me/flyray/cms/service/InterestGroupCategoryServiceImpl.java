package me.flyray.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.cms.api.InterestGroupCategoryService;
import me.flyray.cms.dao.InterestGroupCategoryDao;
import me.flyray.cms.dao.InterestGroupDao;
import me.flyray.cms.model.Activity;
import me.flyray.cms.model.InterestGroupCategory;

/**
 * 
 * @author centerroot
 * @time 创建时间:2017年8月26日下午3:44:11
 * @description : 兴趣小组类别信息逻辑处理服务
 */
@Service("interestGroupCategoryService")
public class InterestGroupCategoryServiceImpl implements InterestGroupCategoryService {

	@Autowired
	private InterestGroupCategoryDao interestGroupCategoryDao;
	/**
	 * 添加兴趣小组类别服务
	 * @author centerroot
	 * @time 创建时间:2017年8月26日下午3:45:49
	 * (non-Javadoc)
	 * @see me.flyray.cms.api.InterestGroupCategoryService#insert(me.flyray.cms.model.InterestGroupCategory)
	 */
	@Override
	public void insert(InterestGroupCategory groupCategory) {
		interestGroupCategoryDao.insert(groupCategory);
	}

	/**
	 * 更新兴趣小组类别记录
	 * @author centerroot
	 * @time 创建时间:2017年8月26日下午3:45:52
	 * (non-Javadoc)
	 * @see me.flyray.cms.api.InterestGroupCategoryService#updateById(me.flyray.cms.model.InterestGroupCategory)
	 */
	@Override
	public void updateById(InterestGroupCategory groupCategory) {
		interestGroupCategoryDao.update(groupCategory);
	}

	/**
	 * 根据输入字段作为条件查询兴趣小组类别列表
	 * @author centerroot
	 * @time 创建时间:2017年8月26日下午3:45:58
	 * (non-Javadoc)
	 * @see me.flyray.cms.api.InterestGroupCategoryService#selectByBizKeys(me.flyray.cms.model.InterestGroupCategory)
	 */
	@Override
	public List<InterestGroupCategory> selectByBizKeys(InterestGroupCategory groupCategory) {
		return interestGroupCategoryDao.selectByBizKeys(groupCategory);
	}

}
