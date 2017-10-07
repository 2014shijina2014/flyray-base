package me.flyray.cms.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.cms.api.CustomerSpecialColumnService;
import me.flyray.cms.dao.CustomerSpecialColumnDao;
import me.flyray.cms.model.CustomerSpecialColumn;
import me.flyray.common.service.AbstractBaseService;

/** 
* @author: bolei
* @date：2017年10月6日 下午3:18:26
* @description：客户与专栏的关系
*/

@Service("customerSpecialColumnService")
public class CustomerSpecialColumnServiceImpl extends AbstractBaseService<CustomerSpecialColumn> implements CustomerSpecialColumnService {

	@Autowired
	private CustomerSpecialColumnDao customerSpecialColumnDao;
	
	@Override
	public void unsubscribe(Map<String, String> param) {
		customerSpecialColumnDao.deleteOne(param);
	}

}
