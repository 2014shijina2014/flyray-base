package me.flyray.cms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import me.flyray.cms.api.ActivityCustomerService;
import me.flyray.cms.dao.ActivityCustomerDao;
import me.flyray.cms.dao.ActivityDao;
import me.flyray.cms.model.Activity;
import me.flyray.cms.model.ActivityCustomer;
import me.flyray.cms.model.ActivityCustomerModel;
import me.flyray.cms.model.InterestGroupCustomer;
import me.flyray.common.utils.BeanUtils;
import me.flyray.crm.api.CustomerBaseService;
import me.flyray.crm.model.CustomerBase;

/**
 * 参与活动的用户
 * @author centerroot
 * @time 创建时间:2017年10月10日下午7:24:59
 * @description :
 */
@Service("activityCustomerService")
public class ActivityCustomerServiceImpl implements ActivityCustomerService {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ActivityCustomerDao activityCustomerDao;
	@Autowired
	private ActivityDao activityDao;
//	@Autowired
//	private CustomerBaseService customerBaseService;
	
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
		ActivityCustomer ac = new ActivityCustomer();
		ac.setActivityId((String) map.get("activityId"));
		ac.setCustomerId((String) map.get("customerId"));
		activityCustomerDao.save(ac);
	}

	@Override
	public void update(Map<String, Object> map) {
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

	@Override
	public void deleteBatch(List<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 根据条件查询活动列表及参与活动的人员信息
	 * @author centerroot
	 * @time 创建时间:2017年11月21日下午10:57:02
	 * (non-Javadoc)
	 * @see me.flyray.cms.api.ActivityCustomerService#queryActivityCustomer(java.util.Map)
	 */
	@Override
	public List<ActivityCustomerModel> queryActivityCustomer(Map<String, Object> request) {
		logger.info("根据条件查询活动列表及参与活动的人员信息,请求参数{}",request);
		List<ActivityCustomerModel> actCustList = new ArrayList<ActivityCustomerModel>();
//		String custmerNo = (String) request.get("custmerNo");
//		String activityName = (String) request.get("activityName");
//		
//		if (StringUtils.isEmpty(custmerNo)) {
//			logger.info("请求参数非法，活动创建人（custmerNo）为空");
//			return actCustList;
//		}
//		
//		Activity reqAct = new Activity();
//		// 根据活动名称查询列表
//		if (StringUtils.isEmpty(activityName)) {
//			reqAct.setActivityName(activityName);
//		}
//		reqAct.setCreateBy(custmerNo);
//		List<Activity> resActList = activityDao.selectByBizKeys(reqAct);
//		logger.info("查询活动详细信息------{}", resActList);
//		if(null != resActList && resActList.size() > 0) {
//			for (int i = 0; i < resActList.size(); i++) {
//				Activity activityItem = resActList.get(i);
//				ActivityCustomer reqActCus = new ActivityCustomer();
//				reqActCus.setActivityId(activityItem.getId());
//				List<ActivityCustomer> respActCusList = selectByBizKeys(reqActCus);
//				if(null != respActCusList && respActCusList.size() > 0) {
//					for (int j = 0; j < respActCusList.size(); j++) {
//						ActivityCustomerModel activityCustomerModel = new ActivityCustomerModel();
//						ActivityCustomer item = respActCusList.get(i);
//						CustomerBase customerBase = customerBaseService.queryByCustomerId(item.getCustomerId());
//
//						activityCustomerModel.setActivityId(activityItem.getId());
//						activityCustomerModel.setActivityName(activityItem.getActivityName());
//						activityCustomerModel.setCustomerId(customerBase.getId());
//						activityCustomerModel.setCustomerNo(customerBase.getCustomerNo());
//						activityCustomerModel.setCustName(customerBase.getCustName());
//						activityCustomerModel.setNickname(customerBase.getNickname());
//						activityCustomerModel.setPhone(customerBase.getPhone());
//						activityCustomerModel.setSex(customerBase.getSex());
//						activityCustomerModel.setIdentityCard(customerBase.getIdentityCard());
//						activityCustomerModel.setAddress(customerBase.getAddress());
//						activityCustomerModel.setAge(customerBase.getAge());
//						activityCustomerModel.setBirthday(customerBase.getBirthday());
//						activityCustomerModel.setAvatar(customerBase.getAvatar());
//						actCustList.add(activityCustomerModel);
//					}
//				}
//			}
//		}
//
		logger.info("根据条件查询活动列表及参与活动的人员信息,响应参数{}",actCustList);
		return actCustList;
	}

	@Override
	public List<Map<String, Object>> selectByMapKey(Map<String, Object> map) {
		List<Map<String, Object>> respList = new ArrayList<>();
		
		try {
			ActivityCustomer activityCustomer = (ActivityCustomer) BeanUtils.mapToObject(map, ActivityCustomer.class);
			List<ActivityCustomer> actcusList = activityCustomerDao.selectByBizKeys(activityCustomer);
			if (actcusList != null && actcusList.size() > 0) {
				for (int i = 0; i < actcusList.size(); i++) {
					ActivityCustomer actCusItem = actcusList.get(i);
					respList.add(BeanUtils.objectToMap(actCusItem));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return respList;
	}

}
