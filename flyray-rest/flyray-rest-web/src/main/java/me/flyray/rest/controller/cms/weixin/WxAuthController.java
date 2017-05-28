package me.flyray.rest.controller.cms.weixin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.flyray.cms.api.WeixinCommonService;

/** 
* @author: bolei
* @date：2017年3月11日 下午10:55:05 
* @description：微信授权
*/

@Controller
public class WxAuthController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WeixinCommonService weixinCommonService;
	
	
	/**
	 * 获取到微信授权重定向时的参数
	 * 通过code获取用户授权信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/weixin/getWxUser", method = RequestMethod.POST)
	public void getWxCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String code = request.getParameter("code");
		String merchantNo = request.getParameter("merchantNo");
		Map<String, Object> requestMap = new HashMap<>();
		requestMap.put("code", code);
		requestMap.put("merchantNo", merchantNo);
		Map<String, Object> userMap = weixinCommonService.getOauthUserInfo(requestMap);
        
	} 
	
	
}
