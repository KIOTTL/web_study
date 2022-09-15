package com.sist.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.FoodVO;
import com.sist.vo.ReserveVO;

public class ReserveDAO {
	private static SqlSessionFactory ssf;
	static {
		try {
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static List<FoodVO> reserveFoodData(String type) {
		List<FoodVO> list=null;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			list=session.selectList("reserveFoodData",type);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	
	// 예약일 읽기
	public static String reserveGetDate(int fno) {
		String rday="";
		SqlSession session=null;
		try {
			session=ssf.openSession();
			rday=session.selectOne("reserveGetDate",fno);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return rday;
	}
	
	public static String reserveGetTime(int rno) {	// select time from reserve_day where rno=17;
		String rtime="";
		SqlSession session=null;
		try {
			session=ssf.openSession();
			rtime=session.selectOne("reserveGetTime",rno);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return rtime;
	}
	
	public static String reserveRealTime(int tno) {	// select time from reserve_time where tno=2;
		String rtime="";
		SqlSession session=null;
		try {
			session=ssf.openSession();
			rtime=session.selectOne("reserveRealTime",tno);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return rtime;
	}
	
	public static void reserveInsert(ReserveVO vo) {
		SqlSession session=null;
		try {
			session=ssf.openSession(true);	// autocommit
			session.insert("reserveInsert",vo);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session!=null)
				session.close();
		}
	}
	
	public static List<ReserveVO> reserveMypageData(String id) {
		List<ReserveVO> list=null;
		SqlSession session=null;
		try {
		   session=ssf.openSession();
		   list=session.selectList("reserveMypageData", id);
		} catch(Exception ex) {
		   ex.printStackTrace();
		} finally {
		   if(session!=null)
			   session.close();
		}
		
		return list;
	}
	
	public static List<ReserveVO> reserveAdminpageData() {
		List<ReserveVO> list=null;
		SqlSession session=null;
		try {
		   session=ssf.openSession();
		   list=session.selectList("reserveAdminpageData");
		} catch(Exception ex) {
		   ex.printStackTrace();
		} finally {
		   if(session!=null)
			   session.close();
		}
		
		return list;
	}
	
	public static void reserveAdminUpdate(int no) {
		SqlSession session=null;
		try {
		   session=ssf.openSession(true);
		   session.update("reserveAdminUpdate",no);
		} catch(Exception ex) {
		   ex.printStackTrace();
		} finally {
		   if(session!=null)
			   session.close();
		}
	}
	
	public static void reserveCancel(int no) {
		SqlSession session=null;
		try {
			session=ssf.openSession(true);
			session.delete("reserveCancel",no);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
	}
	
	public static ReserveVO reserveInfoData(int no) {
		ReserveVO vo=new ReserveVO();
		SqlSession session=null;
		try {
			session=ssf.openSession();
			vo=session.selectOne("reserveInfoData",no);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return vo;
	}
	
}




















