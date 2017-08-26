package me.flyray.rest.controller.cms;

import java.util.HashMap;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> c761494a72cd1e1c09865936d9875eefcb2fa348
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
<<<<<<< HEAD
import me.flyray.cms.api.InterestGroupCategoryService;
import me.flyray.cms.api.InterestGroupService;
=======
import me.flyray.crm.api.WeixinCommonService;
>>>>>>> c761494a72cd1e1c09865936d9875eefcb2fa348

/** 
* @author: bolei
* @date：2017年3月7日 下午8:15:40 
* @description：类说明 
*/

@RestController
@RequestMapping("/activity")
public class ActivityController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ActivityService activityService;
<<<<<<< HEAD
	@Autowired
	private InterestGroupService interestGroupService;
	@Autowired
	private InterestGroupCategoryService interestGroupCategoryService;
=======
>>>>>>> c761494a72cd1e1c09865936d9875eefcb2fa348
	/**
	 * 查询客户信息
	 * 包括客户账户信息
	 * query
	 */
	@ResponseBody
	@RequestMapping(value="/query", method = RequestMethod.GET)
	public Map<String, Object> queryCustomerInfo(@RequestBody Map<String, String> param){
<<<<<<< HEAD
		Map<String, Object> resultMap = new HashMap<String, Object>();
		logger.info("查询活动首页信息------start------{}",param);
		
		
		
		
		logger.info("查询活动首页信息------end------{}",resultMap);
		return resultMap;
=======
		return null;
//		logger.info("查询客户信息------start------{}",param);
//		
//		logger.info("查询客户信息------end------{}",resultMap);
//		return resultMap;
>>>>>>> c761494a72cd1e1c09865936d9875eefcb2fa348
	}
	
	
}
