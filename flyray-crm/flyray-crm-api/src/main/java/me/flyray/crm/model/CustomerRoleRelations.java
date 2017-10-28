package me.flyray.crm.model;

import me.flyray.common.model.BaseModel;

/** 
* @author: bolei
* @date：2017年10月28日 下午12:45:53
* @description：客户与平台所属角色关系
*/

public class CustomerRoleRelations extends BaseModel {

	private String customerId;
	
	private String customerRoleId;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerRoleId() {
		return customerRoleId;
	}

	public void setCustomerRoleId(String customerRoleId) {
		this.customerRoleId = customerRoleId;
	}

}
