package com.sist.model;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.StyleDAO;
import com.sist.dao.StyleReplyDAO;
import com.sist.vo.StyleLikesVO;
import com.sist.vo.StyleReplyVO;
import com.sist.vo.StyleVO;

@Controller
public class StyleModel {
//	@RequestMapping("nav/nav_style.do")
//	public String style_list(HttpServletRequest request, HttpServletResponse response) {
//		String page=request.getParameter("page");
//		if (page==null)
//			page="1";
//		int curpage=Integer.parseInt(page);
//		Map map=new HashMap();
//		int rowSize=8;
//		int start=(curpage*rowSize)-(rowSize-1);
//		int end=curpage*rowSize;
//		map.put("start", start);
//		map.put("end", end);
//		
//		List<StyleVO> list=StyleDAO.styleListData(map);
//		int totalpage=StyleDAO.styleTotalPage(map);
//		
//		
//		final int BLOCK = 5;
//		int startPage = ((curpage-1)/BLOCK*BLOCK) + 1;
//		// [1] [2] [3] [4] [5]  => start = 1, 6, ... / end = 5, 10, ...
//		int endPage = ((curpage-1)/BLOCK*BLOCK) + BLOCK;
//		if(endPage>totalpage) {
//			endPage = totalpage;
//		}
//		request.setAttribute("curpage", curpage);
//		request.setAttribute("totalpage", totalpage);
//		request.setAttribute("startPage", startPage);
//		request.setAttribute("endPage", endPage);
//		
//		request.setAttribute("list", list);
//		request.setAttribute("main_jsp", "../nav/nav_style.jsp");
//		
//		
//		return "../main/main.jsp";
//	}
	
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
		
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("email");
		
		String content=request.getParameter("content");
		String img=request.getParameter("img");
		
		StyleVO vo=new StyleVO();
		vo.setContent(content);
		vo.setImg("../style/image/"+img);
		vo.setEmail(email);
		
		System.out.println("img="+img);
		System.out.println("content="+content);

		StyleDAO.styleInsert(vo);
		
		return "redirect:../nav/nav_style.do";
	}
	
	@RequestMapping("style/style_detail_before.do")
	public String style_detail_before(HttpServletRequest request, HttpServletResponse response) {
		// 쿠키만 전송, 화면 출력 x (ex) insert_ok.do)
		String id=request.getParameter("id");
		Cookie cookie=new Cookie("style"+id, id);
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		// 상세보기로 이동
		return "redirect:../style/detail.do?id="+id;	// request 초기화 => 화면만 이동 (sendRedirect())
	}
	
	@RequestMapping("style/detail.do")
	public String style_detail(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		// 데이터베이스 연동
		
		StyleVO vo=StyleDAO.styleDetailData(Integer.parseInt(id));
		System.out.println("vo.setEmail="+vo.getEmail());
		// request에 담아서 넘겨주기
//		System.out.println("user_id11="+vo.getUser_id());
		request.setAttribute("vo", vo);
//		System.out.println("rcount="+vo.getRcount());
//		System.out.println("dbday="+vo.getDbday());
		
		
		//------------------- reply ------------------
		
		StyleReplyVO svo=new StyleReplyVO();
		svo.setSid(vo.getId());
		
		
		HttpSession session=request.getSession();
		if (session==null) {
			String email="";
			svo.setEmail(email);
		} else {
			String email=(String)session.getAttribute("email");
			svo.setEmail(email);
			System.out.println("email="+email);
			
		}
//		String user_id=request.getParameter("user_id");
//		System.out.println("user_id="+user_id);
//		int index=email.indexOf("@");
//		String name=email.substring(0,index);
//		svo.setName(name);
//		System.out.println("svo.getName():"+svo.getName());
		System.out.println("svo.getEmail():"+svo.getEmail());
		
		
		List<StyleReplyVO> list=StyleReplyDAO.styleReplyListData(svo);
		
//		System.out.println("name="+svo.getName());
//		System.out.println("dbday="+svo.getDbday());
		
		// --------------likes----------------------
		
			StyleLikesVO lvo=new StyleLikesVO();
			lvo.setSid(Integer.parseInt(id));
			if(session.getAttribute("user_id")!=null) {
				int user_id=(int)session.getAttribute("user_id");
				lvo.setUser_id(user_id);
				System.out.println("user_id="+user_id);
			}
			int lcount=StyleDAO.styleLikesCount(lvo);
			
			request.setAttribute("lcount", lcount);
		
		// ---------------tag------------------------
		
		String content = vo.getContent();
		String[] tag = content.split("#");
	    
		//출력				
//		for(int i=0;i<tag.length;i++) {
//		System.out.println(tag[i]);
//		}
		
		request.setAttribute("tag", tag);
		
		request.setAttribute("list", list);
		
		request.setAttribute("main_jsp", "../style/detail.jsp");
		
		return "../main/main.jsp";
		
	}
	
	@RequestMapping("style/tag.do")
	public String shoesFind(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch(Exception ex) {}
		
		String tag=request.getParameter("tag");
//		System.out.println("tag="+tag);

		
		List<StyleVO> list=StyleDAO.styleTagData(tag);
		
		request.setAttribute("tag", tag);
		request.setAttribute("list", list);
		request.setAttribute("main_jsp", "../style/tag.jsp");
		
		return "../main/main.jsp";
	}
	
	@RequestMapping("style/likes.do")
	public String style_likes(HttpServletRequest request, HttpServletResponse response) {
		String sid=request.getParameter("id");
		System.out.println("sid="+sid);
		HttpSession session=request.getSession();
		int user_id=(int) session.getAttribute("user_id");
		System.out.println("user_id="+user_id);
		StyleLikesVO vo=new StyleLikesVO();
		vo.setSid(Integer.parseInt(sid));
		vo.setUser_id(user_id);
//		
		StyleDAO.styleLikesInsert(vo);
		
		return "redirect:../style/detail.do?id="+sid;
	}
	
	@RequestMapping("style/likes_cancel.do")
	public String food_jjim_cancel(HttpServletRequest request, HttpServletResponse response) {
		String sid=request.getParameter("id");
		HttpSession session=request.getSession();
		int user_id=(int) session.getAttribute("user_id");
		StyleLikesVO vo=new StyleLikesVO();
		vo.setSid(Integer.parseInt(sid));
		vo.setUser_id(user_id);
		
		StyleDAO.styleLikesDelete(vo);
		
		return "redirect:../style/detail.do?id="+sid;
	}
	
	@RequestMapping("style/update.do")
	public String style_update(HttpServletRequest request, HttpServletResponse response) {
		
		String id=request.getParameter("id");
		StyleVO vo=StyleDAO.styleUpdateData(Integer.parseInt(id));
		
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../style/update.jsp");
		
		return "../main/main.jsp";
	}
	
	@RequestMapping("style/update_ok.do")
	public String style_update_ok(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch(Exception ex) {}
		
		String content=request.getParameter("content");
		System.out.println("content="+content);
		String id=request.getParameter("id");
		System.out.println("id="+id);
		
		StyleVO vo=new StyleVO();
		vo.setContent(content);
		vo.setId(Integer.parseInt(id));
		
		StyleDAO.styleUpdate(vo);
		
		return "redirect:../style/detail.do?id="+id;
	}
	
	@RequestMapping("style/delete.do")
	public String style_delete(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		
		StyleDAO.styleDelete(Integer.parseInt(id));
		
		return "../style/delete.jsp";
	}
	
	/*
	 * @RequestMapping("mypage/stylelist.do") public String
	 * mypage_stylelist(HttpServletRequest request, HttpServletResponse response) {
	 * HttpSession session=request.getSession(); int user_id=(int)
	 * session.getAttribute("user_id"); System.out.println("user_id="+user_id);
	 * 
	 * StyleDAO.mypageStyle(user_id);
	 * 
	 * request.setAttribute("main_jsp", "../mypage/mypage_style.jsp");
	 * 
	 * return "../main/main.jsp"; }
	 */
	
}











