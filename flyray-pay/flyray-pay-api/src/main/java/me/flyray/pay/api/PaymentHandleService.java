package me.flyray.pay.api;

import me.flyray.pay.dto.PaymentHandleRequest;
import me.flyray.pay.dto.PaymentHandleResponse;

/** 
* @author: bolei
* @date：2017年2月23日 上午11:53:36 
* @description：支付逻辑处理 
*/

public interface PaymentHandleService {

	public PaymentHandleResponse pay(PaymentHandleRequest request);
}
