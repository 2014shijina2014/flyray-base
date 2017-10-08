package me.flyray.cms.model;

/**
 * 活动-用户关联实体
 * @author centerroot
 * @time 创建时间:2017年10月8日上午11:33:38
 * @description :
 */
public class ActivityCustomer {
	
	/**
	 * 活动序号
	 */
	private String activityId;
	/**
	 * 用户序号
	 */
	private String customerId;

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "ActivityCustomer [activityId=" + activityId + ", customerId=" + customerId + "]";
	}

}
