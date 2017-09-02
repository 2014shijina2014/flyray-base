package me.flyray.cms.model;

import java.util.List;

import me.flyray.common.model.BaseModel;

/**
 * 
 * @author centerroot
 * @time 创建时间:2017年8月26日下午2:56:23
 * @description：类别实体
 */
public class InterestGroupCategory extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4867688468585690486L;
	/**
	 * 自增id
	 */
	private Long id;
	/**
	 * 类别名称
	 */
	private String categoryName;
	/**
	 * 创建时间
	 */
	private String createtime;
	/**
	 * 状态标志 00：无效
	 */
	private String flag;
	
	/**
	 * 类别中包含的小组
	 */
	private List<InterestGroup> groupList;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public List<InterestGroup> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<InterestGroup> groupList) {
		this.groupList = groupList;
	}

	@Override
	public String toString() {
		return "InterestGroupCategory [id=" + id + ", categoryName=" + categoryName + ", createtime=" + createtime
				+ ", flag=" + flag + ", groupList=" + groupList + "]";
	}

}
