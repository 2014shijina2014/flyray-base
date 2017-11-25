package me.flyray.cms.api;


import java.util.List;
import java.util.Map;

import me.flyray.cms.model.ActivityCustomer;
import me.flyray.cms.model.ActivityCustomerModel;
import me.flyray.common.service.BaseService;

/**
 * 参与活动的用户
 * @author centerroot
 * @time 创建时间:2017年10月10日下午7:11:12
 * @description :
 */
public interface ActivityCustomerService extends BaseService{
	/**
	 * 根据条件查询参与活动的用户
	 * @author centerroot
	 * @time 创建时间:2017年10月10日下午7:11:32
	 * @param interestGroupCustomer
	 * @return
	 */
	public List<ActivityCustomer> selectByBizKeys(ActivityCustomer activityCustomer);
	
	/**
	 * 根据条件查询活动列表及参与活动的人员信息
	 * @author centerroot
	 * @time 创建时间:2017年11月21日下午10:54:37
	 * @param request
	 * @return
	 */
	public List<ActivityCustomerModel> queryActivityCustomer(Map<String, Object> request);
	
	public List<Map<String, Object>> selectByMapKey(Map<String, Object> map);
}
