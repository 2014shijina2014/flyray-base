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

import me.flyray.cms.model.InterestGroup;
import me.flyray.cms.model.InterestGroupCustomer;
import me.flyray.cms.model.InterestGroupCustomerModel;
import me.flyray.crm.model.CustomerBase;
import me.flyray.rbac.controller.AbstractController;
import me.flyray.rbac.utils.PageUtils;
import me.flyray.rbac.utils.R;
import me.flyray.rest.api.ApiProvider;
import me.flyray.rest.model.Parameter;

@RestController
@RequestMapping("/cms/groupcustomer")
public class GroupCustomerController extends AbstractController {
	@Autowired
	private ApiProvider apiProvider;
	
	/**
	 * 查询关注团队的人员列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("cms:groupcustomer:list")
	public R list(@RequestParam Map<String, Object> params){
		logger.info("查询关注团队的人员列表请求参数:{}",params);
		
		List<InterestGroupCustomerModel> groupCustList = new ArrayList<InterestGroupCustomerModel>();
		String custmerNo = (String) params.get("custmerNo");
		String groupName = (String) params.get("groupName");
		
//		if (StringUtils.isEmpty(custmerNo)) {
//			logger.info("请求参数非法，团队创建人（custmerNo）为空");
//			return R.error(0, "参数错误");
//		}
			
			
			Map<String, Object> group1map = new HashMap<>();
			group1map.put("groupName", params.get("groupName"));
//			group1map.put("custmerNo", params.get("custmerNo"));
			Parameter parameter = new Parameter("interestGroupService", "selectByMapKey");
			parameter.setMap(group1map);
			List<?> group1List = apiProvider.execute(parameter).getList();
			logger.info("查询团队详细信息------{}", group1List);
			if(null != group1List && group1List.size() > 0) {
				for (int i = 0; i < group1List.size(); i++) {
					Map<String, Object> groupMapItem = (Map<String, Object>) group1List.get(i);
					
					Map<String, Object> groupcus1map = new HashMap<>();
					groupcus1map.put("groupId", groupMapItem.get("id"));
					Parameter parameter1 = new Parameter("interestGroupCustomerService", "selectByMapKey");
					parameter1.setMap(groupcus1map);
					List<?> groupcus1List = apiProvider.execute(parameter1).getList();
					
					if(null != groupcus1List && groupcus1List.size() > 0) {
						for (int j = 0; j < groupcus1List.size(); j++) {
							InterestGroupCustomerModel groupCustomerModel = new InterestGroupCustomerModel();
							
							Map<String, Object> item = (Map<String, Object>) groupcus1List.get(i);
							
							Map<String, Object> cus1map = new HashMap<>();
							cus1map.put("id", item.get("customerId"));
							Parameter parameter2 = new Parameter("customerBaseService", "selectByCustomerId");
							parameter2.setMap(cus1map);
							Map<?, ?> custMap = apiProvider.execute(parameter2).getMap();
							
							groupCustomerModel.setGroupId((String) groupMapItem.get("id"));
							groupCustomerModel.setGroupName((String) groupMapItem.get("groupName"));
							groupCustomerModel.setCustomerId((String) custMap.get("id"));
							groupCustomerModel.setCustomerNo((String) custMap.get("customerNo"));
							groupCustomerModel.setCustName((String) custMap.get("custName"));
							groupCustomerModel.setNickname((String) custMap.get("nickname"));
							groupCustomerModel.setPhone((String) custMap.get("phone"));
							groupCustomerModel.setSex((String) custMap.get("sex"));
							groupCustomerModel.setIdentityCard((String) custMap.get("identityCard"));
							groupCustomerModel.setAddress((String) custMap.get("address"));
							groupCustomerModel.setAge((String) custMap.get("age"));
							groupCustomerModel.setBirthday((Date) custMap.get("birthday"));
							groupCustomerModel.setAvatar((String) custMap.get("avatar"));
							groupCustList.add(groupCustomerModel);
						}
					}
				}
			}
			
		logger.info("根据条件查询团队列表及关注团队的人员信息,响应参数{}",groupCustList);
		
		
		int total = groupCustList.size();
		logger.info("查询关注团队的人员列表查询结果size:{}",total);
		PageUtils pageUtil = new PageUtils(groupCustList, total, 10, 1);
		return R.ok().put("page", pageUtil);
	}
}
