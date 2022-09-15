package com.sist.model;

import java.io.Reader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.MemberDAO;
import com.sist.dao.StyleDAO;
import com.sist.vo.MemberVO;

@Controller
public class MemberModel {
	// 이메일 중복체크
		@RequestMapping("account/email_check.do")
		public String member_email_check(HttpServletRequest request, HttpServletResponse response) {
			String email=request.getParameter("email");
			int count=MemberDAO.memberEmailCheck(email);
			request.setAttribute("count", count);
			
			return "../account/idcheck_ok.jsp";
		}
		
		// 전화번호 중복체크
		@RequestMapping("account/tel_check.do")
		public String member_tel_check(HttpServletRequest request, HttpServletResponse response) {
			String tel=request.getParameter("tel");
			int count=MemberDAO.memberTelCheck(tel);
			request.setAttribute("count", count);
			
			return "../account/idcheck_ok.jsp";
		}
		
		// 회원가입
		@RequestMapping("account/join.do")
		public String member_join(HttpServletRequest request, HttpServletResponse response) {
			request.setAttribute("main_jsp","../account/join.jsp");
			
			return "../main/main.jsp";
		}
		
		@RequestMapping("account/join_ok.do")
		public String member_join_ok(HttpServletRequest request, HttpServletResponse response) {
			// 사용자 전송값 받기
			try {
				request.setCharacterEncoding("UTF-8");
			} catch(Exception ex) {}
			
			String email=request.getParameter("email");
			String pwd=request.getParameter("pwd");
			String name=request.getParameter("name");
			String tel=request.getParameter("tel");
			System.out.println(", email="+email+", pwd="+pwd+", name="+name+", tel="+tel);
			
			// 데이터베이스 연결
			MemberVO vo=new MemberVO();
			vo.setEmail(email);
			vo.setPwd(pwd);
			vo.setName(name);
			vo.setTel(tel);
			
			
//			System.out.println("pwd="+pwd);
			
			// 요청처리
			MemberDAO.memberInsert(vo);
			
			// 화면이동
			return "redirect:../main/main.do";
			
		}
		
		// 로그인
		@RequestMapping("account/login.do")
		public String member_login(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("Login");
			
			return "../account/login.jsp";
		}
		
		// 로그인 처리
		@RequestMapping("account/login_ok.do")
		public String member_login_ok(HttpServletRequest request, HttpServletResponse response) {
			// 사용자가 보낸 요청값 받기
//			String id=request.getParameter("id");
//			System.out.println("id="+id);
			String email=request.getParameter("email");
			String pwd=request.getParameter("pwd");
			
			// DAO 연동 ==> mapper(SQL), dao(메서드 처리)
			MemberVO vo=MemberDAO.isLogin(email, pwd);
			String result=vo.getMsg();
			System.out.println("result="+result);
			System.out.println("email="+email);
			int user_id=StyleDAO.styleGetUserId(email);
			System.out.println("user_id="+user_id);
			
			if(result.equals("OK")) {
				HttpSession session=request.getSession();
				session.setAttribute("user_id", user_id);
//				System.out.println("login(user_id)="+user_id);
				session.setAttribute("email", vo.getEmail());
				session.setAttribute("name", vo.getName());
				System.out.println("getemail="+vo.getEmail());
				System.out.println("getid="+session.getId());
			} 
			request.setAttribute("result", result);		
			
			
			return "../account/login_ok.jsp";	// NOID, NOPWD, OK
		}
		
		@RequestMapping("account/logout.do")
		public String member_logout(HttpServletRequest request, HttpServletResponse response) {
			HttpSession session=request.getSession();
			System.out.println(session.getId());
			session.invalidate();	// 저장된 모든 데이터 지우기
			
			return "redirect:../main/main.do";
		}
}
