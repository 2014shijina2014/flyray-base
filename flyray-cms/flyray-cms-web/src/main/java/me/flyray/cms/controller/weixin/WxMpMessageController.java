package me.flyray.cms.controller.weixin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

/** 
* @author: bolei
* @date：2017年3月18日 下午1:44:20 
* @description：微信发送模板消息
*/

@Controller
public class WxMpMessageController {

	@Autowired
	private WxMpService wxMpService;
	
	@RequestMapping(value="/weixin/sendMsg", method = RequestMethod.POST)
	public void getWxCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
		templateMessage.setToUser("");
		templateMessage.setTemplateId("");
		templateMessage.setUrl("");
		templateMessage.getData().add(new WxMpTemplateData("", "", ""));
		templateMessage.getData().add(new WxMpTemplateData("", "", ""));
		wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
		
	}
}
