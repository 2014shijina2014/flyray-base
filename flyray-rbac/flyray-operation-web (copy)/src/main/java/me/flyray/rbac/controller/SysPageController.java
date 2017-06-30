package me.flyray.rbac.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统页面视图
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月24日 下午11:05:27
 */
@Controller
public class SysPageController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping("{urlPath}/{url}.html")
	public String page(@PathVariable("url") String url,@PathVariable("urlPath") String urlPath){
	    logger.info("模块路径------{}",urlPath);
	    return urlPath +"/"+ url + ".html";
	}

	@RequestMapping("generator/{url}.html")
	public String generator(@PathVariable("url") String url){
		return "generator/" + url + ".html";
	}
}
