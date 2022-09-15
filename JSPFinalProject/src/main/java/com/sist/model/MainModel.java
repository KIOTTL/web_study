package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.FoodDAO;
import com.sist.vo.FoodCategoryVO;

@Controller
public class MainModel {
	@RequestMapping("main/main.do")
	public String main_page(HttpServletRequest request, HttpServletResponse response) {
		List<FoodCategoryVO> list=FoodDAO.foodCategoryData();
		request.setAttribute("list", list);
		request.setAttribute("main_jsp", "../main/home.jsp");	// 데이터 출력
		
		
		return "../main/main.jsp";	// include
	}
}
