package me.flyray.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.cms.api.ViewpointService;
import me.flyray.cms.dao.CmsViewPointMapper;
import me.flyray.cms.model.Viewpoint;

@Service("viewpointService")
public class ViewpointServiceImpl implements ViewpointService {

	@Autowired
	private CmsViewPointMapper dao;
	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public void insert(Viewpoint point) {
		// TODO Auto-generated method stub
		dao.insert(point);
	}

	@Override
	public void updateById(Viewpoint point) {
		// TODO Auto-generated method stub
		dao.updateById(point);
	}

	@Override
	public List<Viewpoint> queryAll(Viewpoint point) {
		// TODO Auto-generated method stub
		return dao.queryAll(point);
	}

	@Override
	public Integer queryCountAll(Viewpoint point) {
		// TODO Auto-generated method stub
		return dao.queryCountAll(point);
	}

	@Override
	public Viewpoint selectById(Long id) {
		// TODO Auto-generated method stub
		return dao.selectById(id);
	}

}
