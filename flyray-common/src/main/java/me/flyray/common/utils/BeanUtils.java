package me.flyray.common.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/** 
* @author: bolei
* @date：2017年3月7日 下午10:04:01 
* @description：bean map 转换类
*/

public class BeanUtils {

	public BeanUtils()
    {
    }

	public static Map<String, Object> objectToMap(Object obj) throws Exception {    
        if(obj == null)  
            return null;      
  
        Map<String, Object> map = new HashMap<String, Object>();   
  
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());    
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();    
        for (PropertyDescriptor property : propertyDescriptors) {    
            String key = property.getName();    
            if (key.compareToIgnoreCase("class") == 0) {   
                continue;  
            }  
            Method getter = property.getReadMethod();  
            Object value = getter!=null ? getter.invoke(obj) : null;  
            map.put(key, value);  
        }    
  
        return map;  
    }
	
	/**
	 * 建议用使用reflect进行转换，因为使用Introspector进行转换 有问题
	 * @param map
	 * @param beanClass
	 * @return
	 * @throws Exception
	 */
	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {  
		
		/*if (map == null)     
            return null;      
     
        Object obj = beanClass.newInstance();    
     
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());      
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();      
        for (PropertyDescriptor property : propertyDescriptors) {    
            Method setter = property.getWriteMethod();      
            if (setter != null) {    
                setter.invoke(obj, map.get(property.getName()));     
            }    
        }*/    
        
        if (map == null)    
            return null; 
     
        Object obj = beanClass.newInstance(); 
     
        org.apache.commons.beanutils.BeanUtils.populate(obj, map);    
     
        return obj;
    }     
}
