package me.flyray.pay.api;

import java.util.Map;

/** 
* @author: bolei
* @date：2017年2月23日 上午11:27:39 
* @description： 实际向第三方发起支付接口
*/

public interface PayObjectService<Request> {
	public Map<String,Object> pay(Request request);
}
