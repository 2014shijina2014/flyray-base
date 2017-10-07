package me.flyray.cms.api;

import java.util.Map;

import me.flyray.common.service.BaseService;

/** 
* @author: bolei
* @date：2017年10月6日 下午3:14:51
* @description：客户与专栏的关系
*/

public interface CustomerSpecialColumnService extends BaseService{

	void unsubscribe(Map<String, String> param);

}
