package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.*;
import com.sist.vo.*;

/*
 * 	1. VO : 데이터 모아서 전송
 * 	2. mapper : SQL 문장
 * 	3. DAO : 실제 오라클 연결 ==> SQL 문장 전송, 결과값 읽기
 * 	4. Model : JSP로 요청 결과값 전송
 * 	5. JSP : Model에서 보내준 데이터 출력
 */

@Controller
public class BoardReplyModel {
	@RequestMapping("board_reply/list.do")
	public String board_reply_list(HttpServletRequest request, HttpServletResponse response) {
		String page=request.getParameter("page");
		// 사용자가 전송한 데이터는 request 안에 첨부되어 있다
		if (page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map= new HashMap();
		int rowSize=10;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		map.put("start", start);
		map.put("end", end);
		List<BoardReplyVO> list=BoardReplyDAO.boardReplyListData(map);
		
		int totalpage=BoardReplyDAO.boardReplyTotalPage();
		
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("main_jsp", "../board_reply/list.jsp");
		
		return "../main/main.jsp";
	}
	
	@RequestMapping("board_reply/insert.do")
	public String board_reply_insert(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("main_jsp", "../board_reply/insert.jsp");
		
		return "../main/main.jsp";
	}
	
	@RequestMapping("board_reply/insert_ok.do")
	public String board_reply_insert_ok(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch(Exception ex) {}
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		String pwd=request.getParameter("pwd");
		
		BoardReplyVO vo=new BoardReplyVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		
		// vo ==> DAO로 전송
		BoardReplyDAO.boardReplyInsert(vo);
		
		return "redirect:../board_reply/list.do";	// insert_ok, update_ok, delete_ok 데이터 전송x 처리 후 이전에 실행된 화면으로 이동(list, detail)
	}
	
	@RequestMapping("board_reply/detail.do")
	public String board_reply_detail(HttpServletRequest request, HttpServletResponse response) {
		
		String no=request.getParameter("no");
		BoardReplyVO vo=BoardReplyDAO.boardReplyDetailData(Integer.parseInt(no));
		
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../board_reply/detail.jsp");
		
		return "../main/main.jsp";
	}
	
	@RequestMapping("board_reply/update.do")
	public String board_reply_update(HttpServletRequest request, HttpServletResponse response) {
		
		String no=request.getParameter("no");
		BoardReplyVO vo=BoardReplyDAO.boardReplyUpdateData(Integer.parseInt(no));
		
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../board_reply/update.jsp");
		
		return "../main/main.jsp";
	}
	
	@RequestMapping("board_reply/update_ok.do")
	public String board_reply_update_ok(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch(Exception ex) {}
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		String pwd=request.getParameter("pwd");
		String no=request.getParameter("no");
		
		BoardReplyVO vo=new BoardReplyVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		vo.setNo(Integer.parseInt(no));
		
		// DAO 연동
		BoardReplyDAO.boardReplyUpdate(vo);	
		
		return "redirect:../board_reply/detail.do?no="+vo.getNo();
	}
	
	@RequestMapping("board_reply/delete.do")
	public String board_reply_delete(HttpServletRequest request, HttpServletResponse response) {
		String no=request.getParameter("no");
		
		BoardReplyDAO.boardReplyDelete(Integer.parseInt(no));
		
		return "redirect:../board_reply/list.do";
	}
}










