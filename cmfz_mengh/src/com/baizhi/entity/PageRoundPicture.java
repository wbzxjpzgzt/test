package com.baizhi.entity;

import java.util.List;

public class PageRoundPicture {
	private List<RoundPicture> rows;//每页数据集合
	private Integer total;//总页码
	public List<RoundPicture> getRows() {
		return rows;
	}
	public void setRows(List<RoundPicture> rows) {
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
	public PageRoundPicture(List<RoundPicture> rows, Integer total) {
		super();
		this.rows = rows;
		this.total = total;
	}
	public PageRoundPicture() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
