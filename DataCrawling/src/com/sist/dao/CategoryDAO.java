package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.vo.CategoryVO;
import com.sist.vo.KreamVO;

public class CategoryDAO {
	private Connection conn;
	   private PreparedStatement ps;
	   private final String URL="jdbc:oracle:thin:@183.98.140.90:1521:XE";
	   private final String USERNAME="hr";
	   private final String PASSWORD="happy";
	   // 1. 드라이버 등록 => 한번만 수행 ==> 생성자 
	   public CategoryDAO()
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
	   public void CategoryInsert(CategoryVO c)
	   {
		   // java.io , java.sql => 예외처리 => CheckException
		   try
		   {
			   /*
				 CNO                                       NOT NULL NUMBER
				 POSTER                                    NOT NULL VARCHAR2(500)
				 BRAND                                     NOT NULL VARCHAR2(20)
				 NAME                                      NOT NULL VARCHAR2(200)
				 PRICE                                              VARCHAR2(10)
			    */
			   // 정상문장
			   // 1. 오라클 연결 
			   getConnection();
			   // 2. SQL문장 
			   String sql="INSERT INTO category VALUES(?,?,?,?,?)";
			   
			   // 3. 오라클 전송
			   ps=conn.prepareStatement(sql); // 네트워크 
			   // 4. 실행 
			   // 4-1 ?에 값을 채운다 
			   ps.setInt(1, c.getCno());
			   ps.setString(2, c.getPoster());
			   ps.setString(3, c.getBrand());
			   ps.setString(4, c.getName());
			   ps.setString(5, c.getPrice());

			   
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
	   public ArrayList<CategoryVO> categoryListData()
	   {
		   ArrayList<CategoryVO> list=
				   new ArrayList<CategoryVO>();
		   try
		   {
			   getConnection();
			   String sql="SELECT cno, poster, brand, name, price "
					     +"FROM CategoryVO ";
//					     +"WHERE cno="+cno;
			   ps=conn.prepareStatement(sql);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   CategoryVO c=new CategoryVO();
				   c.setCno(rs.getInt(1));
//				   k.setImg(rs.getString(2));
				   c.setPoster(rs.getString(2));
				   c.setBrand(rs.getString(3));
				   c.setName(rs.getString(4));
				   c.setPrice(rs.getString(5));
				   list.add(c);
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
