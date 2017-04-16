package me.flyray.crm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.common.BeanUtil;
import me.flyray.crm.api.CustomerBaseService;
import me.flyray.crm.dao.CustomerBaseDao;
import me.flyray.crm.model.CustomerBase;

/** 
* @author: bolei
* @date：2017年3月12日 下午5:11:03 
* @description：客户基础信息
*/

@Service("customerBaseService")
public class CustomerBaseServiceImpl implements CustomerBaseService{

	private static final Logger logger = LoggerFactory.getLogger(CustomerBaseServiceImpl.class);
	
	@Autowired
	private CustomerBaseDao customerBaseDao;
	
	@Override
	public List<Map<String, Object>> queryList(Map<String, Object> map) {
		
		List<Map<String, Object>> resultMaps = new ArrayList<>();
		try {
			List<CustomerBase> customerBases= customerBaseDao.queryList(map);
			for (CustomerBase customerBase : customerBases) {
				Map<String, Object> resultMap = BeanUtil.objectToMap(customerBase);
				resultMaps.add(resultMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMaps;
		
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return customerBaseDao.queryTotal(map);
	}

	@Override
	public void save(Map<String, Object> map) {
		if (map == null)     
            return;
		try {
			CustomerBase customerBase = (CustomerBase)BeanUtil.mapToObject(map, CustomerBase.class);
			customerBaseDao.save(customerBase);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Map<String, Object> map) {
		if (map == null)     
            return;
		try {
			CustomerBase customerBase = (CustomerBase)BeanUtil.mapToObject(map, CustomerBase.class);
			customerBaseDao.update(customerBase);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBatch(Long[] ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> queryObject(Map<String, Object> map) {
		
		if (map == null)     
            return null;
		Map<String, Object> resultMap = null;
		try {
			CustomerBase customerBase = (CustomerBase)BeanUtil.mapToObject(map, CustomerBase.class);
			resultMap = BeanUtil.objectToMap(customerBaseDao.queryObject(customerBase));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultMap;
	}

}
