package me.flyray.cms.model;

import me.flyray.common.model.BaseModel;

/** 
* @author: bolei
* @date：2017年10月3日 下午3:57:05
* @description：内容管理专栏
*/

public class SpecialColumn extends BaseModel {
	
	/**
	 * 跟进算法生成id
	 */
	private String id;
	
	/**
	 * 专栏名称
	 */
	private String columnName;
	
	/**
	 * 专栏介绍
	 */
	private String columnDesc;
	
	/**
	 * 专栏logo
	 */
	private String columnLogo;
	
	/**
	 * 专栏创建者
	 */
	private String createBy;
	
	/**
	 * 专栏状态：0上架1下架
	 * @return
	 */
	
	private String columnStatus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnDesc() {
		return columnDesc;
	}

	public void setColumnDesc(String columnDesc) {
		this.columnDesc = columnDesc;
	}

	public String getColumnLogo() {
		return columnLogo;
	}

	public void setColumnLogo(String columnLogo) {
		this.columnLogo = columnLogo;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getColumnStatus() {
		return columnStatus;
	}

	public void setColumnStatus(String columnStatus) {
		this.columnStatus = columnStatus;
	}
	
}
