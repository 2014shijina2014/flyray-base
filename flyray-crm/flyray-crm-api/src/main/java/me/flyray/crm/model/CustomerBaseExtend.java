package me.flyray.crm.model;

import java.io.Serializable;

public class CustomerBaseExtend implements Serializable{
	/**
	 * 客户号
	 */
	private Long customerId;
	/**
	 * 关注客户号
	 */
	private Long followCustomerId;
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
	public Long getFollowCustomerId() {
		return followCustomerId;
	}
	public void setFollowCustomerId(Long followCustomerId) {
		this.followCustomerId = followCustomerId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
}
