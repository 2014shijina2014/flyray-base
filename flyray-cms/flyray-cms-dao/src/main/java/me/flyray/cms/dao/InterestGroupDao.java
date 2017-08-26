package me.flyray.cms.dao;

import java.util.List;

import me.flyray.cms.model.InterestGroup;

/**
 * 
 * @author centerroot
 * @time 创建时间:2017年8月26日上午11:13:35
 * @description:兴趣小组数据操作类
 */

public interface InterestGroupDao {

	public void insert(InterestGroup group);
	public void update(InterestGroup group);
	public List<InterestGroup> selectByBizKeys(InterestGroup group);
	
}
