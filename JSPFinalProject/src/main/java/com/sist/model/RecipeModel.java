package com.sist.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.RecipeDAO;
import com.sist.vo.ChefVO;
import com.sist.vo.RecipeVO;

@Controller
public class RecipeModel {
	@RequestMapping("recipe/recipe_list.do")
	public String recipe_list(HttpServletRequest request, HttpServletResponse response) {
		// 1. 페이지 받기
		String page=request.getParameter("page");
		if (page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		// List ==> Map (start, end)
		int rowSize=9;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		List<RecipeVO> list=RecipeDAO.recipeListData(map);
		
		// 글자수 조정
		for (RecipeVO vo:list) {
			String title=vo.getTitle();
			if (title.length()>19) {
				title=title.substring(0,19)+"...";
			}
			vo.setTitle(title);
		}
		
		int totalpage=RecipeDAO.recipeTotalPage();
		
		// 블록별 나눠서 실행
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK)*BLOCK+1;	// curpage=1~10
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if (endPage>totalpage)
			endPage=totalpage;
		
		// JSP 출력에 필요한 데이터 전송
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("list", list);
		// ==> ${} <% %>(x)
		request.setAttribute("main_jsp", "../recipe/recipe_list.jsp");
		
		return "../main/main.jsp";
	}
	
	@RequestMapping("recipe/chef_list.do")
	public String chef_list(HttpServletRequest request, HttpServletResponse response) {
		String page=request.getParameter("page");
		if (page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		// List ==> Map (start, end)
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		List<ChefVO> list=RecipeDAO.chefListData(map);
		
		int totalpage=RecipeDAO.chefTotalPage();
		
		// 블록별 나눠서 실행
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK)*BLOCK+1;	// curpage=1~10
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if (endPage>totalpage)
			endPage=totalpage;
		
		// JSP 출력에 필요한 데이터 전송
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("list", list);
		
		request.setAttribute("main_jsp", "../recipe/chef_list.jsp");
		
		return "../main/main.jsp";
	}
	
	@RequestMapping("recipe/chef_make.do")
	public String chef_make(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * 	1. VO
		 * 	2. SQL
		 * 	3. DAO
		 * 	4. JSP = LINK
		 * 	5. Model ==> 이동여부 확인
		 * 	6. 데이터 전송
		 * 	7. JSP 출력
		 */
		request.setAttribute("main_jsp", "../recipe/chef_make.jsp");
		
		return "../main/main.jsp";
	}
}
