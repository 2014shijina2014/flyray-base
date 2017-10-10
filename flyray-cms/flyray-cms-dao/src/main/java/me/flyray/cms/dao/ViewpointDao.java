package me.flyray.cms.dao;

import java.util.List;

import me.flyray.cms.model.Viewpoint;
import me.flyray.common.dao.BaseDao;

public interface ViewpointDao extends BaseDao<Viewpoint>{
	
	List<Viewpoint> queryObject(String id);
	void delete(String id);
	Viewpoint selectById(String id);
}
