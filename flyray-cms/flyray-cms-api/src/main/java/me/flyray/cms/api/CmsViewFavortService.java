package me.flyray.cms.api;

import java.util.List;
import java.util.Map;

import me.flyray.cms.model.CmsViewFavort;
import me.flyray.cms.model.CmsViewPoint;

public interface CmsViewFavortService {

	List<CmsViewFavort> queryObject(Long id);

	List<CmsViewFavort> queryList(Map<String, Object> map);

	List<CmsViewFavort> query(Map<String, Object> map);

	Integer queryCount(Map<String, Object> map);

	Integer queryTotal();

	void save(CmsViewFavort favort);

	void delete(Long id);
	
	/**
	 * 点赞或者取消赞执行
	 */
	Map<String, Object> doFavort(Map<String, Object> param);

}
