package me.flyray.pay.service.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.common.service.AbstractBaseService;
import me.flyray.pay.api.PayChannelService;
import me.flyray.pay.dao.PayChannelDao;
import me.flyray.pay.model.PayChannel;

/** 
* @author: bolei
* @date：2017年4月6日 下午10:57:07 
* @description：支付通道
*/

@Service("payChannelService")
public class PayChannelServiceImpl extends AbstractBaseService<PayChannel> implements PayChannelService{
	
	private static final Logger logger = LoggerFactory.getLogger(PayChannelServiceImpl.class);
	
	@Autowired
	private PayChannelDao payChannelDao;
	
}
