package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;

@Controller
public class MemberModel {
	
	// 아이디 중복체크
	@RequestMapping("member/idcheck.do")
	public String member_idcheck(HttpServletRequest request, HttpServletResponse response) {
		
		
		return "../member/idcheck.jsp";
	}
	@RequestMapping("member/idcheck_ok.do")
	public String member_idcheck_ok(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		int count=MemberDAO.memberIdCheck(id);
		request.setAttribute("count", count);
		
		return "../member/idcheck_ok.jsp";
	}
	
	// 이메일 중복체크
	@RequestMapping("member/email_check.do")
	public String member_email_check(HttpServletRequest request, HttpServletResponse response) {
		String email=request.getParameter("email");
		int count=MemberDAO.memberEmailCheck(email);
		request.setAttribute("count", count);
		
		return "../member/idcheck_ok.jsp";
	}
	
	// 전화번호 중복체크
	@RequestMapping("member/tel_check.do")
	public String member_tel_check(HttpServletRequest request, HttpServletResponse response) {
		String tel=request.getParameter("tel");
		int count=MemberDAO.memberTelCheck(tel);
		request.setAttribute("count", count);
		
		return "../member/idcheck_ok.jsp";
	}
	
	// 로그인
	@RequestMapping("member/login.do")
	public String member_login(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Login");
		
		return "../member/login.jsp";
	}
	
	@RequestMapping("member/join.do")
	public String member_join(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("main_jsp","../member/join.jsp");
		
		return "../main/main.jsp";
	}
	
	@RequestMapping("member/join_ok.do")
	public String member_join_ok(HttpServletRequest request, HttpServletResponse response) {
		// 사용자 전송값 받기
		try {
			request.setCharacterEncoding("UTF-8");
		} catch(Exception ex) {}
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String birthday=request.getParameter("birthday");
		String email=request.getParameter("email");
		String post=request.getParameter("post");
		String addr1=request.getParameter("addr1");
		String addr2=request.getParameter("addr2");
		String tel1=request.getParameter("tel1");
		String tel2=request.getParameter("tel2");
		String content=request.getParameter("content");
		
		// 데이터베이스 연결
		MemberVO vo=new MemberVO();
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setName(name);
		vo.setSex(sex);
		vo.setBirthday(birthday);
		vo.setEmail(email);
		vo.setPost(post);
		vo.setAddr1(addr1);
		vo.setAddr2(addr2);
		vo.setTel(tel1+"-"+tel2);
		vo.setContent(content);
		System.out.println(vo.getTel2());
		System.out.println(vo.getTel1());
		
//		System.out.println("pwd="+pwd);
		
		// 요청처리
		MemberDAO.memberInsert(vo);
		
		// 화면이동
		return "redirect:../main/main.do";
		
	}
	
	// 로그인 처리
	@RequestMapping("member/login_ok.do")
	public String member_login_ok(HttpServletRequest request, HttpServletResponse response) {
		// 사용자가 보낸 요청값 받기
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		// DAO 연동 ==> mapper(SQL), dao(메서드 처리)
		MemberVO vo=MemberDAO.isLogin(id, pwd);
		String result=vo.getMsg();
		if(result.equals("OK")) {
			HttpSession session=request.getSession();
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
			session.setAttribute("admin", vo.getAdmin());
		}
		request.setAttribute("result", result);		
		
		return "../member/login_ok.jsp";	// NOID, NOPWD, OK
	}
	
	@RequestMapping("member/logout.do")
	public String member_logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		session.invalidate();	// 저장된 모든 데이터 지우기
		
		return "redirect:../main/main.do";
	}
	
}


























