package me.flyray.pay.api;

import me.flyray.common.service.BaseService;
import me.flyray.pay.model.PayOrder;

/** 
* @author: bolei
* @date：2017年3月18日 下午11:20:24 
* @description：支付订单
*/

public interface PayOrderService extends BaseService{

	PayOrder queryByPayOrder(PayOrder payOrder);

	void save(PayOrder payOrder);

}
