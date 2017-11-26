package me.flyray.rbac.controller.cms;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.flyray.cms.model.Activity;
import me.flyray.cms.model.ActivityCustomerModel;
import me.flyray.rbac.controller.AbstractController;
import me.flyray.rbac.utils.PageUtils;
import me.flyray.rbac.utils.R;
import me.flyray.rest.api.ApiProvider;
import me.flyray.rest.model.Parameter;

@RestController
@RequestMapping("/cms/activitycustomer")
public class ActivityCustomerController extends AbstractController {
	@Autowired
	private ApiProvider apiProvider;
	
	/**
	 * 查询参与活动人员列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("cms:activitycustomer:list")
	public R list(@RequestParam Map<String, Object> params){
		logger.info("查询参与活动人员列表请求参数:{}",params);
		
		List<ActivityCustomerModel> actCustList = new ArrayList<ActivityCustomerModel>();
		String custmerNo = (String) params.get("custmerNo");
		String activityName = (String) params.get("activityName");
		
//		if (StringUtils.isEmpty(custmerNo)) {
//			logger.info("请求参数非法，活动创建人（custmerNo）为空");
//			return R.error(0, "参数错误");
//		}
		
		Map<String, Object> act1map = new HashMap<>();
		act1map.put("activityName", params.get("activityName"));
//		act1map.put("createBy", params.get("custmerNo"));
		
		Parameter parameter = new Parameter("activityService", "selectByMapKey");
		parameter.setMap(act1map);
		List<?> act1List = apiProvider.execute(parameter).getList();
		logger.info("查询活动详细信息------{}", act1List);
		if(null != act1List && act1List.size() > 0) {
			for (int i = 0; i < act1List.size(); i++) {
				Map<String, Object> actMapItem = (Map<String, Object>) act1List.get(i);
				
				Map<String, Object> actcus1map = new HashMap<>();
				actcus1map.put("activityId", actMapItem.get("id"));
				Parameter parameter1 = new Parameter("activityCustomerService", "selectByMapKey");
				parameter1.setMap(actcus1map);
				List<?> actcus1List = apiProvider.execute(parameter1).getList();

				if(null != actcus1List && actcus1List.size() > 0) {
					for (int j = 0; j < actcus1List.size(); j++) {
						ActivityCustomerModel activityCustomerModel = new ActivityCustomerModel();
						Map<String, Object> item = (Map<String, Object>) actcus1List.get(j);
						
						Map<String, Object> cus1map = new HashMap<>();
						cus1map.put("id", item.get("customerId"));
						Parameter parameter2 = new Parameter("customerBaseService", "selectByCustomerId");
						parameter2.setMap(cus1map);
						Map<?, ?> custMap = apiProvider.execute(parameter2).getMap();
						
						activityCustomerModel.setActivityId((String) actMapItem.get("id"));
						activityCustomerModel.setActivityName((String) actMapItem.get("activityName"));
						activityCustomerModel.setCustomerId((String) custMap.get("id"));
						activityCustomerModel.setCustomerNo((String) custMap.get("customerNo"));
						activityCustomerModel.setCustName((String) custMap.get("custName"));
						activityCustomerModel.setNickname((String) custMap.get("nickname"));
						activityCustomerModel.setPhone((String) custMap.get("phone"));
						activityCustomerModel.setSex((String) custMap.get("sex"));
						activityCustomerModel.setIdentityCard((String) custMap.get("identityCard"));
						activityCustomerModel.setAddress((String) custMap.get("address"));
						activityCustomerModel.setAge((String) custMap.get("age"));
						activityCustomerModel.setBirthday((Date) custMap.get("birthday"));
						activityCustomerModel.setAvatar((String) custMap.get("avatar"));
						actCustList.add(activityCustomerModel);
					}
				}
			}
		}

		logger.info("根据条件查询活动列表及参与活动的人员信息,响应参数{}",actCustList);
		
		int total = actCustList.size();
		logger.info("查询参与活动人员列表查询结果size:{}",total);
		PageUtils pageUtil = new PageUtils(actCustList, total, 10, 1);
		return R.ok().put("page", pageUtil);
	}
	
}
