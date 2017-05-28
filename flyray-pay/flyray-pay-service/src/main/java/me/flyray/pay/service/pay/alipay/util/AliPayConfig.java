package me.flyray.pay.service.pay.alipay.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/** 
* @author: bolei
* @date：2017年4月30日 下午2:59:54 
* @description：支付宝支付请求配置 
*/

@Service("aliPayConfig")
public class AliPayConfig {
    
    @Value("${front.callback.url}")
    private String frontCallbackUrl;
    
    @Value("${back.callback.url}")
    private String backCallbackUrl;
    
    @Value("${alipay.gateway_url}")
    private String alipay_gateway_new;
    
    @Value("${alipay.input_charset}")
    private String input_charset;
    
    // 支付宝的公钥，无需修改该值
    @Value("${ali.public.key}")
    public String ali_public_key ;

    public String getFrontCallbackUrl() {
        return frontCallbackUrl;
    }

    public void setFrontCallbackUrl(String frontCallbackUrl) {
        this.frontCallbackUrl = frontCallbackUrl;
    }

    public String getBackCallbackUrl() {
        return backCallbackUrl;
    }

    public void setBackCallbackUrl(String backCallbackUrl) {
        this.backCallbackUrl = backCallbackUrl;
    }

    public String getAlipay_gateway_new() {
        return alipay_gateway_new;
    }

    public void setAlipay_gateway_new(String alipay_gateway_new) {
        this.alipay_gateway_new = alipay_gateway_new;
    }

    public String getInput_charset() {
        return input_charset;
    }

    public void setInput_charset(String input_charset) {
        this.input_charset = input_charset;
    }

    public String getAli_public_key() {
        return ali_public_key;
    }

    public void setAli_public_key(String ali_public_key) {
        this.ali_public_key = ali_public_key;
    }
}
