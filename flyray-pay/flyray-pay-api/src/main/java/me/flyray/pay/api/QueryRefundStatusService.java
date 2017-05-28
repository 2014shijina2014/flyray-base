package me.flyray.pay.api;

import me.flyray.pay.dto.QueryRefundStatusRequest;
import me.flyray.pay.dto.QueryRefundStatusResponse;

/** 
* @author: bolei
* @date：2017年2月23日 下午12:44:20 
* @description：向第三方查询退款状态
*/

public interface QueryRefundStatusService {

	public QueryRefundStatusResponse queryRefundStatus(QueryRefundStatusRequest request);
}
