package me.flyray.pay.api;

import me.flyray.pay.dto.PayOrderRequest;
import me.flyray.pay.dto.PayOrderResponse;

/** 
* @author: bolei
* @date：2017年4月30日 下午1:20:20 
* @description：支付订单处理,创建支付订单
*/

public interface PayOrderHandleService {

	/**
	 * 创建支付订单
	 */
	public PayOrderResponse createPayOrder(PayOrderRequest request);
}
