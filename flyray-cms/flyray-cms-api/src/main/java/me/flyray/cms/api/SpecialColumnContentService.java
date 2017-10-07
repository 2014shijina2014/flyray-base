package me.flyray.cms.api;

import me.flyray.cms.model.SpecialColumnContent;
import me.flyray.common.service.BaseService;

/** 
* @author: bolei
* @date：2017年10月6日 上午9:39:49
* @description：专栏内容相关接口
*/

public interface SpecialColumnContentService extends BaseService {
	
	public SpecialColumnContent queryEntity(SpecialColumnContent param);
	
}
