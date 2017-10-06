package me.flyray.cms.dao;

import java.util.List;
import java.util.Map;

import me.flyray.cms.model.SpecialColumn;
import me.flyray.common.dao.BaseDao;

/** 
* @author: bolei
* @date：2017年10月4日 上午11:14:52
* @description：专栏相关处理
*/

public interface SpecialColumnDao extends BaseDao<SpecialColumn>{

	List<SpecialColumn> queryCustomerColumnsList(Map<String, Object> queryMap);

}
