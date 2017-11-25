package me.flyray.crm.model;

import java.io.Serializable;

/** 
* @author: bolei
* @date：Jul 9, 2017 10:59:19 AM 
* @description： 客户账单
*/

public class CustomerBilling implements Serializable{

	/**
	 * 自增ID
	 */
	private Long id;
	
	/**
	 * 账单类型
	 */
	private String BillingType;
	
	/**
	 * 账单类型
	 */
	private String amt;
	
	/**
	 * 描述
	 */
	private String desc;
	
	/**
	 * 账单状态
	 */
	private String BillingStatus;
	
	/**
	 * 资金来源
	 */
	private String fundsSource;
	
	/**
	 * 资金去向
	 */
	private String fundsDisposition;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBillingType() {
		return BillingType;
	}

	public void setBillingType(String billingType) {
		BillingType = billingType;
	}

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getBillingStatus() {
		return BillingStatus;
	}

	public void setBillingStatus(String billingStatus) {
		BillingStatus = billingStatus;
	}

	public String getFundsSource() {
		return fundsSource;
	}

	public void setFundsSource(String fundsSource) {
		this.fundsSource = fundsSource;
	}

	public String getFundsDisposition() {
		return fundsDisposition;
	}

	public void setFundsDisposition(String fundsDisposition) {
		this.fundsDisposition = fundsDisposition;
	}
	
}
