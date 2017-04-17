package me.flyray.pay.service.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.common.service.AbstractBaseService;
import me.flyray.pay.api.RefundOrderService;
import me.flyray.pay.dao.RefundOrderDao;
import me.flyray.pay.model.RefundOrder;

/** 
* @author: bolei
* @date：2017年4月8日 下午10:54:13 
* @description：退款订单 
*/

@Service("refundOrderService")
public class RefundOrderServiceImpl extends AbstractBaseService<RefundOrder> implements RefundOrderService{

	@Autowired
	private RefundOrderDao refundOrderDao;
	
}
