package me.flyray.cms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.cms.api.InterestGroupCustomerService;
import me.flyray.cms.dao.InterestGroupCustomerDao;
import me.flyray.cms.model.InterestGroupCustomer;

/**
 * 团队成员接口
 * @author centerroot
 * @time 创建时间:2017年10月10日下午7:25:10
 * @description :
 */
@Service("interestGroupCustomerService")
public class InterestGroupCustomerServiceImpl implements InterestGroupCustomerService {
	
	@Autowired
	private InterestGroupCustomerDao interestGroupCustomerDao;
	
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
	 * 查询参加团队的成员
	 * @author centerroot
	 * @time 创建时间:2017年10月10日下午7:25:43
	 * (non-Javadoc)
	 * @see me.flyray.cms.api.InterestGroupCustomerService#selectByBizKeys(me.flyray.cms.model.InterestGroupCustomer)
	 */
	@Override
	public List<InterestGroupCustomer> selectByBizKeys(InterestGroupCustomer interestGroupCustomer) {
		return interestGroupCustomerDao.selectByBizKeys(interestGroupCustomer);
	}

}
