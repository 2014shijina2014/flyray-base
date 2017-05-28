package me.flyray.pay.api;

import me.flyray.common.service.BaseService;
import me.flyray.pay.model.PayChannelInterface;

/** 
* @author: bolei
* @date：2017年3月18日 下午11:19:51 
* @description：支付通道接口
*/

public interface PayChannelInterfaceService extends BaseService{

	PayChannelInterface getPayChannelInterface(String payChannelNo);

}
