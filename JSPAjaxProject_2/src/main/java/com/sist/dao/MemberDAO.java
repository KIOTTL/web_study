package com.sist.dao;

import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;

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
	
	public static String emailIdFind(String name, String email) {
		String result="";
		SqlSession session=ssf.openSession();
		int count=session.selectOne("memberNameCount", name);	// 이름 존재여부 => 0 존재x , 0이상 존재
		if(count==0) {
			result="존재하지 않는 이름입니다";
		} else {
			String db_email=session.selectOne("memberGetEmail", name);
			if(db_email.equals(email)) {
				Map map=new HashMap();
				map.put("name", name);
				map.put("email", email);
				result=session.selectOne("emailIdFind",map);
			} else {
				result="이메일이 틀립니다";
			}
		}
		
		return result;
	}
	
	public static String telIdFind(String name, String tel) {
		String result="";
		SqlSession session=ssf.openSession();
		int count=session.selectOne("memberNameCount", name);
		if(count==0) {
			result="존재하지 않는 이름입니다";	
		} else {
			String db_tel=session.selectOne("memberGetTel",name);
			if(db_tel.equals(tel)) {
				Map map=new HashMap();
				map.put("name", name);
				map.put("tel", tel);
				result=session.selectOne("telIdFind",map);
			} else {
				result="전화번호가 틀립니다";
			}
		}
		
		return result;
	}
}















