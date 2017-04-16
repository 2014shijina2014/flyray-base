package me.flyray.crm.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.common.service.AbstractBaseService;
import me.flyray.crm.api.CustomerBaseService;
import me.flyray.crm.dao.CustomerBaseDao;
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


}
