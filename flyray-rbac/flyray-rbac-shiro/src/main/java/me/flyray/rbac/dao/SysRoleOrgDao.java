package me.flyray.rbac.dao;

import java.util.List;
import me.flyray.rbac.entity.SysRoleOrgEntity;

/**
 * 角色与组织机构对应关系
 * @author centerroot
 * @time 创建时间:2017年11月18日上午10:12:54
 * @description :
 */
public interface SysRoleOrgDao extends BaseDao<SysRoleOrgEntity> {
	
	List<Long> listOrgId(Long roleId);
	
	List<Long> listRoleId(Long orgId);
	
	int batchRemoveByOrgId(Long[] id);
	
	int batchRemoveByRoleId(Long[] id);
}
