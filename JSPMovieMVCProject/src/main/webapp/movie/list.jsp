<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	/*
		list.jsp ==> request(톰캣) => ip, port, 사용자 요청 정보(? 뒤)
		1) JSP
			=> 자바코딩
				HTML, Java => 구분
				<%
					자바
				%>
				<%= %> => 데이터 출력
			=> 내장 객체
				request (HttpServletRequest)
					사용자 정보, 요청 정보
					-----------------
					 - getParameter()
					 - getParameterValues() : ex) checkBox
					 - setCharacterEncoding() : ex) 한글 변환
					 - getSession() : session 객체 가지고 온다
					 - getCookie() : cookie 읽기
					 - setAttribute() : 기존의 데이터 + 새로운 데이터 추가
				response (HttpServletResponse)
					응답 정보, 화면 변경
					----------------
					 응답 : HTML, Cookie => 둘 중 한 개만 설정
					 setContextType ("text/html", "text/xml", "text/plain(JSON))
					 addCookie() : 쿠키 전송
					 sendRedirect() : 서버에서 화면 이동 (insert, update, delete)
				session (HttpSession) : 서버 클라이언트의 일부 정보 저장 (프로젝트에서 사용하는 모든 JSP에서 사용 가능) => id, 장바구니
					=> setAttribute(String key, Object obj), getAttribute(), invalidate(), removeAttribute()
						   저장			지정값 읽기		전제 메모리 해제	일부 메모리 해제
				cookie (Cookie:내장 객체가 아니다) :클라이언트 브라우저 (방문)
					=> 쿠키 생성 Cookie cookie=new Cookie(키, 값)
														   -- 문자열만 저장 가능
					=> 기간 설정 setMaxAge(초단위) => 60*60*24
					=> 저장 위치 setPath("/")
					=> 브라우저로 전송 response.addCookie()
					=> 쿠키 읽기 Cookie[] cookies=request.getCookies()
								==> 키 : getName()
								==> 값 : getValue()
			=> DataBase : DAO 
			
			Java : 데이터 관리 (오라클을 연결)
			JavaScript : 이벤트 처리(브라우저 안에서 동적)
			HTML/CSS : 화면만 출력 (정적)
	*/
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container-fluid{
   margin-top: 50px;
}
.row{
   margin: 0px auto;
   width: 100%;
}
</style>
</head>
<body>
<div class='container-fluid'>
    <div class="row">
     <div class="text-right">
      <a href="list.do?cno=1" class="btn btn-sm btn-success">현재 상영 영화</a>
      <a href="list.do?cno=2" class="btn btn-sm btn-info">개봉 예정 영화</a>
     </div>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
      <%-- for(CategoryVO vo:list) --%>
      <c:forEach var="vo" items="${list }">
        <div class="col-md-3">
	      <div class="thumbnail">
	        <a href="detail_before.do?mno=${vo.getMno()}">
	          <img src="${vo.getPoster() }" alt="Lights" style="width:300px;height: 300px">
	          <div class="caption">
	            <p>${ vo.getTitle() }</p>
	          </div>
	        </a>
	      </div>
	    </div>
      </c:forEach>
    </div>
    <div class="row">
      <div class="text-center">
        <a href="list.jsp?cno=${cno }&page=${curpage>1 ? curpage-1:curpage }" class="btn btn-sm btn-info">이전</a>
        ${curpage } page/ ${totalpage } pages
        <a href="list.jsp?cno=${cno }&page=${curpage<totalpage ? curpage+1:curpage }" class="btn btn-sm btn-warning">다음</a>
      </div>
    </div>
    <div style="height: 10px"></div>
    <div class="row">
      <h3>최근 방문 영화</h3>
      <hr>
        <c:forEach var="vo" items="${cList }">
        		<img src="${vo.getPoster() }" style="width:100px; height: 100px">		
        </c:forEach>
    </div>
  </div>
</body>
</html>