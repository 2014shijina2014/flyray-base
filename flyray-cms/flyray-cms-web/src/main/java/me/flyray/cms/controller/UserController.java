package me.flyray.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.flyray.cms.service.UserServiceImpl;



@Controller
public class UserController {
	
	@Autowired
	private UserServiceImpl cmsUserService;
	
	@ResponseBody
	@RequestMapping(value="/displayAllUser", method = RequestMethod.GET)
	public void displayAllUser() {
		cmsUserService.displayAllUser();
	}

}
