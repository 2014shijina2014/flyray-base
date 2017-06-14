package me.flyray.crm.model;

/** 
* @author: bolei
* @date：Jun 14, 2017 7:53:52 PM 
* @description：客户关系表 用户三级分销
*/

public class CustomerRelations {
	
	/**
	 * 客户编号
	 */
	private String customerNo;
	
	/**
	 * 分销级数
	 */
	private String FxLevel;
	
	/**
	 * 推荐客户编号
	 */
	private String parentNo;
	
	/**
	 * 所推荐客户编号
	 */
	private String childNo;

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getFxLevel() {
		return FxLevel;
	}

	public void setFxLevel(String fxLevel) {
		FxLevel = fxLevel;
	}

	public String getParentNo() {
		return parentNo;
	}

	public void setParentNo(String parentNo) {
		this.parentNo = parentNo;
	}

	public String getChildNo() {
		return childNo;
	}

	public void setChildNo(String childNo) {
		this.childNo = childNo;
	}
	
}
