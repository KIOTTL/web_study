package com.sist.dao;

import java.sql.*;
import java.util.ArrayList;

import com.sist.vo.*;
public class KreamDAO {
   private Connection conn;
   private PreparedStatement ps;
   private final String URL="jdbc:oracle:thin:@183.98.140.90:1521:XE";
   private final String USERNAME="hr";
   private final String PASSWORD="happy";
   // 1. 드라이버 등록 => 한번만 수행 ==> 생성자 
   public KreamDAO()
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
   public void KreamInsert(KreamVO k)
   {
	   // java.io , java.sql => 예외처리 => CheckException
	   try
	   {
		   /*
		    *    MNO                                                NUMBER
				 CNO                                                NUMBER
				 TITLE                                              VARCHAR2(500)
				 SINGER                                             VARCHAR2(500)
				 ALBUM                                              VARCHAR2(500)
				 POSTER                                             VARCHAR2(260)
				 IDCREMENT                                          NUMBER
				 STATE
				 
				 kno, img, brand, name, translated_name, amount, desc, express_mark
		    */
		   // 정상문장
		   // 1. 오라클 연결 
		   getConnection();
		   // 2. SQL문장 
		   String sql="INSERT INTO kream VALUES(?,?,?,?,?,?,?)";
		   
		   // 3. 오라클 전송
		   ps=conn.prepareStatement(sql); // 네트워크 
		   // 4. 실행 
		   // 4-1 ?에 값을 채운다 
		   ps.setInt(1, k.getKno());
//		   ps.setString(2, k.getImg());
		   ps.setString(2, k.getBrand());
		   ps.setString(3, k.getName());
		   ps.setString(4, k.getTranslated_name());
		   ps.setString(5, k.getAmount());
		   ps.setString(6, k.getDesc());
		   ps.setString(7, k.getExpress_mark());
		   
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
   public ArrayList<KreamVO> musicListData()
   {
	   ArrayList<KreamVO> list=
			   new ArrayList<KreamVO>();
	   try
	   {
		   getConnection();
		   String sql="SELECT kno,brand,name,"
				     +"translated_name, amount, desc, express_mark "
				     +"FROM KreamVO ";
//				     +"WHERE cno="+cno;
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   KreamVO k=new KreamVO();
			   k.setKno(rs.getInt(1));
//			   k.setImg(rs.getString(2));
			   k.setBrand(rs.getString(2));
			   k.setName(rs.getString(3));
			   k.setTranslated_name(rs.getString(4));
			   k.setAmount(rs.getString(5));
			   k.setDesc(rs.getString(6));
			   k.setExpress_mark(rs.getString(7));
			   list.add(k);
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
