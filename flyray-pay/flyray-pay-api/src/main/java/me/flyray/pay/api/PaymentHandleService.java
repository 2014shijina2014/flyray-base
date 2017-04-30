package me.flyray.pay.api;

import me.flyray.pay.dto.PaymentHandleRequest;
import me.flyray.pay.dto.PaymentHandleResponse;

/** 
* @author: bolei
* @date：2017年2月23日 下午12:56:34 
* @description：支付逻辑处理 
*/

public interface PaymentHandleService {
	
	/**
	 * 1、根据支付渠编号道需要返回支付通道对象
	 * 2、根据支付通道对象调用相关支付通道支付
	 * 3、创建支付订单
	 */
	public PaymentHandleResponse pay(PaymentHandleRequest request);
}
