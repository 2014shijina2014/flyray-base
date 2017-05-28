package me.flyray.pay.dto;

import java.util.Map;

/** 
* @author: bolei
* @date：2017年3月6日 下午10:11:02 
* @description：
*/

public abstract class AbstractRequest {

    /**
     * 商户号
     */
    private String merchantNo;
    /**
     * 支付通道编号
     */
    private String payChannelNo;
    /**
     * 扩展参数
     */
    private Map<String,Object> extra;

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

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }
    
}
