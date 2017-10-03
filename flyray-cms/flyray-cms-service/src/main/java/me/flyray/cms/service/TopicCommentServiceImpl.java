package me.flyray.cms.service;

import org.springframework.stereotype.Service;

import me.flyray.cms.api.TopicCommentService;
import me.flyray.cms.model.TopicComment;
import me.flyray.common.service.AbstractBaseService;

@Service("topicCommentService")
public class TopicCommentServiceImpl extends AbstractBaseService<TopicComment> implements TopicCommentService{

}
