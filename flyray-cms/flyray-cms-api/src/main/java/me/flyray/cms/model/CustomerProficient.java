package me.flyray.cms.model;

import me.flyray.common.model.BaseModel;

/**
 * @author huo.xq
 *	客户专家表
 */
public class CustomerProficient extends BaseModel{

	
	private static final long serialVersionUID = 217566751194666499L;
	/**
	 * 客户号
	 */
	private String customerNo;
	/**
	 * 客户证件正面照
	 */
	private String certPhotoFileNo;
	/**
	 * 客户等级
	 */
	private String leval;
	
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	public String getCertPhotoFileNo() {
		return certPhotoFileNo;
	}
	public void setCertPhotoFileNo(String certPhotoFileNo) {
		this.certPhotoFileNo = certPhotoFileNo;
	}
	public String getLeval() {
		return leval;
	}
	public void setLeval(String leval) {
		this.leval = leval;
	}
	
	
	
}
