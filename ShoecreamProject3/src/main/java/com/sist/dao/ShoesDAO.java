package com.sist.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.ShoesCategoryVO;
import com.sist.vo.ShoesVO;



public class ShoesDAO {
	private static SqlSessionFactory ssf;

	static {	// 자동 수행
		try {
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public static List<ShoesVO> shoesPopListData() {	
		SqlSession session=null;
		List<ShoesVO> list=null;
		try {
			session=ssf.openSession();
			list=session.selectList("shoesPopListData");	
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}
	
	public static List<ShoesVO> shoesNewListData() {	
		SqlSession session=null;
		List<ShoesVO> list=null;
		try {
			session=ssf.openSession();
			list=session.selectList("shoesNewListData");	
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}

	public static List<ShoesVO> shoesPreListData() {
		SqlSession session=null;
		List<ShoesVO> list=null;
		try {
			session=ssf.openSession();
			list=session.selectList("shoesPreListData");	
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}

	public static List<ShoesVO> shoesBrandListData(String brand) {
		SqlSession session=null;
		List<ShoesVO> list=null;
		try {
			session=ssf.openSession();
			list=session.selectList("shoesBrandListData", brand);	
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}
	
	public static ShoesVO shoesDetailData(int goods_id) {	
		SqlSession session=null;
		ShoesVO vo=null;
		try {
			session=ssf.openSession();
			vo=session.selectOne("shoesDetailData", goods_id);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		
		return vo;		
	}
	
}
