package com.baizhi.entity;

import org.springframework.web.multipart.MultipartFile;

import com.baizhi.annotation.Comment;

public class User {
		@Comment("编号")
	   private Integer userid;
		@Comment("密码")
	   private String password;
		@Comment("电话")	
	   private String phone;
		@Comment("头像")
	   private String userhead;
		@Comment("法名")
	   private String faname;
		@Comment("用户名")
	   private String username;
		@Comment("性别")
	   private String sex;
		@Comment("归属地")
	   private String location;
		@Comment("签名")
	   private String sign;
		@Comment("上师")
	   private String mid;
		@Comment("状态")
	   private String status;
		@Comment("盐值")
	   private String salt;
	   
	   private MultipartFile file;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserhead() {
		return userhead;
	}

	public void setUserhead(String userhead) {
		this.userhead = userhead;
	}

	public String getFaname() {
		return faname;
	}

	public void setFaname(String faname) {
		this.faname = faname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", password=" + password + ", phone="
				+ phone + ", userhead=" + userhead + ", faname=" + faname
				+ ", username=" + username + ", sex=" + sex + ", location="
				+ location + ", sign=" + sign + ", mid=" + mid + ", status="
				+ status + ", salt=" + salt + ", file=" + file + "]";
	}

	public User(Integer userid, String password, String phone, String userhead,
			String faname, String username, String sex, String location,
			String sign, String mid, String status, String salt,
			MultipartFile file) {
		super();
		this.userid = userid;
		this.password = password;
		this.phone = phone;
		this.userhead = userhead;
		this.faname = faname;
		this.username = username;
		this.sex = sex;
		this.location = location;
		this.sign = sign;
		this.mid = mid;
		this.status = status;
		this.salt = salt;
		this.file = file;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	   
	   
	   
}
