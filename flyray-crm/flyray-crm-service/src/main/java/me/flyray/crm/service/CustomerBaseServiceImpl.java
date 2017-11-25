package me.flyray.crm.service;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.common.service.AbstractBaseService;
import me.flyray.common.utils.BeanUtils;
import me.flyray.crm.api.CustomerBaseService;
import me.flyray.crm.dao.CustomerBaseDao;
import me.flyray.crm.model.CustomerBaseExtend;
import me.flyray.crm.model.CustomerBase;

/** 
* @author: bolei
* @date：2017年3月12日 下午5:11:03 
* @description：客户基础信息
*/

@Service("customerBaseService")
public class CustomerBaseServiceImpl extends AbstractBaseService<CustomerBase> implements CustomerBaseService{

	private static final Logger logger = LoggerFactory.getLogger(CustomerBaseServiceImpl.class);
	
	@Autowired
	private CustomerBaseDao customerBaseDao;

	@Override
	public void save(CustomerBase customerBase) {
		customerBaseDao.save(customerBase);
	}

	@Override
	public void updateExtent(CustomerBaseExtend extent) {
		// TODO Auto-generated method stub
		customerBaseDao.updateExtent(extent); 
	}

	@Override
	public void saveExtend(CustomerBaseExtend extent) {
		// TODO Auto-generated method stub
		customerBaseDao.saveExtend(extent);
	}

	@Override
	public void deleteBaseAndExtend(Long id) {
		// TODO Auto-generated method stub
		customerBaseDao.deleteBaseAndExtend(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		customerBaseDao.delete(id);
	}

	@Override
	public CustomerBase queryByCustomerId(String customerId) {
		CustomerBase customerBase = customerBaseDao.queryByCustomerId(customerId);
		return customerBase;
	}

	@Override
	public CustomerBase queryByCustomerNo(String customerNo) {
		CustomerBase customerBase = customerBaseDao.queryByCustomerNo(customerNo);
		return customerBase;
	}

	@Override
	public Map<String, Object> selectByCustomerId(Map<String, Object> map) {
		Map<String, Object> respMap = new HashMap<>();
		
		try {
			CustomerBase customerBase = (CustomerBase) BeanUtils.mapToObject(map, CustomerBase.class);
			CustomerBase respdto = customerBaseDao.queryByCustomerId(customerBase.getId());
			respMap = (Map<String, Object>) BeanUtils.objectToMap(respdto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return respMap;
	}

}
