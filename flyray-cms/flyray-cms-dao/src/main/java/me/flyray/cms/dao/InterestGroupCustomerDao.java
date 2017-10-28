package me.flyray.cms.dao;

import java.util.List;

import me.flyray.cms.model.InterestGroupCustomer;
import me.flyray.common.dao.BaseDao;

public interface InterestGroupCustomerDao extends BaseDao<InterestGroupCustomer> {
	
	public List<InterestGroupCustomer> selectByBizKeys(InterestGroupCustomer interestGroupCustomer);
	
	public void delete(InterestGroupCustomer interestGroupCustomer);
	
}
