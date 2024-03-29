package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.SeoulDAO;
import com.sist.vo.SeoulLNSVO;

import java.util.*;

@Controller
public class SeoulModel {
	@RequestMapping("seoul/location.do")
	public String seoul_location(HttpServletRequest request, HttpServletResponse resoponse) {
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=16;
		int start=(rowSize*curpage)-(rowSize-1);	// rownum=1
		int end=curpage*rowSize;
		
		map.put("start", start);	// #{start}
		map.put("end", end);	// #{end}
		map.put("table_name", "seoul_location");	// ${table_name}
		List<SeoulLNSVO> list=SeoulDAO.seoullnsListData(map);
		int totalpage=SeoulDAO.seoullnsTotalPage(map);
		
		/*
		 * 	[1][2][3][4][5] 
		 * 	[6][7][8][9][10]
		 */
		final int BLOCK=5;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if (endPage>totalpage)
			endPage=totalpage;
		
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("list", list);
		
		request.setAttribute("main_jsp", "../seoul/location.jsp");
		
		return "../main/main.jsp";
	}
	
	@RequestMapping("seoul/nature.do")
	public String seoul_nature(HttpServletRequest request, HttpServletResponse resoponse) {
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=16;
		int start=(rowSize*curpage)-(rowSize-1);	// rownum=1
		int end=curpage*rowSize;
		
		map.put("start", start);	// #{start}
		map.put("end", end);	// #{end}
		map.put("table_name", "seoul_nature");	// ${table_name}
		List<SeoulLNSVO> list=SeoulDAO.seoullnsListData(map);
		int totalpage=SeoulDAO.seoullnsTotalPage(map);
		
		/*
		 * 	[1][2][3][4][5] 
		 * 	[6][7][8][9][10]
		 */
		final int BLOCK=5;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if (endPage>totalpage)
			endPage=totalpage;
		
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("list", list);
		
		request.setAttribute("main_jsp", "../seoul/nature.jsp");
		
		return "../main/main.jsp";
	}	
	
	@RequestMapping("seoul/shop.do")
	public String seoul_shop(HttpServletRequest request, HttpServletResponse resoponse) {
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=16;
		int start=(rowSize*curpage)-(rowSize-1);	// rownum=1
		int end=curpage*rowSize;
		
		map.put("start", start);	// #{start}
		map.put("end", end);	// #{end}
		map.put("table_name", "seoul_shop");	// ${table_name}
		List<SeoulLNSVO> list=SeoulDAO.seoullnsListData(map);
		int totalpage=SeoulDAO.seoullnsTotalPage(map);
		
		/*
		 * 	[1][2][3][4][5] 
		 * 	[6][7][8][9][10]
		 */
		final int BLOCK=5;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if (endPage>totalpage)
			endPage=totalpage;
		
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("list", list);
		
		request.setAttribute("main_jsp", "../seoul/shop.jsp");
		
		return "../main/main.jsp";
	}
	
	@RequestMapping("seoul/hotel.do")
	public String seoul_hotel(HttpServletRequest request, HttpServletResponse resoponse) {
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=16;
		int start=(rowSize*curpage)-(rowSize-1);	// rownum=1
		int end=curpage*rowSize;
		
		map.put("start", start);	// #{start}
		map.put("end", end);	// #{end}
		map.put("table_name", "seoul_hotel");	// ${table_name}
		List<SeoulLNSVO> list=SeoulDAO.seoullnsListData(map);
		int totalpage=SeoulDAO.seoullnsTotalPage(map);
		
		/*
		 * 	[1][2][3][4][5] 
		 * 	[6][7][8][9][10]
		 */
		final int BLOCK=5;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if (endPage>totalpage)
			endPage=totalpage;
		
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("list", list);
		
		request.setAttribute("main_jsp", "../seoul/hotel.jsp");
		
		return "../main/main.jsp";
	}
	
	@RequestMapping("seoul/guest.do")
	public String seoul_guest(HttpServletRequest request, HttpServletResponse resoponse) {
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=16;
		int start=(rowSize*curpage)-(rowSize-1);	// rownum=1
		int end=curpage*rowSize;
		
		map.put("start", start);	// #{start}
		map.put("end", end);	// #{end}
		map.put("table_name", "seoul_guest");	// ${table_name}
		List<SeoulLNSVO> list=SeoulDAO.seoullnsListData(map);
		int totalpage=SeoulDAO.seoullnsTotalPage(map);
		
		/*
		 * 	[1][2][3][4][5] 
		 * 	[6][7][8][9][10]
		 */
		final int BLOCK=5;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if (endPage>totalpage)
			endPage=totalpage;
		
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("list", list);
		
		request.setAttribute("main_jsp", "../seoul/guest.jsp");
		
		return "../main/main.jsp";
	}	
	
	@RequestMapping("seoul/lns_detail.do")
	public String seoul_lns_detail(HttpServletRequest request, HttpServletResponse response) {
		String no=request.getParameter("no");
		String cno=request.getParameter("cno");
		String table_name="seoul_";
		if(Integer.parseInt(cno)==1) {
			table_name+="location";
		} else if (Integer.parseInt(cno)==2) {
			table_name+="nature";
		} else if (Integer.parseInt(cno)==3) {
			table_name+="shop";
		}
		
		Map map=new HashMap();
		map.put("no", no);
		map.put("table_name", table_name);
		SeoulLNSVO vo=SeoulDAO.seoulDetailData(map);
		
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../seoul/lns_detail.jsp");
		
		return "../main/main.jsp";
	}
}
