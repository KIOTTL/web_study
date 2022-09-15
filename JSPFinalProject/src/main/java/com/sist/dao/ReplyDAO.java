package com.sist.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.util.*;
import com.sist.vo.*;

public class ReplyDAO {
	private static SqlSessionFactory ssf;
	static {
		try {
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// <select id="replyListData" resultType="ReplyVO" parameterType="ReplyVO">
	public static List<ReplyVO> replyListData(ReplyVO vo) {
		List<ReplyVO> list = null;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			list=session.selectList("replyListData", vo);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	
	public static void replyInsert(ReplyVO vo) {
		SqlSession session=null;
		try {
			session=ssf.openSession(true);
			session.update("countIncrement",vo);
			session.insert("replyInsert",vo);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
	}
	
	/*
	 * <delete id="replyDelete" parameterType="int">
		  DELETE FROM project_reply
		  WHERE no=#{no}
		</delete>
	 */
	public static void replyDelete(int no) {
		SqlSession session=null;
		try {
			session=ssf.openSession(true);
			session.delete("replyDelete",no);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
	}
	
	/*
	 * <update id="replyUpdate" parameterType="ReplyVO">
		  UPDATE project_reply SET
		  msg=#{msg}
		  WHERE no=#{no}
		</update>
	 */
	public static void replyUpdate(ReplyVO vo) {
		SqlSession session=null;
		try {
			session=ssf.openSession(true);
			session.delete("replyUpdate",vo);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
	}
}























