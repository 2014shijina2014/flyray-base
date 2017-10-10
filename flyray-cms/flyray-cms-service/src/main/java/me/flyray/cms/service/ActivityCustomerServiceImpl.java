package me.flyray.cms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.cms.api.ActivityCustomerService;
import me.flyray.cms.dao.ActivityCustomerDao;
import me.flyray.cms.model.ActivityCustomer;
import me.flyray.cms.model.InterestGroupCustomer;

/**
 * 参与活动的用户
 * @author centerroot
 * @time 创建时间:2017年10月10日下午7:24:59
 * @description :
 */
@Service("activityCustomerService")
public class ActivityCustomerServiceImpl implements ActivityCustomerService {

	@Autowired
	private ActivityCustomerDao activityCustomerDao;
	
	@Override
	public List<Map<String, Object>> queryList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> queryObject(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> queryById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void save(Map<String, Object> map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Map<String, Object> map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBatch(Long[] ids) {
		// TODO Auto-generated method stub

	}

	/**
	 * 根据条件查询参与活动的用户
	 * @author centerroot
	 * @time 创建时间:2017年10月10日下午7:25:29
	 * (non-Javadoc)
	 * @see me.flyray.cms.api.ActivityCustomerService#selectByBizKeys(me.flyray.cms.model.InterestGroupCustomer)
	 */
	@Override
	public List<ActivityCustomer> selectByBizKeys(ActivityCustomer activityCustomer) {
		return activityCustomerDao.selectByBizKeys(activityCustomer);
	}

}
