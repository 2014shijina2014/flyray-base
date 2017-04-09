package me.flyray.crm.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import me.flyray.crm.api.CustomerAuthService;
import me.flyray.crm.model.CustomerAuth;

/** 
* @author: bolei
* @date：2017年4月6日 下午10:24:22 
* @description：类说明 
*/

@Service("customerAuthService")
public class CustomerAuthServiceImpl implements CustomerAuthService{

	@Override
	public CustomerAuth queryObject(Long customerNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerAuth> queryList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void save(CustomerAuth customerAuth) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CustomerAuth customerAuth) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBatch(Long[] ids) {
		// TODO Auto-generated method stub
		
	}

}
