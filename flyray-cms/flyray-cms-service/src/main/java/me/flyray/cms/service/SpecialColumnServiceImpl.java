package me.flyray.cms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.cms.api.SpecialColumnService;
import me.flyray.cms.dao.SpecialColumnDao;
import me.flyray.cms.model.SpecialColumn;
import me.flyray.common.service.AbstractBaseService;

/** 
* @author: bolei
* @date：2017年10月4日 上午11:08:01
* @description：类说明 
*/

@Service("specialColumnService")
public class SpecialColumnServiceImpl extends AbstractBaseService<SpecialColumn> implements SpecialColumnService{

	@Autowired
	private SpecialColumnDao specialColumnDao;
	
	@Override
	public List<SpecialColumn> queryCustomerColumnsList(Map<String, Object> queryMap) {
		return specialColumnDao.queryCustomerColumnsList(queryMap);
	}

}
