package me.flyray.rest.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import me.flyray.common.exception.BusinessException;

/** 
* @author: bolei
* @date：2017年9月27日 下午12:46:23
* @description：类说明 
*/

public class CommonHandlerExceptionResolver implements HandlerExceptionResolver{

	private static final Logger logger = LoggerFactory.getLogger(CommonHandlerExceptionResolver.class);
	
	@Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        ModelAndView mv = new ModelAndView();
        /* 使用response返回 */
        response.setStatus(HttpStatus.OK.value()); // 设置状态码
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); // 设置ContentType
        response.setCharacterEncoding("UTF-8"); // 避免乱码
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        JSONObject json=new JSONObject();
        json.put("", "");
        json.put("status", "");
        if (ex instanceof BusinessException) {
        	json.put("code", ex.getMessage());
        	json.put("msg", ex.getMessage());
        } else {
        	json.put("msg", "服务异常！");
        }
        response.setCharacterEncoding("UTF-8");
        try {
			response.getWriter().write(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("与客户端通讯异常:" + e.getMessage(), e);
		}
        logger.debug("异常:" + ex.getMessage(), ex);
        return mv;
    }

}
