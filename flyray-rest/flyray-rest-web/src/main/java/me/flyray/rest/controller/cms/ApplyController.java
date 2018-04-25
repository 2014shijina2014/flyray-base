package me.flyray.rest.controller.cms;


import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApplyController {

	@RequestMapping(value="/apply", method = RequestMethod.GET)
	public String index(){ 
		return "apply";	}
	
	@RequestMapping("/applyForProficient"  )  
	public Map<String,Object> applyForProficient(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {
		
		return null;
	}
	
}
