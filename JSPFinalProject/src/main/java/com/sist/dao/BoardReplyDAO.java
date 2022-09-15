package com.sist.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.util.*;
import com.sist.vo.*;

/*
 * 	DAO => DAO+mapper+VO 데이터베이스 연결
 * 	Model => VO+DAO 호출 (요청값 전송) ==> JSP
 */

public class BoardReplyDAO {
	private static SqlSessionFactory ssf;
	static {
		try {
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static List<BoardReplyVO> boardReplyListData(Map map) {
		SqlSession session=null;
		List<BoardReplyVO> list=null;
		try {
			session=ssf.openSession();
			list=session.selectList("boardReplyListData",map);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session!=null)
				session.close();
		}
		
		return list;
	}
	
	public static void boardReplyInsert(BoardReplyVO vo) {
		SqlSession session=null;
		try {
			session=ssf.openSession(true);	// getConnection() : 미리 생성된 Connection 주소 읽기
			// autocommit, 트랜잭션 => .commit
			session.insert("boardReplyInsert",vo);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session!=null)
				session.close();	// disConnection(), ps.close(),conn.close() : 반환
		}
	}
	
	public static int boardReplyTotalPage() {
		SqlSession session=null;
		int total=0;
		try {
			session=ssf.openSession();
			total=session.selectOne("boardReplyTotalPage");
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return total;
	}
	
	public static List<BoardReplyVO> boardReplyAdminData() {
		List<BoardReplyVO> list=null;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			list=session.selectList("boardReplyAdminData");
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	
	public static BoardReplyVO boardReplyDetailData(int no) {
		BoardReplyVO vo=null;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			session.update("boardReplyHitIncrement",no);
			session.commit();
			vo=session.selectOne("boardReplyDetailData", no);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return vo;
	}
	
	public static void boardReplyInsertOk(int pno, BoardReplyVO vo) {
		SqlSession session=null;
		try {
			session=ssf.openSession();
			int gi=session.selectOne("boardReplyInfoData", pno);
			vo.setGroup_id(gi);
			session.insert("boardReplyInsertOk",vo);
			session.update("boardReplyIsReply",pno);
			session.commit();
		} catch(Exception ex) {
			session.rollback();
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
	}
	
	public static BoardReplyVO boardReplyUpdateData(int no) {
		BoardReplyVO vo=null;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			vo=session.selectOne("boardReplyDetailData", no);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return vo;
	}
	
	public static void boardReplyUpdate(BoardReplyVO vo) {
		SqlSession session=null;
		try {
			session=ssf.openSession(true);
			session.update("boardReplyUpdate",vo);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
	}

	public static void boardReplyDelete(int no) {
		SqlSession session=null;
		try {
			session=ssf.openSession(true);
			int gi=session.selectOne("boardGetGroupId",no);
			session.delete("boardReplyDelete",gi);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
	}
	
	
}












