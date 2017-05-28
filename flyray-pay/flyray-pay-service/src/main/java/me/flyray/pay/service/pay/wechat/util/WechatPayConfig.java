package me.flyray.pay.service.pay.wechat.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/** 
* @author: bolei
* @date：2017年4月30日 下午1:47:45 
* @description：微信支付请求配置
*/

@Service("wechatPayConfig")
public class WechatPayConfig {

	@Value("${wechat.gateway_url}")
    private String wechatGatewayUrl;
	
	@Value("${wechat.gateway_refund_url}")
    private String wechatGatewayRefundUrl;
	
	@Value("${back.callback.url}")
    private String backCallbackUrl;
	
    @Value("${wechat.gateway_refund_status_url}")
	private String wechatgatewayRefundStatusUrl;
    
	public String getWechatgatewayRefundStatusUrl() {
		return wechatgatewayRefundStatusUrl;
	}

	public void setWechatgatewayRefundStatusUrl(String wechatgatewayRefundStatusUrl) {
		this.wechatgatewayRefundStatusUrl = wechatgatewayRefundStatusUrl;
	}

	public String getWechatGatewayUrl() {
		return wechatGatewayUrl;
	}

	public void setWechatGatewayUrl(String wechatGatewayUrl) {
		this.wechatGatewayUrl = wechatGatewayUrl;
	}

	public String getBackCallbackUrl() {
		return backCallbackUrl;
	}

	public void setBackCallbackUrl(String backCallbackUrl) {
		this.backCallbackUrl = backCallbackUrl;
	}

    public String getWechatGatewayRefundUrl() {
        return wechatGatewayRefundUrl;
    }

    public void setWechatGatewayRefundUrl(String wechatGatewayRefundUrl) {
        this.wechatGatewayRefundUrl = wechatGatewayRefundUrl;
    }
}
