package com.baizhi.entity;

import java.util.List;


public class PageLog{
	private List<Log> rows;//每页数据集合
	private Integer total;//总页码
	public List<Log> getRows() {
		return rows;
	}
	public void setRows(List<Log> rows) {
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
		return "PageLog [rows=" + rows + ", total=" + total + "]";
	}
	public PageLog(List<Log> rows, Integer total) {
		super();
		this.rows = rows;
		this.total = total;
	}
	public PageLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}