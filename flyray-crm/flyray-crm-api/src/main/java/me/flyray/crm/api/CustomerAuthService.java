package me.flyray.crm.api;

import java.util.Map;

import me.flyray.common.service.BaseService;
import me.flyray.crm.model.CustomerAuth;
import me.flyray.crm.model.CustomerBase;

/** 
* @author: bolei
* @date：2017年3月15日 下午10:57:30 
* @description：客户登录授权
*/

public interface CustomerAuthService extends BaseService{

	void save(CustomerAuth customerAuth);
	
	/**
	 * 客户登录授权
	 *生成客户信息
	 *根据账户类型开立相应账户
	 */
	CustomerBase customerAuth(Map<String, Object> map);
	
}
