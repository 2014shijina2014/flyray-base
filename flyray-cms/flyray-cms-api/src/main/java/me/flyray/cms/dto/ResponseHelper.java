package me.flyray.cms.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.flyray.cms.util.BeanUtil;

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
			if (clazz instanceof Map) {
				map.put("data", clazz);
				return map;
			}if (clazz instanceof List) {
				Map<String,Object> reMap = new HashMap<String, Object>();
				reMap.put("list", clazz);
				return reMap;
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
