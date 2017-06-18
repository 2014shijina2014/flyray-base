package me.flyray.pay.service.refund;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import me.flyray.pay.api.RefundHandlerService;
import me.flyray.pay.dto.RefundRequest;
import me.flyray.pay.dto.RefundResponse;

/** 
* @author: bolei
* @date：Jun 14, 2017 7:29:25 AM 
* @description：退款逻辑接口
*/

@Service("refundHandlerService")
public class RefundHandlerServiceImpl implements RefundHandlerService{

	private static final Logger logger = LoggerFactory.getLogger(RefundHandlerServiceImpl.class);
	
	
	@Override
	public RefundResponse refund(RefundRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
