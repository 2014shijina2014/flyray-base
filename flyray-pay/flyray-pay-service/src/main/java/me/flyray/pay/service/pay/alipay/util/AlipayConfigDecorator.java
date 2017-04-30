package me.flyray.pay.service.pay.alipay.util;

import me.flyray.pay.model.PayChannelConfig;

public class AlipayConfigDecorator{

    private AliPayConfig aliPayConfig;
    
    private PayChannelConfig payChannelConfig;
    
    public AlipayConfigDecorator(AliPayConfig aliPayConfig, PayChannelConfig payChannelConfig) {
        super();
        this.aliPayConfig = aliPayConfig;
        this.payChannelConfig = payChannelConfig;
    }

    public String getAlipay_gateway_new() {
        return aliPayConfig.getAlipay_gateway_new();
    }

    public String getInput_charset() {
        return aliPayConfig.getInput_charset();
    }

    public String getPrivate_key() {
        return payChannelConfig.getMerKey();
    }

    public String getAli_public_key() {
        return aliPayConfig.getAli_public_key();
    }

    public String getSign_type() {
        return payChannelConfig.getSingType();
    }

    public String getFrontCallbackUrl() {
        return aliPayConfig.getFrontCallbackUrl();
    }

    public String getBackCallbackUrl() {
        return aliPayConfig.getBackCallbackUrl();
    }

    public String getPartner() {
        return payChannelConfig.getMerAccount();
    }

    public String getSeller_email() {
        return payChannelConfig.getMerAccount();
    }

    public PayChannelConfig getPayChannelConfig() {
        return payChannelConfig;
    }

    public void setSign_type(String singType) {
        payChannelConfig.setSingType(singType);
    }
    
    
    
}
