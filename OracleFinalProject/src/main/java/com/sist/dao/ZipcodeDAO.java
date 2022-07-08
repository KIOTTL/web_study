package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ZipcodeDAO {
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
	private String URL="jdbc:oracle:thin:@183.98.140.90:1521:XE";
	
	// 드라이버 설정 ==> ojdbc8.jar
	// 18c, 21c ==> ojdbc8.jar
	public ZipcodeDAO() {		// 멤버변수의 초기화 / 시작과 함께 등록(드라이버 연결, 서버 연결)
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
	// ----------------------------------------------------------------------------------- 필수 조건
	
	// 1. 우편번호 검색 ==> LIKE, NVL
	public List<ZipcodeVO> postFind(String dong) {
		List<ZipcodeVO> list = new ArrayList<ZipcodeVO>();
		try {
			// 1. 연결
			getConnection();
			// 2. SQL문장 제작
			String sql = "SELECT zipcode,sido,gugun,dong,NVL(bunji,' ') "		// bunji 뒤 '':null ' ':공백
					+"FROM zipcode "
					+"WHERE dong LIKE '%'||?||'%'";		// MySQL => CONCAT('%',?,'%')
			// 3. 오라클 전송
			ps=conn.prepareStatement(sql);
			// 4. ?에 값 채우기
			ps.setString(1, dong);
			// 5. 실행 후 결과값 받기
			ResultSet rs = ps.executeQuery();
			// 6. rs에 있는 값 List에 채우기
			while(rs.next()) {		// 처음 위치부터 출력
				ZipcodeVO vo = new ZipcodeVO();
				vo.setZipcode(rs.getString(1));
				vo.setSido(rs.getString(2));
				vo.setGugun(rs.getString(3));
				vo.setDong(rs.getString(4));
				vo.setBunji(rs.getString(5));
				
				list.add(vo);	// 검색된 모든 결과값 모아서 전송
			}
			rs.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection();
		}
		
		return list;
	}
	
	// 2. 검색 수 출력 ==> COUNT => 단일행에서 집합(COUNT) 못 써서 따로
	public int postFindCount(String dong) {
		int count=0;
		try {
			// 1. 연결
			getConnection();
			// 2. SQL문장 제작
			String sql = "SELECT COUNT(*) "
					+"FROM zipcode "
					+"WHERE dong LIKE '%'||?||'%'";
			// 3. 오라클 전송
			ps=conn.prepareStatement(sql);
			// 4. ?에 값 채우기
			ps.setString(1, dong);
			// 5. 실행 후 결과값 받기
			ResultSet rs = ps.executeQuery();
			// 6. rs의 위치 변경
			rs.next();
			// 7. 값 받기
			count=rs.getInt(1);
			rs.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection();
		}
		
		return count;
	}
	
}

















