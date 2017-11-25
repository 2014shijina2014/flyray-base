package me.flyray.cms.model;

import java.io.Serializable;
import java.util.Date;

public class InterestGroupCustomerModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1473439953333930565L;
	/**
	 * 团队序号
	 */
	private String groupId;
	/**
	 * 小组名称
	 */
	private String groupName;
	/**
	 * 用户序号
	 */
	private String customerId;
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

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerNo() {
		return customerNo;
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

	@Override
	public String toString() {
		return "InterestGroupCustomerModel [groupId=" + groupId + ", groupName=" + groupName + ", customerId="
				+ customerId + ", customerNo=" + customerNo + ", custName=" + custName + ", nickname=" + nickname
				+ ", phone=" + phone + ", sex=" + sex + ", identityCard=" + identityCard + ", address=" + address
				+ ", age=" + age + ", birthday=" + birthday + ", avatar=" + avatar + "]";
	}
	
	
}
