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

import me.flyray.pay.api.RefundHandlerService;

/** 
* @author: bolei
* @date：Jun 14, 2017 7:33:41 AM 
* @description：退款接口
*/

@Controller
@RequestMapping("/refund")
public class RefundHandlerControler {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private RefundHandlerService refundHandlerService;
	
	/**
	  * 退款申请
	  * apply
	  */
	@ResponseBody
	@RequestMapping(value="/apply", method = RequestMethod.POST)
	public Map<String, Object> apply(@RequestBody Map<String, String> param) {
		return null;
	}
	
	/**
	 * 退款查询查询
	 * query
	 */
	@ResponseBody
	@RequestMapping(value="/query", method = RequestMethod.POST)
	public Map<String, Object> query(@RequestBody Map<String, String> param) {
		return null;
	}
}
