package me.flyray.cms.api;

import java.util.List;
import java.util.Map;

import me.flyray.cms.model.InterestGroupCategory;
import me.flyray.common.service.BaseService;

/**
 * 
 * @author centerroot
 * @time 创建时间:2017年8月26日下午3:41:11
 * @description :兴趣小组类别服务接口
 */

public interface InterestGroupCategoryService extends BaseService{
	
	/**
	 * 添加兴趣小组类别服务
	 * @author centerroot
	 * @time 创建时间:2017年8月26日下午3:42:04
	 * @param groupCategory
	 */
	public void insert(InterestGroupCategory groupCategory);

	public List<InterestGroupCategory> query(Map<String, Object> queryMap);
	
}
