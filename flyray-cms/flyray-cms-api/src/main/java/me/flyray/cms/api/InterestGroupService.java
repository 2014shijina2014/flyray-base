package me.flyray.cms.api;

import java.util.List;
import java.util.Map;

import me.flyray.cms.model.InterestGroup;
import me.flyray.common.service.BaseService;

/**
 * 
 * @author centerroot
 * @time 创建时间:2017年8月26日下午1:36:14
 * @description:兴趣小组服务接口
 */

public interface InterestGroupService extends BaseService{
	
	/**
	 * 添加兴趣小组服务
	 * @author centerroot
	 * @time 创建时间:2017年8月26日下午1:41:30
	 * @param group
	 */
	public void insert(InterestGroup group);

	public List<InterestGroup> query(Map<String, Object> queryGroupMap);
	
	public List<Map<String, Object>> selectByMapKey(Map<String, Object> map);
}
