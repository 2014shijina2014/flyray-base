package me.flyray.rest.model;

import me.flyray.cms.model.CmsViewPoint;
import me.flyray.crm.model.CustomerBase;

public class ViewPointItem {
	private CmsViewPoint cmsViewPoint;
	private CustomerBase customer;
	public CmsViewPoint getCmsViewPoint() {
		return cmsViewPoint;
	}
	public void setCmsViewPoint(CmsViewPoint cmsViewPoint) {
		this.cmsViewPoint = cmsViewPoint;
	}
	public CustomerBase getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerBase customer) {
		this.customer = customer;
	}
	
}
