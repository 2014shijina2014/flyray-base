package me.flyray.rbac.service;

import java.util.List;
import java.util.Map;

import me.flyray.rbac.entity.SysRoleEntity;
import me.flyray.rbac.entity.SysUserRoleEntity;



/**
 * 用户与角色对应关系
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:43:24
 */
public interface SysUserRoleService {
	
	void saveOrUpdate(Long userId, List<Long> roleIdList);
	
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);
	
	void delete(Long userId);
	
	List<SysUserRoleEntity> queryListByUserId(Long userId);
}
