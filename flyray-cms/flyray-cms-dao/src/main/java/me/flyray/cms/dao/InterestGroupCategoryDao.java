package me.flyray.cms.dao;

import me.flyray.cms.model.InterestGroupCategory;
import me.flyray.common.dao.BaseDao;

/**
 * 
 * @author centerroot
 * @time 创建时间:2017年8月26日下午3:00:19
 * @description : 类别数据操作类
 */
public interface InterestGroupCategoryDao extends BaseDao<InterestGroupCategory>{
		
	public void insert(InterestGroupCategory category);
	
}
