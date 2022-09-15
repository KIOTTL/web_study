package com.sist.dao;

import java.io.Reader;
import java.util.List;

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

	public static List<ShoesVO> navNewList() {	
		SqlSession session=null;
		List<ShoesVO> list=null;
		try {
			session=ssf.openSession();
			list=session.selectList("navNewList");	
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}
	
	public static List<ShoesVO> navMenList() {	
		SqlSession session=null;
		List<ShoesVO> list=null;
		try {
			session=ssf.openSession();
			list=session.selectList("navMenList");	
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}
	
	public static List<ShoesVO> navWomenList() {	
		SqlSession session=null;
		List<ShoesVO> list=null;
		try {
			session=ssf.openSession();
			list=session.selectList("navWomenList");	
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
