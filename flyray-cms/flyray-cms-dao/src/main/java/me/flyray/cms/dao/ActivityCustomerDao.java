package me.flyray.cms.dao;

import java.util.List;

import me.flyray.cms.model.ActivityCustomer;
import me.flyray.common.dao.BaseDao;

public interface ActivityCustomerDao extends BaseDao<ActivityCustomer> {
	
	public List<ActivityCustomer> selectByBizKeys(ActivityCustomer activityCustomer);
}
