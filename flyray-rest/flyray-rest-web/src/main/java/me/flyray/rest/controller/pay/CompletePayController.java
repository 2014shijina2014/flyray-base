package me.flyray.rest.controller.pay;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
* @author: bolei
* @date：Jun 14, 2017 7:25:05 AM 
* @description：支付完成回调处理
*/

@Controller
@RequestMapping("/pay")
public class CompletePayController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	  * 接收支付完成回调
	  * 1、做账务处理
	  * 2、订单、流水状态更新
	  * 3、账单状态更新
	  */
	@ResponseBody
	@RequestMapping(value="/complete", method = RequestMethod.POST)
	public Map<String, Object> complete(@RequestBody Map<String, String> param) {
		logger.info("请求创建支付订单---start---{}",param);
		return null;
	}
}
