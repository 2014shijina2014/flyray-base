package me.flyray.crm.model;

import java.io.Serializable;

/** 
* @author: bolei
* @date：2017年3月26日 上午9:09:03 
* @description：客户账户
*/

public class CustomerAccount implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 客户号
	 */
	private String customerId;
	
	/**
	 * 客户账户号
	 * 唯一存在
	 */
	private String customerAccountNo;
	
	/**
	 *  账户类型 数据库字典表维护 枚举
	 */
	private String accountType;
	
	/**
	 * 账户值
	 */
	private String value;
	
	/**
	 * 冻结值
	 */
	private String freezeValue;
	
	/**
	 * 账户状态 枚举值
	 */
	private String status;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerAccountNo() {
		return customerAccountNo;
	}

	public void setCustomerAccountNo(String customerAccountNo) {
		this.customerAccountNo = customerAccountNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getFreezeValue() {
		return freezeValue;
	}

	public void setFreezeValue(String freezeValue) {
		this.freezeValue = freezeValue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
