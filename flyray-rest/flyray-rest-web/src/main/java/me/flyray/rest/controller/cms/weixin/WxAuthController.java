package me.flyray.rest.controller.cms.weixin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** 
* @author: bolei
* @date：2017年3月11日 下午10:55:05 
* @description：微信授权
*/

@Controller
public class WxAuthController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@RequestMapping(value="/weixin/getWxCode", method = RequestMethod.GET)
	public void getWxCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	} 
	
	
}
