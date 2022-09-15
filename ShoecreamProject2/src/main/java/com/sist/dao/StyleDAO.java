package com.sist.dao;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.MemberVO;
import com.sist.vo.StyleLikesVO;
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
	
	public static List<StyleVO> styleListData(Map map) {
		List<StyleVO> list = null;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			list=session.selectList("styleListData", map);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	
	public static List<StyleVO> styleListDataPop(Map map) {
		List<StyleVO> list = null;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			list=session.selectList("styleListDataPop", map);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	
	public static int styleTotalPage(Map map) {
		int total=0;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			total=session.selectOne("styleTotalPage", map);
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
	
	public static StyleVO styleDetailData(int id) {	// rs.next()
		SqlSession session=null;
		StyleVO vo=null;
		try {
			session=ssf.openSession();
			vo=session.selectOne("styleDetailData", id);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		
		return vo;		
	}
	
	public static List<StyleVO> styleTagData(String tag) {
		
		SqlSession session=null;
		List<StyleVO> list=null;
		try {
			session=ssf.openSession();
			list=session.selectList("styleTagData", tag);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return list;
		
	}
	
//	public static List<MemberVO> styleGetEmail(int user_id) {
//		List<MemberVO> list=null;
//		SqlSession session=null;
//		try {
//			session=ssf.openSession();
//			list=session.selectList("styleGetEmail",user_id);
//		} catch(Exception ex) {
//			ex.printStackTrace();
//		} finally {
//			if(session!=null)
//				session.close();
//		}
//		
//		return list;
//	}
	public static MemberVO styleGetEmail(String user_id) {
		MemberVO vo=null;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			vo=session.selectOne("styleGetEmail",user_id);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return vo;
	}
	
	public static int styleGetUserId(String email) {
		SqlSession session=null;
		int user_id=0;
		try {
			session=ssf.openSession();
			user_id=session.selectOne("styleGetUserId",email);
		} catch(Exception ex) {
			if(session!=null)
				session.close();
		}
		
		return user_id;
	}
	
	public static void styleLikesInsert(StyleLikesVO vo) {
		SqlSession session=null;
		try {
			session=ssf.openSession(true);
			session.insert("styleLikesInsert",vo);
			session.update("likesIncrement",vo);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
	}
	
	public static int styleLikesCount(StyleLikesVO vo) {
		int count=0;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			count=session.selectOne("styleLikesCount",vo);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return count;
	}
	
	public static void styleLikesDelete(StyleLikesVO vo) {
		SqlSession session=null;
		try {
			session=ssf.openSession(true);
			session.delete("styleLikesDelete",vo);
			session.update("likesDecrement",vo);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
	}
	
//	public static int styleGetSid() {
//		SqlSession session=null;
//		int sid=0;
//		try {
//			session=ssf.openSession(true);
//			session.selectOne("styleGetSid");
//		} catch(Exception ex) {
//			ex.printStackTrace();
//		} finally {
//			if(session!=null)
//				session.close();
//		}
//		
//		return sid;
//	}
	
	public static StyleVO styleUpdateData(int id) {
		StyleVO vo=new StyleVO();
		SqlSession session=null;
		try {
			session=ssf.openSession();
			vo=session.selectOne("styleDetailData",id);
		} catch(Exception ex) {
			System.out.println("styleUpdateData error : ");
			ex.printStackTrace();
		} finally {
			if (session!=null)
				session.close();
		}
		
		return vo;
	}
	
	public static void styleUpdate(StyleVO vo) {
		SqlSession session=null;
		try {
			session=ssf.openSession(true);	// true 없으면 commit(x) => autocommit false
			session.update("styleUpdate",vo);
//			session.commit(); // true 안 적었을 경우
		} catch(Exception ex) {
			System.out.println("styleUpdate error : ");
			ex.printStackTrace();
		} finally {
			if (session!=null)
				session.close();
		
		}
	}
	
	public static void styleDelete(int id) {
		SqlSession session=null;
		try {
			session=ssf.openSession();
			session.delete("styleDelete",id);
			session.commit();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
	}
	
	public static List<StyleVO> mypageStyle(Map map){
		SqlSession session=null;
		List<StyleVO> list=null;
		try {
			session=ssf.openSession();
			list=session.selectList("mypageStyle",map);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		return list;
	}
	
	public static int mypageStyleTotalPage(Map map) {
		int total=0;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			total=session.selectOne("mypageStyleTotalPage", map);
		} catch(Exception ex) {
			System.out.println("mypageStyleTotalPage error : ");
			ex.printStackTrace();
		} finally {
			if (session!=null)
				session.close();
		}
		
		return total;
	}
	
	 
	 public static List<StyleVO> mypageStyleLikes(int user_id){
		 SqlSession session=null;
		 List<StyleVO> list=null;
		 try {
			 session=ssf.openSession();
			 list=session.selectList("mypageStyleLikes",user_id);
		 } catch(Exception ex) {
			 ex.printStackTrace();
		 } finally {
			 if(session!=null)
				 session.close();
		 }
		 return list;
	 }
		
	 
}
