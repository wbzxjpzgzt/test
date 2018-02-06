package com.baizhi.entity;

import java.util.List;

public class Menu {
	private Integer menuid;
	private String menuname;
	private String iconCls;
	private String url;
	private Integer parent_id;
	
	private List<Menu> list;

	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public List<Menu> getList() {
		return list;
	}

	public void setList(List<Menu> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Menu [menuid=" + menuid + ", menuname=" + menuname
				+ ", iconCls=" + iconCls + ", url=" + url + ", parent_id="
				+ parent_id + ", list=" + list + "]";
	}

	public Menu(Integer menuid, String menuname, String iconCls, String url,
			Integer parent_id, List<Menu> list) {
		super();
		this.menuid = menuid;
		this.menuname = menuname;
		this.iconCls = iconCls;
		this.url = url;
		this.parent_id = parent_id;
		this.list = list;
	}

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
