package me.flyray.cms.dao;

import java.util.List;
import java.util.Map;

import me.flyray.cms.model.ProficientRecommend;

public interface ProficientRecommendDao {
	
	ProficientRecommend queryObject(Long id);
	
	List<ProficientRecommend> queryList(Map<String, Object> map);
	
	List<ProficientRecommend> query(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ProficientRecommend proficientRecommend);
	
	void update(ProficientRecommend proficientRecommend);
}
