package me.flyray.rest.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;

/** 
* @author: bolei
* @date：2017年9月16日 上午10:51:41
* @description：拦截所有请求
*/

public class CommonInterceptor extends HandlerInterceptorAdapter{  

	private static final Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  
        throws Exception { 
		logger.info("HandlerInterceptorAdapter------start------{}",request);
        return true;
    }  
    public void postHandle(  
        HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)  
        throws Exception {  
    	logger.info("HandlerInterceptorAdapter------处理相应start------{}",response);
    	
    	logger.info("HandlerInterceptorAdapter------处理相应end------{}",response);
    }  
    public void afterCompletion(  
        HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)  
        throws Exception {  
    	logger.info("HandlerInterceptorAdapter------处理相应start------{}",response);
    	
    	logger.info("HandlerInterceptorAdapter------处理相应end------{}",response);
    }  
    
    /**
     * getInputStream()和getReader() 都只能读取一次，由于RequestBody是流的形式读取，那么流读了一次就没有了，所以只能被调用一次。
     * 先将RequestBody保存，然后通过Servlet自带的HttpServletRequestWrapper类覆盖getReader()和getInputStream()方法，
     * 使流从保存的body读取。然后再Filter中将ServletRequest替换为ServletRequestWrapper
     */
    
}
