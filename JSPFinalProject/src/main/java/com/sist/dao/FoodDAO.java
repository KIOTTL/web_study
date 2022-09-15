package com.sist.dao;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.FoodCategoryVO;
import com.sist.vo.FoodVO;
import com.sist.vo.JjimVO;
import com.sist.vo.RecipeVO;

public class FoodDAO {
	// XML 파싱 => 등록된 데이터 읽기
	private static SqlSessionFactory ssf;
	static {	// 자동 수행
		try {
			// XML 읽기
			// src/main/java => Config.xml (classpath 영역 => MyBatis 자동 인식)
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	// --------- getConnection, disConnection
	
	/*
	 *   <select id="foodCategoryData" resultType="FoodCategoryVO">
		    <!-- 
		    	List<FoodCategoryVO> = selectList
		    	FoodCategoryVO  	 = selectOne                                                               
		     -->
		     SELECT cno, title, subject, poster
		     FROM food_category
		  </select>
	 */
	public static List<FoodCategoryVO> foodCategoryData() {
		SqlSession session=null;
		List<FoodCategoryVO> list=null;
		try {
			session=ssf.openSession();
			list=session.selectList("foodCategoryData");
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}
	
	/*
	 *   <select id="foodListData" resultType="FoodVO" parameterType="int">
		    SELECT fno, poster, name, tel, type
		    FROM food_house
		    WHERE cno=#{cno}
		  </select>
	*/
	public static List<FoodVO> foodListData(int cno) {	// while(rs.next())
		SqlSession session=null;
		List<FoodVO> list=null;
		try {
			session=ssf.openSession();
			list=session.selectList("foodListData",cno);	// cno=>#{cno}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}
	
	/*
		  <select id="foodCategoryInfoData" resultType="FoodCategoryVO" parameterType="int">
		    SELECT title, subject
		    FROM food_category
		    WHERE cno=#{cno}
		  </select>
	 */
	public static FoodCategoryVO foodCategoryInfoData(int cno) {
		SqlSession session=null;
		FoodCategoryVO vo=null;
		try {
			session=ssf.openSession();
			vo=session.selectOne("foodCategoryInfoData", cno);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		
		return vo;
	}
	
	/*
	 *   <select id="foodDetailData" resultType="FoodVO" parameterType="int">
		    SELECT * FROM food_house
		    WHERE fno=#{fno}
		  </select>
		  
		  ==> select
		  		selectList (while(rs.next())
		  		selectOne  (rs.next())
		  	  insert
		  	  	insert
		  	  update
		  	  	update
		  	  delete
		  	  	delete
		  	  	
		  	  ? ==> parameterType
		  	  결과값 ==> resultType
	 */
	public static FoodVO foodDetailData(int fno) {	// rs.next()
		SqlSession session=null;
		FoodVO vo=null;
		try {
			session=ssf.openSession();
			vo=session.selectOne("foodDetailData", fno);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		
		return vo;		
	}
	
	public static List<FoodVO> foodLocationFindData(Map map) {
		List<FoodVO> list=null;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			list=session.selectList("foodLocationFindData", map);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	
	public static int foodLocationFindTotalPage(String address) {
		int total=0;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			total=session.selectOne("foodLocationFindTotalPage", address);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return total;
	}
	
	public static void foodJjimInsert(JjimVO vo) {
		SqlSession session=null;
		try {
			session=ssf.openSession(true);
			session.insert("foodJjimInsert",vo);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
	}
	
	public static int foodJjimCount(JjimVO vo) {
		int count=0;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			count=session.selectOne("foodJjimCount",vo);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return count;
	}
	
	public static FoodVO foodJjimListData(int fno) {
		FoodVO vo=null;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			vo=session.selectOne("foodJjimListData",fno);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return vo;
	}
	
	public static List<Integer> foodJjimGetFno(String id) {
		List<Integer> list=null;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			list=session.selectList("foodJjimGetFno",id);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	
	public static void foodJjimDelete(JjimVO vo) {
		SqlSession session=null;
		try {
			session=ssf.openSession(true);
			session.delete("foodJjimDelete",vo);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
	}
	
	// FoodModel => detail
	public static List<RecipeVO> foodRecipeMakeData(String type) {
		List<RecipeVO> list=null;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			list=session.selectList("foodRecipeMakeData",type);		
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return list;
	}
}




















