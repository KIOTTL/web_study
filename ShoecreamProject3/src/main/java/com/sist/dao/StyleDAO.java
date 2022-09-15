package com.sist.dao;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.StyleVO;


public class StyleDAO {
	private static SqlSessionFactory ssf;
	static {
		try {
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static List<StyleVO> styleListData() {
		List<StyleVO> list = null;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			list=session.selectList("styleListData");
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	
	public static int styleTotalPage() {
		int total=0;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			total=session.selectOne("styleTotalPage");
		} catch(Exception ex) {
			System.out.println("styleTotalPage error : ");
			ex.printStackTrace();
		} finally {
			if (session!=null)
				session.close();
		}
		
		return total;
	}
	
	public static void styleInsert(StyleVO vo) {
		SqlSession session=null;
		try {
			session=ssf.openSession(true);	// true 없으면 commit(x) => autocommit false
			session.insert("styleInsert",vo);
//			session.commit(); // true 안 적었을 경우
		} catch(Exception ex) {
			System.out.println("styleInsert error : ");
			ex.printStackTrace();
		} finally {
			if (session!=null)
				session.close();
		
		}
	}
}
