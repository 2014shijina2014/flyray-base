package me.flyray.pay.api;

import me.flyray.common.service.BaseService;
import me.flyray.pay.model.PayChannelConfig;

/** 
* @author: bolei
* @date：2017年3月18日 下午11:19:37 
* @description： 支付通道配置
*/

public interface PayChannelConfigService extends BaseService{

	PayChannelConfig getPayChannelConfig(String merchantNo, String payChannelNo);

}
