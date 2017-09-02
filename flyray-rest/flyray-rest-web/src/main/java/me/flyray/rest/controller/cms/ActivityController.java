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
import me.flyray.cms.model.Activity;
import me.flyray.cms.model.InterestGroup;
import me.flyray.cms.model.InterestGroupCategory;
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
	 * 查询客户首页活动页面信息
	 * query
	 */
	@ResponseBody
	@RequestMapping(value="/query", method = RequestMethod.POST)
	public Map<String, Object> queryCustomerInfo(@RequestBody Map<String, String> param){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		logger.info("查询活动首页信息------start------{}",param);
		
		// TODO 用户登录后获取到机构id和商户id后替换参数
		Long orgId = 2l;
		Long merId = 1l;
		List<Activity> recActivities = activityService.selectRecommendActivity(orgId, merId);
		logger.info("查询活动首页信息------查询推荐活动记录------{}",recActivities);
		
		InterestGroupCategory groupCategory = new InterestGroupCategory();
		groupCategory.setOrgId(orgId);
		groupCategory.setMerchantId(merId);
		logger.info("查询活动首页信息------查询兴趣小组类别请求参数------{}",groupCategory.toString());
		List<InterestGroupCategory> groupCategories = interestGroupCategoryService.selectByBizKeys(groupCategory);
		logger.info("查询活动首页信息------查询兴趣小组类别响应参数------{}",groupCategories);
		if (null != groupCategories) {
			for (int i = 0; i < groupCategories.size(); i++) {
				InterestGroupCategory groupCategoryItem = groupCategories.get(i); 
				InterestGroup group = new InterestGroup();
				group.setOrgId(orgId);
				group.setMerchantId(merId);
				group.setGroupCategoryId(groupCategoryItem.getId());
				group.setFlag("20");
				logger.info("查询活动首页信息------查询兴趣小组请求参数------{}",group.toString());
				List<InterestGroup> groups = interestGroupService.selectByBizKeys(group);
				logger.info("查询活动首页信息------查询兴趣小组响应参数------{}",groupCategories);
				groupCategoryItem.setGroupList(groups);
			}
		}
		
		
		resultMap.put("activities", recActivities);
		resultMap.put("groupCategories", groupCategories);
		
		logger.info("查询活动首页信息------end------{}",resultMap);
		return ResponseHelper.success(resultMap, "00", "请求数据成功");
	}
	
	
}
