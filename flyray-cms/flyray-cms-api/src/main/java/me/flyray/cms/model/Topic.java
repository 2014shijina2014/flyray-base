package me.flyray.cms.model;

/**
 * @author: bolei
 * @date：2017年3月6日 下午10:21:42
 * @description：话题
 */

public class Topic {
	
	/**
	 * 自增id
	 */
	private Long id;
	
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
	private String customerNo;
	
	/**
	 * 发起时间
	 */
	private String createTime;
	
	/**
	 * 审核删除标识
	 */
	private String flag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
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
	
}
