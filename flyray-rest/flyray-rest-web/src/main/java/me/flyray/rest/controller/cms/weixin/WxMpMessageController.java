package me.flyray.rest.controller.cms.weixin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** 
* @author: bolei
* @date：2017年3月18日 下午1:44:20 
* @description：微信发送模板消息
*/

@Controller
public class WxMpMessageController {
	
	@RequestMapping(value="/weixin/sendMsg", method = RequestMethod.POST)
	public void getWxCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	}
}
