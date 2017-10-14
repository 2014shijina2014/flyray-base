package me.flyray.cms.model;

import me.flyray.common.model.BaseModel;

/**
 * @author: bolei
 * @date：2017年3月6日 下午10:21:42
 * @description：话题
 */

public class Topic extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6637440544286734697L;

	/**
	 * id
	 */
	private String id;
	
	/**
	 * 话题标题
	 */
	private String title;
	
	/**
	 * 话题内容
	 */
	private String content;
	
	/**
	 * 描述 
	 */
	private String discription;
	
	/**
	 * 背景图片
	 */
	private String img;
	
	/**
	 * 发起话题人
	 */
	private String createBy;
	
	/**
	 * 发起时间
	 */
	private String createTime;
	
	/**
	 * 审核删除标识
	 */
	private String flag;
	/**
	 * 发起话题人名字
	 */
	private String name;
	
	/**
	 * 发起人头像
	 */
	private String authImg;
	
	
	
	public String getAuthImg() {
		return authImg;
	}

	public void setAuthImg(String authImg) {
		this.authImg = authImg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", title=" + title + ", content=" + content + ", discription=" + discription
				+ ", img=" + img + ", createBy=" + createBy + ", createTime=" + createTime + ", flag=" + flag
				+ ", name=" + name + ", authImg=" + authImg + "]";
	}
}
