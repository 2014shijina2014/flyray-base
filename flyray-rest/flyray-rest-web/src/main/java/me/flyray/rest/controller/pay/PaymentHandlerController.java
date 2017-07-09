package me.flyray.rest.controller.pay;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.flyray.pay.api.PaymentHandlerService;
import me.flyray.pay.dto.CreateOrderRequst;
import me.flyray.pay.dto.PayOrderRequest;
import me.flyray.rest.util.ResponseHelper;

/** 
* @author: bolei
* @date：Jun 14, 2017 7:33:10 AM 
* @description：支付接口
*/

@Controller
@RequestMapping("/pay")
public class PaymentHandlerController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PaymentHandlerService paymentHandlerService;
	
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
		paymentHandlerService.createOrder(createOrder);
		//生成账单
		return ResponseHelper.success(createOrder, "00", "创建支付订单成功");
	}
	
	/**
	 * 交易支付
	  * pay
	  */
	@ResponseBody
	@RequestMapping(value="/pay", method = RequestMethod.POST)
	public Map<String, Object> pay(@RequestBody Map<String, String> param) {
		logger.info("请求支付---start---{}",param);
		PayOrderRequest payRequest = new PayOrderRequest();
		payRequest.setPayOrderNo((String)param.get("payOrderNo"));
		payRequest.setBankCode((String)param.get("bankCode"));
		payRequest.setPayChannelNo((String)param.get("payChannelNo"));
		payRequest.setPayMethod((String)param.get("payMethod"));
		paymentHandlerService.pay(payRequest);
		return ResponseHelper.success(null, "00", "支付请求成功");
	}
	
	/**
	 * 支付交易取消
	  * cancel
	  */
	@ResponseBody
	@RequestMapping(value="/cancel", method = RequestMethod.POST)
	public Map<String, Object> cancel(@RequestBody Map<String, String> param) {
		return null;
	}
	
	/**
	 * 支付交易查询
	 * query
	 */
	@ResponseBody
	@RequestMapping(value="/query", method = RequestMethod.POST)
	public Map<String, Object> query(@RequestBody Map<String, String> param) {
		return null;
	}
}
