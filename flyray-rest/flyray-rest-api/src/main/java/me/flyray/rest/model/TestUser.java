package me.flyray.rest.model;

import java.io.Serializable;

/** 
* @author: bolei
* @date：2017年3月26日 下午9:38:36 
* @description：类说明 
*/

@SuppressWarnings("serial")
public class TestUser implements Serializable{

	private String username;
	private String password;
	private String chinesename;
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
	
}
