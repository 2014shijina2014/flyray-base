package me.flyray.pay.service.pay.alipay.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import me.flyray.common.utils.MD5;
import me.flyray.common.utils.RSA;
import me.flyray.pay.model.PayChannelConfig;
import me.flyray.pay.service.pay.alipay.util.AliPayConfig;

/** 
* @author: bolei
* @date：2017年4月30日 下午3:11:59 
* @description：类说明 
*/

@Service("aliSignatureService")
public class AliSignatureService {

	private static final Logger logger = LoggerFactory.getLogger(AliDirectPayService.class);
	
	@Value("${allinpay.private.cert.path}")
	private String priavteCertPath;

	@Autowired
	private AliPayConfig aliPayConfig;

	public String sign(String toBeSign, PayChannelConfig channelConfig) {
		logger.info("调用本地签名服务开始,待签名字符串:{},支付通道:{}", toBeSign, channelConfig.getPayCompanyNo());

		String sign = getSign(toBeSign, channelConfig);

		logger.info("调用本地签名服务完成,签名串:{}", sign);

		return sign;
	}

	private String getSign(String toBeSign, PayChannelConfig channelConfig) {
		if ("RSA".equalsIgnoreCase(channelConfig.getSingType())) {
			logger.info("支付宝RSA签名");
			return RSA.sign(toBeSign, channelConfig.getMerKey(), "UTF-8");
		} else {
			logger.info("支付宝MD5签名");
			return MD5.sign(toBeSign, channelConfig.getMerKey(), "UTF-8");
		}
	}

	public boolean verify(String toBeSign, String sign, PayChannelConfig channelConfig) {
		if ("RSA".equalsIgnoreCase(channelConfig.getSingType())) {
			return RSA.verify(toBeSign, sign, aliPayConfig.getAli_public_key(), "UTF-8");
		} else {
			return MD5.verify(toBeSign, sign, channelConfig.getMerKey(), "UTF-8");
		}
	}
}
