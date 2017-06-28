package me.flyray.pay.api;

import me.flyray.pay.dto.CreateOrderRequst;
import me.flyray.pay.dto.CreateOrderResponse;
import me.flyray.pay.dto.PayOrderRequest;
import me.flyray.pay.dto.PayOrderResponse;

/** 
* @author: bolei
* @date：2017年2月23日 下午12:56:34 
* @description：支付逻辑处理 
*/

public interface PaymentHandlerService {
	
	/**
	 * 1、根据支付渠编号道需要返回支付通道对象
	 * 2、根据支付通道对象调用相关支付通道支付
	 * 3、创建支付流水
	 */
	public PayOrderResponse pay(PayOrderRequest request);
	
	/**
	 *  支付统一下单
	 *  创建支付订单
	 */
	public CreateOrderResponse createOrder(CreateOrderRequst requst);
}
