package me.flyray.pay.service.manager;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.common.service.AbstractBaseService;
import me.flyray.pay.api.PayOrderService;
import me.flyray.pay.api.PaySerialService;
import me.flyray.pay.dao.PaySerialDao;
import me.flyray.pay.model.PaySerial;

/** 
* @author: bolei
* @date：2017年4月8日 下午10:53:03 
* @description：支付流水
*/

@Service("paySerialService")
public class PaySerialServiceImpl extends AbstractBaseService<PaySerial> implements PaySerialService{

	@Autowired
	private PaySerialDao paySerialDao;
	
}
