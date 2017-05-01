package me.flyray.pay.service.pay.wechat.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import me.flyray.common.utils.BeanUtils;
import me.flyray.pay.model.PayChannelConfig;
import me.flyray.pay.service.pay.wechat.domain.RequestElement;

/** 
* @author: bolei
* @date：2017年4月30日 下午2:03:47 
* @description：微信服务签名
*/

@Service("wechatSignatureService")
public class WechatSignatureService {

	public String sign(Object obj, PayChannelConfig channelConfig) throws Exception {
		return toSign(BeanUtils.objectToMap(obj), channelConfig);
	}

	public String toSign(Map<String, Object> sPara, PayChannelConfig channelConfig) {
		return null;
		
	}

}
