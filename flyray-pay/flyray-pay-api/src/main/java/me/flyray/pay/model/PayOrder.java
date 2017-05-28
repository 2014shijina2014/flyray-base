package me.flyray.pay.model;

import java.math.BigDecimal;
import java.util.Date;

/** 
* @author: bolei
* @date：2017年3月6日 下午10:12:53 
* @description：支付订单
*/

public class PayOrder {

	/**
	 * 订单自增id
	 */
	private Long id;
	
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
	
	/**
	 * 交易时间
	 */
	private Date payTime;
	
	/**
	 * 交易手续费
	 */
	private BigDecimal payFee;
	
	/**
	 * 交易金额
	 */
	private BigDecimal payAmt;
	
	/**
	 * 订单描述
	 */
	private String body;
	
	/**
	 * 支付方式（1支付宝2微信3余额 13余额支付宝）
	 */
	private String payMethod;
	
	/**
	 * 交易状态（未支付、支付中、支付失败、支付成功、已部分退款、已退款）
	 */
	private String orderStatus;
	
	/**
	 * 机构编号
	 */
	private String orgNo;
	
	/**
	 *  已退款金额
	 */
	private BigDecimal redundedAmt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public BigDecimal getPayFee() {
		return payFee;
	}

	public void setPayFee(BigDecimal payFee) {
		this.payFee = payFee;
	}

	public BigDecimal getPayAmt() {
		return payAmt;
	}

	public void setPayAmt(BigDecimal payAmt) {
		this.payAmt = payAmt;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrgNo() {
		return orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	public BigDecimal getRedundedAmt() {
		return redundedAmt;
	}

	public void setRedundedAmt(BigDecimal redundedAmt) {
		this.redundedAmt = redundedAmt;
	}
	
}
