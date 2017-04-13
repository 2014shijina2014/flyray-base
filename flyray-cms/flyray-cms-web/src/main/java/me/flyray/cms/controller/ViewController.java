package me.flyray.cms.controller;

import me.flyray.cms.service.ViewServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	public ViewServiceImpl viewService;
	
	@RequestMapping(value="/view", method = RequestMethod.GET)
	public ModelAndView view(String id){
		String path = viewService.view(id);
		return new ModelAndView("view","message",path);
	}
	
}
