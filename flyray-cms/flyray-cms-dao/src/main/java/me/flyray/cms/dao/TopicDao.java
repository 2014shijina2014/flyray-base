package me.flyray.cms.dao;

import me.flyray.cms.model.Topic;
import me.flyray.common.dao.BaseDao;

public interface TopicDao extends BaseDao<Topic>{
	Topic selectById(String id);
}
