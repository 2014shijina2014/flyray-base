package me.flyray.pay.dto;

/** 
* @author: bolei
* @date：2017年2月23日 下午12:32:58 
* @description：退款请求
*/

public class RefundHandleRequest {

	private String merchantNo;
	
	private String payChannelNo;

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getPayChannelNo() {
		return payChannelNo;
	}

	public void setPayChannelNo(String payChannelNo) {
		this.payChannelNo = payChannelNo;
	}
	
}
