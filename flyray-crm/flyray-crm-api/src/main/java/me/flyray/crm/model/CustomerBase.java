package me.flyray.crm.model;

import java.io.Serializable;
import java.util.Date;

/** 
* @author: bolei
* @date：2017年3月6日 下午9:53:42 
* @description：客户基础信息
*/

public class CustomerBase implements Serializable{

	/**
	 * 客户自增ID
	 */
	private Long id;
	
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
	 * 商户号
	 */
	private String merchantNo;
	
	/**
	 * 机构号
	 */
	private String orgNo;
	/**
	 * 拓展
	 */
	private CrmCustomerBaseExtend crmCustomerBaseExtend;
	
	public CrmCustomerBaseExtend getCrmCustomerBaseExtend() {
		return crmCustomerBaseExtend;
	}

	public void setCrmCustomerBaseExtend(CrmCustomerBaseExtend crmCustomerBaseExtend) {
		this.crmCustomerBaseExtend = crmCustomerBaseExtend;
	}

	public String getCustomerNo() {
		return customerNo;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getOrgNo() {
		return orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	@Override
	public String toString() {
		return "CustomerBase [id=" + id + ", customerNo=" + customerNo + ", custName=" + custName + ", nickname="
				+ nickname + ", phone=" + phone + ", sex=" + sex + ", identityCard=" + identityCard + ", address="
				+ address + ", age=" + age + ", birthday=" + birthday + ", avatar=" + avatar + ", merchantNo="
				+ merchantNo + ", orgNo=" + orgNo + ", crmCustomerBaseExtend=" + crmCustomerBaseExtend + "]";
	}
	
}
