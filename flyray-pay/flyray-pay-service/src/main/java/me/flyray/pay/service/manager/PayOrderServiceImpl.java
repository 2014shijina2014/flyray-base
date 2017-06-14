package me.flyray.pay.service.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.common.service.AbstractBaseService;
import me.flyray.pay.api.PayOrderService;
import me.flyray.pay.dao.PayOrderDao;
import me.flyray.pay.model.PayOrder;

/** 
* @author: bolei
* @date：2017年4月8日 下午10:52:08 
* @description：支付订单
*/

@Service("payOrderService")
public class PayOrderServiceImpl extends AbstractBaseService<PayOrder> implements PayOrderService{

	@Autowired
	private PayOrderDao payOrderDao;

	@Override
	public void save(PayOrder payOrder) {
		payOrderDao.save(payOrder);
	}

	@Override
	public PayOrder queryByPayOrder(PayOrder payOrder) {
		return payOrderDao.queryObject(payOrder);
	}
	
}
