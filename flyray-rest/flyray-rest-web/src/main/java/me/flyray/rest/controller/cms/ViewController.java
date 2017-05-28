package me.flyray.rest.controller.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author huoxiaoqiang
 *
 */
@Controller
public class ViewController {

	@RequestMapping(value="/view", method = RequestMethod.GET)
	public ModelAndView view(String id){
		
		return new ModelAndView("view","message",id);
	}
	
}
