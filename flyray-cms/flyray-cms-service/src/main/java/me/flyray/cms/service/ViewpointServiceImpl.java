package me.flyray.cms.service;

import java.util.HashMap;
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
	public void delete(String id) {
		viewPointDao.delete(id.toString());
	}

	@Override
	public List<Viewpoint> query(Map<String, Object> map) {
		return viewPointDao.queryList(map);
	}

	@Override
	public Map<String, Object> selectPointById(Map<String, Object> map) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<String, Object>();
		String id = (String) map.get("id");
		Viewpoint point = new Viewpoint();
		try {
			point = viewPointDao.selectById(id);
			result.put("point", point);
			result.put("code", "00");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", "01");
		}
		
		return result;
	}
}