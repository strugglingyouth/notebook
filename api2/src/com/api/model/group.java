package com.api.model;

import java.util.Date;

public class group {
	private int id;
	private int ownuserid;
	private String title;
	private  String date;
	private String desc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOwnuserid() {
		return ownuserid;
	}
	public void setOwnuserid(int ownuserid) {
		this.ownuserid = ownuserid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	

}
