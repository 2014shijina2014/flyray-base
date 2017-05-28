package me.flyray.pay.model;

import java.math.BigDecimal;

/** 
* @author: bolei
* @date：2017年3月6日 下午10:13:58 
* @description：退款流水
*/

public class RefundSerial {

	/**
	 * 退款流水号
	 */
	private String serialNo;
	
	/**
	 * 退款订单号
	 */
	private String redunOrderNo;
	
	/**
	 * 支付公司
	 */
	private String payCompanyNo;
	
	/**
	 * 退款金额
	 */
	private BigDecimal redundAmt;
	
	/**
	 * 退款状态
	 */
	private String refundStatus;
	
	/**
	 * 记账状态
	 */
	private String accountStatus;

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getRedunOrderNo() {
		return redunOrderNo;
	}

	public void setRedunOrderNo(String redunOrderNo) {
		this.redunOrderNo = redunOrderNo;
	}

	public String getPayCompanyNo() {
		return payCompanyNo;
	}

	public void setPayCompanyNo(String payCompanyNo) {
		this.payCompanyNo = payCompanyNo;
	}

	public BigDecimal getRedundAmt() {
		return redundAmt;
	}

	public void setRedundAmt(BigDecimal redundAmt) {
		this.redundAmt = redundAmt;
	}

	public String getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	
}
