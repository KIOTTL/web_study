package com.sist.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.NavDAO;
import com.sist.dao.StyleDAO;
import com.sist.vo.MemberVO;
import com.sist.vo.ShoesVO;
import com.sist.vo.StyleLikesVO;
import com.sist.vo.StyleVO;

@Controller
public class NavModel {
	@RequestMapping("nav/nav_new.do")
	public String nav_new(HttpServletRequest request, HttpServletResponse response) {
		
		String page = request.getParameter("page");
		if(page == null) {
			page = "1";
		}
		int curpage = Integer.parseInt(page);
		Map map = new HashMap();
		int rowSize = 12;
		int start = (rowSize*curpage)-(rowSize-1); //rownum
		int end = (rowSize*curpage);
		
		map.put("table_name", "nav_new");// ${table_name}
		map.put("start", start); // #{start}
		map.put("end", end);
		List<ShoesVO> list = NavDAO.navNewList(map);
		int totalpage = NavDAO.navTotalPage(map);
		
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
		request.setAttribute("main_jsp", "../nav/nav_new.jsp");
		
		return "../main/main.jsp";	
	}
	
	@RequestMapping("nav/nav_men.do")
	public String nav_men(HttpServletRequest request, HttpServletResponse response) {
		
		String page = request.getParameter("page");
		if(page == null) {
			page = "1";
		}
		int curpage = Integer.parseInt(page);
		Map map = new HashMap();
		int rowSize = 12;
		int start = (rowSize*curpage)-(rowSize-1); //rownum
		int end = (rowSize*curpage);
		
		map.put("table_name", "nav_men");// ${table_name}
		map.put("start", start); // #{start}
		map.put("end", end);
		List<ShoesVO> list = NavDAO.navMenList(map);
		int totalpage = NavDAO.navTotalPage2(map);
		
		final int BLOCK = 10;
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
		request.setAttribute("main_jsp", "../nav/nav_men.jsp");
		
		return "../main/main.jsp";		
	}
	
	@RequestMapping("nav/nav_women.do")
	public String nav_women(HttpServletRequest request, HttpServletResponse response) 
	{	
		String page = request.getParameter("page");
		if(page == null) {
			page = "1";
		}
		int curpage = Integer.parseInt(page);
		Map map = new HashMap();
		int rowSize = 12;
		int start = (rowSize*curpage)-(rowSize-1); //rownum
		int end = (rowSize*curpage);
		
		map.put("table_name", "nav_women");// ${table_name}
		map.put("start", start); // #{start}
		map.put("end", end);
		List<ShoesVO> list = NavDAO.navWomenList(map);
		int totalpage = NavDAO.navTotalPage3(map);
		
		final int BLOCK = 10;
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
	
//	@RequestMapping("nav/nav_style.do")
//	public String nav_style(HttpServletRequest request, HttpServletResponse response) {
//		
//		List<StyleVO> list = NavDAO.navStyleList();
//		request.setAttribute("list", list);
//		request.setAttribute("main_jsp", "../nav/nav_style.jsp");
//		
//		return "../main/main.jsp";	
//	}
	
	@RequestMapping("nav/nav_style.do")
	public String style_list(HttpServletRequest request, HttpServletResponse response) {
		String page=request.getParameter("page");
		if (page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=8;
		int start=(curpage*rowSize)-(rowSize-1);
		int end=curpage*rowSize;
		map.put("start", start);
		map.put("end", end);
		
//		String email=request.getParameter("email");
//		System.out.println("email="+email);
//		int index=email.indexOf("@");
//		String nickname=email.substring(0,index);
		
//		System.out.println("nickname="+nickname);
//		request.setAttribute("nickname", nickname);
		
//		String user_id=request.getParameter("id");
//		MemberVO vo=StyleDAO.styleGetEmail(user_id);
//		String email=vo.getEmail();
//		System.out.println("email="+email);
//		int index=email.indexOf("@");
//		String nickname=email.substring(0,index);
		
		List<StyleVO> list=StyleDAO.styleListData(map);
		List<StyleVO> list2=StyleDAO.styleListDataPop(map);
		int totalpage=StyleDAO.styleTotalPage(map);
		
		
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
		
//		<select id="styleGetEmail" resultType="MemberVO" parameterType="int">
//		List<MemberVO> mlist=StyleDAO.styleGetEmail(Integer.parseInt(user_id));
		
		
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		request.setAttribute("main_jsp", "../nav/nav_style.jsp");
		
//		// -------------likes--------------------
////		StyleVO vo=new StyleVO();
//		StyleLikesVO lvo=new StyleLikesVO();
////		String sid=request.getParameter("id");
////		System.out.println("sid="+sid);
//		String sid=request.getParameter("sid");
//		System.out.println(sid);
////		lvo.setSid(Integer.parseInt(sid));
//		HttpSession session=request.getSession();
//		int user_id=(int)session.getAttribute("user_id");
//		lvo.setUser_id(user_id);
//		int lcount=StyleDAO.styleLikesCount(lvo);
//		
//		request.setAttribute("lcount", lcount);
		
		
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