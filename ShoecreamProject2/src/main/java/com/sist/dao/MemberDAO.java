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
		
		public static MemberVO isLogin(String email, String pwd) {
			MemberVO vo=new MemberVO();
			SqlSession session=null;
			
			try {
				session=ssf.openSession();
				int count=session.selectOne("memberEmailCount",email);
				
				if(count==0) {
					vo.setMsg("NOID");
				} else {
					vo=session.selectOne("memberInfoData",email);
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
}
