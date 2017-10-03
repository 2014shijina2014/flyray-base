package me.flyray.cms.api;

import java.util.Map;

import me.flyray.common.service.BaseService;

public interface ViewFavortService extends BaseService{

	void delete(Long id);
	
	/**
	 * 点赞或者取消赞执行
	 */
	Map<String, Object> doFavort(Map<String, Object> param);

}
