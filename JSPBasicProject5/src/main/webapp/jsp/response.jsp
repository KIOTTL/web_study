<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	response : 내장 객체
	-------- IP, PORT => 주로 요청 처리 결과값을 전송
						 --------------------- HTML / COOKIE
						 sentConetentType("브라우저에 어떤 형식으로 전송")
						 					text / html
	=> HttpServletResponse : 클래스명
	=> 응답 정보 
		setContentType() : HTML / XML  전송
		addCookie() : COOKIE 전송
		setHeader() : HTML, XML, COOKIE 전송 전에 처리
			=> 다운로드 창 띄우기
	=> 화면 이동 정보
		sendRedirect() : request 값을 초기화
		=> forward() : request 유지
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