package me.flyray.rest.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/** 
* @author: bolei
* @date：2017年9月16日 上午10:51:41
* @description：拦截所有请求
*/

public class CommonInterceptor extends HandlerInterceptorAdapter{  

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  
        throws Exception { 
        return true;
    }  
    public void postHandle(  
        HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)  
        throws Exception {  
    }  
    public void afterCompletion(  
        HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)  
        throws Exception {  
    }  
}
