package com.sist.vo;

import java.io.Serializable;

public class StyleVO implements Serializable {
	private int sno, like_count, reply_count;
	private String picture, profile, nickname, content,
				poster, name, price;
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLike_Count() {
		return like_count;
	}
	public void setLike_Count(int like_count) {
		this.like_count = like_count;
	}
	public int getReply_Count() {
		return reply_count;
	}
	public void setReply_Count(int reply_count) {
		this.reply_count = reply_count;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
