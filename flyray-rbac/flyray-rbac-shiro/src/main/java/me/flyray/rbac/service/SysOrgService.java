package me.flyray.rbac.service;

import java.util.List;
import java.util.Map;

import me.flyray.rbac.entity.SysOrgEntity;

/** 
* @author: bolei
* @date：Jul 7, 2017 10:44:28 PM 
* @description：组织机构
*/

public interface SysOrgService {

	SysOrgEntity queryObject(Long orgId);
	
	List<SysOrgEntity> queryList(Map<String, Object> map);

	int save(SysOrgEntity sysOrg);
	
	void update(SysOrgEntity sysOrg);
	
	void delete(Long orgId);

	/**
	 * 查询子部门ID列表
	 * @param parentId  上级部门ID
	 */
	List<Long> queryOrgIdList(Long parentId);

	/**
	 * 获取子部门ID(包含本部门ID)，用于数据过滤
	 */
	String getSubOrgIdList(Long orgId);
}
