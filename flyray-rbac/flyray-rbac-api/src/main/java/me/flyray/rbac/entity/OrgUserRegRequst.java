package me.flyray.rbac.entity;

import java.io.Serializable;

/** 
* @author: bolei
* @date：Aug 25, 2017 11:42:55 PM 
* @description：组织机构注册接口
*/

public class OrgUserRegRequst implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 组织机构名称
	 */
	private String orgName;
	
	/**
	 * 商户类型
	 */
	private String merchantType;

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}
	
	
}
