package com.sist.model;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class StyleReplyModel {
	@RequestMapping("stylereply/reply_insert.do")
	public String reply_insert(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch(Exception ex) {}
		
		String sid=request.getParameter("sid");	// 게시물 번호
		String content=request.getParameter("content");
//		HttpSession session=request.getSession();

		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("email");
//		String user_id=(String)session.getAttribute("id");
//		System.out.println("email="+email);
		int index=email.indexOf("@");
		String name=email.substring(0,index);
		
		//String user_id=request.getParameter("user_id");
		
		StyleReplyVO vo=new StyleReplyVO();
		vo.setSid(Integer.parseInt(sid));
		vo.setEmail(email);
		vo.setName(name);
		vo.setContent(content);
//		vo.setUser_id(Integer.parseInt(user_id));
//		System.out.println(user_id);
		System.out.println("name="+email);
		System.out.println("content="+content);
		
		/*
		 * SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH24:MI:SS"); Date
		 * regdate = vo.getRegdate(); String dbday = sdf.format(regdate);
		 * vo.setDbday(dbday); System.out.println("dbday="+dbday);
		 */
		
//		// update (countIntcrement)
//		String[] temp= {"","project_freeboard","seoul_location","seoul_nature","seoul_shop"};
//		String table=temp[Integer.parseInt(type)];
//		vo.setTable_name(table);
		
		// DAO => 오라클 전송 
		StyleReplyDAO.styleReplyInsert(vo);
		
		request.setAttribute("email", email);
		
		return "redirect:../style/detail.do?id="+sid;
	}
	
	
	@RequestMapping("stylereply/rereply_insert.do") 
	public String rereply_insert(HttpServletRequest request, HttpServletResponse response) { 
		try {
			  request.setCharacterEncoding("UTF-8"); 
		} catch(Exception ex) {}
	  
		String sid=request.getParameter("sid");
		
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("email");
//		System.out.println("email="+email);
		int index=email.indexOf("@");
		String name=email.substring(0,index);

		String content=request.getParameter("content"); 
		String group_id=request.getParameter("group_id"); 
		String group_step=request.getParameter("group_step"); 
		String group_tab=request.getParameter("group_tab"); 
		String root=request.getParameter("id"); 
		
		
//		HttpSession session=request.getSession();
//		System.out.println(session);
//		String group_id=(String)session.getAttribute("group_id");
//		String group_step=(String)session.getAttribute("group_step");
//		String root=(String)session.getAttribute("id");
//	  
		StyleReplyVO vo=new StyleReplyVO(); 
		vo.setSid(Integer.parseInt(sid));
		
		vo.setEmail(email);
		
		vo.setName(name); 
		vo.setContent(content);
		vo.setGroup_id(Integer.parseInt(group_id));
		vo.setGroup_step(Integer.parseInt(group_step));
		vo.setGroup_tab(Integer.parseInt(group_tab));
		vo.setRoot(Integer.parseInt(root));

//		vo.setGroup_id(Integer.parseInt(group_id));
//		vo.setGroup_step(Integer.parseInt(group_step));
//		vo.setRoot(Integer.parseInt(root));
//		
		System.out.println("sid="+sid);
		System.out.println("name="+email);
		System.out.println("content="+content);
		System.out.println("group_id="+group_id);
		
//		
		StyleReplyDAO.styleRereplyInsert(vo);
	  
		return "redirect:../style/detail.do?id="+sid; 
	}
	 
	@RequestMapping("mypage/mypage_style.do")
    public String mypage_style(HttpServletRequest request,HttpServletResponse response) {
		String page=request.getParameter("page");
		if (page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		
		Map map=new HashMap();
		HttpSession session=request.getSession();
		int user_id=(int) session.getAttribute("user_id");
		map.put("user_id", user_id);
		
		int totalpage=StyleDAO.mypageStyleTotalPage(map);
		int rowSize=8;
		int start=(curpage*rowSize)-(rowSize-1);
		int end=curpage*rowSize;
		map.put("start", start);
		map.put("end", end);
		
		
		List<StyleVO> list=StyleDAO.mypageStyle(map);
		
		final int BLOCK = 5;
		int startPage = ((curpage-1)/BLOCK*BLOCK) + 1;
		int endPage = ((curpage-1)/BLOCK*BLOCK) + BLOCK;
		if(endPage>totalpage) {
			endPage = totalpage;
		}
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		
		request.setAttribute("list", list);
		
		String name="hong";
    	List<StyleReplyVO> list2=StyleReplyDAO.styleReplyMypageData(name);
    	request.setAttribute("list2", list2);
    	
    	///////////////////////////////////////////////////////////////////
		
		
		
		List<StyleVO> list3=StyleDAO.mypageStyleLikes(user_id);
		request.setAttribute("list3", list3);
    	
    	request.setAttribute("main_jsp", "../mypage/mypage_style.jsp");
    	
    	return "../main/main.jsp";
    }
	
	// 댓글 삭제
		@RequestMapping("stylereply/reply_delete.do")
		public String reply_delete(HttpServletRequest request, HttpServletResponse response) {
			String sid=request.getParameter("sid");	// 게시물 번호 => detail로 이동시
			String id=request.getParameter("id"); // 댓글 번호 => delete시 사용
			String group_id=request.getParameter("group_id");
			
			// 삭제 => DAO
			StyleReplyDAO.styleReplyDelete(Integer.parseInt(id), Integer.parseInt(group_id));
			
			return "redirect:../style/detail.do?id="+sid;	// .do는 데이터 넘어가지 x
		}
		@RequestMapping("mypage/reply_delete.do")
		public String mypage_reply_delete(HttpServletRequest request, HttpServletResponse response) {
			String sid=request.getParameter("sid");	// 게시물 번호 => detail로 이동시
			String id=request.getParameter("id"); // 댓글 번호 => delete시 사용
			String group_id=request.getParameter("group_id");
			
			// 삭제 => DAO
			StyleReplyDAO.styleReplyDelete(Integer.parseInt(id), Integer.parseInt(group_id));
			
			return "redirect:../mypage/mypage_style.do";	// .do는 데이터 넘어가지 x
		}
		
		// 댓글 수정
		@RequestMapping("stylereply/reply_update.do")
		public String reply_update(HttpServletRequest request, HttpServletResponse response) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch(Exception ex) {}
			String sid=request.getParameter("sid");	// 게시물 번호 => detail로 이동시
			String id=request.getParameter("id"); // 댓글 번호 => delete시 사용
			String content=request.getParameter("content");
			
			// DAO연동
			StyleReplyVO vo=new StyleReplyVO();
			vo.setId(Integer.parseInt(id));
			vo.setContent(content);
			StyleReplyDAO.styleReplyUpdate(vo);
			
			return "redirect:../style/detail.do?id="+sid;
			
		}
	
}
