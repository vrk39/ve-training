package com.vtech.jdbc.helper;

public class LoginBean {
	private int loginId;
	private int empXid;
	private String username;
	private String password;
	private String permission;

	public int getEmpXid() {
		return empXid;
	}

	public void setEmpXid(int empXid) {
		this.empXid = empXid;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
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

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

}
