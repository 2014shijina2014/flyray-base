package me.flyray.cms.api;

import java.util.List;
import java.util.Map;

import me.flyray.cms.model.CmsViewPoint;

public interface CmsViewPointService {

	List<CmsViewPoint> queryObject(Long id);
	List<CmsViewPoint> queryList(Map<String, Object> map);
	Integer queryTotal();
	void save(CmsViewPoint point);
	void delete(Long id);

}
