package me.flyray.cms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.cms.api.ViewpointService;
import me.flyray.cms.dao.ViewpointDao;
import me.flyray.cms.model.Viewpoint;
import me.flyray.common.service.AbstractBaseService;

@Service("viewpointService")
public class ViewpointServiceImpl extends AbstractBaseService<Viewpoint> implements ViewpointService{
	
	@Autowired
	private ViewpointDao viewPointDao;
	
	@Override
	public void delete(Long id) {
		viewPointDao.delete(id);
	}

	@Override
	public List<Viewpoint> query(Map<String, Object> map) {
		return viewPointDao.queryList(map);
	}
}