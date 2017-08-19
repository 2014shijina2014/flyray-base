package me.flyray.cms.model;

import java.sql.Timestamp;

public class Viewpoint {
	/**
	 * 主键编号
	 */
	private Long id;
	private String customerNo;
	private String pointText;
	private String pointImg;
	private Timestamp pointTime;
	private String pointAddress;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	public String getPointText() {
		return pointText;
	}
	public void setPointText(String pointText) {
		this.pointText = pointText;
	}
	public String getPointImg() {
		return pointImg;
	}
	public void setPointImg(String pointImg) {
		this.pointImg = pointImg;
	}
	public Timestamp getPointTime() {
		return pointTime;
	}
	public void setPointTime(Timestamp pointTime) {
		this.pointTime = pointTime;
	}
	public String getPointAddress() {
		return pointAddress;
	}
	public void setPointAddress(String pointAddress) {
		this.pointAddress = pointAddress;
	}
	
	
}
