package com.sist.dao;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.GoodsVO;

public class GoodsDAO {
	private static SqlSessionFactory ssf;
	
	// 자동 인식 => 초기화 블럭
	static {
		try {
			// XML 파싱 (Config.xml(Connection), Mapper(PreparedStatement, ResultSet)
			// Config.xml는 1개 Mapper는 테이블 개수만큼
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static List<GoodsVO> goodsHomeData(String table_name){
		List<GoodsVO> list=null;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			list=session.selectList("goodsHomeData",table_name);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	
	// 목록 읽기
	public static List<GoodsVO> goodsListData(Map map) {
		List<GoodsVO> list=null;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			list=session.selectList("goodsListData",map);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	
	// 총페이지
	public static int goodsTotalPage(String table_name) {
		int total=0;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			total=session.selectOne("goodsTotalPage",table_name);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return total;
	}
	
	public static GoodsVO goodsDetailData(Map map) {
		GoodsVO vo=new GoodsVO();
		SqlSession session=null;
		try {
			session=ssf.openSession();
			vo=session.selectOne("goodsDetailData",map);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session!=null)
				session.close();
		}
		
		return vo;
	}
	
}





















