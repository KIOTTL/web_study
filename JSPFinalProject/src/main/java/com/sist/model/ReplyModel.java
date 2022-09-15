package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.ReplyDAO;
import com.sist.vo.ReplyVO;

@Controller
public class ReplyModel {
	
	@RequestMapping("reply/reply_insert.do")
	public String reply_insert(HttpServletRequest request, HttpServletResponse response) {
		// bno, type, msg ==> id, name
		try {
			request.setCharacterEncoding("UTF-8");
		} catch(Exception ex) {}
			
		String bno=request.getParameter("bno");	// 게시물 번호
		String type=request.getParameter("type"); // 카테고리
		String msg=request.getParameter("msg");
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		String name=(String)session.getAttribute("name");
		
		ReplyVO vo=new ReplyVO();
		vo.setBno(Integer.parseInt(bno));
		vo.setId(id);
		vo.setName(name);
		vo.setMsg(msg);
		vo.setType(Integer.parseInt(type));
		
		// update (countIncrement)
		String[] temp= {"","project_freeboard","seoul_location","seoul_nature","seoul_shop"};
		String table=temp[Integer.parseInt(type)];
		vo.setTable_name(table);
		
		
		// FreeBoardModel (freeboard_detail)
		// DAO => 오라클 전송 
		ReplyDAO.replyInsert(vo);
		
		return "redirect:../freeboard/detail.do?no="+bno;
	}
	
	// 댓글 삭제
	@RequestMapping("reply/reply_delete.do")
	public String reply_delete(HttpServletRequest request, HttpServletResponse response) {
		String bno=request.getParameter("bno");	// 게시물 번호 => detail로 이동시
		String no=request.getParameter("no"); // 댓글 번호 => delete시 사용
		
		// 삭제 => DAO
		ReplyDAO.replyDelete(Integer.parseInt(no));
		
		return "redirect:../freeboard/detail.do?no="+bno;	// .do는 데이터 넘어가지 x
	}
	
	// 댓글 수정
	@RequestMapping("reply/reply_update.do")
	public String reply_update(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch(Exception ex) {}
		String bno=request.getParameter("bno");	// 게시물 번호 => detail로 이동시
		String no=request.getParameter("no"); // 댓글 번호 => delete시 사용
		String msg=request.getParameter("msg");
		
		// DAO연동
		ReplyVO vo=new ReplyVO();
		vo.setNo(Integer.parseInt(no));
		vo.setMsg(msg);
		ReplyDAO.replyUpdate(vo);
		
		return "redirect:../freeboard/detail.do?no="+bno;
		
	}
}













