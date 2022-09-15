package com.sist.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.ShoesDAO;
import com.sist.dao.StyleDAO;
import com.sist.vo.ShoesVO;
import com.sist.vo.StyleVO;

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
		Map map=new HashMap();
		map.put("start", 1);
		map.put("end", 5);
		List<StyleVO> list4=StyleDAO.styleListData(map);
		request.setAttribute("list4", list4);
		request.setAttribute("main_jsp", "../main/home.jsp");
		

		return "../main/main.jsp";

	}
	 
}