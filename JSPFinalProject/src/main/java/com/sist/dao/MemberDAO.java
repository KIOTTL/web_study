package com.sist.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.MemberVO;

public class MemberDAO {
	private static SqlSessionFactory ssf;
	static {
		try {
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// 아이디 중복 체크
	public static int memberIdCheck(String id) {
		int count=0;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			count=session.selectOne("memberIdCheck",id);
		} catch(Exception ex) {
			
		} finally {
			if (session!=null)
				session.close();
		}
		
		return count;
	}
	
	// 이메일 중복 체크
	public static int memberEmailCheck(String email) {
		int count=0;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			count=session.selectOne("memberEmailCheck",email);
		} catch(Exception ex) {
			
		} finally {
			if (session!=null)
				session.close();
		}
		
		return count;
	}
	
	// 전화번호 중복 체크
	public static int memberTelCheck(String tel) {
		int count=0;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			count=session.selectOne("memberTelCheck",tel);
		} catch(Exception ex) {
			
		} finally {
			if (session!=null)
				session.close();
		}
		
		return count;
	}
	
	/*
	 *  ID       NOT NULL VARCHAR2(20)  
		PWD      NOT NULL VARCHAR2(10)  
		NAME     NOT NULL VARCHAR2(34)  
		SEX               VARCHAR2(10)  
		BIRTHDAY NOT NULL VARCHAR2(30)  
		EMAIL             VARCHAR2(100) 
		POST     NOT NULL VARCHAR2(20)  
		ADDR1    NOT NULL VARCHAR2(200) 
		ADDR2             VARCHAR2(200) 
		TEL               VARCHAR2(30)  
		CONTENT           CLOB          
		ADMIN             CHAR(1)       
		LOGIN             CHAR(1)    
	 */
	// 회원가입
	// <insert id="memberInsert" parameterType="MemberVO">
	public static void memberInsert(MemberVO vo) {
		SqlSession session=null;
		try {
			session=ssf.openSession(true);	// autocommit
			session.insert("memberInsert",vo);
		} catch(Exception ex) {
			System.out.println("memberInsert error:");
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
	}
	
	/*
	 * <!-- id 존재여부 확인 (0 => 없음, 1 => 있음) -->
		<select id="memberIdCount" resultType="int" parameterType="string">
		  SELECT COUNT(*)
		  FROM project_member
		  WHERE id=#{id}
		</select>
		<!-- 비밀번호 읽기 -->
		<select id="memberInfoData" resultType="MemberVO" parameterType="string">
		  SELECT pwd, id, name, admin
		  FROM project_member
		  WHERE id=#{id}
		</select>
	 */
	public static MemberVO isLogin(String id, String pwd) {
		MemberVO vo=new MemberVO();
		SqlSession session=null;
		
		try {
			session=ssf.openSession();
			int count=session.selectOne("memberIdCount",id);
			
			if(count==0) {
				vo.setMsg("NOID");
			} else {
				vo=session.selectOne("memberInfoData",id);
				if(pwd.equals(vo.getPwd())) {	// 로그인 성공
					vo.setMsg("OK");
				} else {	// 비밀번호 틀린 경우
					vo.setMsg("NOPWD");
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}
		
		return vo;
	}
	
	public static MemberVO memberDetailData(String id) {
		MemberVO vo=new MemberVO();
		SqlSession session=null;
		try {
			session=ssf.openSession();	
			vo=session.selectOne("memberDetailData",id);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session!=null)
				session.close();
		}
		
		return vo;
	}
	
	
	public static boolean memberUpdate(MemberVO vo) {
		boolean bCheck=false;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			MemberVO pvo=session.selectOne("memberInfoData", vo.getId());
			if (pvo.getPwd().equals(vo.getPwd())) {
				bCheck=true;
				session.update("memberUpdate",vo);
				session.commit();
			} else {
				bCheck=false;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session!=null)
				session.close();
		}
		
		return bCheck;
	}
	
	public static boolean memberDelete(String id, String pwd) {
		boolean bCheck=false;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			MemberVO pvo=session.selectOne("memberInfoData", id);
			if (pvo.getPwd().equals(pwd)) {
				bCheck=true;
				session.delete("memberDelete",id);
				session.commit();
			} else {
				bCheck=false;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session!=null)
				session.close();
		}
		
		return bCheck;
	}
}
























