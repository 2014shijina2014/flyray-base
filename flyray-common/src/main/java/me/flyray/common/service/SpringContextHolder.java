package me.flyray.common.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/** 
* @author: bolei
* @date：2017年4月30日 下午12:42:21 
* @description：类说明 
*/

public class SpringContextHolder implements ApplicationContextAware{

	 /**  
     * 以静态变量保存ApplicationContext,可在任意代码中取出ApplicaitonContext.  
     */    
   private static ApplicationContext context;    
   
   /**  
    * 实现ApplicationContextAware接口的context注入函数, 将其存入静态变量.  
    */    
   public void setApplicationContext(ApplicationContext context) {    
       SpringContextHolder.context =context;    
   }       
   public static ApplicationContext getApplicationContext() {    
       return context;    
   }    
   /**  
    * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.  
    */
   @SuppressWarnings("unchecked")
   public static <T> T getBean(String name) {    
       return (T) context.getBean(name);    
   }    

}
