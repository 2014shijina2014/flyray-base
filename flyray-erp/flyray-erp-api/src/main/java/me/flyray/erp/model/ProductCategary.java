package me.flyray.erp.model;

/** 
* @author: bolei
* @date：2017年4月17日 下午4:00:00 
* @description：商品分类
*/

public class ProductCategary {
	
	/**
	 * 自增ID
	 */
	private Integer id;
	
	/**
	 * 机构ID
	 */
	private String orgId;
	
	/**
	 * 商户号
	 */
	private String merchantNo;
	
	/**
	 * 商品分类名称
	 */
	private String categaryName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getCategaryName() {
		return categaryName;
	}

	public void setCategaryName(String categaryName) {
		this.categaryName = categaryName;
	}

}
