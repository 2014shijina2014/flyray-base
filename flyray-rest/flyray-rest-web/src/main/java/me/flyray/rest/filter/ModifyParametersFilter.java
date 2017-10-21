package me.flyray.rest.filter;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import jodd.io.StreamUtil;
import me.flyray.common.exception.BusinessException;

/** 
* @author: bolei
* @date：Jun 22, 2017 8:31:58 AM
* @description：用装饰模式来修改请求中的参数
* 一次请求只通过一次filter
*/

public class ModifyParametersFilter extends OncePerRequestFilter{

	private static final Logger logger = LoggerFactory.getLogger(ModifyParametersFilter.class);
	JSONObject reqJson;
	@Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        ModifyParametersWrapper mParametersWrapper = new ModifyParametersWrapper(request);
        try {
        	if (reqJson == null) {
        		out(response,"请求参数不能为空");
			}
        	if(reqJson.get("customerId") != null || reqJson.get("orgId") != null
        			|| reqJson.get("merchantId") != null){
        		out(response,"customerId、merchantId和orgId不能为空");
        	}
        	filterChain.doFilter(mParametersWrapper, response);
        } catch (RuntimeException e) {  
            if(e instanceof BusinessException){//如果是你定义的业务异常  
                request.setAttribute("BusinessException", e);//存储业务异常信息类  
            }
            e.printStackTrace();  
        } 
    }
	
    /**
     * 继承HttpServletRequestWrapper，创建装饰类，以达到修改HttpServletRequest参数的目的
     */
    private class ModifyParametersWrapper extends HttpServletRequestWrapper {
        private Map<String, String[]> parameterMap; // 所有参数的Map集合
        private final byte[] body;  
        @SuppressWarnings("unchecked")
		public ModifyParametersWrapper(HttpServletRequest request) throws IOException {
            super(request);
            
			// body = StreamUtil.readBytes(request.getReader(), JoddDefault.encoding);
			// 因为http协议默认传输的编码就是iso-8859-1,如果使用utf-8转码乱码的话，可以尝试使用iso-8859-1
			body = StreamUtil.readBytes(request.getInputStream());
			String req = new String(body,"UTF-8");
			reqJson= JSONObject.parseObject(req); 
        }
        // 重写几个HttpServletRequestWrapper中的方法
        @Override  
        public BufferedReader getReader() throws IOException {  
            return new BufferedReader(new InputStreamReader(getInputStream()));  
        }  
      
        @Override  
        public ServletInputStream getInputStream() throws IOException {  
            final ByteArrayInputStream bais = new ByteArrayInputStream(body);  
            return new ServletInputStream() {  
      
                @Override  
                public int read() throws IOException {  
                    return bais.read();  
                }

				@Override
				public boolean isFinished() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean isReady() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public void setReadListener(ReadListener readListener) {
					// TODO Auto-generated method stub
					
				}  
            };  
        }  
    }
    
    /**
     * 返回输出json
     *
     * @param response
     * @param resultCode
     */
    private static final void out(HttpServletResponse response, String msg) {
        ObjectMapper objectMapper = new ObjectMapper();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("code", "01");
            map.put("msg", msg);
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
