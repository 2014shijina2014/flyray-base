package me.flyray.rest.controller.cms;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import me.flyray.pay.dto.CreateOrderRequst;
import me.flyray.rest.util.ResponseHelper;

/** 
* @author: bolei
* @date：2017年3月7日 下午8:13:48 
* @description：话题
*/

@RestController
@RequestMapping("/api/cms/topics")
public class TopicController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	  * 创建支付交易订单
	  * create
	  */
	@ResponseBody
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public Map<String, Object> create(@RequestBody Map<String, String> param) {
		logger.info("请求创建支付订单---start---{}",param);
		CreateOrderRequst createOrder = new CreateOrderRequst();
		createOrder.setCustomerNo((String)param.get("customerNo"));
		createOrder.setMerchantNo((String)param.get("merchantNo"));
		createOrder.setPayOrderNo((String)param.get("payOrderNo"));
		//生成账单
		return ResponseHelper.success(createOrder, "00", "创建支付订单成功");
	}
}
