package me.flyray.cms.model;

import java.sql.Timestamp;

import me.flyray.common.model.BaseModel;

/** 
* @author: bolei
* @date：2017年3月6日 下午10:20:39 
* @description：活动 
*/

public class Activity extends BaseModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4641341658497485836L;

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
	
	/**
	 * 活动开始时间
	 */
	private String activityStartTime;
	/**
	 * 活动结束时间
	 */
	private String activityEndTime;
	/**
	 * 活动地点
	 */
	private String activityAddr;
	/**
	 * 创建时间
	 */
	private Timestamp createTime;
	/**
	 * 创建者
	 */
	private long createBy;
	
	/**
	 * 状态标识
	 * 00：无效；10：推荐；20：置顶
	 */
	private String flag;

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

	public String getActivityStartTime() {
		return activityStartTime;
	}

	public void setActivityStartTime(String activityStartTime) {
		this.activityStartTime = activityStartTime;
	}

	public String getActivityEndTime() {
		return activityEndTime;
	}

	public void setActivityEndTime(String activityEndTime) {
		this.activityEndTime = activityEndTime;
	}

	public String getActivityAddr() {
		return activityAddr;
	}

	public void setActivityAddr(String activityAddr) {
		this.activityAddr = activityAddr;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(long createBy) {
		this.createBy = createBy;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Activity [getId()=" + getId() + ", getActivityName()=" + getActivityName() + ", getActivityLogo()="
				+ getActivityLogo() + ", getActivityDes()=" + getActivityDes() + ", getActivityContent()="
				+ getActivityContent() + ", getInterestGroupId()=" + getInterestGroupId() + ", getActivityStartTime()="
				+ getActivityStartTime() + ", getActivityEndTime()=" + getActivityEndTime() + ", getActivityAddr()="
				+ getActivityAddr() + ", getCreateTime()=" + getCreateTime() + ", getCreateBy()=" + getCreateBy()
				+ ", getFlag()=" + getFlag() + ", getMerchantId()=" + getMerchantId() + ", getOrgId()=" + getOrgId()
				+ "]";
	}
	
}
