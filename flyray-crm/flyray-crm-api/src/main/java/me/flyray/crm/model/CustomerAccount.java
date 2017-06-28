package me.flyray.crm.model;

/** 
* @author: bolei
* @date：2017年3月26日 上午9:09:03 
* @description：客户账户
*/

public class CustomerAccount {
	
	/**
	 * 客户号
	 */
	private String customerNo;
	
	/**
	 * 客户账户号
	 * 唯一存在
	 */
	private String custAccountNo;
	
	/**
	 *  账户类型 数据库字典表维护
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
	 * 账户状态
	 */
	private String status;

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getCustAccountNo() {
		return custAccountNo;
	}

	public void setCustAccountNo(String custAccountNo) {
		this.custAccountNo = custAccountNo;
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
