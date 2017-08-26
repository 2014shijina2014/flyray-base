package me.flyray.erp.model;

import me.flyray.common.model.BaseModel;

/** 
* @author: bolei
* @date：2017年4月17日 下午4:00:00 
* @description：商品分类
*/

public class ProductCategary extends BaseModel {
	
	/**
	 * 自增ID
	 */
	private Integer id;
	
	/**
	 * 商品分类名称
	 */
	private String categaryName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategaryName() {
		return categaryName;
	}

	public void setCategaryName(String categaryName) {
		this.categaryName = categaryName;
	}

}
