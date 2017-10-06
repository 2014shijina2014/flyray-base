package me.flyray.cms.model;

import me.flyray.common.model.BaseModel;

/** 
* @author: bolei
* @date：2017年10月6日 上午11:15:17
* @description：cms模块的评论回复表
*/

public class Comment extends BaseModel {
	
	/**
	 * 主键id
	 */
	private Long id;
	
	/**
	 * 评论类型(1评论2回复)
	 */
	private String commentType;
	
	/**
	 * 评论内容
	 */
	private String commentContent;
	
	/**
	 * 评论的目标id
	 */
	private Long commentTargetId;
	
	/**
	 * 发表评论的用户id
	 */
	private Long commentBy;
	
	/**
	 * 评论的目标用户id
	 */
	private Long  commentTargetUserId;
	
	/**
	 * 该评论被点赞的数量
	 */
	private Long  commentLikeCount;
	
	/**
	 * 评论时间
	 */
	private String  commentTime;
	
	/**
	 * 评论模块编号
	 */
	private String  commentModuleNo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommentType() {
		return commentType;
	}

	public void setCommentType(String commentType) {
		this.commentType = commentType;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Long getCommentTargetId() {
		return commentTargetId;
	}

	public void setCommentTargetId(Long commentTargetId) {
		this.commentTargetId = commentTargetId;
	}

	public Long getCommentBy() {
		return commentBy;
	}

	public void setCommentBy(Long commentBy) {
		this.commentBy = commentBy;
	}

	public Long getCommentTargetUserId() {
		return commentTargetUserId;
	}

	public void setCommentTargetUserId(Long commentTargetUserId) {
		this.commentTargetUserId = commentTargetUserId;
	}

	public Long getCommentLikeCount() {
		return commentLikeCount;
	}

	public void setCommentLikeCount(Long commentLikeCount) {
		this.commentLikeCount = commentLikeCount;
	}

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	public String getCommentModuleNo() {
		return commentModuleNo;
	}

	public void setCommentModuleNo(String commentModuleNo) {
		this.commentModuleNo = commentModuleNo;
	}
	
}
