package com.baizhi.entity;

public class Resources {
	private Integer id;
	private String name;
	private String href;
	private String tag;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	@Override
	public String toString() {
		return "Resources [id=" + id + ", name=" + name + ", href=" + href
				+ ", tag=" + tag + "]";
	}
	public Resources(Integer id, String name, String href, String tag) {
		super();
		this.id = id;
		this.name = name;
		this.href = href;
		this.tag = tag;
	}
	public Resources() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
