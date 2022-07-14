package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.vo.CategoryVO;
import com.sist.vo.StyleVO;

public class StyleDAO {
	private Connection conn;
	   private PreparedStatement ps;
	   private final String URL="jdbc:oracle:thin:@183.98.140.90:1521:XE";
	   private final String USERNAME="hr";
	   private final String PASSWORD="happy";
	   // 1. 드라이버 등록 => 한번만 수행 ==> 생성자 
	   public StyleDAO()
	   {
		   try
		   {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
		   }catch(Exception ex){}
	   }
	   // 2. 데이터베이스 연결 
	   public void getConnection()
	   {
		   try
		   {
			   conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			   // conn hr/happy
		   }catch(Exception ex){}
	   }
	   // 3. 데이터베이스 해제 
	   public void disConnection()
	   {
		   try
		   {
			   if(ps!=null) ps.close();
			   if(conn!=null) conn.close();
			   
		   }catch(Exception ex){}
	   }
	   // 4. 기능 
	   // 4-1. Music 데이터 추가 
	   public void StyleInsert(StyleVO s)
	   {
		   // java.io , java.sql => 예외처리 => CheckException
		   try
		   {
			   /*
				 SNO                                       NOT NULL NUMBER
				 PICTURE                                   NOT NULL VARCHAR2(500)
				 PROFILE                                            VARCHAR2(500)
				 NICKNAME                                           VARCHAR2(20)
				 CONTENT                                   NOT NULL VARCHAR2(1000)
				 LIKE_COUNT                                         NUMBER
				 REPLY_COUNT                                        NUMBER
				 POSTER                                    NOT NULL VARCHAR2(500)
				 NAME                                      NOT NULL VARCHAR2(200)
				 PRICE                                              VARCHAR2(20)
			    */
			   // 정상문장
			   // 1. 오라클 연결 
			   getConnection();
			   // 2. SQL문장 
			   String sql="INSERT INTO category VALUES(?,?,?,?,?,?,?,?,?)";
			   
			   // 3. 오라클 전송
			   ps=conn.prepareStatement(sql); // 네트워크 
			   // 4. 실행 
			   // 4-1 ?에 값을 채운다 
			   ps.setInt(1, s.getSno());
			   ps.setString(2, s.getPicture());
			   ps.setString(3, s.getProfile());
			   ps.setString(4, s.getNickname());
			   ps.setString(5, s.getContent());
			   ps.setInt(6, s.getLike_Count());
			   ps.setInt(7, s.getReply_Count());
			   ps.setString(8, s.getName());
			   ps.setString(9, s.getPrice());

			   
			   ps.executeUpdate();
			   
		   }catch(Exception ex)
		   {
			   // 에러처리 => 복구 
			   ex.printStackTrace();
		   }
		   finally
		   {
			   // 서버 닫기 
			   disConnection();
		   }
	   }
	   // 4-2. 데이터베이스에서 Music 읽기 
	   public ArrayList<StyleVO> styleListData()
	   {
		   ArrayList<StyleVO> list=
				   new ArrayList<StyleVO>();
		   try
		   {
			   getConnection();
			   String sql="SELECT sno, picture, profile, nickname, content, like_count, reply_count, poster, name, price "
					     +"FROM StyleVO ";
//					     +"WHERE cno="+cno;
			   ps=conn.prepareStatement(sql);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   StyleVO s=new StyleVO();
				   s.setSno(rs.getInt(1));
				   s.setPicture(rs.getString(2));
				   s.setProfile(rs.getString(3));
				   s.setNickname(rs.getString(4));
				   s.setContent(rs.getString(5));
				   s.setLike_Count(rs.getInt(6));
				   s.setReply_Count(rs.getInt(7));
				   s.setName(rs.getString(8));
				   s.setPrice(rs.getString(9));
				   list.add(s);
			   }
			   rs.close();
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
		   return list;
	   }
}
