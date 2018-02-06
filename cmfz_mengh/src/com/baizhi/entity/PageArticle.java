package com.baizhi.entity;

import java.util.List;


public class PageArticle{
	private List<Article> rows;//每页数据集合
	private Integer total;//总页码
	public List<Article> getRows() {
		return rows;
	}
	public void setRows(List<Article> rows) {
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
	public PageArticle(List<Article> rows, Integer total) {
		super();
		this.rows = rows;
		this.total = total;
	}
	public PageArticle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}