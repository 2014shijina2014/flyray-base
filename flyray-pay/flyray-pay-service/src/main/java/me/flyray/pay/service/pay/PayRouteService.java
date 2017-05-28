package me.flyray.pay.service.pay;

import org.springframework.stereotype.Service;

import me.flyray.pay.model.PayChannel;

/** 
* @author: bolei
* @date：2017年4月30日 上午11:45:45 
* @description： 支付智能路由
*/

@Service("payRouteService")
public class PayRouteService {

	/**
	 * @param bankCode
	 * @param payMethod
	 * @param merchantNo
	 * 1、查询商户所有可用通道,查询条件  商户号 merchantNo
	 * 2、过滤支付方式 payMethod和银行码
	 * 3、查询路由策略、获取最优路由策略
	 */
	public PayChannel getRoute(String bankCode,String payMethod,String merchantNo) {
		
		return null;
	}
}
