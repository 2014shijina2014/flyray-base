package me.flyray.cms.dao;

import java.util.List;
import java.util.Map;

import me.flyray.cms.model.ProficientRecommend;
import me.flyray.common.dao.BaseDao;

public interface ProficientRecommendDao extends BaseDao<ProficientRecommend>{
	
	List<ProficientRecommend> query(Map<String, Object> map);
}
