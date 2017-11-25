package me.flyray.cms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import me.flyray.cms.api.InterestGroupCustomerService;
import me.flyray.cms.dao.ActivityDao;
import me.flyray.cms.dao.InterestGroupCustomerDao;
import me.flyray.cms.dao.InterestGroupDao;
import me.flyray.cms.model.Activity;
import me.flyray.cms.model.ActivityCustomer;
import me.flyray.cms.model.ActivityCustomerModel;
import me.flyray.cms.model.InterestGroup;
import me.flyray.cms.model.InterestGroupCustomer;
import me.flyray.cms.model.InterestGroupCustomerModel;
import me.flyray.common.utils.BeanUtils;
import me.flyray.crm.api.CustomerBaseService;
import me.flyray.crm.model.CustomerBase;

/**
 * 团队成员接口
 * @author centerroot
 * @time 创建时间:2017年10月10日下午7:25:10
 * @description :
 */
@Service("interestGroupCustomerService")
public class InterestGroupCustomerServiceImpl implements InterestGroupCustomerService {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private InterestGroupCustomerDao interestGroupCustomerDao;
	@Autowired
	private InterestGroupDao interestGroupDao;
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
		InterestGroupCustomer igc = new InterestGroupCustomer();
		igc.setCustomerId((String) map.get("customerId"));
		igc.setGroupId((String) map.get("groupId"));
		interestGroupCustomerDao.save(igc);
	}

	@Override
	public void update(Map<String, Object> map) {
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

	/**
	 * 根据条件删除用户团队关系
	 * @author centerroot
	 * @time 创建时间:2017年10月28日下午2:18:13
	 * (non-Javadoc)
	 * @see me.flyray.cms.api.InterestGroupCustomerService#delete(me.flyray.cms.model.InterestGroupCustomer)
	 */
	@Override
	public void delete(InterestGroupCustomer interestGroupCustomer) {
		interestGroupCustomerDao.delete(interestGroupCustomer);
	}

	@Override
	public void deleteBatch(List<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 根据条件查询团队列表及关注团队的人员信息
	 * @author centerroot
	 * @time 创建时间:2017年11月21日下午10:57:29
	 * (non-Javadoc)
	 * @see me.flyray.cms.api.InterestGroupCustomerService#queryGroupCustomer(java.util.Map)
	 */
	@Override
	public List<InterestGroupCustomerModel> queryGroupCustomer(Map<String, Object> request) {
		logger.info("根据条件查询团队列表及关注团队的人员信息,请求参数{}",request);
		List<InterestGroupCustomerModel> groupCustList = new ArrayList<InterestGroupCustomerModel>();
//		String custmerNo = (String) request.get("custmerNo");
//		String groupName = (String) request.get("groupName");
//		
//		if (StringUtils.isEmpty(custmerNo)) {
//			logger.info("请求参数非法，团队创建人（custmerNo）为空");
//			return groupCustList;
//		}
//		
//			
//			InterestGroup reqGroup = new InterestGroup();
//			// 根据活动名称查询列表
//			if (StringUtils.isEmpty(groupName)) {
//				reqGroup.setGroupName(groupName);
//			}
//			reqGroup.setCustmerNo(custmerNo);
//			List<InterestGroup> resGroupList = interestGroupDao.selectByBizKeys(reqGroup);
//			logger.info("查询团队详细信息------{}", resGroupList);
//			if(null != resGroupList && resGroupList.size() > 0) {
//				for (int i = 0; i < resGroupList.size(); i++) {
//					InterestGroup groupItem = resGroupList.get(i);
//					InterestGroupCustomer reqgroupCus = new InterestGroupCustomer();
//					reqgroupCus.setGroupId(groupItem.getId());
//					List<InterestGroupCustomer> respGroupCusList = selectByBizKeys(reqgroupCus);
//					if(null != respGroupCusList && respGroupCusList.size() > 0) {
//						for (int j = 0; j < respGroupCusList.size(); j++) {
//							InterestGroupCustomerModel groupCustomerModel = new InterestGroupCustomerModel();
//							InterestGroupCustomer item = respGroupCusList.get(i);
//							CustomerBase customerBase = customerBaseService.queryByCustomerId(item.getCustomerId());
//
//							groupCustomerModel.setGroupId(groupItem.getId());
//							groupCustomerModel.setGroupName(groupItem.getGroupName());
//							groupCustomerModel.setCustomerId(customerBase.getId());
//							groupCustomerModel.setCustomerNo(customerBase.getCustomerNo());
//							groupCustomerModel.setCustName(customerBase.getCustName());
//							groupCustomerModel.setNickname(customerBase.getNickname());
//							groupCustomerModel.setPhone(customerBase.getPhone());
//							groupCustomerModel.setSex(customerBase.getSex());
//							groupCustomerModel.setIdentityCard(customerBase.getIdentityCard());
//							groupCustomerModel.setAddress(customerBase.getAddress());
//							groupCustomerModel.setAge(customerBase.getAge());
//							groupCustomerModel.setBirthday(customerBase.getBirthday());
//							groupCustomerModel.setAvatar(customerBase.getAvatar());
//							groupCustList.add(groupCustomerModel);
//						}
//					}
//				}
//			}
			
		logger.info("根据条件查询团队列表及关注团队的人员信息,响应参数{}",groupCustList);
		return groupCustList;
	}

	@Override
	public List<Map<String, Object>> selectByMapKey(Map<String, Object> map) {
		List<Map<String, Object>> respList = new ArrayList<>();
		
		try {
			InterestGroupCustomer interestGroupCustomer = (InterestGroupCustomer) BeanUtils.mapToObject(map, InterestGroupCustomer.class);
			List<InterestGroupCustomer> actList = interestGroupCustomerDao.selectByBizKeys(interestGroupCustomer);
			respList = (List<Map<String, Object>>) BeanUtils.objectToMap(actList) ;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return respList;
	}

}
