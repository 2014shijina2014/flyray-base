package me.flyray.crm.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import me.flyray.crm.api.MerchantAccountService;
import me.flyray.crm.model.MerchantAcount;

/** 
* @author: bolei
* @date：2017年4月15日 上午2:10:39 
* @description：类说明 
*/
@Service("merchantAccountService")
public class MerchantAccountServiceImpl implements MerchantAccountService{

	@Override
	public void openAccount(MerchantAcount merchantAcount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deposit(MerchantAcount merchantAcount) {
		// TODO Auto-generated method stub
		//记账明细
	}

	@Override
	public void withdraw(MerchantAcount merchantAcount) {
		// TODO Auto-generated method stub
		//记账明细
	}

	@Override
	public void transfer(Map<String, Object> param) {
		// TODO Auto-generated method stub
		//记账明细
	}

}
