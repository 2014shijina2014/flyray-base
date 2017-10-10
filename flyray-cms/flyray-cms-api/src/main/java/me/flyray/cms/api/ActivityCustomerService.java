package me.flyray.cms.api;


import java.util.List;

import me.flyray.cms.model.ActivityCustomer;
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
}
