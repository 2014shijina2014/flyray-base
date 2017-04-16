package me.flyray.cms.model;

import java.util.Date;

/**
 * 专家推荐表
 */
public class ProficientRecommend {

	/**
	 * 主键
	 */
	private int id;
	/**
	 * 客户号
	 */
	private String customerNo;
	
	/**
	 * 推荐日期
	 */
	private String recommendDate;
	/**
	 * 推荐时间
	 */
	private Date recommendTime;
	/**
	 * 推荐
	 */
	private String recommendPhotoFile;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	
	public String getRecommendDate() {
		return recommendDate;
	}
	public void setRecommendDate(String recommendDate) {
		this.recommendDate = recommendDate;
	}
	public Date getRecommendTime() {
		return recommendTime;
	}
	public void setRecommendTime(Date recommendTime) {
		this.recommendTime = recommendTime;
	}
	public String getRecommendPhotoFile() {
		return recommendPhotoFile;
	}
	public void setRecommendPhotoFile(String recommendPhotoFile) {
		this.recommendPhotoFile = recommendPhotoFile;
	}
	
	
	
}
