package me.flyray.cms.dao;

import java.util.List;

import me.flyray.cms.model.InterestGroupCategory;

/**
 * 
 * @author centerroot
 * @time 创建时间:2017年8月26日下午3:00:19
 * @description : 类别数据操作类
 */
public interface InterestGroupCategoryDao {
	
	public void insert(InterestGroupCategory category);
	public void update(InterestGroupCategory category);
	public List<InterestGroupCategory> selectByBizKeys(InterestGroupCategory category);
	
}
