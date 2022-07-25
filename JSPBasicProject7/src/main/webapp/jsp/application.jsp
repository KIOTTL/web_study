<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--   <%=application.getMajorVersion() %><br>
  <%=application.getMinorVersion() %><br>
  <%=application.getServerInfo() %> --%>
  <%-- log() : 서버 관리자 --%>
  <%
  	// web.xml 등록된 값 읽기
  	String driver=application.getInitParameter("driver");	// <param-value></param-value>
  	String url=application.getInitParameter("url");
  	String username=application.getInitParameter("username");
  	String password=application.getInitParameter("password");
  	application.log("Driver : "+driver);
  	application.log("URL : "+url);
  	application.log("Username : "+username);
  	application.log("Password : "+password);
  %>
  <%=application.getRealPath("/") %>
</body>
</html>