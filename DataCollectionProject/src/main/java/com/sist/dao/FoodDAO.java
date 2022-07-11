package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
import java.sql.*;

/*
 * 	CNO                                       NOT NULL NUMBER
 TITLE                                     NOT NULL VARCHAR2(1000)
 SUBJECT                                   NOT NULL VARCHAR2(1000)
 POSTER                                    NOT NULL VARCHAR2(200)
 LINK                                      NOT NULL VARCHAR2(500)
 */
public class FoodDAO {
	// 오라클 연결 클래스
	private Connection conn;
	
	// 오라클 SQL문장 전송 => 결과값 읽기
	/*
	 * 	PreparedStatement : SQL 문장
	 * 	CallableStatement : PL/SQL => Procedure
	 * 	==> 실행 요청
	 * 		executeQuery ==> 결과값 받음 => SELECT
	 * 		executeUpdate => 실행 요청 => COMMIT 포함 => INSERT, UPDATE, DELETE
	 * 	==> 한 개의 메서드(기능)에서 SQL문장이 한 개 이상일 수 있다
	 * 
	 */
	private PreparedStatement ps;
	
	// 오라클 주소
	private String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	// 드라이버 설정 ==> ojdbc8.jar
	// 18c, 21c ==> ojdbc8.jar
	public FoodDAO() {		// 멤버변수의 초기화 / 시작과 함께 등록(드라이버 연결, 서버 연결)
		// 한 번만 수행 => 생성자
		try {
			// 리플렉션 => 메모리 할당, 메서드 호출, 변수의 초기값 주입
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception ex) {}
	}
	
	// 오라클 연결 => SQLplus
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		} catch(Exception ex) {}
	}
	
	// 오라클 닫기
	public void disConnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch(Exception ex) {}
	} 
	
	public void categoryInsert(FoodCategoryVO vo) {
		try {
			getConnection();
			// 시퀀스 없을 때 서브쿼리 사용 => 자동 증가 번호 만들기
			String sql = "INSERT INTO food_category "
					+"VALUES((SELECT NVL(MAX(cno)+1,1) FROM food_category), "
					+"?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getPoster());
			ps.setString(4, vo.getLink());
			
			ps.executeUpdate();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection();
		}
	}
	
	public List<FoodCategoryVO> foodCategoryInfoData() {
		List<FoodCategoryVO> list = new ArrayList<FoodCategoryVO>();
		try {
			getConnection();
			String sql = "SELECT cno,link,title "
					+"FROM food_category "
					+"ORDER BY cno ASC";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				FoodCategoryVO vo = new FoodCategoryVO();
				vo.setCno(rs.getInt(1));
				vo.setLink(rs.getString(2));
				vo.setTitle(rs.getString(3));
				
				list.add(vo);
			}
			rs.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection();
		}
		
		return list;
	}
	
}































