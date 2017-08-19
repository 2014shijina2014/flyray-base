package me.flyray.rest.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/** 
* @author: bolei
* @date：Jun 22, 2017 8:31:58 AM
* @description：用装饰模式来修改请求中的参数
*/

public class ModifyParametersFilter extends OncePerRequestFilter{

	@Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        ModifyParametersWrapper mParametersWrapper = new ModifyParametersWrapper(request);
        filterChain.doFilter(mParametersWrapper, response);
    }
 
    /**
     * 继承HttpServletRequestWrapper，创建装饰类，以达到修改HttpServletRequest参数的目的
     */
    private class ModifyParametersWrapper extends HttpServletRequestWrapper {
        private Map<String, String[]> parameterMap; // 所有参数的Map集合
 
        @SuppressWarnings("unchecked")
		public ModifyParametersWrapper(HttpServletRequest request) {
            super(request);
            parameterMap = request.getParameterMap();
        }
 
        // 重写几个HttpServletRequestWrapper中的方法
        /**
         * 获取所有参数名
         * 
         * @return 返回所有参数名
         */
        @Override
        public Enumeration<String> getParameterNames() {
            Vector<String> vector = new Vector<String>(parameterMap.keySet());
            return vector.elements();
        }
 
        /**
         * 获取指定参数名的值，如果有重复的参数名，则返回第一个的值 接收一般变量 ，如text类型
         * 
         * @param name
         *            指定参数名
         * @return 指定参数名的值
         */
        @Override
        public String getParameter(String name) {
            String[] results = parameterMap.get(name);
            if (results == null || results.length <= 0)
                return null;
            else {
                System.out.println("修改之前： " + results[0]);
                return modify(results[0]);
            }
        }
 
        /**
         * 获取指定参数名的所有值的数组，如：checkbox的所有数据 
         * 接收数组变量 ，如checkobx类型
         */
        @Override
        public String[] getParameterValues(String name) {
            String[] results = parameterMap.get(name);
            if (results == null || results.length <= 0)
                return null;
            else {
                int length = results.length;
                for (int i = 0; i < length; i++) {
                    System.out.println("修改之前2： " + results[i]);
                    results[i] = modify(results[i]);
                }
                return results;
            }
        }
 
        /**
         * 自定义的一个简单修改原参数的方法，即：给原来的参数值前面添加了一个修改标志的字符串
         * 
         * @param string
         *            原参数值
         * @return 修改之后的值
         */
        private String modify(String string) {
            return "Modified: " + string;
        }
    }

}
