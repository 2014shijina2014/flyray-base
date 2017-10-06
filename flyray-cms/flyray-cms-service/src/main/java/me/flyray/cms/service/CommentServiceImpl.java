package me.flyray.cms.service;

import org.springframework.stereotype.Service;

import me.flyray.cms.api.CommentService;
import me.flyray.cms.model.Comment;
import me.flyray.common.service.AbstractBaseService;

/** 
* @author: bolei
* @date：2017年10月6日 上午11:27:03
* @description：cms模块的评论回复表
*/

@Service("commentService")
public class CommentServiceImpl extends AbstractBaseService<Comment> implements CommentService {

}
