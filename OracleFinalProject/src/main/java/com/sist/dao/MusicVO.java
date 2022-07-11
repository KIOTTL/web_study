package com.sist.dao;

/*
 * 	MNO          NUMBER          => int
	CNO          NUMBER          => int
	TITLE        VARCHAR2(500)   => String
	SINGER       VARCHAR2(500)   => String
	ALBUM        VARCHAR2(500)   => String
	POSTER       VARCHAR2(260)   => String
	IDCREMENT    NUMBER          => int
	STATE        VARCHAR2(20)    =>String
	
	데이터베이스
	1) 자바 <==> 컬럼 매칭
	   - 오라클
	     -----
	     문자
	       CHAR(1~2000byte) 고정 => CHAR(30) => 'a' => 30byte
	       VARCHAR2(1~4000byte) 가변 => 입력된 값만큼 메모리 할당
	       CLOB(4기가) 가변
	       --------------------------------------------------- 자바 => String
	     숫자
	       NUMBER => 8자리, 소수점 2자리
	       NUMBER(7,2) => 정수, 실수
	       ---------------------------- 자바 => int, double (데이터 첨부 확인)
	     날짜
	       DATE
	       ----- 자바 => java.util.Date
	       	
 */

// 캡슐화 코딩 => 데이터 보호
// 오라클에서 가지고 온 데이터 저장이 목적, 웹으로 전송할 목족
// 데이터형 클래스 (사용자 정의 데이터형)
// 읽기 / 쓰기 => getter / setter
public class MusicVO {
	private int mno, cno, idcrement;
	private String title, singer, album, poster, state;
	
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
	public int getIdcrement() {
		return idcrement;
	}
	public void setIdcrement(int idcrement) {
		this.idcrement = idcrement;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}    
	
}
