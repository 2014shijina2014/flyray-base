package me.flyray.rest.controller.cms;

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

import me.flyray.cms.api.InterestGroupService;
import me.flyray.cms.model.InterestGroup;
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
		String merId = (String) param.get("merId");
		String categoryId = (String) param.get("categoryId");

		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("orgId", orgId);
		queryMap.put("merchantId", merId);
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
		String merId = (String) param.get("merId");
		String groupId = (String) param.get("groupId");

		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("orgId", orgId);
		queryMap.put("merchantId", merId);
		queryMap.put("id", groupId);
//		int resultTotal = interestGroupService.queryTotal(queryMap);
//		param.put("totalCount", String.valueOf(resultTotal));
//		queryMap.putAll(getPagination(param));
		
		logger.info("查询活动团队列表信息------{}", queryMap);
		List<InterestGroup> groups = interestGroupService.query(queryMap);
		logger.info("查询活动团队列表信息------{}", groups);
		InterestGroup interestGroup = null;
		if (null != groups && groups.size() > 0) {
			interestGroup = groups.get(0);
		}
		
//		int pageSizeInt = Integer.valueOf(param.get("pageSize"));
//		PageUtils pageUtil = new PageUtils(resultTotal, pageSizeInt, Integer.valueOf(param.get("currentPage")));
//		if (isLastPage(param)) {
//			return ResponseHelper.success(null,pageUtil, "01", "已经到最后一条了~");
//		}
		
		resultMap.put("interestGroup", interestGroup);

		logger.info("查询活动团队列表信息------end------{}", resultMap);
		return ResponseHelper.success(resultMap, null, "00", "请求数据成功");
	}
}
