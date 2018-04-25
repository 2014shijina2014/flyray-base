package me.flyray.rest.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
* @author: bolei
* @date：2018年4月10日 上午11:27:51
* @description：类说明 
*/

public class MyCharsetFilter implements Filter  
{  
    private FilterConfig config = null;  
      
    public void destroy()  
    {  
        System.out.println("MyCharsetFilter准备销毁...");  
    }  
  
    public void doFilter(ServletRequest arg0, ServletResponse arg1,FilterChain chain) throws IOException, ServletException  
    {  
        // 强制类型转换  
        HttpServletRequest request = (HttpServletRequest) arg0;  
        HttpServletResponse response = (HttpServletResponse) arg1;  
        // 获取web.xm设置的编码集，设置到Request、Response中  
        request.setCharacterEncoding(config.getInitParameter("charset"));  
        response.setContentType(config.getInitParameter("contentType"));  
        response.setCharacterEncoding(config.getInitParameter("charset"));  
        // 将请求转发到目的地  
        chain.doFilter(request, response);  
    }  
  
    public void init(FilterConfig arg0) throws ServletException  
    {  
        this.config = arg0;  
        System.out.println("MyCharsetFilter初始化...");  
    }  
}
