package com.baizhi.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Album {
	private Integer aid;
	private String aname;
	private String acontent;
	private String apictureurl;
	private String mid;
	private Integer agrade;
	private String status;
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date atime;
	
	private Master master;

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAcontent() {
		return acontent;
	}

	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}

	public String getApictureurl() {
		return apictureurl;
	}

	public void setApictureurl(String apictureurl) {
		this.apictureurl = apictureurl;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public Integer getAgrade() {
		return agrade;
	}

	public void setAgrade(Integer agrade) {
		this.agrade = agrade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getAtime() {
		return atime;
	}

	public void setAtime(Date atime) {
		this.atime = atime;
	}

	public Master getMaster() {
		return master;
	}

	public void setMaster(Master master) {
		this.master = master;
	}

	@Override
	public String toString() {
		return "Album [aid=" + aid + ", aname=" + aname + ", acontent="
				+ acontent + ", apictureurl=" + apictureurl + ", mid=" + mid
				+ ", agrade=" + agrade + ", status=" + status + ", atime="
				+ atime + ", master=" + master + "]";
	}

	public Album(Integer aid, String aname, String acontent,
			String apictureurl, String mid, Integer agrade, String status,
			Date atime, Master master) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.acontent = acontent;
		this.apictureurl = apictureurl;
		this.mid = mid;
		this.agrade = agrade;
		this.status = status;
		this.atime = atime;
		this.master = master;
	}

	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
