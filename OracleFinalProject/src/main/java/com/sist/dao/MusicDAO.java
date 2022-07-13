package com.sist.dao;

import java.sql.*;	// 오라클 연결 => 모든 데이터베이스 연결 가능
import java.util.*; // Collection

/*
 * 	1. 드라이버 등록
 * 	2. 오라클 연결
 * 	3. 오라클 연결 해제
 * 	4. 기능 수행 ==> 요구사항
 * ----------------------
 * 		1) 목록 출력 => 페이지 나누기 (인라인뷰)
 *  	2) 장르별 처리 ==> WHERE
 *  	3) 검색 => 찾기 ==> LIKE
 */

// 사용자 요청을 받아서 오라클 연결 => 결과값을 가지고 오는 역할
public class MusicDAO {
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
	public MusicDAO() {		// 멤버변수의 초기화 / 시작과 함께 등록(드라이버 연결, 서버 연결)
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
	
	// 기능
	// 1. 목록 출력 => 페이지 나누기
	/*
	 * 		1) 자바로 나누기
	 * 		2) 오라클로 나누기 ==> 인라인뷰
	 *      -- View : 한 개 이상의 테이블을 참조해서 만든 가상 테이블
	 *      		  => 테이블과 동일하게 사용 가능
	 *      		  => DML(INSERT, UPDATE, DELETE) => 실제 참조하고 있는 테이블에 저장
	 *      	      => READ ONLY
	 *      		  종류) ====> SQL문장을 저장하고 나중에 필요할 때 재사용
	 *      			         뷰에 저장되는 실제 데이터 저장이 아닌 SQL문장 저장
	 *      					 보안과 SQL문장을 단순화
	 *      		       1. 단일뷰 : 테이블 한 개 연결 => 필요한 데이터만 모아서 사용
	 *   				   2. 복합뷰 : 2개 이상의 테이블 => JOIN, SubQuery
	 *   				   3. 인라인뷰 : 	=> SELECT 이용
	 *   								=> rownum : INSERT시마다 지정되는 ROW의 번호
	 *   								   ------- 단점) Top-N(처음부터, 중간(X))
	 *   			  사용방식(뷰)
	 *   				CREATE OR REPLACE VIEW view_name
	 *   				AS
	 *   				  SELECT ~~
	 *   				
	 *   			  인라인뷰 => 오라클 기록상에 남아 있지 않는다 (한 번 사용)
	 *   				SELECT ~~
	 *   				FROM (SELECT ~~)
	 */
	public List<MusicVO> musicListData(int cno, int page) {
		// cno => 장르별 페이지 나누기
		List<MusicVO> list = new ArrayList<MusicVO>();
		try {
			// 무조건 사용 가능
			// 오라클 연결
			getConnection();
			
			// SQL문장 만들고 전송 => 오라클
			String sql = "SELECT mno,cno,poster,title,singer,album,idcrement,state,num "
					+"FROM (SELECT mno,cno,poster,title,singer,album,idcrement,state,rownum as num "
					+"FROM (SELECT mno,cno,poster,title,singer,album,idcrement,state "
					+"FROM music "
					+"WHERE cno=? "
					+"ORDER BY mno ASC)) "
					+"WHERE num BETWEEN ? AND ?";
			ps=conn.prepareStatement(sql);
			
			// ?에 값 채우기
			int rowSize=10;
			// 1, 11, 21, 31, ...
			int start=(rowSize*page)-(rowSize-1);	// rownum => 1번부터 => rowSize-1
			int end=rowSize*page;
			
			ps.setInt(1, cno);		// 1번 ?
			ps.setInt(2, start);	// 2번 ?
			ps.setInt(3, end);		// 3번 ?
			
			// 실행 요청 => 결과값 받기
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				MusicVO vo = new MusicVO();
				vo.setMno(rs.getInt(1));
				vo.setCno(rs.getInt(2));
				vo.setPoster(rs.getString(3));
				vo.setTitle(rs.getString(4));
				vo.setSinger(rs.getString(5));
				vo.setAlbum(rs.getString(6));
				vo.setIdcrement(rs.getInt(7));
				vo.setState(rs.getString(8));
				
				list.add(vo);	// 페이지에 출력할 개수만큼 모아서 웹으로 한 번에 전송
			}
			rs.close();
			
		} catch(Exception ex) {
			/*
			 * 	에러 메세지
			 * 	getMessage() : 에러 메세지만 출력
			 * 	printStackTrace() : 실행된 과정 보여줌 (에러부분 추출)			
			 */
			ex.printStackTrace();
		} finally {
			// 닫기 => 정상 비정상 => try, catch와 상관없이 무조건 실행
			disConnection();	// 반복 제거
			// 메서드 => 재사용, 반복 제거
		}
		
		return list;
	}
	
	// 총 페이지 가지고 오기
	public int musicTotalPage(int cno) {
		int total=0;
		try {
			getConnection();
			String sql = "SELECT CEIL(COUNT(*)/10.0) "
					+"FROM music "
					+"WHERE cno=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, cno);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection();
		}
		
		return total;
	}
	
}





























