package me.flyray.pay.service.manager;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.common.service.AbstractBaseService;
import me.flyray.pay.api.PayChannelConfigService;
import me.flyray.pay.dao.PayChannelConfigDao;
import me.flyray.pay.model.PayChannelConfig;

/** 
* @author: bolei
* @date：2017年4月6日 下午10:53:36 
* @description：类说明 
*/

@Service("payChannelConfigService")
public class PayChannelConfigServiceImpl extends AbstractBaseService<PayChannelConfig> implements PayChannelConfigService{

	@Autowired
	private PayChannelConfigDao payChannelConfigDao;

	@Override
	public PayChannelConfig getPayChannelConfig(String merchantNo, String payChannelNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
