package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

public class Admin implements Serializable{
	private Integer adminid;
	private String adminname;
	private String salt;
	private String password;
	private String status;
	private String logintime;
	private String ip;
	
	

	public Integer getAdminid() {
		return adminid;
	}

	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLogintime() {
		return logintime;
	}

	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}



	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", adminname=" + adminname
				+ ", salt=" + salt + ", password=" + password + ", status="
				+ status + ", logintime=" + logintime + ", ip=" + ip
				+ "]";
	}

	public Admin(Integer adminid, String adminname, String salt,
			String password, String status, String logintime, String ip,
			List<Role> roles) {
		super();
		this.adminid = adminid;
		this.adminname = adminname;
		this.salt = salt;
		this.password = password;
		this.status = status;
		this.logintime = logintime;
		this.ip = ip;
		
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
