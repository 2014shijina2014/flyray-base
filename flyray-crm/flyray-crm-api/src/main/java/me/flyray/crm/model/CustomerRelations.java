package me.flyray.crm.model;

import java.io.Serializable;
import java.util.Date;

/** 
* @author: bolei
* @date：Jun 14, 2017 7:53:52 PM 
* @description：客户关系表 用户三级分销
* http://blog.csdn.net/cctcc/article/details/53992215
*/

public class CustomerRelations implements Serializable{
	
	/**
	 * 公众号ID
	 */
	private String wxId;
	
	/**
	 * 客户编号
	 */
	private Long customerId;
	
	/**
	 * 分销级数
	 */
	private String fxLevel;
	
	/**
	 * 推荐客户编号
	 */
	private Long parentId;
	
	/**
	 * 所推荐客户编号
	 */
	private Long childId;
	
	/**
	 * 被邀请时间
	 */
	private Date invitedTime;

	public String getWxId() {
		return wxId;
	}

	public void setWxId(String wxId) {
		this.wxId = wxId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getFxLevel() {
		return fxLevel;
	}

	public void setFxLevel(String fxLevel) {
		this.fxLevel = fxLevel;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getChildId() {
		return childId;
	}

	public void setChildId(Long childId) {
		this.childId = childId;
	}

	public Date getInvitedTime() {
		return invitedTime;
	}

	public void setInvitedTime(Date invitedTime) {
		this.invitedTime = invitedTime;
	}

}
