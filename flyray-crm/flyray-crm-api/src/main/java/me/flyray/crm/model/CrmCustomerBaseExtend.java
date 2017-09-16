package me.flyray.crm.model;

import java.io.Serializable;

public class CrmCustomerBaseExtend implements Serializable{
	/**
	 * 客户号
	 */
	private Long customerId;
	/**
	 * 关注客户号
	 */
	private String followCustomerNo;
	/**
	 * 学校名
	 */
	private String schoolName;
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getFollowCustomerNo() {
		return followCustomerNo;
	}
	public void setFollowCustomerNo(String followCustomerNo) {
		this.followCustomerNo = followCustomerNo;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	@Override
	public String toString() {
		return "CrmCustomerBaseExtend [customerId=" + customerId + ", followCustomerNo=" + followCustomerNo
				+ ", schoolName=" + schoolName + "]";
	}
	
}
