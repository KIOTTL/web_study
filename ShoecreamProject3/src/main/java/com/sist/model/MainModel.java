package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.ShoesDAO;
import com.sist.vo.ShoesVO;

@Controller
public class MainModel {

	@RequestMapping("main/main.do")
	public String main_page(HttpServletRequest request, HttpServletResponse response) {
 
		List<ShoesVO> list = ShoesDAO.shoesPopListData();
		List<ShoesVO> list2 = ShoesDAO.shoesNewListData();
		List<ShoesVO> list3 = ShoesDAO.shoesPreListData();
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);
		request.setAttribute("main_jsp", "../main/home.jsp");

		return "../main/main.jsp";

	}
	 
}