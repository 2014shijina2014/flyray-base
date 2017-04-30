package me.flyray.pay.service.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.common.service.AbstractBaseService;
import me.flyray.pay.api.PayChannelInterfaceService;
import me.flyray.pay.dao.PayChannelInterfaceDao;
import me.flyray.pay.model.PayChannelInterface;

/** 
* @author: bolei
* @date：2017年4月6日 下午10:56:37 
* @description：支付通道接口 
*/

@Service("payChannelInterfaceService")
public class PayChannelInterfaceServiceImpl extends AbstractBaseService<PayChannelInterface> implements PayChannelInterfaceService{

	@Autowired
	private PayChannelInterfaceDao payChannelInterfaceDao;

	@Override
	public PayChannelInterface getPayChannelInterface(String payChannelNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
