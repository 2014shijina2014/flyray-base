package me.flyray.cms.api;

import java.util.Map;

import me.flyray.cms.model.Topic;
import me.flyray.common.service.BaseService;

/** 
* @author: bolei
* @date：2017年3月15日 下午10:55:49 
* @description：话题相关接口
*/

public interface TopicService extends BaseService{
	Topic queryTopicInfo(Map<String, Object> param);
}
