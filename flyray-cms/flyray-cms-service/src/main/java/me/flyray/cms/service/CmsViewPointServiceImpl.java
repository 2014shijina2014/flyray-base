package me.flyray.cms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.cms.api.CmsViewPointService;
import me.flyray.cms.dao.CmsViewPointDao;
import me.flyray.cms.model.CmsViewPoint;

@Service("cmsViewPointService")
public class CmsViewPointServiceImpl implements CmsViewPointService{
	
	@Autowired
	private CmsViewPointDao cmsViewPointDao;
	
	@Override
	public List<CmsViewPoint> queryObject(Long id) {
		// TODO Auto-generated method stub
		return cmsViewPointDao.queryObject(id);
	}

	@Override
	public List<CmsViewPoint> queryList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return cmsViewPointDao.queryList(map);
	}

	@Override
	public Integer queryTotal() {
		// TODO Auto-generated method stub
		return cmsViewPointDao.queryTotal();
	}

	@Override
	public void save(CmsViewPoint point) {
		// TODO Auto-generated method stub
		cmsViewPointDao.save(point);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		cmsViewPointDao.delete(id);
	}
}
