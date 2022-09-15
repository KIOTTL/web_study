package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.BoardReplyDAO;
import com.sist.vo.*;

@Controller
public class AdminPageModel {
	   @RequestMapping("adminpage/adminpage.do")
	   public String adminpage_main(HttpServletRequest request,HttpServletResponse response)
	   {
		   // admin home 예약, 구매 내역
		   request.setAttribute("admin_jsp", "../adminpage/adminhome.jsp");
		   
		   request.setAttribute("main_jsp", "../adminpage/adminpage.jsp");
		   
		   return "../main/main.jsp";
	   }
	   
	   @RequestMapping("adminpage/reply.do")
	   public String adminpage_reply(HttpServletRequest request, HttpServletResponse response) {
		   
		   // admin 답변 달기
		   List<BoardReplyVO> list=BoardReplyDAO.boardReplyAdminData();
		   request.setAttribute("list", list);
		   
		   request.setAttribute("admin_jsp", "../adminpage/reply.jsp");
		   request.setAttribute("main_jsp", "../adminpage/adminpage.jsp");
		   
		   return "../main/main.jsp";
	   }
	   
	   @RequestMapping("adminpage/detail.do")
	   public String admingpage_detail(HttpServletRequest request, HttpServletResponse response) {
		   // detail
		   String no=request.getParameter("no");
		   BoardReplyVO vo=BoardReplyDAO.boardReplyDetailData(Integer.parseInt(no));
		   request.setAttribute("vo", vo);
		   
		   request.setAttribute("admin_jsp", "../adminpage/detail.jsp");
		   request.setAttribute("main_jsp", "../adminpage/adminpage.jsp");
		   
		   return "../main/main.jsp";
	   }
	   
	   // 답변
	   @RequestMapping("adminpage/reply_insert.do")
	   public String adminpage_reply_insert(HttpServletRequest request, HttpServletResponse response) {
		   String no=request.getParameter("no");
		   request.setAttribute("no", no);
		   
		   request.setAttribute("admin_jsp", "../adminpage/reply_insert.jsp");
		   request.setAttribute("main_jsp", "../adminpage/adminpage.jsp");
		   
		   return "../main/main.jsp";
	   }
	   
	   // 답변 오라클에 추가
	   @RequestMapping("adminpage/reply_insert_ok.do")
	   public String adminpage_reply_insert_ok(HttpServletRequest request, HttpServletResponse response) {
		   try {
			   request.setCharacterEncoding("UTF-8");
		   } catch(Exception ex) {}
		   
		   String name=request.getParameter("name");
		   String subject=request.getParameter("subject");
		   String content=request.getParameter("content");
		   String pwd=request.getParameter("pwd");
		   String pno=request.getParameter("pno");
		   
		   BoardReplyVO vo=new BoardReplyVO();
		   vo.setName(name);
		   vo.setContent(content);
		   vo.setPwd(pwd);
		   vo.setSubject(subject);
		   
		   BoardReplyDAO.boardReplyInsertOk(Integer.parseInt(pno),vo);
		   
		   return "redirect: ../adminpage/reply.do";	// 목록
	   }
}