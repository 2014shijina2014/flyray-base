package me.flyray.cms.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import me.flyray.common.model.BaseModel;

public class Viewpoint extends BaseModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键，自增
	 */
	private String id;
	/**
	 * 索引，用户编号
	 */
	private String createBy;
	/**
	 * 发表观点，文字内容
	 */
	private String pointText;
	/**
	 * 发表观点，图片路径，json格式
	 */
	private String pointImg;
	/**
	 * 发表时间
	 */
	private Date pointTime;
	/**
	 * 发表地点
	 */
	private String pointAddress;
	/**
	 * 点赞数量
	 */
	private Integer favortCount;
	/**
	 * 评论数量
	 */
	private Integer commentCount;
	/**
	 *发表状态距现在时间
	 * 
	 */
	private String diffTime;
	/**
	 * 是否点赞过 1、点赞过，2、没有点赞过
	 */
	private Integer ifFavort;
	
	
	
	
	public Integer getIfFavort() {
		return ifFavort;
	}
	public void setIfFavort(Integer ifFavort) {
		this.ifFavort = ifFavort;
	}
	public String getDiffTime() {
		return diffTime;
	}
	public void setDiffTime(String diffTime) {
		this.diffTime = diffTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPointImg() {
		return pointImg;
	}
	public void setPointImg(String pointImg) {
		this.pointImg = pointImg;
	}
	public Date getPointTime() {
		return pointTime;
	}
	public void setPointTime(Date pointTime) {
		this.pointTime = pointTime;
	}
	public String getPointAddress() {
		return pointAddress;
	}
	public void setPointAddress(String pointAddress) {
		this.pointAddress = pointAddress;
	}
	public String getPointText() {
		return pointText;
	}
	public void setPointText(String pointText) {
		this.pointText = pointText;
	}
	
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Integer getFavortCount() {
		return favortCount;
	}
	public void setFavortCount(Integer favortCount) {
		this.favortCount = favortCount;
	}
	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	@Override
	public String toString() {
		return "Viewpoint [id=" + id + ", createBy=" + createBy + ", pointText=" + pointText + ", pointImg=" + pointImg
				+ ", pointTime=" + pointTime + ", pointAddress=" + pointAddress + ", favortCount=" + favortCount
				+ ", commentCount=" + commentCount + ", diffTime=" + diffTime + ", ifFavort=" + ifFavort + "]";
	}
	
}
