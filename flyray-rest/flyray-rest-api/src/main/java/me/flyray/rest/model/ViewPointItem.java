package me.flyray.rest.model;

import me.flyray.cms.model.Viewpoint;
import me.flyray.crm.model.CustomerBase;

public class ViewPointItem {
	private Viewpoint cmsViewPoint;
	private CustomerBase customer;
	public Viewpoint getCmsViewPoint() {
		return cmsViewPoint;
	}
	public void setCmsViewPoint(Viewpoint cmsViewPoint) {
		this.cmsViewPoint = cmsViewPoint;
	}
	public CustomerBase getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerBase customer) {
		this.customer = customer;
	}
	
}
