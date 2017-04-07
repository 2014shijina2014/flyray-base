package me.flyray.crm.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.flyray.crm.api.UserService;
import me.flyray.crm.model.User;



@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value="/displayAllUser", method = RequestMethod.GET)
	public HashMap<String, List<User>> displayAllUser() {
		HashMap<String, List<User>> map = new HashMap<String, List<User>>();
		map.put("users", userService.displayAllUser());
		return map;
	}

}
