package me.flyray.cms.model;

/** 
* @author: bolei
* @date：2017年3月6日 下午10:20:39 
* @description：活动 
*/

public class Activity {
	
	/**
	 * 自增id
	 */
	private Long id;
	
	/**
	 * 所属兴趣组
	 */
	private Long InterestGroupId;
	
	/**
	 * 活动名称
	 */
	private String activityName;
	
	/**
	 * 活动logo
	 */
	private String activityLogo;
	
	/**
	 * 活动摘要
	 */
	private String activityDes;
	
	/**
	 * 活动内容
	 */
	private String activityContent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityLogo() {
		return activityLogo;
	}

	public void setActivityLogo(String activityLogo) {
		this.activityLogo = activityLogo;
	}

	public String getActivityDes() {
		return activityDes;
	}

	public void setActivityDes(String activityDes) {
		this.activityDes = activityDes;
	}

	public String getActivityContent() {
		return activityContent;
	}

	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}

	public Long getInterestGroupId() {
		return InterestGroupId;
	}

	public void setInterestGroupId(Long interestGroupId) {
		InterestGroupId = interestGroupId;
	}
	
}
