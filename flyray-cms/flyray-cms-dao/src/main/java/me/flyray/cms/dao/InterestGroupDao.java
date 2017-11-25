package me.flyray.cms.dao;

import java.util.List;

import me.flyray.cms.model.Activity;
import me.flyray.cms.model.InterestGroup;
import me.flyray.common.dao.BaseDao;

/**
 * 
 * @author centerroot
 * @time 创建时间:2017年8月26日上午11:13:35
 * @description:兴趣小组数据操作类
 */

public interface InterestGroupDao extends BaseDao<InterestGroup>{

	public void insert(InterestGroup group);
	public List<InterestGroup> selectByBizKeys(InterestGroup interestGroup);
	
}
