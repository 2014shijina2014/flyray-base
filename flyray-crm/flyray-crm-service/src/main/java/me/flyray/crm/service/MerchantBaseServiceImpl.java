package me.flyray.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.common.service.AbstractBaseService;
import me.flyray.crm.api.MerchantBaseService;
import me.flyray.crm.dao.MerchantBaseDao;
import me.flyray.crm.model.MerchantBase;

/** 
* @author: bolei
* @date：2017年4月6日 下午10:29:23 
* @description：商户基础信息
*/

@Service("merchantBaseService")
public class MerchantBaseServiceImpl extends AbstractBaseService<MerchantBase> implements MerchantBaseService{

	@Autowired
	private MerchantBaseDao merchantBaseDao;
	
}
