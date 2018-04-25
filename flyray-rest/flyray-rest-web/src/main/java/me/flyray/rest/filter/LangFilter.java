package me.flyray.rest.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.druid.support.json.JSONUtils;

/** 
* @author: bolei
* @date：2018年4月10日 上午11:16:13
* @description：类说明 
*/

public class LangFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        ChangeRequestWrapper changeRequestWrapper = new ChangeRequestWrapper((HttpServletRequest) servletRequest);

        Map<String, String[]> parameterMap = new HashMap<>(changeRequestWrapper.getParameterMap());

        String[] strings = parameterMap.get("lang");
           //逻辑代码给定默认的参数值,如果参数不为中文,则直接返回异常
        if (strings == null || strings.length == 0) {
            strings = new String[1];
            strings[0] = "zh";
            parameterMap.put("lang", strings);
            changeRequestWrapper.setParameterMap(parameterMap);
        }else{
            String language = strings[0];
            if (!language.equals("zh")) {
                Map<String,String> error = new HashMap<>();
                error.put("code","500");

                ServletOutputStream outputStream = null;
                try {
                    outputStream = servletResponse.getOutputStream();
                    outputStream.write(1);
                } finally {
                    if (outputStream != null) {
                        outputStream.flush();
                        outputStream.close();
                    }
                }

                return;
            }
        }
        //使用复写后的wrapper
        filterChain.doFilter(changeRequestWrapper, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
