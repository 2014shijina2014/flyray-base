package me.flyray.pay.api;

import me.flyray.pay.dto.QueryPayStatusRequest;
import me.flyray.pay.dto.QueryPayStatusResponse;

/** 
* @author: bolei
* @date：2017年2月23日 下午12:44:04 
* @description：向第三方查询支付状态
*/

public interface QueryPayStatusService {

	public QueryPayStatusResponse queryPayStatus(QueryPayStatusRequest request);
}
