package com.baizhi.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Article {
	private Integer artid;
	private String artname;
	private String artcontent;
	private String mid;
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date arttime;
	private Integer clicks;
	private String status;
	private String artpic;
	
	private Master master;

	public Integer getArtid() {
		return artid;
	}

	public void setArtid(Integer artid) {
		this.artid = artid;
	}

	public String getArtname() {
		return artname;
	}

	public void setArtname(String artname) {
		this.artname = artname;
	}

	public String getArtcontent() {
		return artcontent;
	}

	public void setArtcontent(String artcontent) {
		this.artcontent = artcontent;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public Date getArttime() {
		return arttime;
	}

	public void setArttime(Date arttime) {
		this.arttime = arttime;
	}

	public Integer getClicks() {
		return clicks;
	}

	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getArtpic() {
		return artpic;
	}

	public void setArtpic(String artpic) {
		this.artpic = artpic;
	}

	public Master getMaster() {
		return master;
	}

	public void setMaster(Master master) {
		this.master = master;
	}

	@Override
	public String toString() {
		return "Article [artid=" + artid + ", artname=" + artname
				+ ", artcontent=" + artcontent + ", mid=" + mid + ", arttime="
				+ arttime + ", clicks=" + clicks + ", status=" + status
				+ ", artpic=" + artpic + ", master=" + master + "]";
	}

	public Article(Integer artid, String artname, String artcontent,
			String mid, Date arttime, Integer clicks, String status,
			String artpic, Master master) {
		super();
		this.artid = artid;
		this.artname = artname;
		this.artcontent = artcontent;
		this.mid = mid;
		this.arttime = arttime;
		this.clicks = clicks;
		this.status = status;
		this.artpic = artpic;
		this.master = master;
	}

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
