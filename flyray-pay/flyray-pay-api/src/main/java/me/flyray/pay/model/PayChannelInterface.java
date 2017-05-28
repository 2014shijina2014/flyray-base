package me.flyray.pay.model;

/** 
* @author: bolei
* @date：2017年3月6日 下午10:12:18 
* @description： 支付通道接口
*/

public class PayChannelInterface {

	/**
	 * 自增id
	 */
	private Long id;
	
	/**
	 * 支付通道编号
	 */
	private String payChannelNo;
	
	/**
	 * 支付接口名称
	 */
	private String payServiceName;
	
	/**
	 * 退款接口名称
	 */
	private String RefundServiceName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPayChannelNo() {
		return payChannelNo;
	}

	public void setPayChannelNo(String payChannelNo) {
		this.payChannelNo = payChannelNo;
	}

	public String getPayServiceName() {
		return payServiceName;
	}

	public void setPayServiceName(String payServiceName) {
		this.payServiceName = payServiceName;
	}

	public String getRefundServiceName() {
		return RefundServiceName;
	}

	public void setRefundServiceName(String refundServiceName) {
		RefundServiceName = refundServiceName;
	}
	
}
