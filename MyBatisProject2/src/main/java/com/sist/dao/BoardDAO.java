package com.sist.dao;

import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;

public class BoardDAO {
	private static SqlSessionFactory ssf;
	static {
		//XML 파싱 => 데이터 주입
		try {
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// 목록
	// resultType ==> return형
	// parameterType ==> 매개변수
	public static List<BoardVO> boardListData(Map map) {
		SqlSession session=null;	// 주소 읽기
		List<BoardVO> list=new ArrayList<BoardVO>();
		try {
			 session=ssf.openSession();
			 list=session.selectList("boardListData", map);	// id와 ?에 들어갈 값
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();  // 반환
		}
		
		return list;
	}
	
	// 상세보기
	
}
