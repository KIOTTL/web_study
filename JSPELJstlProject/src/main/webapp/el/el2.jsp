<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	EL => 내장 객체
	String name = "홍길동";
	${name} => 출력 안 됨 <%=name %>
	------- 일반 변수 출력x
	request.setAttribute("name","홍길동");
	${name}
	 ------ request.getAttribute("name")
	 session.setAttribute("id","admin");
	 ${sessionScope.id}
	 
	 ===> request, session에 추가된 값 출력
	 1. requestScope => request.getAttribute() : request.setAttribute("key",value) 
	 												=> value출력 : getAttribute("key")
	 												=> ${requestScope.key}
	 												=> ${key} => requestScope 생략 가능
	 2. sessionScope => session.getAttribute() : session.setAttribute("key",value) 
	 												=> value출력 : getAttribute("key")
	 												=> ${sessionScope.key}
	 												=> ${key} => sessionScope 생략 가능
	 				request, session 같은 키가 있는 경우 request가 우선 순위
	 3. applicationScope => application.getAttribute()
	 4. param => request.getParameter() : request.getParameter("name") => ${param.name}
	 5. paramValue => request.getParameterValues() : request.getParameterValues("hobby") => ${paramValues.hobby}
	 
	 request, session에 추가된 값 출력
 --%>
 <%
 	String name = "홍길동";
 	
 	// ${} 출력 위해 request, session값 추가 ==> setAttribute()
  	request.setAttribute("name", "홍길동");
 	session.setAttribute("name", "심청이");
 	session.setAttribute("name1", "박문수");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름 : ${name }<br>
	이름 : ${requestScope.name }<br>
	이름 : ${sessionScope.name }<br>
	이름 : ${name1 }<br>
</body>
</html>