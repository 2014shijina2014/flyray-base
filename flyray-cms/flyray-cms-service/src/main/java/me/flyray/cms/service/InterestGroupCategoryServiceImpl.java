package me.flyray.cms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.cms.api.InterestGroupCategoryService;
import me.flyray.cms.dao.InterestGroupCategoryDao;
import me.flyray.cms.model.InterestGroupCategory;
import me.flyray.common.service.AbstractBaseService;

/**
 * 
 * @author centerroot
 * @time 创建时间:2017年8月26日下午3:44:11
 * @description : 兴趣小组类别信息逻辑处理服务
 */
@Service("interestGroupCategoryService")
public class InterestGroupCategoryServiceImpl extends AbstractBaseService<InterestGroupCategory> implements InterestGroupCategoryService {

	@Autowired
	private InterestGroupCategoryDao interestGroupCategoryDao;
	/**
	 * 添加兴趣小组类别服务
	 * @author centerroot
	 * @time 创建时间:2017年8月26日下午3:45:49
	 * (non-Javadoc)
	 * @see me.flyray.cms.api.InterestGroupCategoryService#insert(me.flyray.cms.model.InterestGroupCategory)
	 */
	@Override
	public void insert(InterestGroupCategory groupCategory) {
		interestGroupCategoryDao.insert(groupCategory);
	}
	@Override
	public List<InterestGroupCategory> query(Map<String, Object> queryMap) {
		return interestGroupCategoryDao.queryList(queryMap);
	}

}
