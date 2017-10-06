package me.flyray.cms.api;

import java.util.List;
import java.util.Map;

import me.flyray.cms.model.Viewpoint;
import me.flyray.common.service.BaseService;

/** 
* @date：2017年3月15日 下午10:55:49 
* @description：圈子相关接口
*/

public interface ViewpointService extends BaseService{

	void delete(Long id);

	List<Viewpoint> query(Map<String, Object> map);
}