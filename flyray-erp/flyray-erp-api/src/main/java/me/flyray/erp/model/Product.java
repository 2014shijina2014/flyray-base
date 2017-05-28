package me.flyray.erp.model;

/** 
* @author: bolei
* @date：2017年4月17日 下午3:54:00 
* @description：商品表
*/

public class Product {
	
	/**
	 * 自增ID
	 */
	private Integer id;
	
	/**
	 * 商品名称
	 */
	private String productName;
	
	/**
	 * 商品描述
	 */
	private String productDes;
	
	/**
	 * 商品价格
	 */
	private String productPrice;
	
	/**
	 * 商户号
	 */
	private String merchantNo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDes() {
		return productDes;
	}

	public void setProductDes(String productDes) {
		this.productDes = productDes;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	
}
