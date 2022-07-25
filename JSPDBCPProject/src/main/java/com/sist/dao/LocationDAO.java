package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LocationDAO {
	private Connection conn;
	private PreparedStatement ps;
	
	// DBCP => POOL (Connection 저장 => 관리)
	// 연결 객체 가지고 오기 => getConnection => 생성 아니고 생성된 객체 가지고 오기
	public void getConnection() {
		try {
			// 저장된 위치 가져오기 (JNDI) => java://comp/env => Connection 객체 저장
			// 1. 탐색기 열기
			Context init = new InitialContext();
			
			// 2. C드라이버 열기
			Context c = (Context)init.lookup("java://comp/env");
			
			// 3. 저장된 폴더에서 Connection 읽어오기
			DataSource ds = (DataSource)c.lookup("jdbc/oracle");
			conn=ds.getConnection();	// 미리 생성된 Connection 객체 얻어오기
			
		} catch(Exception ex) {}
	}
	
	// 반환 => disConnection => ps.close(), conn.close()
	public void disConnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch(Exception ex) {}
	}
	
	// 기능
	public List<LocationVO> locationListData(int page) {
		List<LocationVO> list=new ArrayList<LocationVO>();
		try {
			// 미리 생성된 Connection 객체 주소 얻어오기
			getConnection();
			
			String sql = "SELECT no, title, poster, num "
					+"FROM (SELECT no, title, poster, rownum as num "
					+"FROM (SELECT no, title, poster "
					+"FROM seoul_location ORDER BY no ASC)) "
					+"WHERE num BETWEEN ? AND ?";
			// rownum 이용시 => Top-N => 중간 데이터 가지고 오기 불가능
			ps=conn.prepareStatement(sql);
			int rowSize=12;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				LocationVO vo = new LocationVO();
				vo.setNo(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPoster(rs.getString(3));
				
				list.add(vo);
			}
			rs.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			// 닫기 => 반환 (commons-dbcp.jar) => 다른 사용자가 재사용 가능 (일정 Connection 객체로 사용) => 서버 부하가 적어짐
			disConnection();
		}
		
		return list;
	}
	
	// 총페이지 구하기
	public int locationTotalPage() {
		int total=0;
		try {
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/12.0) FROM seoul_location";
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
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
