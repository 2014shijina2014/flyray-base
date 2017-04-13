package me.flyray.cms.model;


/**
 * 客户关注表
 */
public class CustomerBaseExtend extends BaseModel{

	
	private static final long serialVersionUID = 4698727055885715497L;

	/**
	 * 客户编号
	 */
	private String customerNo;
	
	/**
	 * 关注客户编号
	 */
	private String followCustomerNo;

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getFollowCustomerNo() {
		return followCustomerNo;
	}

	public void setFollowCustomerNo(String followCustomerNo) {
		this.followCustomerNo = followCustomerNo;
	}
	
	
	
}
