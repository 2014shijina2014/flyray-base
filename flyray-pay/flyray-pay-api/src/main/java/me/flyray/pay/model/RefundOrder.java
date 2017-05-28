package me.flyray.pay.model;

import java.math.BigDecimal;
import java.util.Date;

/** 
* @author: bolei
* @date：2017年3月6日 下午10:13:26 
* @description：退款订单
*/

public class RefundOrder {

	/**
	 * 退款订单自增id
	 */
	private Long id;
	
	/**
	 * 支付订单号
	 */
	private String payOrderNo;
	
	/**
	 * 	退款订单号
	 */
	private String refundOrderNo;
	
	/**
	 * 退款金额
	 */
	private BigDecimal refundAmt;
	
	/**
	 *  机构编号
	 */
	private String orgNo;
	
	/**
	 * 退款手续费
	 */
	private BigDecimal refundFee;
	
	/**
	 * 退款时间
	 */
	private Date refundTime;
	
	/**
	 * 跟支付方式对应
	 */
	private String refundMethod;
	
	/**
	 * 退款原因
	 */
	private String refundReason;

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

	public String getRefundOrderNo() {
		return refundOrderNo;
	}

	public void setRefundOrderNo(String refundOrderNo) {
		this.refundOrderNo = refundOrderNo;
	}

	public BigDecimal getRefundAmt() {
		return refundAmt;
	}

	public void setRefundAmt(BigDecimal refundAmt) {
		this.refundAmt = refundAmt;
	}

	public String getOrgNo() {
		return orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	public BigDecimal getRefundFee() {
		return refundFee;
	}

	public void setRefundFee(BigDecimal refundFee) {
		this.refundFee = refundFee;
	}

	public Date getRefundTime() {
		return refundTime;
	}

	public void setRefundTime(Date refundTime) {
		this.refundTime = refundTime;
	}

	public String getRefundMethod() {
		return refundMethod;
	}

	public void setRefundMethod(String refundMethod) {
		this.refundMethod = refundMethod;
	}

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}
	
}
