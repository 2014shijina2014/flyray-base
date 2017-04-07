package me.flyray.crm.api;

import me.flyray.crm.model.CustomerAuth;

/** 
* @author: bolei
* @date：2017年3月15日 下午10:57:30 
* @description：客户登录授权
*/

public interface CustomerAuthService {

	void save(CustomerAuth customerAuth);
	
	void update(CustomerAuth customerAuth);
}
