package com.sist.vo;

import java.util.Date;

/*
 *  STYLE_ID NOT NULL NUMBER         
	IMG      NOT NULL VARCHAR2(2000) 
	CONTENT  NOT NULL CLOB           
	RGDATE   NOT NULL DATE           
	BOOKMARK          NUMBER         
	USER_ID  NOT NULL NUMBER 
 */

public class StyleVO {
	private int id, bookmark, user_id, rcount;
	private String img, content, dbday, email;
	private Date rgdate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBookmark() {
		return bookmark;
	}
	public void setBookmark(int bookmark) {
		this.bookmark = bookmark;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRgdate() {
		return rgdate;
	}
	public void setRgdate(Date rgdate) {
		this.rgdate = rgdate;
	}
	public String getDbday() {
		return dbday;
	}
	public void setDbday(String dbday) {
		this.dbday = dbday;
	}
	public int getRcount() {
		return rcount;
	}
	public void setRcount(int rcount) {
		this.rcount = rcount;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
