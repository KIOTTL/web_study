package com.sist.model;

import java.util.List;

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
	

	
}
