package me.flyray.cms.api;

import java.util.List;
import java.util.Map;

import me.flyray.cms.model.Comment;
import me.flyray.common.service.BaseService;

/** 
* @author: bolei
* @date：2017年10月6日 上午11:24:40
* @description：cms模块的评论回复表
*/

public interface CommentService extends BaseService {

	/**
	 *  根据条件查询评论
	 */
	public List<Comment> query(Map<String, Object> param);
	
	public Comment saveAll(Map<String, Object> param);
}
