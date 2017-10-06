package me.flyray.cms.api;

import java.util.List;
import java.util.Map;

import me.flyray.cms.model.SpecialColumn;
import me.flyray.common.service.BaseService;

/** 
* @author: bolei
* @date：2017年10月3日 下午4:36:03
* @description：内容管理专栏
*/

public interface SpecialColumnService extends BaseService{

	List<SpecialColumn> queryCustomerColumnsList(Map<String, Object> queryMap);

}
