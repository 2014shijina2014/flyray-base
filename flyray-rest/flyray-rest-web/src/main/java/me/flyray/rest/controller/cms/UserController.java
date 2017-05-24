package me.flyray.rest.controller.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class UserController {
	
	@ResponseBody
	@RequestMapping(value="/displayAllUser", method = RequestMethod.GET)
	public void displayAllUser() {
		
	}

}
