package com.sist.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.LikesVO;
import com.sist.vo.ShoesVO;

public class LikesDAO {

	private static SqlSessionFactory ssf;

    static {   
       try 
       {
         Reader reader=Resources.getResourceAsReader("Config.xml");
         ssf=new SqlSessionFactoryBuilder().build(reader);
       } catch(Exception ex) {
         ex.printStackTrace();
       }
    }
	
    ///////////////////////////// 기본
	
	/*
	 *<!-- 좋아요 테이블에 추가 -->
	<insert id="likesInsert" parameterType="LikesVO"> 
	 */
	public static void likesInsert(LikesVO vo)
	{
		SqlSession session = null;
		
		try
		{
			session = ssf.openSession(true); // => insert는 commit 필요
			session.insert("likesInsert", vo);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	/*
	 *<!-- 좋아요 수 확인 = 좋아요 여부 -->
	<select id="likesCount" resultType="int" parameterType="LikesVO">
	 */
	public static int likesCount(LikesVO vo)
	{
		int count = 0;
		SqlSession session = null;
		
		try
		{
			session = ssf.openSession();
			count = session.selectOne("likesCount", vo);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
		return count;
	}
	
	/*
	 * <!-- 마이페이지 좋아요 목록 출력 --> 상품의 모든 데이터 가져 옴 => ShoesVO 사용
	1. <select id="likesListData" resultType="LikesVO" parameterType="int">
	 */
	public static ShoesVO likesListData(int goods_id)
	{
		SqlSession session = null;
		ShoesVO vo = null;
		
		try
		{
			session = ssf.openSession();
			vo = session.selectOne("likesListData", goods_id);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
		return vo;
	}
	
	// 2. <select id="likesGetGoodsId" resultType="int" parameterType="String">
	public static List<Integer> likesGetGoodsId(String email)
	{
		List<Integer> list = null;
		SqlSession session = null;
		
		try
		{
			session = ssf.openSession();
			list = session.selectList("likesGetGoodsId", email);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	
	/*
	 * <!-- 좋아요 취소 -->
	<delete id="likesDelete" parameterType="LikesVO">
	 */
	public static void likesDelete(LikesVO vo)
	{
		SqlSession session = null;
		
		try
		{
			session = ssf.openSession(true);
			session.delete("likesDelete", vo);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
	}
	
}
