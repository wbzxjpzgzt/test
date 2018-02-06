package com.baizhi.entity;

import java.util.List;

public class PageUser {
	private List<User> rows;//每页数据集合
	private Integer total;//总页码
	public List<User> getRows() {
		return rows;
	}
	public void setRows(List<User> rows) {
		this.rows = rows;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "PageRoundPicture [rows=" + rows + ", total=" + total + "]";
	}
	public PageUser(List<User> rows, Integer total) {
		super();
		this.rows = rows;
		this.total = total;
	}
	public PageUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
