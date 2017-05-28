package me.flyray.pay.api;

import me.flyray.pay.dto.PayOrderHandleRequest;
import me.flyray.pay.dto.PayOrderHandleResponse;

/** 
* @author: bolei
* @date：2017年4月30日 下午1:20:20 
* @description：支付订单处理,创建支付订单
*/

public interface PayOrderHandleService {

	/**
	 * 创建支付订单
	 */
	public PayOrderHandleResponse createPayOrder(PayOrderHandleRequest request);
}
