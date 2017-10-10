package me.flyray.cms.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.cms.api.CommentService;
import me.flyray.cms.dao.CommentDao;
import me.flyray.cms.model.Comment;
import me.flyray.common.service.AbstractBaseService;
import me.flyray.common.utils.SnowFlake;

/** 
* @author: bolei
* @date：2017年10月6日 上午11:27:03
* @description：cms模块的评论回复表
*/

@Service("commentService")
public class CommentServiceImpl extends AbstractBaseService<Comment> implements CommentService {

	@Autowired
	private CommentDao commentDao;
	
	@Override
	public List<Comment> query(Map<String, Object> param) {
		return commentDao.queryList(param);
	}

	@Override
	public Map<String, Object> saveTopicComment(Map<String, Object> param) {
		String content = (String) param.get("content");
		String targetId = (String) param.get("targetId");
		String commentByName = (String) param.get("commentByName");
		String commentBy = (String) param.get("commentBy");
		Long id = SnowFlake.getId();
		Comment comment = new Comment();
		comment.setId(id.toString());
		comment.setCommentModuleNo("2");
		comment.setCommentType("1");
		comment.setCommentContent(content);
		comment.setCommentTargetId(targetId);
		comment.setCommentByName(commentByName);
		comment.setCommentBy(Long.valueOf(commentBy));
		comment.setCommentTime(new Timestamp(new Date().getTime()));
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			commentDao.save(comment);
			String format = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat sdf = new SimpleDateFormat(format); 
			String time = sdf.format(comment.getCommentTime());
			comment.setCommentTimes(time);
			map.put("code", "00");
			map.put("comment", comment);
		} catch (Exception e) {
			map.put("code", "01");
			e.printStackTrace();
		}
		
		return map;
	}

	@Override
	public Comment savePointComment(Map<String, Object> param) throws Exception{
		String commentType = (String) param.get("commentType");//1评论2回复
		Comment comment = new Comment();
		Long id = SnowFlake.getId();
		comment.setId(String.valueOf(id));
		String commentContent = (String) param.get("commentContent");
		String commentTargetId = (String) param.get("commentTargetId");
		String commentBy = (String) param.get("commentBy");
		String commentByName = (String) param.get("commentByName");
		comment.setCommentContent(commentContent);
		//如果是评论commentTargetId是被评论的观点的编号，如果是回复 commentTargetId 是被回复的评论的编号
		comment.setCommentTargetId(commentTargetId);
		comment.setCommentLikeCount(Long.valueOf("0"));
		comment.setCommentTime(new Timestamp(new Date().getTime()));
		comment.setCommentModuleNo("1");
		comment.setCommentBy(Long.valueOf(commentBy));
		comment.setCommentByName(commentByName);
		if ("1".equals(commentType)) {
			//1、评论
			comment.setCommentType("1");
		} else if("2".equals(commentType)) {
			//2、回复
			comment.setCommentType("2");
			Integer commentTargetUserId = (Integer) param.get("commentTargetUserId");
			String commentTargetUserName = (String) param.get("commentTargetUserName");
			comment.setCommentTargetUserId(Long.valueOf(commentTargetUserId));
			comment.setCommentTargetUserName(commentTargetUserName);
			
		}
		commentDao.save(comment);
		return comment;
	}

}
