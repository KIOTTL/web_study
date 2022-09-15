package com.sist.dao;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.ShoesVO;
import com.sist.vo.StyleVO;

public class NavDAO {
   private static SqlSessionFactory ssf;

   static {   
      try {
         Reader reader=Resources.getResourceAsReader("Config.xml");
         ssf=new SqlSessionFactoryBuilder().build(reader);
      } catch(Exception ex) {
         ex.printStackTrace();
      }
   }
   
   public static int navTotalPage(Map map)
   {
      int total = 0;
      SqlSession session = null;
      
      try
      {
         session = ssf.openSession();
         total = session.selectOne("navTotalPage", map);
      }catch(Exception ex) {
         ex.printStackTrace();
      }finally {
         if(session!=null) session.close();
      }
      return total;
   }
   
   public static int navTotalPage2(Map map)
   {
	   int total = 0;
	   SqlSession session = null;
	   
	   try
	   {
		   session = ssf.openSession();
		   total = session.selectOne("navTotalPage2", map);
	   }catch(Exception ex) {
		   ex.printStackTrace();
	   }finally {
		   if(session!=null) session.close();
	   }
	   return total;
   }
   
   public static int navTotalPage3(Map map)
   {
	   int total = 0;
	   SqlSession session = null;
	   
	   try
	   {
		   session = ssf.openSession();
		   total = session.selectOne("navTotalPage3", map);
	   }catch(Exception ex) {
		   ex.printStackTrace();
	   }finally {
		   if(session!=null) session.close();
	   }
	   return total;
   }

   public static List<ShoesVO> navNewList(Map map) {   
      SqlSession session=null;
      List<ShoesVO> list=null;
      try {
         session=ssf.openSession();
         list=session.selectList("navNewList", map);   
      } catch(Exception ex) {
         ex.printStackTrace();
      } finally {
         session.close();
      }
      
      return list;
   }
   
   public static List<ShoesVO> navMenList(Map map) {   
      SqlSession session=null;
      List<ShoesVO> list=null;
      try {
         session=ssf.openSession();
         list=session.selectList("navMenList", map);   
      } catch(Exception ex) {
         ex.printStackTrace();
      } finally {
         session.close();
      }
      
      return list;
   }
   
   public static List<ShoesVO> navWomenList(Map map) {   
      SqlSession session=null;
      List<ShoesVO> list=null;
      try {
         session=ssf.openSession();
         list=session.selectList("navWomenList", map);   
      } catch(Exception ex) {
         ex.printStackTrace();
      } finally {
         session.close();
      }
      
      return list;
   }
   
   public static List<ShoesVO> navKidsList() {   
      SqlSession session=null;
      List<ShoesVO> list=null;
      try {
         session=ssf.openSession();
         list=session.selectList("navKidsList");   
      } catch(Exception ex) {
         ex.printStackTrace();
      } finally {
         session.close();
      }
      
      return list;
   }
   
   public static List<StyleVO> navStyleList() {   
      SqlSession session=null;
      List<StyleVO> list=null;
      try {
         session=ssf.openSession();
         list=session.selectList("navStyleList");   
      } catch(Exception ex) {
         ex.printStackTrace();
      } finally {
         session.close();
      }
      
      return list;
   }
   
   public static List<ShoesVO> navBrandList() {   
      SqlSession session=null;
      List<ShoesVO> list=null;
      try {
         session=ssf.openSession();
         list=session.selectList("navBrandList");   
      } catch(Exception ex) {
         ex.printStackTrace();
      } finally {
         session.close();
      }
      
      return list;
   }
   
   public static List<ShoesVO> navCalendarList() {   
      SqlSession session=null;
      List<ShoesVO> list=null;
      try {
         session=ssf.openSession();
         list=session.selectList("navCalendarList");   
      } catch(Exception ex) {
         ex.printStackTrace();
      } finally {
         session.close();
      }
      
      return list;
   }   
}