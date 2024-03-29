package com.sist.dao;

/*
 * 	MNO      NOT NULL NUMBER        
	CNO               NUMBER        
	TITLE             VARCHAR2(500) 
	GRADE             VARCHAR2(50)  
	RESERVE           VARCHAR2(20)  
	GENRE             VARCHAR2(200) 
	TIME              VARCHAR2(30)  
	REGDATE           VARCHAR2(200) 
	DIRECTOR          VARCHAR2(100) 
	ACTOR             VARCHAR2(200) 
	SHOWUSER          VARCHAR2(20)  
	POSTER            VARCHAR2(260) 
	STORY             CLOB          
	KEY               VARCHAR2(50)  
	HIT               NUMBER        
	SCORE             NUMBER(3,2) 
 */

// record 단위 (컬럼 여러 개를 묶은 것)
public class MovieVO {
	private int mno, cno, hit;
	private double score;
	private String title, grade, reserve, genre, time, regdate, director, actor, showuser, poster, story, key;
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getReserve() {
		return reserve;
	}
	public void setReserve(String reserve) {
		this.reserve = reserve;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getShowuser() {
		return showuser;
	}
	public void setShowuser(String showuser) {
		this.showuser = showuser;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	
}
