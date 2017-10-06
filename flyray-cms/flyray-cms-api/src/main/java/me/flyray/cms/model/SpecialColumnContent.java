package me.flyray.cms.model;

/** 
* @author: bolei
* @date：2017年10月6日 上午9:30:47
* @description：专栏内容
*/

public class SpecialColumnContent {

	/**
	 * 根据算法生成的id
	 */
	private Long id;
	
	/**
	 * 专栏内容名称
	 */
	private String columnContentTitle;
	
	/**
	 * 专栏具体内容
	 */
	private String columnContent;
	
	/**
	 * 创建时间
	 */
	private String createTime;
	
	/**
	 * 创建人
	 */
	private Long createBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getColumnContentTitle() {
		return columnContentTitle;
	}

	public void setColumnContentTitle(String columnContentTitle) {
		this.columnContentTitle = columnContentTitle;
	}

	public String getColumnContent() {
		return columnContent;
	}

	public void setColumnContent(String columnContent) {
		this.columnContent = columnContent;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
	
}
