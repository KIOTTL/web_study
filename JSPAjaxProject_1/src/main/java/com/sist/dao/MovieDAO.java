package com.sist.dao;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MovieDAO {
	private static SqlSessionFactory ssf;
	static {
		try {
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		} catch(Exception ex) {}
	}
	
	public static List<MovieVO> movieListData(Map map) {
		SqlSession session=ssf.openSession();
		List<MovieVO> list=session.selectList("movieListData",map);
		session.close();
		
		return list;
	}
	
	public static MovieVO movieDetailData(int mno) {
		SqlSession session=ssf.openSession();
		MovieVO vo=session.selectOne("movieDetailData",mno);
		session.close();
		
		return vo;
		
	}
	
	public static int movieTotalPage(int cno) {
		SqlSession session=ssf.openSession();
		int total = session.selectOne("movieTotalPage",cno);
		session.close();
		
		return total;
		
	}
	
	public static List<MovieVO> movieFindData(String title) {
		  SqlSession session=ssf.openSession();//getConnection() 
		  List<MovieVO> list=session.selectList("movieFindData",title);
		  session.close();
		  return list;
		  
	}
	
	public static List<MovieVO> movieSearchData() {
		  SqlSession session=ssf.openSession();//getConnection() 
		  List<MovieVO> list=session.selectList("movieSearchData");
		  session.close();
		  return list;
		  
	}
}
