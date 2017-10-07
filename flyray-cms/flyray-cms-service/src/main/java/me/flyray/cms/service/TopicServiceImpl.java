package me.flyray.cms.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.cms.api.TopicService;
import me.flyray.cms.dao.TopicDao;
import me.flyray.cms.model.Topic;
import me.flyray.common.service.AbstractBaseService;
@Service("topicService")
public class TopicServiceImpl  extends AbstractBaseService<Topic> implements TopicService{
	@Autowired
	private TopicDao topicDao;
	@Override
	public Topic queryTopicInfo(Map<String, Object> param) {
		String id = (String) param.get("id");
		Topic topic = topicDao.selectById(id);
		return topic;
	}

}
