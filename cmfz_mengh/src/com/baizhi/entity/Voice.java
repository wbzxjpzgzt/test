package com.baizhi.entity;

public class Voice {
	private Integer vid;
	private Integer aid;
	private String vname;
	private String mid;
	private Integer downloads;
	private String size;
	private String status;
	private String vurl;
	
	private Album album;
	
	
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public Integer getDownloads() {
		return downloads;
	}
	public void setDownloads(Integer downloads) {
		this.downloads = downloads;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getVurl() {
		return vurl;
	}
	public void setVurl(String vurl) {
		this.vurl = vurl;
	}

	public Voice(Integer vid, Integer aid, String vname, String mid,
			Integer downloads, String size, String status, String vurl,
			Album album) {
		super();
		this.vid = vid;
		this.aid = aid;
		this.vname = vname;
		this.mid = mid;
		this.downloads = downloads;
		this.size = size;
		this.status = status;
		this.vurl = vurl;
		this.album = album;
	}
	@Override
	public String toString() {
		return "Voice [vid=" + vid + ", aid=" + aid + ", vname=" + vname
				+ ", mid=" + mid + ", downloads=" + downloads + ", size="
				+ size + ", status=" + status + ", vurl=" + vurl + ", album="
				+ album + "]";
	}
	public Voice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
