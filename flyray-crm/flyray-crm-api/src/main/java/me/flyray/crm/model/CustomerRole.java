package me.flyray.crm.model;

import me.flyray.common.model.BaseModel;

/** 
* @author: bolei
* @date：2017年10月28日 下午12:45:53
* @description：客户对于平台所属角色
*/

public class CustomerRole extends BaseModel {

	/**
	 * 自增ID
	 */
	private Long id;
	
	/**
	 * 客户角色编号
	 */
	private String roleNo;
	
	/**
	 * 客户角色名称
	 */
	private String roleName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleNo() {
		return roleNo;
	}

	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
