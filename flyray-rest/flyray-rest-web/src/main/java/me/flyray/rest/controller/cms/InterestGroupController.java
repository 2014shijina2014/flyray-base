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

import me.flyray.cms.api.InterestGroupCustomerService;
import me.flyray.cms.api.InterestGroupService;
import me.flyray.cms.model.ActivityCustomer;
import me.flyray.cms.model.InterestGroup;
import me.flyray.cms.model.InterestGroupCustomer;
import me.flyray.crm.api.CustomerBaseService;
import me.flyray.crm.model.CustomerBase;
import me.flyray.rest.controller.AbstractController;
import me.flyray.rest.util.PageUtils;
import me.flyray.rest.util.ResponseHelper;

/**
 * 团队（兴趣小组）活动页
 * @author centerroot
 * @time 创建时间:2017年10月6日上午11:18:59
 * @description :
 */
@RestController
@RequestMapping("/api/cms/interestGroup")
public class InterestGroupController extends AbstractController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private InterestGroupService interestGroupService;
	@Autowired
	private CustomerBaseService customerBaseService;
	@Autowired
	private InterestGroupCustomerService interestGroupCustomerService;
	
	/**
	 * 查询活动分类下的活动团队列表
	 */
	@ResponseBody
	@RequestMapping(value = "/queryInterestGroup", method = RequestMethod.POST)
	public Map<String, Object> queryInterestGroup(@RequestBody Map<String, String> param) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		logger.info("查询活动团队列表信息------start------{}", param);

		// TODO 用户登录后获取到机构id和商户id后替换参数
		String orgId = (String) param.get("orgId");
		String merchantId = (String) param.get("merchantId");
		String categoryId = (String) param.get("categoryId");

		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("orgId", orgId);
		queryMap.put("merchantId", merchantId);
		queryMap.put("groupCategoryId", categoryId);
		int resultTotal = interestGroupService.queryTotal(queryMap);
		param.put("totalCount", String.valueOf(resultTotal));
		queryMap.putAll(getPagination(param));
		
		logger.info("查询活动团队列表信息------{}", queryMap);
		List<InterestGroup> groups = interestGroupService.query(queryMap);
		logger.info("查询活动团队列表信息------{}", groups);
		
		
		
		int pageSizeInt = Integer.valueOf(param.get("pageSize"));
		PageUtils pageUtil = new PageUtils(resultTotal, pageSizeInt, Integer.valueOf(param.get("currentPage")));
		if (isLastPage(param)) {
			return ResponseHelper.success(null,pageUtil, "01", "已经到最后一条了~");
		}
		
		resultMap.put("groups", groups);

		logger.info("查询活动团队列表信息------end------{}", resultMap);
		return ResponseHelper.success(resultMap,pageUtil, "00", "请求数据成功");
	}

	/**
	 * 根据ID查询活动团队详细信息
	 */
	@ResponseBody
	@RequestMapping(value = "/queryInterestGroupById", method = RequestMethod.POST)
	public Map<String, Object> queryInterestGroupById(@RequestBody Map<String, String> param) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		logger.info("查询活动团队列表信息------start------{}", param);

		// TODO 用户登录后获取到机构id和商户id后替换参数
		String orgId = (String) param.get("orgId");
		String merchantId = (String) param.get("merchantId");
		String groupId = (String) param.get("groupId");
		String customerId = (String) param.get("customerId");
		if (null == groupId || "".equals(groupId.trim())) {
			logger.info("用户报名参加活动请求参数错误，groupId：{}",groupId);
			return ResponseHelper.success(resultMap, null, "01", "请求数据失败");
		}
		if (null == customerId || "".equals(customerId.trim())) {
			logger.info("用户报名参加活动请求参数错误，customerId：{}",customerId);
			return ResponseHelper.success(resultMap, null, "01", "请求数据失败");
		}
		
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("orgId", orgId);
		queryMap.put("merchantId", merchantId);
		queryMap.put("id", groupId);
		
		logger.info("查询活动团队列表信息------{}", queryMap);
		List<InterestGroup> groups = interestGroupService.query(queryMap);
		logger.info("查询活动团队列表信息------{}", groups);
		InterestGroup interestGroup = null;
		if (null != groups && groups.size() > 0) {
			interestGroup = groups.get(0);
		}
		logger.info("查询活动团队详细信息------{}", interestGroup);
		InterestGroupCustomer reqGroupCus = new InterestGroupCustomer();
		reqGroupCus.setGroupId(groupId);
		List<InterestGroupCustomer> respGroupCusList = interestGroupCustomerService.selectByBizKeys(reqGroupCus);
		List<CustomerBase> customerList = null;
		if(null != respGroupCusList && respGroupCusList.size() > 0) {
			customerList = new ArrayList<CustomerBase>();
			for (int i = 0; i < respGroupCusList.size(); i++) {
				InterestGroupCustomer item = respGroupCusList.get(i);
				Long custId = Long.valueOf(item.getCustomerId());
				CustomerBase customerBase = customerBaseService.queryByCustomerId(custId);
				customerList.add(customerBase);
			}
		}
		
		InterestGroupCustomer reqJoinGroupCus = new InterestGroupCustomer();
		reqJoinGroupCus.setGroupId(groupId);
		reqJoinGroupCus.setCustomerId(customerId);
		List<InterestGroupCustomer> respJoinGroupCusList = interestGroupCustomerService.selectByBizKeys(reqJoinGroupCus);
		if (null != respJoinGroupCusList && respJoinGroupCusList.size() > 0) {
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

		logger.info("查询参加团队的用户信息------{}", customerList);
		resultMap.put("interestGroup", interestGroup);
		resultMap.put("customerList", customerList);

		logger.info("查询活动团队列表信息------end------{}", resultMap);
		return ResponseHelper.success(resultMap, null, "00", "请求数据成功");
	}
	
	/**
	 * 添加参加团队人员
	 */
	@ResponseBody
	@RequestMapping(value = "/customerJoinInterestGroup", method = RequestMethod.POST)
	public Map<String, Object> customerJoinInterestGroup(@RequestBody Map<String, String> param) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		logger.info("添加参加团队人员------start------{}", param);

		String groupId = (String) param.get("groupId");
		String customerId = (String) param.get("customerId");
		String customerPhone = (String) param.get("customerPhone");
		if (null == groupId || "".equals(groupId.trim())) {
			logger.info("用户报名参加活动请求参数错误，groupId：{}",groupId);
			resultMap.put("isJoin", "0");
			return ResponseHelper.success(resultMap, null, "01", "请求数据失败");
		}
		if (null == customerId || "".equals(customerId.trim())) {
			logger.info("用户报名参加活动请求参数错误，customerId：{}",customerId);
			resultMap.put("isJoin", "0");
			return ResponseHelper.success(resultMap, null, "01", "请求数据失败");
		}
		
		InterestGroupCustomer reqGroupCus = new InterestGroupCustomer();
		reqGroupCus.setGroupId(groupId);
		reqGroupCus.setCustomerId(customerId);
		List<InterestGroupCustomer> respGroupCusList = interestGroupCustomerService.selectByBizKeys(reqGroupCus);
		if (null == respGroupCusList || respGroupCusList.size() <= 0) {
			Map<String, Object> saveMap = new HashMap<>();
			saveMap.put("groupId", groupId);
			saveMap.put("customerId", customerId);
			interestGroupCustomerService.save(saveMap);
		}
		
		if(null != customerPhone && !"".equals(customerPhone.trim())) {
			Map<String, Object> upMap = new HashMap<String, Object>();
			upMap.put("id", Integer.valueOf(customerId));
			upMap.put("phone", customerPhone);
			customerBaseService.update(upMap);
		}
		
		resultMap.put("isJoin", "1");
		
		logger.info("查询活动团队列表信息------end------{}", resultMap);
		return ResponseHelper.success(resultMap, null, "00", "请求数据成功");
	}
	
	
	/**
	 * 退出团队
	 */
	@ResponseBody
	@RequestMapping(value = "/customerOutInterestGroup", method = RequestMethod.POST)
	public Map<String, Object> customerOutInterestGroup(@RequestBody Map<String, String> param) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		logger.info("退出团队------start------{}", param);

		String groupId = (String) param.get("groupId");
		String customerId = (String) param.get("customerId");
		if (null == groupId || "".equals(groupId.trim())) {
			logger.info("用户退出团队请求参数错误，groupId：{}",groupId);
			resultMap.put("isJoin", "1");
			return ResponseHelper.success(resultMap, null, "01", "请求数据失败");
		}
		if (null == customerId || "".equals(customerId.trim())) {
			logger.info("用户退出团队请求参数错误，customerId：{}",customerId);
			resultMap.put("isJoin", "1");
			return ResponseHelper.success(resultMap, null, "01", "请求数据失败");
		}
		
		InterestGroupCustomer reqGroupCus = new InterestGroupCustomer();
		reqGroupCus.setGroupId(groupId);
		reqGroupCus.setCustomerId(customerId);
		interestGroupCustomerService.delete(reqGroupCus);
		
		resultMap.put("isJoin", "0");
		
		logger.info("退出团队------end------{}", resultMap);
		return ResponseHelper.success(resultMap, null, "00", "请求数据成功");
	}
}
