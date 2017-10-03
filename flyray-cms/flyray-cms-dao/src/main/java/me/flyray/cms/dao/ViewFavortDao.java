package me.flyray.cms.dao;

import java.util.List;
import java.util.Map;

import me.flyray.cms.model.ViewFavort;
import me.flyray.common.dao.BaseDao;

public interface ViewFavortDao extends BaseDao<ViewFavort>{
	
	List<ViewFavort> query(Map<String, Object> map);

	void delete(Long id);
	
}
