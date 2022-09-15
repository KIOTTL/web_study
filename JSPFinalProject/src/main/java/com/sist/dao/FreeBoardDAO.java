package com.sist.dao;

import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import com.sist.vo.*;

public class FreeBoardDAO {
	private static SqlSessionFactory ssf;
	static {
		try {
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static List<FreeBoardVO> boardListData(Map map) {
		List<FreeBoardVO> list = null;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			list=session.selectList("boardListData", map);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	
	public static int boardTotalPage() {
		int total=0;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			total=session.selectOne("boardTotalPage");
		} catch(Exception ex) {
			System.out.println("boardTotalPage error : ");
			ex.printStackTrace();
		} finally {
			if (session!=null)
				session.close();
		}
		
		return total;
	}
	
	public static void boardInsert(FreeBoardVO vo) {
		SqlSession session=null;
		try {
			session=ssf.openSession(true);	// true 없으면 commit(x) => autocommit false
			session.insert("boardInsert",vo);
//			session.commit(); // true 안 적었을 경우
		} catch(Exception ex) {
			System.out.println("boardInsert error : ");
			ex.printStackTrace();
		} finally {
			if (session!=null)
				session.close();
		
		}
	}
	
	public static FreeBoardVO boardDetailData(int no) {
		FreeBoardVO vo=new FreeBoardVO();
		SqlSession session=null;
		try {
			session=ssf.openSession();
			session.update("hitIncrement",no);
			session.commit();
			vo=session.selectOne("boardDetailData",no);
		} catch(Exception ex) {
			System.out.println("boardDetailData error : ");
			ex.printStackTrace();
		} finally {
			if (session!=null)
				session.close();
		}
		
		return vo;
	}
	
	public static FreeBoardVO boardUpdateData(int no) {
		FreeBoardVO vo=new FreeBoardVO();
		SqlSession session=null;
		try {
			session=ssf.openSession();
			vo=session.selectOne("boardDetailData",no);
		} catch(Exception ex) {
			System.out.println("boardUpdateData error : ");
			ex.printStackTrace();
		} finally {
			if (session!=null)
				session.close();
		}
		
		return vo;
	}
	
	public static String boardPwdCheck(int no, String pwd) {
		String result="";
		SqlSession session=null;
		try {
			session=ssf.openSession();
			String db_pwd=session.selectOne("boardGetPassword",no);
			
			if (db_pwd.equals(pwd)) {
				result="yes";
			} else {
				result="no";
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session!=null)
				session.close();
		}
		
		return result;
	}
	
	public static void boardUpdate(FreeBoardVO vo) {
		SqlSession session=null;
		try {
			session=ssf.openSession(true);	// true 없으면 commit(x) => autocommit false
			session.update("boardUpdate",vo);
//			session.commit(); // true 안 적었을 경우
		} catch(Exception ex) {
			System.out.println("boardUpdate error : ");
			ex.printStackTrace();
		} finally {
			if (session!=null)
				session.close();
		
		}
	}
	
	public static String boardDelete(int no, String pwd) {
		String result="";
		SqlSession session=null;
		try {
			session=ssf.openSession();
			// <select id="boardGetPassword" resultType="string" parameterType="int">
			/*
			 * 	SELECT pwd FROM project_freeboard
			 * 	WHERE no=#{no}
			 * 
			 * 	map.put("boardGetPassword", "SELECT pwd FROM project_freeboard WHERE no=#{no}")
			 */
			String db_pwd=session.selectOne("boardGetPassword",no);
			if(db_pwd.equals(pwd)) {
				result="yes";
				/*
				 * 	<delete id="boardDelete" parameterType="int">
				 * 	 DELETE FROM project_freeboard
				 * 	 WHERE no=#{no}
				 * 	</delete>
				 */
				session.delete("boardDelete",no);
				session.commit();
			} else {
				result="no";
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return result;
	}
}














