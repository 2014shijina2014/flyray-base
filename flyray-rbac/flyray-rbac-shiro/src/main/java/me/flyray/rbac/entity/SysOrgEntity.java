package me.flyray.rbac.entity;

import java.util.List;

/** 
* @author: bolei
* @date：Jun 25, 2017 2:41:26 PM 
* @description：组织机构
*/

public class SysOrgEntity {

	/**
	 * 机构部门ID
	 */
	private Long id;
	
	/**
	 * 机构部门编号
	 */
	private String orgNo;
	
	/**
	 * 机构部门名称
	 */
	private String name;
	
	/**
	 * 所属机构部门
	 */
	private Long parentId;
	
	/**
	 * 创建人user_id
	 */
	private String createBy;
	
	/**
	 * 创建时间
	 */
	private String createTime;
	
	/**
	 * 最后修改人user_id
	 */
	private String lastUpdateBy;
	
	
	/**
	 * 最后修改时间
	 */
	private String lastUpdateTime;
	
	/**
	 * 机构部门排序号
	 */
	private Integer orgSort;
	
	//上级部门名称
	private String parentName;
	
	/**
	 * ztree属性
	 */
	private Boolean open;
	
	/**
	 * 状态
	 */
	private Boolean statusFlag;
	
	private List<?> list;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrgNo() {
		return orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Integer getOrgSort() {
		return orgSort;
	}

	public void setOrgSort(Integer orgSort) {
		this.orgSort = orgSort;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public Boolean getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(Boolean statusFlag) {
		this.statusFlag = statusFlag;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
	
	
}
