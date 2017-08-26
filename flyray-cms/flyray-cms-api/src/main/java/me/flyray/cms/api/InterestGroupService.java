package me.flyray.cms.api;

import java.util.List;

import me.flyray.cms.model.InterestGroup;

/**
 * 
 * @author centerroot
 * @time 创建时间:2017年8月26日下午1:36:14
 * @description:兴趣小组服务接口
 */

public interface InterestGroupService {
	
	/**
	 * 添加兴趣小组服务
	 * @author centerroot
	 * @time 创建时间:2017年8月26日下午1:41:30
	 * @param group
	 */
	public void insert(InterestGroup group);
	
	/**
	 * 更新兴趣小组记录
	 * @author centerroot
	 * @time 创建时间:2017年8月26日下午1:42:04
	 * @param group
	 */
	public void updateById(InterestGroup group);
	
	/**
	 * 根据输入字段作为条件查询兴趣小组列表
	 * @author centerroot
	 * @time 创建时间:2017年8月26日下午1:42:41
	 * @param group
	 * @return
	 */
	public List<InterestGroup> selectByBizKeys(InterestGroup group);

}
