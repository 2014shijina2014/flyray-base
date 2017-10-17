package me.flyray.cms.model;

import java.io.Serializable;

/**
 * 团队-用户关联实体
 * @author centerroot
 * @time 创建时间:2017年10月8日上午11:34:04
 * @description :
 */
public class InterestGroupCustomer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6760042572654863286L;
	/**
	 * 团队序号
	 */
	private String groupId;
	/**
	 * 用户序号
	 */
	private String customerId;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "InterestGroupCustomer [groupId=" + groupId + ", customerId=" + customerId + "]";
	}

}
