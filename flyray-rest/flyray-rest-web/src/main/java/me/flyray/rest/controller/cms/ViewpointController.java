package me.flyray.rest.controller.cms;

import java.util.Map;

import org.apache.zookeeper.proto.GetACLRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.flyray.rest.util.ResponseHelper;

/** 
* @author: bolei
* @date：2017年8月19日 下午2:00:46
* @description：首页圈子
*/

@Controller
@RequestMapping("/api/cms/viewpoints")
public class ViewpointController {
	
	/**
	 * 添加观点
	 */
	@ResponseBody
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public Map<String, Object> add(@RequestBody Map<String, String> param) {
		
		String pointText = param.get("pointText");
		System.out.println(pointText);
		return ResponseHelper.success(param, "00", "创建支付订单成功");
	}
}
