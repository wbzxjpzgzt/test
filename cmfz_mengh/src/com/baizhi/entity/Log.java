package com.baizhi.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Log {
	private String id;
	private String name;
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createtime;
	private String detail;
	private String type;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Log [id=" + id + ", name=" + name + ", createtime="
				+ createtime + ", detail=" + detail + ", type=" + type + "]";
	}
	public Log(String id, String name, Date createtime, String detail,
			String type) {
		super();
		this.id = id;
		this.name = name;
		this.createtime = createtime;
		this.detail = detail;
		this.type = type;
	}
	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
