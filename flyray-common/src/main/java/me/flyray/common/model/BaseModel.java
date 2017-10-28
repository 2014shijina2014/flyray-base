package me.flyray.common.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class BaseModel implements Serializable {
	
	/**
	 * 商户号
	 */
	private String merchantId;
	
	/**
	 * 机构Id
	 */
	private String orgId;

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	
}
