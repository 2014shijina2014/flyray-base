package me.flyray.rest.model;

/** 
* @author: bolei
* @date：2017年9月27日 下午12:55:12
* @description：类说明 
*/

public class ApiResult {
	
	private String code;
	
	private String status;
	
	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
