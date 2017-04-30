package me.flyray.pay.service.pay.wechat.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import me.flyray.pay.model.PayChannelConfig;
import me.flyray.pay.service.pay.wechat.domain.RequestElement;

/** 
* @author: bolei
* @date：2017年4月30日 下午2:03:47 
* @description：微信服务签名
*/

@Service("wechatSignatureService")
public class WechatSignatureService {

	public String sign(RequestElement reqElement, PayChannelConfig channelConfig) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object toSign(Map<String, Object> signMap, PayChannelConfig channelConfig) {
		// TODO Auto-generated method stub
		return null;
	}

}
