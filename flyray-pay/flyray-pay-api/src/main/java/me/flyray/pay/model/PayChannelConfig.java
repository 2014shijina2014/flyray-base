package me.flyray.pay.model;

/** 
* @author: bolei
* @date：2017年3月6日 下午10:11:41 
* @description：支付通道配置 
*/

public class PayChannelConfig {

	/**
	 * 自增id
	 */
	private Long id;
	
	/**
	 *  支付通道编号
	 */
	private String payChannelNo;
	
	/**
	 * 支付公司
	 */
	private String payCompanyNo;
	
	/**
	 * 组织机构
	 */
	private String orgNo;
	
	/**
	 * 商户号
	 */
	private String merchantNo;
	
	/**
	 * 微信商户号
	 */
	private String merAccount;
	
	/**
	 * 商户key
	 */
	private String merKey;
	
	/**
	 * 商户 签名类型
	 */
	private String SingType;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPayChannelNo() {
		return payChannelNo;
	}

	public void setPayChannelNo(String payChannelNo) {
		this.payChannelNo = payChannelNo;
	}

	public String getPayCompanyNo() {
		return payCompanyNo;
	}

	public void setPayCompanyNo(String payCompanyNo) {
		this.payCompanyNo = payCompanyNo;
	}

	public String getOrgNo() {
		return orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getMerAccount() {
		return merAccount;
	}

	public void setMerAccount(String merAccount) {
		this.merAccount = merAccount;
	}

	public String getMerKey() {
		return merKey;
	}

	public void setMerKey(String merKey) {
		this.merKey = merKey;
	}

	public String getSingType() {
		return SingType;
	}

	public void setSingType(String singType) {
		SingType = singType;
	}

}
