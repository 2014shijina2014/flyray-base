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
	 * 交易类型 支付 退款 支付查询 退款查询
	 */
	private String tradeType;
	
	/**
	 * 接口名称
	 */
	private String serviceName;

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

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

}
