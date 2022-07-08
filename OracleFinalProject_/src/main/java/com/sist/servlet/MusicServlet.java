package com.sist.servlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;

// 수동 호출(x)
// 브라우저에 URL 주소 뒤 /MusicServlet이 적혀있으면 톰캣에 의해 호출 => service를 호출 => 출력된 HTML을 브라우저로 전송 후 실행
@WebServlet("/MusicServlet")
public class MusicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// main
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request => 사용자가 보내 준 데이터 받는 역할 => getParameter()
		// response => 응답 (HTML, Cookie) => HTML 전송, 화면 변경
		// => JSP에서는 내장 객체
		
		// 응답 타입 지정 => text/html, text/xml, text/plain
		//                  ----------            ---------- JSON
		// 브라우저 전송 ==> HTML (한글 포함)
		response.setContentType("text/html;charset=UTF-8");
		
		// 누구에게 전송 => 요청한 사용자에게 HTML 출력 위치 알려줌
		PrintWriter out=response.getWriter();	// 요청한 사람의 ip 가지고 있음
		
		// 1. 사용자 요청 받기 => 장르, 페이지 (request) => String ==> ArrayList<MusicVO>(int cno, int page)
		String cno=request.getParameter("cno");
		String page=request.getParameter("page");
		// => 실행 페이지는 사용자가 선택 불가 ==> main page 뜰 때
		// 디폴트 ==> 디폴트 빠지면 페이지 출력x
		if(cno==null)
			cno="1";	// Top100
		if(page==null)
			page="1";
		// => 웹에서는 파일(x), 페이지(o) ==> 상용화 사이트(기본 75페이지)
		
		// 2. 요청 => 데이터베이스 값 받기 => 매개변수는 사용자가 요청한 값
		int curpage=Integer.parseInt(page);	// 현재 페이지 지정
		// 2-2. 현재 페이지에 대한 데이터 읽기 시작
		MusicDAO dao = new MusicDAO();
		List<MusicVO> list = dao.musicListData(Integer.parseInt(cno), curpage);
		int totalpage = dao.musicTotalPage(Integer.parseInt(cno));
		
		// 3. HTML만들어서 브라우저 전송 => out.println()
		String[] genre = {
			"",			// cno=0
			"Top 100",
			"가요",
			"POP",
			"OST",
			"트로트",
			"JAZZ",
			"CLASSIC"
		};
		out.println("<html>");
		out.println("<head>");	// style, script
		out.println("</head>");
		out.println("<body>");	// 화면 출력
		out.println("<center>");
		// 해당 파일에 데이터 전송
		// URL 주소 안 파일명?변수=값 (한 개) => MusicServlet?cno=1
		// 파일명?변수=값&변수=값... (두 개 이상) => MusicServlet?cno=1&page2  ==> cno = 1 & page = 2 (공백 있을시 에러 발생)
		/*
		 * 		String cno=request.getParameter("cno");
				String page=request.getParameter("page");
		 */
		// <a href> : 화면 이동
		out.println("<a href=MusicServlet?cno=1>Top100</a>&nbsp;");	// &nbsp:공백 , MusicServlet:값 받는 애(14), ?cno=1 : ? 뒤 데이터 전송(33)
		out.println("<a href=MusicServlet?cno=2>가요</a>&nbsp");
		out.println("<a href=MusicServlet?cno=3>POP</a>&nbsp");
		out.println("<a href=MusicServlet?cno=4>OST</a>&nbsp");
		out.println("<a href=MusicServlet?cno=5>트로트</a>&nbsp");
		out.println("<a href=MusicServlet?cno=6>JAZZ</a>&nbsp");
		out.println("<a href=MusicServlet?cno=7>CLASSIC</a>");
		// 요청 => service() 호출되면서 실행 => HTML 변경
		// 재요청 => 이전 화면 메모리에서 해제 => 새로운 파일 생성
		//                destroy()
		// service() => destroy() ==> WAS (톰캣) WAS:WEb Application Server
		// WebServer(송수신), WAS(자바 번역)
		out.println("<h1>"+genre[Integer.parseInt(cno)]+"</h1>");
		/*
		 * 	table
		 *    |
		 *   tr : 한 줄 생성
		 *    |
		 *  ------
		 *  |    |
		 *  th   td
		 *  --   -- 
		 *  제목  실제 데이터
		 */
		out.println("<table border=1 bordercolor=black width=960>");
		// 제목
		out.println("<tr>");
		out.println("<th>순위</th>");
		out.println("<th></th>");
		out.println("<th>곡명</th>");
		out.println("<th>가수명</th>");
		out.println("<th>앨범</th>");
		out.println("</tr>");
		// 데이터 출력
		for(MusicVO vo:list	) {
			out.println("<tr>");
			out.println("<td>"+vo.getMno()+"</td>");
			out.println("<td>");
			out.println("<img src="+vo.getPoster()+" width=30 height=30>");
			out.println("</td>");			
			out.println("<td>"+vo.getTitle()+"</td>");
			out.println("<td>"+vo.getSinger()+"</td>");
			out.println("<td>"+vo.getAlbum()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		
	}

}
