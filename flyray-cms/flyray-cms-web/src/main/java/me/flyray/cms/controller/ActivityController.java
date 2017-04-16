package me.flyray.cms.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.flyray.cms.dto.ResponseHelper;
import me.flyray.cms.model.Activity;
import me.flyray.cms.util.BeanUtil;

/** 
* @author: bolei
* @date：2017年3月7日 下午8:15:40 
* @description：类说明 
*/

@RestController
@RequestMapping("/activity")
public class ActivityController {

	private static final Logger logger = LoggerFactory.getLogger(ActivityController.class);
	
	/**
	 * 保存活动
	 */
	@RequestMapping("/save")
	public Map<String, Object> save(@RequestBody Activity activity){
		//数据校验
		try {
			System.out.println(BeanUtil.objectToMap(activity));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseHelper.success(activity, "00", "请求数据成功");
	}
	
}
