package me.flyray.crm.model;

import java.util.Date;

import me.flyray.common.model.BaseModel;

/** 
* @author: bolei
* @date：2017年3月6日 下午9:53:42 
* @description：客户基础信息
*/

public class CustomerBase extends BaseModel {

	/**
	 * 客户ID
	 */
	private String id;
	
	/**
	 * 客户编号
	 */
	private String customerNo;
	
	/**
	 * 客户名称
	 */
	private String custName;
	
	/**
	 * 客户昵称
	 */
	private String nickname;
	
	/**
	 * 客户电话
	 */
	private String phone;
	
	/**
	 * 客户性别
	 */
	private String sex;
	
	/**
	 * 客户身份证号
	 */
	private String identityCard;
	
	/**
	 * 客户住址
	 */
	private String address;
	
	/**
	 * 客户年龄
	 */
	private String age;
	
	/**
	 * 客户生日
	 */
	private Date birthday;
	
	/**
	 * 头像
	 */
	
	private String avatar;
	
	/**
	 * 拓展
	 */
	private CustomerBaseExtend customerBaseExtend;

	public String getCustomerNo() {
		return customerNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	public CustomerBaseExtend getCustomerBaseExtend() {
		return customerBaseExtend;
	}


	public void setCustomerBaseExtend(CustomerBaseExtend customerBaseExtend) {
		this.customerBaseExtend = customerBaseExtend;
	}
	
}
