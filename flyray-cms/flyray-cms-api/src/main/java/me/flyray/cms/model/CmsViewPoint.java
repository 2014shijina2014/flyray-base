package me.flyray.cms.model;

import java.io.Serializable;
import java.util.Date;

public class CmsViewPoint implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键，自增
	 */
	private Long id;
	/**
	 * customer_id
	 */
	private Long customerId;
	/**
	 * point_text
	 */
	private String pointText;
	/**
	 * point_img
	 */
	private String pointImg;
	/**
	 * point_time
	 */
	private Date pointTime;
	/**
	 * point_address
	 */
	private String pointAddress;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPointImg() {
		return pointImg;
	}
	public void setPointImg(String pointImg) {
		this.pointImg = pointImg;
	}
	public Date getPointTime() {
		return pointTime;
	}
	public void setPointTime(Date pointTime) {
		this.pointTime = pointTime;
	}
	public String getPointAddress() {
		return pointAddress;
	}
	public void setPointAddress(String pointAddress) {
		this.pointAddress = pointAddress;
	}
	public String getPointText() {
		return pointText;
	}
	public void setPointText(String pointText) {
		this.pointText = pointText;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "CmsViewPoint [id=" + id + ", customerId=" + customerId + ", pointText=" + pointText + ", pointImg="
				+ pointImg + ", pointTime=" + pointTime + ", pointAddress=" + pointAddress + "]";
	}
	
	
}
