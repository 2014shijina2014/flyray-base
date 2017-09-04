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
	private Long orgId;
	
	/**
	 * 商户号
	 */
	private Long merchantId;
	
	/**
	 * 第三方支付公司商户号
	 */
	private String merAccount;
	
	/**
	 * 第三方支付公司商户key
	 */
	private String merKey;
	
	/**
	 * 第三方支付公司商户 签名类型
	 */
	private String singType;
	
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

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
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
		return singType;
	}

	public void setSingType(String singType) {
		this.singType = singType;
	}
}
