package me.flyray.crm.model;

/** 
* @author: bolei
* @date：2017年3月6日 下午10:06:20 
* @description：商户基础信息
*/

public class MerchantBase {

	/**
	 * 商户自增ID
	 */
	private Integer id;
	
	/**
	 * 商户号
	 */
	private String merchantNo;
	
	/**
	 * 所属机构
	 */
	private String orgId;
	
	/**
	 * 商户名称
	 */
	private String merchantName;
	
	/**
	 * 商户简介
	 */
	private String briefIntro;
	
	/**
	 * 商户地址
	 */
	private String merchantAddress;
	
	/**
	 * 商户联系电话
	 */
	private String merchantPhone;
	
	/**
	 * 商户logo
	 */
	private String merchantLogo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getBriefIntro() {
		return briefIntro;
	}

	public void setBriefIntro(String briefIntro) {
		this.briefIntro = briefIntro;
	}

	public String getMerchantAddress() {
		return merchantAddress;
	}

	public void setMerchantAddress(String merchantAddress) {
		this.merchantAddress = merchantAddress;
	}

	public String getMerchantPhone() {
		return merchantPhone;
	}

	public void setMerchantPhone(String merchantPhone) {
		this.merchantPhone = merchantPhone;
	}

	public String getMerchantLogo() {
		return merchantLogo;
	}

	public void setMerchantLogo(String merchantLogo) {
		this.merchantLogo = merchantLogo;
	}
	
}
