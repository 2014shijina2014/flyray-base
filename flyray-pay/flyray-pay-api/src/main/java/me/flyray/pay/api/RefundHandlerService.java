package me.flyray.pay.api;

import me.flyray.pay.dto.RefundRequest;
import me.flyray.pay.dto.RefundResponse;

/** 
* @author: bolei
* @date：2017年2月23日 上午11:54:03 
* @description：退款逻辑接口
*/

public interface RefundHandlerService {

	public RefundResponse refund(RefundRequest request);
}
