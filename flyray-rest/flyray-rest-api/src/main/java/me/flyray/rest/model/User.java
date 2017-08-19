package me.flyray.rest.model;

import java.util.Date;

public class User{
	
	private Integer id;
	private String username;
	private String password;
	private String chinesename;
	private Integer dept;
	private String email;
	private String tel;
	private Integer sysRole;
	private Integer state;
	private Date registerDate;
	private Date updateDate;
	private Date dimissionDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getChinesename() {
		return chinesename;
	}

	public void setChinesename(String chinesename) {
		this.chinesename = chinesename;
	}

	public Integer getDept() {
		return dept;
	}

	public void setDept(Integer dept) {
		this.dept = dept;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getSysRole() {
		return sysRole;
	}

	public void setSysRole(Integer sysRole) {
		this.sysRole = sysRole;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getDimissionDate() {
		return dimissionDate;
	}

	public void setDimissionDate(Date dimissionDate) {
		this.dimissionDate = dimissionDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", chinesename=" + chinesename
				+ ", dept=" + dept + ", email=" + email + ", tel=" + tel + ", sysRole=" + sysRole + ", state=" + state
				+ ", registerDate=" + registerDate + ", updateDate=" + updateDate + ", dimissionDate=" + dimissionDate
				+ "]";
	}
}
