package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.*;
import com.sist.vo.*;

@Controller
public class FoodModel {
	@RequestMapping("food/food_list.do")	// 카테고리별 맛집 리스트
	public String food_list(HttpServletRequest request, HttpServletResponse response) {
		// 카테고리 번호
		String cno=request.getParameter("cno");
		// cno를 DAO에 보내서 데이터 읽어오기
		List<FoodVO> list=FoodDAO.foodListData(Integer.parseInt(cno));
		FoodCategoryVO vo=FoodDAO.foodCategoryInfoData(Integer.parseInt(cno));
		request.setAttribute("list", list);
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../food/food_list.jsp");
		
		return "../main/main.jsp";	// forward
	}
	
	// 쿠키 전송
	@RequestMapping("food/food_detail_before.do")
	public String food_detail_before(HttpServletRequest request, HttpServletResponse response) {
		// 쿠키만 전송, 화면 출력 x (ex) insert_ok.do)
		String fno=request.getParameter("fno");
		Cookie cookie=new Cookie("food"+fno, fno);
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		// 상세보기로 이동
		return "redirect:../food/food_detail.do?fno="+fno;	// request 초기화 => 화면만 이동 (sendRedirect())
	}
	
	/*
	 * 	Model
	 * 	1. 사용자 요청 데이터 받기 (필수X)
	 * 	2. 데이터베이스 연결 (핵심)
	 * 	3. request에 값 담기
	 * 	4. 어떤 JSP로 보낼지 설정 
	 * 
	 * 	JSP
	 * 	 request에 있는 데이터 출력
	 * 	 
	 */
	@RequestMapping("food/jjim.do")
	public String food_jjim(HttpServletRequest request, HttpServletResponse response) {
		String fno=request.getParameter("fno");
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		JjimVO vo=new JjimVO();
		vo.setFno(Integer.parseInt(fno));
		vo.setId(id);
		
		FoodDAO.foodJjimInsert(vo);
		
		return "redirect:../food/food_detail.do?fno="+fno;
	}
	
	@RequestMapping("food/food_detail.do")
	public String food_detail(HttpServletRequest request, HttpServletResponse response) {
		String fno=request.getParameter("fno");
		// 데이터베이스 연동
		FoodVO vo=FoodDAO.foodDetailData(Integer.parseInt(fno));
		// request에 담아서 넘겨주기
		String address=vo.getAddress();
		String addr1=address.substring(0,address.lastIndexOf("지")); // 주소 지번에서 자르기
		String addr2=address.substring(address.lastIndexOf("지")+2);	// 지도 출력
		request.setAttribute("addr1", addr1.trim());
		request.setAttribute("addr2", addr2.trim());
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../food/food_detail.jsp");
		
		// 찜
		JjimVO jvo=new JjimVO();
		jvo.setFno(Integer.parseInt(fno));
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		jvo.setId(id);
		int jcount=FoodDAO.foodJjimCount(jvo);
		
		request.setAttribute("jcount", jcount);
		request.setAttribute("likecount", 0);
		
		// 관련 레시피 전송
		String type=vo.getType();
		// 브런치 / 버거 / 샌드위치 => 브런치 | 버거 | 샌드위치 => 브런치|버거|샌드위치
		type=type.replace("/", "|").replace(" ", "");
		
		List<RecipeVO> rList=FoodDAO.foodRecipeMakeData(type);
		request.setAttribute("rList", rList);
		
		return "../main/main.jsp";
	}
	
	@RequestMapping("food/food_find.do")
	public String food_find(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch(Exception ex) {}
		
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		String addr=request.getParameter("addr");
		if(addr==null)
			addr="강남";
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("address", addr);
		
		List<FoodVO> list=FoodDAO.foodLocationFindData(map);
		int totalpage=FoodDAO.foodLocationFindTotalPage(addr);
		
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("list", list);
		request.setAttribute("addr", addr);
		
		request.setAttribute("main_jsp", "../food/food_find.jsp");
		
		return "../main/main.jsp";
	}
	
	@RequestMapping("food/jjim_list.do")
	public String food_jjim_list(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		
		List<Integer> list=FoodDAO.foodJjimGetFno(id);
		List<FoodVO> fList=new ArrayList<FoodVO>();
		
		for(int fno:list) {
			FoodVO vo=FoodDAO.foodJjimListData(fno);
			fList.add(vo);
		}
		
		request.setAttribute("fList", fList);
		
		request.setAttribute("mypage_jsp", "../mypage/jjim_list.jsp");
		request.setAttribute("main_jsp", "../mypage/mypage.jsp");
		
		return "../main/main.jsp";
	}
	
	@RequestMapping("food/jjim_cancel.do")
	public String food_jjim_cancel(HttpServletRequest request, HttpServletResponse response) {
		String fno=request.getParameter("fno");
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		JjimVO vo=new JjimVO();
		vo.setId(id);
		vo.setFno(Integer.parseInt(fno));
		
		FoodDAO.foodJjimDelete(vo);
		
		return "redirect:../food/jjim_list.do";
	}
}












