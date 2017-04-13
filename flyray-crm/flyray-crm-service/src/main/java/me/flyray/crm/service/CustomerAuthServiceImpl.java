package me.flyray.crm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.common.BeanUtil;
import me.flyray.crm.api.CustomerAuthService;
import me.flyray.crm.dao.CustomerAuthDao;
import me.flyray.crm.model.CustomerAuth;

/** 
* @author: bolei
* @date：2017年4月6日 下午10:24:22 
* @description：类说明 
*/

@Service("customerAuthService")
public class CustomerAuthServiceImpl implements CustomerAuthService{

	@Autowired
	private CustomerAuthDao customerAuthDao;
	
	@Override
	public List<Map<String, Object>> queryList(Map<String, Object> map) {
		
		List<Map<String, Object>> resultMaps = new ArrayList<>();
		try {
			List<CustomerAuth> customerAuths= customerAuthDao.queryList(map);
			for (CustomerAuth customerAuth : customerAuths) {
				Map<String, Object> resultMap = BeanUtil.objectToMap(customerAuth);
				resultMaps.add(resultMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMaps;
		
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return customerAuthDao.queryTotal(map);
	}

	@Override
	public void save(Map<String, Object> map) {
		if (map == null)     
            return;
		try {
			CustomerAuth customerAuth = (CustomerAuth)BeanUtil.mapToObject(map, CustomerAuth.class);
			customerAuthDao.save(customerAuth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Map<String, Object> map) {
		if (map == null)     
            return;
		try {
			CustomerAuth customerAuth = (CustomerAuth)BeanUtil.mapToObject(map, CustomerAuth.class);
			customerAuthDao.update(customerAuth);
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
			CustomerAuth customerAuth = (CustomerAuth)BeanUtil.mapToObject(map, CustomerAuth.class);
			resultMap = BeanUtil.objectToMap(customerAuthDao.queryObject(customerAuth));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultMap;
	}

}
