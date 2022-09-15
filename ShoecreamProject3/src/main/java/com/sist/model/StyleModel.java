package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.StyleDAO;
import com.sist.vo.StyleVO;

@Controller
public class StyleModel {
	@RequestMapping("nav/nav_style.do")
	public String style_list(HttpServletRequest request, HttpServletResponse response) {
		List<StyleVO> list=StyleDAO.styleListData();

		request.setAttribute("list", list);
		request.setAttribute("main_jsp", "../nav/nav_style.jsp");
		
		
		return "../main/main.jsp";
	}
	
	@RequestMapping("style/insert.do")
	public String style_insert(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("main_jsp", "../style/insert.jsp");
		
		return "../main/main.jsp";
	}
	
	@RequestMapping("style/insert_ok.do")
	public String style_insert_ok(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch(Exception ex) {}
		
		String content=request.getParameter("content");
		String img=request.getParameter("img");
		
		 
		StyleVO vo=new StyleVO();
		vo.setContent(content);
		vo.setImg("../style/image/"+img);
		System.out.println("img="+img);
		
		StyleDAO.styleInsert(vo);
		
		return "redirect:../nav/nav_style.do";
	}
}











