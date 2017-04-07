package me.flyray.cms.model;

/** 
* @author: bolei
* @date：2017年3月6日 下午10:20:39 
* @description：活动 
*/

public class Activity {
	
	private Integer id;
	
	/**
	 * 机构编号
	 */
	private String orgNo;
	
	/**
	 * 活动名称
	 */
	private String activityName;
	
	/**
	 * 活动logo
	 */
	private String activityLogo;
	
	/**
	 * 活动描述
	 */
	private String activityDes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrgNo() {
		return orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
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
	
}
