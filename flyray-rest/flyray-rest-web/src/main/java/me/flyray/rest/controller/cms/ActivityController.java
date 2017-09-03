package me.flyray.rest.controller.cms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import me.flyray.cms.api.ActivityService;
import me.flyray.cms.api.InterestGroupCategoryService;
import me.flyray.cms.api.InterestGroupService;
import me.flyray.rest.util.ResponseHelper;

/** 
* @author: bolei
* @date：2017年3月7日 下午8:15:40 
* @description：类说明 
*/

@RestController
@RequestMapping("/api/cms/activity")
public class ActivityController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ActivityService activityService;
	@Autowired
	private InterestGroupService interestGroupService;
	@Autowired
	private InterestGroupCategoryService interestGroupCategoryService;
	/**
	 * 查询客户信息
	 * 包括客户账户信息
	 * query
	 */
	@ResponseBody
	@RequestMapping(value="/query", method = RequestMethod.POST)
	public Map<String, Object> queryCustomerInfo(@RequestBody Map<String, String> param){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		logger.info("查询活动首页信息------start------{}",param);
		
		resultMap.put("value", "001");
		List<String> a = new ArrayList<String>();
		a.add("lala");
		a.add("niuniu");
		resultMap.put("list", a);
		
		logger.info("查询活动首页信息------end------{}",resultMap);
		return ResponseHelper.success(resultMap, "00", "请求数据成功");
	}
	
	
}
