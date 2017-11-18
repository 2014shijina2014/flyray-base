package me.flyray.rbac.service;

import java.util.List;

import me.flyray.rbac.entity.SysRoleOrgEntity;

/**
 * 角色机构对应关系
 * @author centerroot
 * @time 创建时间:2017年11月18日上午10:22:47
 * @description :
 */
public interface SysRoleOrgService {
	
	void saveOrUpdate(SysRoleOrgEntity sysRoleOrgEntity);
	
	/**
	 * 根据角色ID查询组织机构
	 * @author centerroot
	 * @time 创建时间:2017年11月18日上午10:31:25
	 * @param roleId
	 * @return
	 */
	List<Long> listOrgId(Long roleId);
	
	/**
	 * 根据组织机构查询角色
	 * @author centerroot
	 * @time 创建时间:2017年11月18日上午10:32:31
	 * @param orgId
	 * @return
	 */
	List<Long> listRoleId(Long orgId);
	
	/**
	 * 根据角色ID删除
	 * @author centerroot
	 * @time 创建时间:2017年11月18日上午10:33:33
	 * @param roleId
	 */
	void delete(Long roleId);
}
