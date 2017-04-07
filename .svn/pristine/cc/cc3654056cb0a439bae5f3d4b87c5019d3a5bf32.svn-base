package me.flyray.rbac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.flyray.rbac.service.TestServiceImpl;


@Controller
public class UserController {
	
	@Autowired
	private TestServiceImpl testService;
	
	@ResponseBody
	@RequestMapping(value="/displayAllUser", method = RequestMethod.GET)
	public void displayAllUser() {
		testService.displayAllUser();
	}

}
