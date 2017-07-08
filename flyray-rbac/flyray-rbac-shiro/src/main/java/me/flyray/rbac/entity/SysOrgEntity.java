package me.flyray.rbac.entity;

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
	private String orgName;
	
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
	
	/**
	 * ztree属性
	 */
	private Boolean open;

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

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
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
	
	
}
