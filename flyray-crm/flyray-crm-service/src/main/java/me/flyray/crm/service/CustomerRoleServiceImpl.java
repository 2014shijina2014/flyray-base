package me.flyray.crm.service;

import org.springframework.stereotype.Service;

import me.flyray.common.service.AbstractBaseService;
import me.flyray.crm.api.CustomerRoleService;
import me.flyray.crm.model.CustomerRole;

/** 
* @author: bolei
* @date：2017年10月28日 下午12:53:25
* @description：类说明 
*/

@Service("customerRoleService")
public class CustomerRoleServiceImpl extends AbstractBaseService<CustomerRole> implements CustomerRoleService{

}
