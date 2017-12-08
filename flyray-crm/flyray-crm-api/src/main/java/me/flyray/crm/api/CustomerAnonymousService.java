package me.flyray.crm.api;

import java.util.Map;

/** 
* @author: bolei
* @date：2017年12月2日 下午1:09:54
* @description：客户匿名逻辑处理 
*/

public interface CustomerAnonymousService {
	
	/**
	 * @param customerId
	 * 返回匿名名称
	 * 匿名用户头像
	 */
	Map<String, Object> generalAnonymousInfo(String customerId);
}
