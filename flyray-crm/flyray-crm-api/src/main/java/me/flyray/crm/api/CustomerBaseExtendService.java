package me.flyray.crm.api;

import me.flyray.common.service.BaseService;
import me.flyray.crm.model.CustomerBaseExtend;

/** 
* @author: bolei
* @date：2017年11月6日 下午4:21:10
* @description：会员扩展信息
*/

public interface CustomerBaseExtendService extends BaseService{

	void save(CustomerBaseExtend customerBaseExtend);
}
