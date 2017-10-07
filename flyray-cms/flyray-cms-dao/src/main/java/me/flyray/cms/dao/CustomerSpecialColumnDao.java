package me.flyray.cms.dao;

import java.util.Map;

import me.flyray.cms.model.CustomerSpecialColumn;
import me.flyray.common.dao.BaseDao;

/** 
* @author: bolei
* @date：2017年10月6日 下午3:15:46
* @description：类说明 
*/

public interface CustomerSpecialColumnDao extends BaseDao<CustomerSpecialColumn>{

	void deleteOne(Map<String, String> param);

}
