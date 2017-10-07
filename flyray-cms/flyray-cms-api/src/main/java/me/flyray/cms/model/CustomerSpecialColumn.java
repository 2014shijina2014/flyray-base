package me.flyray.cms.model;

import me.flyray.common.model.BaseModel;

/** 
* @author: bolei
* @date：2017年10月6日 下午3:09:09
* @description：客户与专栏的关系 
*/

public class CustomerSpecialColumn extends BaseModel {

	/**
	 * 客户id
	 */
	private Long customerId;
	
	/**
	 * 客户订阅的专栏id
	 */
	
	private Long specialColumnId;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getSpecialColumnId() {
		return specialColumnId;
	}

	public void setSpecialColumnId(Long specialColumnId) {
		this.specialColumnId = specialColumnId;
	}
	
}
