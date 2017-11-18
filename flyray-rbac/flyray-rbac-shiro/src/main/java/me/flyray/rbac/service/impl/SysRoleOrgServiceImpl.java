package me.flyray.rbac.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.rbac.dao.SysRoleOrgDao;
import me.flyray.rbac.entity.SysRoleOrgEntity;
import me.flyray.rbac.service.SysRoleOrgService;

/**
 * 角色机构对应关系
 * @author centerroot
 * @time 创建时间:2017年11月18日上午10:36:08
 * @description :
 */
@Service("sysRoleOrgService")
public class SysRoleOrgServiceImpl implements SysRoleOrgService {
	@Autowired
	private SysRoleOrgDao sysRoleOrgDao;
	
	@Override
	public void saveOrUpdate(SysRoleOrgEntity sysRoleOrgEntity) {
		//先删除角色与机构关系
		sysRoleOrgDao.delete(sysRoleOrgEntity.getRoleId());
		
		//保存角色与机构关系
		sysRoleOrgDao.save(sysRoleOrgEntity);
	}

	/**
	 * 根据角色ID查询组织机构
	 * @author centerroot
	 * @time 创建时间:2017年11月18日上午10:36:37
	 * (non-Javadoc)
	 * @see me.flyray.rbac.service.SysRoleOrgService#listOrgId(java.lang.Long)
	 */
	@Override
	public List<Long> listOrgId(Long roleId) {
		return sysRoleOrgDao.listOrgId(roleId);
	}

	/**
	 * 根据组织机构查询角色
	 * @author centerroot
	 * @time 创建时间:2017年11月18日上午10:36:44
	 * (non-Javadoc)
	 * @see me.flyray.rbac.service.SysRoleOrgService#listRoleId(java.lang.Long)
	 */
	@Override
	public List<Long> listRoleId(Long orgId) {
		return sysRoleOrgDao.listRoleId(orgId);
	}

	/**
	 * 根据角色ID删除
	 * @author centerroot
	 * @time 创建时间:2017年11月18日上午10:37:09
	 * (non-Javadoc)
	 * @see me.flyray.rbac.service.SysRoleOrgService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long roleId) {
		// TODO Auto-generated method stub

	}

}
