package me.flyray.pay.api;

import me.flyray.pay.dto.CompletePayRequest;
import me.flyray.pay.dto.CompletePayResponse;

/** 
* @author: bolei
* @date：2017年5月7日 下午10:52:14 
* @description：支付完成处理
*/

public interface CompletePayService {
	
	CompletePayResponse CompletePay(CompletePayRequest request);
}
