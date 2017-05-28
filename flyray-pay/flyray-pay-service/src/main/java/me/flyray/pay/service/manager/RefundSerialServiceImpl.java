package me.flyray.pay.service.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.common.service.AbstractBaseService;
import me.flyray.pay.api.RefundSerialService;
import me.flyray.pay.dao.RefundSerialDao;
import me.flyray.pay.model.RefundSerial;

/** 
* @author: bolei
* @date：2017年4月8日 下午10:54:36 
* @description：退款流水 
*/

@Service("refundSerialService")
public class RefundSerialServiceImpl extends AbstractBaseService<RefundSerial> implements RefundSerialService{

	@Autowired
	private RefundSerialDao refundSerialDao;
	
}
