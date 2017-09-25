package me.flyray.rest.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/** 
* @author: bolei
* @date：Jun 22, 2017 7:46:36 AM 
* @description：登录拦截器
* WebRequestInterceptor 中对WebRequest 进行的所有操作都将同步到HttpServletRequest 中，然后在当前请求中一直传递 
*/

public class LoginInterceptor implements WebRequestInterceptor{

	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public void afterCompletion(WebRequest arg0, Exception arg1) throws Exception {
		// TODO Auto-generated method stub
		logger.info("WebRequestInterceptor---登陆授权拦截开始---start------{}",arg0);
	}

	@Override
	public void postHandle(WebRequest arg0, ModelMap arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preHandle(WebRequest arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}


}
