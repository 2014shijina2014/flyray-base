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
	private Date recommendDate;
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
	public Date getRecommendDate() {
		return recommendDate;
	}
	public void setRecommendDate(Date recommendDate) {
		this.recommendDate = recommendDate;
	}
	public String getRecommendPhotoFile() {
		return recommendPhotoFile;
	}
	public void setRecommendPhotoFile(String recommendPhotoFile) {
		this.recommendPhotoFile = recommendPhotoFile;
	}
	
	
	
}
