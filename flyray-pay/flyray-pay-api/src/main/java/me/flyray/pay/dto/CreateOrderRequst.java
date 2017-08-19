package me.flyray.pay.dto;

/** 
* @author: bolei
* @date：Jun 14, 2017 8:21:16 AM 
* @description：类描述
*/

public class CreateOrderRequst {

	/**
	 * 订单号
	 */
	private String payOrderNo;
	
	/**
	 * 客户账号
	 */
	private String customerNo;
	
	/**
	 *  商户账号
	 */
	private String merchantNo;

	public String getPayOrderNo() {
		return payOrderNo;
	}

	public void setPayOrderNo(String payOrderNo) {
		this.payOrderNo = payOrderNo;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	
}
