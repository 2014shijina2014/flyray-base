package me.flyray.cms.model;

import java.sql.Timestamp;

import me.flyray.common.model.BaseModel;

/** 
* @author: bolei
* @date：2017年10月6日 上午11:15:17
* @description：cms模块的评论回复表
*/

public class Comment extends BaseModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8754505712835926770L;

	/**
	 * 主键id
	 */
	private String id;
	
	/**
	 * 回复评论的目标id
	 */
	private String parentId;
	
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
	private String commentTargetId;
	
	/**
	 * 发表评论的用户id
	 */
	private String commentBy;
	
	/**
	 * 发表评论的用户昵称
	 */
	private String commentByName;
	
	/**
	 * 评论的目标用户id
	 */
	private String  commentTargetUserId;
	
	/**
	 * 评论的目标用户昵称
	 */
	private String commentTargetUserName;
	
	/**
	 * 该评论被点赞的数量
	 */
	private Long  commentLikeCount;
	
	/**
	 * 评论时间
	 */
	private Timestamp  commentTime;
	
	/**
	 * 评论模块编号
	 */
	private String  commentModuleNo;
	/**
	 * 评论人头像
	 */
	private String commentImg;
	/**
	 * 字符串格式时间
	 */
	private String commentTimes;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
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
	public String getCommentTargetId() {
		return commentTargetId;
	}
	public void setCommentTargetId(String commentTargetId) {
		this.commentTargetId = commentTargetId;
	}
	public String getCommentBy() {
		return commentBy;
	}
	public void setCommentBy(String commentBy) {
		this.commentBy = commentBy;
	}
	public String getCommentByName() {
		return commentByName;
	}
	public void setCommentByName(String commentByName) {
		this.commentByName = commentByName;
	}
	public String getCommentTargetUserId() {
		return commentTargetUserId;
	}
	public void setCommentTargetUserId(String commentTargetUserId) {
		this.commentTargetUserId = commentTargetUserId;
	}
	public String getCommentTargetUserName() {
		return commentTargetUserName;
	}
	public void setCommentTargetUserName(String commentTargetUserName) {
		this.commentTargetUserName = commentTargetUserName;
	}
	public Long getCommentLikeCount() {
		return commentLikeCount;
	}
	public void setCommentLikeCount(Long commentLikeCount) {
		this.commentLikeCount = commentLikeCount;
	}
	public Timestamp getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}
	public String getCommentModuleNo() {
		return commentModuleNo;
	}
	public void setCommentModuleNo(String commentModuleNo) {
		this.commentModuleNo = commentModuleNo;
	}
	public String getCommentImg() {
		return commentImg;
	}
	public void setCommentImg(String commentImg) {
		this.commentImg = commentImg;
	}
	public String getCommentTimes() {
		return commentTimes;
	}
	public void setCommentTimes(String commentTimes) {
		this.commentTimes = commentTimes;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", parentId=" + parentId + ", commentType=" + commentType + ", commentContent="
				+ commentContent + ", commentTargetId=" + commentTargetId + ", commentBy=" + commentBy
				+ ", commentByName=" + commentByName + ", commentTargetUserId=" + commentTargetUserId
				+ ", commentTargetUserName=" + commentTargetUserName + ", commentLikeCount=" + commentLikeCount
				+ ", commentTime=" + commentTime + ", commentModuleNo=" + commentModuleNo + ", commentImg=" + commentImg
				+ ", commentTimes=" + commentTimes + "]";
	}
	
	
}
