package com.baizhi.entity;

public class Master {
	private String  mid;
	
	private String masterhead;

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMasterhead() {
		return masterhead;
	}

	public void setMasterhead(String masterhead) {
		this.masterhead = masterhead;
	}

	@Override
	public String toString() {
		return "Master [mid=" + mid + ", masterhead=" + masterhead + "]";
	}

	public Master(String mid, String masterhead) {
		super();
		this.mid = mid;
		this.masterhead = masterhead;
	}

	public Master() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
