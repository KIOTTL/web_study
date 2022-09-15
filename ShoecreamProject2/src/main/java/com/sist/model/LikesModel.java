package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;

@Controller
public class LikesModel {

//	@RequestMapping("nav/likes.do")
//	public String shoes_likes(HttpServletRequest request, HttpServletResponse response)
//	{
//		String page = request.getParameter("page");
//		
//		HttpSession session = request.getSession();
//		int user_id = (int)session.getAttribute(page);
//		
//		LikesVO vo = new LikesVO();
//		vo.setGoods_id(user_id);
//		vo.setUser_id(user_id);
//		
//		LikesDAO.likesInsert(vo);
//		
//		return "redirect:../nav/nav_men.do?page=" + page; // 수정 필요
//	}
	
	// 마이페이지에 좋아요 목록 출력
	@RequestMapping("mypage/mypage_list.do")
	public String likes_list(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id"); // 회원 이메일 속성 가져옴
		
		List<Integer> list = LikesDAO.likesGetGoodsId(user_id); // 회원이 좋아요한 게시물의 고유 번호
		List<ShoesVO> lList = new ArrayList<ShoesVO>(); // ShoesVO, 신발 데이터
		
		for(int goods_id: list)
		{
			ShoesVO vo = LikesDAO.likesListData(goods_id); // 회원의 좋아요한 게시글 고유 번호 가져옴
			lList.add(vo); // 좋아요한 게시글의 데이터를 lList에 저장
		}
		
		request.setAttribute("lList", lList); // 좋아요한 게시글의 모든 데이터(*)
		request.setAttribute("my_mypage_jsp", "../mypage/my_bookmark.jsp");
		request.setAttribute("main_jsp", "../mypage/my_mypage.jsp");
		
		return "../main/main.jsp";
	}
	
	// 좋아요 취소
	@RequestMapping("mypage/likes_cancel.do")
	public String likes_cancel(HttpServletRequest request, HttpServletResponse response)
	{
		String goods_id = request.getParameter("goods_id");
		
		HttpSession session = request.getSession();
		int user_id = (int)session.getAttribute("user_id");
		
		LikesVO vo = new LikesVO();
		vo.setUser_id(user_id);
		vo.setGoods_id(Integer.parseInt(goods_id));
		
		// DAO 연동
		LikesDAO.likesDelete(vo);
		
		return "redirect:../mypage/mypage_list.do";
	}
}
