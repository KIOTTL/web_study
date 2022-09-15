package com.sist.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.ShoesDAO;
import com.sist.vo.ShoesVO;

@Controller
public class ShoesModel {
	
	@RequestMapping("shoes/shoes_list.do")
	public String shoes_list(HttpServletRequest request, HttpServletResponse response) {

		String brand=request.getParameter("brand");
		List<ShoesVO> list=ShoesDAO.shoesBrandListData(brand);
		request.setAttribute("list", list);
		request.setAttribute("main_jsp", "../shoes/shoes_list.jsp");
		
		return "../main/main.jsp";	// forward
	}
	
	@RequestMapping("shoes/shoes_detail_before.do")
	public String shoes_detail_before(HttpServletRequest request, HttpServletResponse response) {
		
		String goods_id=request.getParameter("goods_id");
		Cookie cookie=new Cookie("shoes"+goods_id, goods_id);
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		
		return "redirect:../shoes/shoes_detail.do?goods_id="+goods_id;	
	}
	
	@RequestMapping("shoes/shoes_detail.do")
	public String food_detail(HttpServletRequest request, HttpServletResponse response) {
		String goods_id=request.getParameter("goods_id");

		ShoesVO vo=ShoesDAO.shoesDetailData(Integer.parseInt(goods_id));
		
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../shoes/shoes_detail.jsp");
		
		return "../main/main.jsp";
	}
	
	@RequestMapping("main/search.do")
	public String shoesFind(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch(Exception ex) {}
		
		String fd=request.getParameter("fd");
//		if(fd==null) {
//			fd="NIKE";
//		}
		if(fd.trim()=="")
		{
			fd="NIKE";
		} 
		System.out.println("fd="+fd);

	    String page = request.getParameter("page");
		if(page == null) {
			page = "1";
		}
		int curpage = Integer.parseInt(page);
		Map map = new HashMap();
		int rowSize = 12;
		int start = (rowSize*curpage)-(rowSize-1); //rownum
		int end = (rowSize*curpage);
		
		map.put("start", start); // #{start}
		map.put("end", end);
		map.put("brand", fd);
		map.put("name_eng", fd);
		map.put("name_kor", fd);
		List<ShoesVO> list=ShoesDAO.shoesFindData(map);
		int totalpage = ShoesDAO.findTotalPage(map);
		
		final int BLOCK = 5;
		int startPage = ((curpage-1)/BLOCK*BLOCK) + 1;
		// [1] [2] [3] [4] [5]  => start = 1, 6, ... / end = 5, 10, ...
		int endPage = ((curpage-1)/BLOCK*BLOCK) + BLOCK;
		if(endPage>totalpage) {
			endPage = totalpage;
		}
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("list", list);
		request.setAttribute("fd", fd);
		request.setAttribute("main_jsp", "../main/search.jsp");
		
		return "../main/main.jsp";
	}
	

	
}
