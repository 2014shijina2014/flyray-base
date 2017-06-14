package me.flyray.pay.service.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.pay.api.PayOrderHandleService;
import me.flyray.pay.api.PayOrderService;
import me.flyray.pay.dto.PayOrderRequest;
import me.flyray.pay.dto.PayOrderResponse;
import me.flyray.pay.model.PayOrder;

/** 
* @author: bolei
* @date：2017年4月30日 下午1:25:53 
* @description：支付订单处理
*/

@Service("payOrderHandleService")
public class PayOrderHandleServiceImpl implements PayOrderHandleService{

	@Autowired
	private PayOrderService payOrderService;
	
	@Override
	public PayOrderResponse createPayOrder(PayOrderRequest request) {
		
		PayOrder payOrder = new PayOrder();
		payOrder.setMerchantNo("");
		payOrderService.save(payOrder);
		
		return null;
	}

}
