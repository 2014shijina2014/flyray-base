package me.flyray.common.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class BaseModel implements Serializable {
	
	private Long merchantId;
	
	private Long orgId;

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	
}
