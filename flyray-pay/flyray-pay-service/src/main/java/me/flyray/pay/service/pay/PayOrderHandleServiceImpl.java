package me.flyray.pay.service.pay;

import org.springframework.stereotype.Service;

import me.flyray.pay.api.PayOrderHandleService;
import me.flyray.pay.dto.PayOrderHandleRequest;
import me.flyray.pay.dto.PayOrderHandleResponse;

/** 
* @author: bolei
* @date：2017年4月30日 下午1:25:53 
* @description：支付订单处理
*/

@Service("payOrderHandleService")
public class PayOrderHandleServiceImpl implements PayOrderHandleService{

	@Override
	public PayOrderHandleResponse createPayOrder(PayOrderHandleRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
