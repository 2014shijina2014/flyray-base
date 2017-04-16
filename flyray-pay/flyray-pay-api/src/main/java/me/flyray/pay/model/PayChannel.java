package me.flyray.pay.model;

import java.math.BigDecimal;

/** 
* @author: bolei
* @date：2017年3月6日 下午10:11:02 
* @description：支付通道
*/

public class PayChannel {

	/**
	 * 自增id
	 */
	private Integer id;
	
	/**
	 *  支付通道编号
	 */
	private String payChannelNo;
	
	/**
	 * 支付公司
	 */
	private String payCompanyNo;
	
	/**
	 *  通道费率
	 */
	private String feeRatio;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPayChannelNo() {
		return payChannelNo;
	}

	public void setPayChannelNo(String payChannelNo) {
		this.payChannelNo = payChannelNo;
	}

	public String getPayCompanyNo() {
		return payCompanyNo;
	}

	public void setPayCompanyNo(String payCompanyNo) {
		this.payCompanyNo = payCompanyNo;
	}

	public String getFeeRatio() {
		return feeRatio;
	}

	public void setFeeRatio(String feeRatio) {
		this.feeRatio = feeRatio;
	}
}
