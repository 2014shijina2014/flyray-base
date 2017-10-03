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
import me.flyray.rest.controller.AbstractController;
import me.flyray.rest.util.PageUtils;
import me.flyray.rest.util.ResponseHelper;

/**
 * @author: bolei
 * @date：2017年3月7日 下午8:15:40
 * @description：类说明
 */

@RestController
@RequestMapping("/api/cms/activity")
public class ActivityController extends AbstractController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ActivityService activityService;
	@Autowired
	private InterestGroupService interestGroupService;
	@Autowired
	private InterestGroupCategoryService interestGroupCategoryService;

	/**
	 * 查询推荐活动
	 */
	@ResponseBody
	@RequestMapping(value = "/queryHotActivity", method = RequestMethod.POST)
	public Map<String, Object> queryHotActivity(@RequestBody Map<String, String> param) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		logger.info("查询推荐活动------start------{}", param);

		// TODO 用户登录后获取到机构id和商户id后替换参数
		Long orgId = null;
		Long merId = null;
		String orgstr = (String) param.get("orgId");
		String merstr = (String) param.get("merId");
		if (null != orgstr && !"".equals(orgstr.trim())) {
			orgId = Long.valueOf(orgstr.trim());
		}
		if (null != merstr && !"".equals(merstr.trim())) {
			merId = Long.valueOf(merstr.trim());
		}
		
		List<Activity> recActivities = activityService.selectRecommendActivity(orgId, merId);
		logger.info("查询活动首页信息------查询推荐活动记录------{}", recActivities);
		resultMap.put("activities", recActivities);

		logger.info("查询活动首页信息------end------{}", resultMap);
		return ResponseHelper.success(resultMap, null, "00", "请求数据成功");
	}
	
	/**
	 * 查询客户信息 包括客户账户信息 query
	 */
	@ResponseBody
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public Map<String, Object> queryCustomerInfo(@RequestBody Map<String, String> param) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		logger.info("查询活动首页信息------start------{}", param);

		// TODO 用户登录后获取到机构id和商户id后替换参数
		Long orgId = null;
		Long merId = null;
		String orgstr = (String) param.get("orgId");
		String merstr = (String) param.get("merId");
		if (null != orgstr && !"".equals(orgstr.trim())) {
			orgId = Long.valueOf(orgstr.trim());
		}
		if (null != merstr && !"".equals(merstr.trim())) {
			merId = Long.valueOf(merstr.trim());
		}

		InterestGroupCategory groupCategory = new InterestGroupCategory();
		groupCategory.setOrgId(orgId);
		groupCategory.setMerchantId(merId);

		Map<String, Object> queryMap = new HashMap<>();
		int resultTotal = interestGroupCategoryService.queryTotal(queryMap);
		queryMap.putAll(getPagination(param));
		List<Map<String, Object>> igcListMap = interestGroupCategoryService.queryList(queryMap);
		
		if (null != igcListMap) {
			for (int i = 0; i < igcListMap.size(); i++) {
				Map<String, Object> groupCategoryItem = igcListMap.get(i);
				Map<String, Object> queryGroupMap = new HashMap<>();
				queryGroupMap.put("orgId", orgId);
				queryGroupMap.put("merId", merId);
				queryGroupMap.put("groupCategoryId", orgId);
				queryGroupMap.put("flag", "20");
				logger.info("查询活动首页信息------查询兴趣小组请求参数------{}", queryGroupMap);
				List<InterestGroup> groups = interestGroupService.query(queryGroupMap);
				logger.info("查询活动首页信息------查询兴趣小组响应参数------{}", groups);
				groupCategoryItem.put("groupList", groups);
			}
		}
		param.put("totalCount", String.valueOf(resultTotal));
		PageUtils pageUtil = new PageUtils(resultTotal, resultTotal, Integer.valueOf(param.get("currentPage")));
		if (isLastPage(param)) {
			return ResponseHelper.success(null,pageUtil, "01", "已经到最后一条了~");
		}
		
		resultMap.put("groupCategories", igcListMap);

		logger.info("查询活动首页信息------end------{}", resultMap);
		return ResponseHelper.success(resultMap,pageUtil, "00", "请求数据成功");
	}

}
