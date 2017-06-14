package me.flyray.rest.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
* @author: bolei
* @date：2017年3月7日 下午9:10:22 
* @description：类说明 
*/

public class ResponseHelper {

	public static <T> Map<String, Object> success(Object clazz, String code, String msg) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("code", code);
		map.put("status", "200");
		map.put("msg", msg);
		try {
			if (clazz == null) {
				return map;
			}
			if (clazz instanceof Map) {
				map.put("data", clazz);
				return map;
			}if (clazz instanceof List) {
				map.put("data", clazz);
			}
			else {
				map.put("data", BeanUtil.objectToMap(clazz));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public static <T> Map<String, Object> failure(String code, String msg) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("code", code);
		map.put("status", "200");
		map.put("msg", msg);
		map.put("data", "[]");
		return map;
	}
	
}
