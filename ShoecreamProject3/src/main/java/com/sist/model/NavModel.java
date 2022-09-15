package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.NavDAO;
import com.sist.vo.ShoesVO;
import com.sist.vo.StyleVO;

@Controller
public class NavModel {
	@RequestMapping("nav/nav_new.do")
	public String nav_new(HttpServletRequest request, HttpServletResponse response) {
		
		List<ShoesVO> list = NavDAO.navNewList();
		request.setAttribute("list", list);
		request.setAttribute("main_jsp", "../nav/nav_new.jsp");
		
		return "../main/main.jsp";	
	}
	
	@RequestMapping("nav/nav_men.do")
	public String nav_men(HttpServletRequest request, HttpServletResponse response) {
		
		List<ShoesVO> list = NavDAO.navMenList();
		request.setAttribute("list", list);
		request.setAttribute("main_jsp", "../nav/nav_men.jsp");
		
		return "../main/main.jsp";	
	}
	
	@RequestMapping("nav/nav_women.do")
	public String nav_women(HttpServletRequest request, HttpServletResponse response) {
		
		List<ShoesVO> list = NavDAO.navWomenList();
		request.setAttribute("list", list);
		request.setAttribute("main_jsp", "../nav/nav_women.jsp");
		
		return "../main/main.jsp";	
	}
	
	@RequestMapping("nav/nav_kids.do")
	public String nav_kids(HttpServletRequest request, HttpServletResponse response) {
		
		List<ShoesVO> list = NavDAO.navKidsList();
		request.setAttribute("list", list);
		request.setAttribute("main_jsp", "../nav/nav_kids.jsp");
		
		return "../main/main.jsp";	
	}
	
	@RequestMapping("nav/nav_style.do")
	public String nav_style(HttpServletRequest request, HttpServletResponse response) {
		
		List<StyleVO> list = NavDAO.navStyleList();
		request.setAttribute("list", list);
		request.setAttribute("main_jsp", "../nav/nav_style.jsp");
		
		return "../main/main.jsp";	
	}
	
	@RequestMapping("nav/nav_brand.do")
	public String nav_brand(HttpServletRequest request, HttpServletResponse response) {
		
		List<ShoesVO> list = NavDAO.navBrandList();
		request.setAttribute("list", list);
		request.setAttribute("main_jsp", "../nav/nav_brand.jsp");
		
		return "../main/main.jsp";	
	}
	
	@RequestMapping("nav/nav_calendar.do")
	public String nav_calendar(HttpServletRequest request, HttpServletResponse response) {
		
		List<ShoesVO> list = NavDAO.navCalendarList();
		request.setAttribute("list", list);
		request.setAttribute("main_jsp", "../nav/nav_calendar.jsp");
		
		return "../main/main.jsp";	
	}
}
