package com.baizhi.entity;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.annotation.JSONField;

public class RoundPicture {
	private String rpicid;
	private String picname;
	private String picdiscribe;
	private String picstatus;
	private MultipartFile file;
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date pictime;
	public RoundPicture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoundPicture(String rpicid, String picname, String picdiscribe,
			String picstatus, MultipartFile file, Date pictime) {
		super();
		this.rpicid = rpicid;
		this.picname = picname;
		this.picdiscribe = picdiscribe;
		this.picstatus = picstatus;
		this.file = file;
		this.pictime = pictime;
	}
	@Override
	public String toString() {
		return "RoundPicture [rpicid=" + rpicid + ", picname=" + picname
				+ ", picdiscribe=" + picdiscribe + ", picstatus=" + picstatus
				+ ", file=" + file + ", pictime=" + pictime + "]";
	}
	public String getRpicid() {
		return rpicid;
	}
	public void setRpicid(String rpicid) {
		this.rpicid = rpicid;
	}
	public String getPicname() {
		return picname;
	}
	public void setPicname(String picname) {
		this.picname = picname;
	}
	public String getPicdiscribe() {
		return picdiscribe;
	}
	public void setPicdiscribe(String picdiscribe) {
		this.picdiscribe = picdiscribe;
	}
	public String getPicstatus() {
		return picstatus;
	}
	public void setPicstatus(String picstatus) {
		this.picstatus = picstatus;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public Date getPictime() {
		return pictime;
	}
	public void setPictime(Date pictime) {
		this.pictime = pictime;
	}
	
	

	
	
}
