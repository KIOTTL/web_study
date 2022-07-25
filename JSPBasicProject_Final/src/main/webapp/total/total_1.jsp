<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	웹 프로그램의 이해
		- 요청 (request) => 사용자가 요청 (GET/POST) => 데이터를 전송
		- 응답 (response) => 응답(서버) => HTML/Cookie
		한 개의 jsp에서는 한 개만 실행
	동작 원리
		- jsp 파일 요청 (URL => 파일 요청 => 받아서 파일 찾기(404) => 실행 (505)
		- jsp 번역 (웹서버 : 요청받기, 응답하기, WAS(톰캣 => 실행 => HTML 추출)
		- 서블릿 코드 생성(work)
		- 인터프리터
		- 메모리에 저장 => HTML을 브라우저가 읽어 감
	JSP 지시자 / 태그
		page / taglib
	내장객체
		request : 요청정보
			- getParameter()
			- getParameterValues()
			- setCharacterEncoding()
			- setAttribute()
			- getAttribute()
			- getRequestURI()
			- getContextPath()
		response : 응답정보
			- setHeader()
			- sendRedirect()
		session : 서버에 저장 (클라이언트 일부 정보)
			- setAttribute()
			- getAttribute()
			- invalidate()
			- removeAttribute()
		application ㅣ 서버정보
			- getRealPath()
		
		cookie
			- new Cookie(key, value)
			- getName() => key
			- getValue() => value
			- setMaxAge() : 기간 설정
			- setPath()
			- 전송 : response.addCookie()
			  읽기 : request.getCookies()
	자바빈즈 : Bean (데이터 모아서 전송할 목적)
			변수 : private
				읽기 / 쓰기 setXxx() => setter
				--- getXxx(), boolean => isXxx()
			=> 객체 생성
				<jsp:useBean id="객체명" class="객체 생성할 클래스명(패키지명)">
			=> 값 설정
				<jsp:setProperty name="객체명" property="name"> setName()
				<jsp:setProperty name="객체명" property="*"> 객체가 가지고 있는 모든 setXxx() 호출
			=> 값 읽기
				<jsp:getProperty name="객체명" property="변수명">
					<%=객체명.getXxx() %>
	ConnectionPool => Connection을 제한(재사용) 
		JDBC : 데이터베이스 연결, Connection / Statement / ResultSet
			   연결 / 닫기
			   --- Connection => 생성이 되면 바로 해제가 안 됨 (메모리 누수) => 서버 과부하
	데이터베이스 연동 : JDBC
	세션(서버) 쿠키(클라이언트)				
	
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>