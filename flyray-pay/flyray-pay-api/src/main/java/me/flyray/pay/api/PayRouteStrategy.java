package me.flyray.pay.api;

import java.util.List;

import me.flyray.pay.model.PayChannel;

/** 
* @author: bolei
* @date：2017年4月30日 下午12:10:03 
* @description：支付路由策略
*/

public interface PayRouteStrategy {

	public List<PayChannel> route(List<PayChannel> payChannels);
}
