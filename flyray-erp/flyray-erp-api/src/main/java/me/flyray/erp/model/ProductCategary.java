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
	private Integer orgId;
	
	/**
	 * 商户号
	 */
	private Integer merchantNo;
	
	/**
	 * 商品分类名称
	 */
	private Integer categaryName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Integer getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(Integer merchantNo) {
		this.merchantNo = merchantNo;
	}

	public Integer getCategaryName() {
		return categaryName;
	}

	public void setCategaryName(Integer categaryName) {
		this.categaryName = categaryName;
	}
	
}
