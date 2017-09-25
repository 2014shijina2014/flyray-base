package me.flyray.rest.interceptor;

import java.io.BufferedReader;
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

import com.alibaba.fastjson.JSONObject;
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
		HttpServletRequest _request;
		_request = request;
		 
        StringBuffer jsonStr = new StringBuffer();
        try (BufferedReader bufferedReader = _request.getReader())
        {
            String line;
            while ((line = bufferedReader.readLine()) != null)
                jsonStr.append(line);
        }
        //获取到提交测json，将密码解密后重新复制给requestBody
        JSONObject json = JSONObject.parseObject(jsonStr.toString());
        if (json.get("orgNo") == null || json.get("orgNo") == "") {
        	out(response);
        	return false;
		}
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
    
    /**
     * getInputStream()和getReader() 都只能读取一次，由于RequestBody是流的形式读取，那么流读了一次就没有了，所以只能被调用一次。
     * 先将RequestBody保存，然后通过Servlet自带的HttpServletRequestWrapper类覆盖getReader()和getInputStream()方法，
     * 使流从保存的body读取。然后再Filter中将ServletRequest替换为ServletRequestWrapper
     */
    /**
     * 返回输出json
     *
     * @param response
     * @param resultCode
     */
    private static final void out(HttpServletResponse response) {
        ObjectMapper objectMapper = new ObjectMapper();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("code", "01");
            map.put("msg", "orgNo 不能为空");
            map.put("status", "201");
            out.append(objectMapper.writeValueAsString(map));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
