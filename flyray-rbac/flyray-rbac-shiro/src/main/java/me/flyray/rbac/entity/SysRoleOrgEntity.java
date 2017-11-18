package me.flyray.rbac.entity;

import java.io.Serializable;

/**
 * 角色与机构对应关系
 * @author centerroot
 * @time 创建时间:2017年11月18日上午10:16:33
 * @description :
 */
public class SysRoleOrgEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3366671899418066416L;

	/**
	 * 记录id
	 */
	private Long id;

	/**
	 * 角色ID
	 */
	private Long roleId;

	/**
	 * 机构ID
	 */
	private Long orgId;

	public SysRoleOrgEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
}
