package me.flyray.cms.api;

import java.util.List;

import me.flyray.cms.model.Activity;
import me.flyray.cms.model.InterestGroupCategory;

/**
 * 
 * @author centerroot
 * @time 创建时间:2017年8月26日下午3:41:11
 * @description :兴趣小组类别服务接口
 */

public interface InterestGroupCategoryService {
	
	/**
	 * 添加兴趣小组类别服务
	 * @author centerroot
	 * @time 创建时间:2017年8月26日下午3:42:04
	 * @param groupCategory
	 */
	public void insert(InterestGroupCategory groupCategory);
	
	/**
	 * 更新兴趣小组类别记录
	 * @author centerroot
	 * @time 创建时间:2017年8月26日下午3:42:09
	 * @param groupCategory
	 */
	public void updateById(InterestGroupCategory groupCategory);
	
	/**
	 * 根据输入字段作为条件查询兴趣小组类别列表
	 * @author centerroot
	 * @time 创建时间:2017年8月26日下午3:42:14
	 * @param groupCategory
	 * @return
	 */
	public List<InterestGroupCategory> selectByBizKeys(InterestGroupCategory groupCategory);

}
