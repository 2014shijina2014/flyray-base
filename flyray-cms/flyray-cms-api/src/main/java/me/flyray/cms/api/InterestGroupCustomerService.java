package me.flyray.cms.api;


import java.util.List;

import me.flyray.cms.model.InterestGroupCustomer;
import me.flyray.common.service.BaseService;

/**
 * 团队成员接口
 * @author centerroot
 * @time 创建时间:2017年10月10日下午7:13:16
 * @description :
 */
public interface InterestGroupCustomerService extends BaseService{
	/**
	 * 查询参加团队的成员
	 * @author centerroot
	 * @time 创建时间:2017年10月10日下午7:13:35
	 * @param interestGroupCustomer
	 * @return
	 */
	public List<InterestGroupCustomer> selectByBizKeys(InterestGroupCustomer interestGroupCustomer);

	/**
	 * 根据条件删除用户团队关系
	 * @author centerroot
	 * @time 创建时间:2017年10月28日下午2:17:39
	 * @param interestGroupCustomer
	 */
	public void delete(InterestGroupCustomer interestGroupCustomer);
}
