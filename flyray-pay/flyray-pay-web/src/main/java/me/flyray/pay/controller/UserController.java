package me.flyray.pay.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.flyray.pay.model.PayChannel;
import me.flyray.pay.service.manager.PayChannelServiceImpl;



@Controller
public class UserController {
	
	@Autowired
	private PayChannelServiceImpl payChannelServiceImpl;
	
	@ResponseBody
	@RequestMapping(value="/displayAllUser", method = RequestMethod.GET)
	public HashMap<String, List<PayChannel>> displayAllUser() {
		HashMap<String, List<PayChannel>> map = new HashMap<String, List<PayChannel>>();
		//map.put("users", userService.displayAllUser());
		Map<String, Object> map1 = new HashMap<>();
		map1.put("payChannelNo", "payChannelNo");
		map1.put("payCompanyNo", "payCompanyNo");
		map1.put("feeRatio", "1");
		payChannelServiceImpl.save(map1);
		
		return map;
	}

}
