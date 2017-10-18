package me.flyray.rest.controller.cms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import me.flyray.cms.api.ActivityCustomerService;
import me.flyray.cms.api.ActivityService;
import me.flyray.cms.api.InterestGroupCategoryService;
import me.flyray.cms.api.InterestGroupService;
import me.flyray.cms.model.Activity;
import me.flyray.cms.model.ActivityCustomer;
import me.flyray.cms.model.InterestGroup;
import me.flyray.crm.api.CustomerBaseService;
import me.flyray.crm.model.CustomerBase;
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
	private ActivityCustomerService activityCustomerService;
	@Autowired
	private CustomerBaseService customerBaseService;
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
		String orgId = (String) param.get("orgId");
		String merId = (String) param.get("merId");
		String groupId = (String) param.get("groupId");
		
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("orgId", orgId);
		queryMap.put("merchantId", merId);
		queryMap.put("InterestGroupId", groupId);
		List<Activity> recActivities = activityService.selectRecommendActivity(queryMap);
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

		String orgId = (String) param.get("orgId");
		String merId = (String) param.get("merId");
		
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("orgId", orgId);
		queryMap.put("merchantId", merId);
		int resultTotal = interestGroupCategoryService.queryTotal(queryMap);
		param.put("totalCount", String.valueOf(resultTotal));
		queryMap.putAll(getPagination(param));
		logger.info("查询活动首页信息------查询团队类型请求参数：{}", queryMap);
		List<Map<String, Object>> igcListMap = interestGroupCategoryService.queryList(queryMap);
		logger.info("查询活动首页信息------查询团队类型响应结果：{}", igcListMap);
		
		if (null != igcListMap) {
			for (int i = 0; i < igcListMap.size(); i++) {
				Map<String, Object> groupCategoryItem = igcListMap.get(i);
				Map<String, Object> queryGroupMap = new HashMap<>();
				queryGroupMap.put("orgId", orgId);
				queryGroupMap.put("merchantId", merId);
				queryGroupMap.put("groupCategoryId", groupCategoryItem.get("id"));
				queryGroupMap.put("flag", "20");
				logger.info("查询活动首页信息------查询兴趣小组请求参数------{}", queryGroupMap);
				List<InterestGroup> groups = interestGroupService.query(queryGroupMap);
				logger.info("查询活动首页信息------查询兴趣小组响应参数------{}", groups);
				groupCategoryItem.put("groupList", groups);
			}
		}
		
		int pageSizeInt = Integer.valueOf(param.get("pageSize"));
		PageUtils pageUtil = new PageUtils(resultTotal, pageSizeInt, Integer.valueOf(param.get("currentPage")));
		if (isLastPage(param)) {
			return ResponseHelper.success(null,pageUtil, "01", "已经到最后一条了~");
		}
		
		resultMap.put("groupCategories", igcListMap);

		logger.info("查询活动首页信息------end------{}", resultMap);
		return ResponseHelper.success(resultMap,pageUtil, "00", "请求数据成功");
	}
	
	/**
	 * 查询团队中的活动列表
	 */
	@ResponseBody
	@RequestMapping(value = "/queryGroupActivity", method = RequestMethod.POST)
	public Map<String, Object> queryActivity(@RequestBody Map<String, String> param) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		logger.info("查询团队中的活动列表------start------{}", param);

		String orgId = (String) param.get("orgId");
		String merId = (String) param.get("merId");
		String groupId = (String) param.get("groupId");
		String actStatus = (String) param.get("actStatus");
		
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("orgId", orgId);
		queryMap.put("merchantId", merId);
		queryMap.put("InterestGroupId", groupId);
		queryMap.put("actStatus", actStatus);
		
		int resultTotal = activityService.queryGroupActTotal(queryMap);
		param.put("totalCount", String.valueOf(resultTotal));
		queryMap.putAll(getPagination(param));
		
		logger.info("查询团队中的活动列表------请求参数: {}", queryMap);
		List<Activity> recActivities = activityService.queryGroupActList(queryMap);
		logger.info("查询团队中的活动列表------recActivities: {}", recActivities);
		
		int pageSizeInt = Integer.valueOf(param.get("pageSize"));
		PageUtils pageUtil = new PageUtils(resultTotal, pageSizeInt, Integer.valueOf(param.get("currentPage")));
		if (isLastPage(param)) {
			return ResponseHelper.success(null,pageUtil, "01", "已经到最后一条了~");
		}
		
		resultMap.put("activities", recActivities);

		logger.info("查询团队中的活动列表------end------{}", resultMap);
		return ResponseHelper.success(resultMap, pageUtil, "00", "请求数据成功");
	}
	
	
	/**
	 * 查询活动详细信息
	 */
	@ResponseBody
	@RequestMapping(value = "/queryActivityInfo", method = RequestMethod.POST)
	public Map<String, Object> queryActivityInfo(@RequestBody Map<String, String> param) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		logger.info("查询活动详细信息------start------{}", param);

		String activityId = (String) param.get("activityId");
		String customerId = (String) param.get("customerId");
		if (null == activityId || "".equals(activityId.trim())) {
			logger.info("查询活动详情信息请求参数错误，activityId：{}",activityId);
			return ResponseHelper.success(resultMap, null, "01", "请求数据失败");
		}
		if (null == customerId || "".equals(customerId.trim())) {
			logger.info("用户报名参加活动请求参数错误，customerId：{}",customerId);
			return ResponseHelper.success(resultMap, null, "01", "请求数据失败");
		}
		Activity reqAct = new Activity();
		reqAct.setId(activityId);
		Activity resAct = activityService.queryEntity(reqAct);
		logger.info("查询活动详细信息------{}", resAct);
		ActivityCustomer reqActCus = new ActivityCustomer();
		reqActCus.setActivityId(activityId);
		List<ActivityCustomer> respActCusList = activityCustomerService.selectByBizKeys(reqActCus);
		List<CustomerBase> customerList = null;
		if(null != respActCusList && respActCusList.size() > 0) {
			customerList = new ArrayList<CustomerBase>();
			for (int i = 0; i < respActCusList.size(); i++) {
				ActivityCustomer item = respActCusList.get(i);
				Long custId = Long.valueOf(item.getCustomerId());
				CustomerBase customerBase = customerBaseService.queryByCustomerId(custId);
				customerList.add(customerBase);
			}
		}
		
		ActivityCustomer reqJoinActCus = new ActivityCustomer();
		reqJoinActCus.setActivityId(activityId);
		reqJoinActCus.setCustomerId(customerId);
		List<ActivityCustomer> respJoinActCusList = activityCustomerService.selectByBizKeys(reqJoinActCus);
		if (null != respJoinActCusList && respJoinActCusList.size() > 0) {
			// 已参加
			resultMap.put("isJoin", "1");
		} else {
			// 未参加
			resultMap.put("isJoin", "0");
		}
		CustomerBase customerBase = customerBaseService.queryByCustomerId(Long.valueOf(customerId));
		if (null != customerBase.getPhone() && !"".equals(customerBase.getPhone().trim())) {
			// 已保存过电话
			resultMap.put("isHavPhone", "1");
		} else {
			// 未保存过电话
			resultMap.put("isHavPhone", "0");
		}
		if (null != resAct.getActivityStartTime()) {
			//小写的mm表示的是分钟 
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date startdate= null;
			Date enddate= null;
			try {
				startdate = sdf.parse(resAct.getActivityStartTime());
				enddate = sdf.parse(resAct.getActivityEndTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			if (null != startdate && null != enddate) {
				int i = new Date().compareTo(startdate);
				int j = new Date().compareTo(enddate);
				if (i < 0) {
					// 活动未开始
					resultMap.put("isStart", "0");
				} else if (i >=0 && j < 0) {
					// 活动进行中
					resultMap.put("isStart", "1");
				} else if (j >= 0) {
					// 活动结束
					resultMap.put("isStart", "2");
				}
			}else {
				// 当获取活动开始时间失败，默认为未开始
				resultMap.put("isStart", "0");
			}
		}else {
			// 当获取活动开始时间失败，默认为未开始
			resultMap.put("isStart", "0");
		}

		logger.info("查询参与活动的用户信息------activity:{}", resAct);
		logger.info("查询参与活动的用户信息------customerList:{}", customerList);
		resultMap.put("activity", resAct);
		resultMap.put("customerList", customerList);

		logger.info("查询活动详细信息------end------{}", resultMap);
		return ResponseHelper.success(resultMap, null, "00", "请求数据成功");
	}
	
	/**
	 * 用户参加报名参加活动
	 */
	@ResponseBody
	@RequestMapping(value = "/customerJoinActivity", method = RequestMethod.POST)
	public Map<String, Object> customerJoinActivity(@RequestBody Map<String, String> param) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		logger.info("用户参加报名参加活动------start------{}", param);

		String activityId = (String) param.get("activityId");
		String customerId = (String) param.get("customerId");
		String customerPhone = (String) param.get("customerPhone");
		if (null == activityId || "".equals(activityId.trim())) {
			logger.info("用户报名参加活动请求参数错误，activityId：{}",activityId);
			resultMap.put("isJoin", "0");
			return ResponseHelper.success(resultMap, null, "01", "请求数据失败");
		}
		if (null == customerId || "".equals(customerId.trim())) {
			logger.info("用户报名参加活动请求参数错误，customerId：{}",customerId);
			resultMap.put("isJoin", "0");
			return ResponseHelper.success(resultMap, null, "01", "请求数据失败");
		}
		
		ActivityCustomer reqActCus = new ActivityCustomer();
		reqActCus.setActivityId(activityId);
		reqActCus.setCustomerId(customerId);
		List<ActivityCustomer> respActCusList = activityCustomerService.selectByBizKeys(reqActCus);
		if (null == respActCusList || respActCusList.size() <= 0) {
			// 用户未报名
			Map<String, Object> saveMap = new HashMap<String, Object>();
			saveMap.put("activityId", activityId);
			saveMap.put("customerId", customerId);
			activityCustomerService.save(saveMap);
		}
		
		if(null != customerPhone && !"".equals(customerPhone.trim())) {
			Map<String, Object> upMap = new HashMap<String, Object>();
			upMap.put("id", Integer.valueOf(customerId));
			upMap.put("phone", customerPhone);
			customerBaseService.update(upMap);
		}

		resultMap.put("isJoin", "1");
		
		logger.info("用户参加报名参加活动------end------{}", resultMap);
		return ResponseHelper.success(resultMap, null, "00", "请求数据成功");
	}
}
