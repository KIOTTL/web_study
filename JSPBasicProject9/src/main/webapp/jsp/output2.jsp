<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%--
	JSP 액션태그
	<jsp:~> => xml 태그 ==> 지정된 태그만 사용 가능, 속성 지정된 내용만 사용 가능
						   대소문자 구분
						   속성값 사용시 "" 사용
						   닫는 태그 반드시 사용
						   여는 태그, 닫는 태그 대신 Empty 태그 사용 가능 <a/>
	
	목적 : 최대한으로 자바 코딩 제거
		  <% %> <%! %> <%= %> => 제거
	<jsp:useBean> : 객체 메모리 할당
	  <jsp:useBean id="mb" class="com.sist.dao.MemberBean">
	  		=> MemberBean mb = new MemberBean()
	<jsp:setProperty>
	  <jsp:setProperty name="객체명" property="변수명" value="값">
	  ex) <jsp:setProperty name="mb" property="name" value="박문수">
	  		=> mb.setName("박문수")
	  	  <jsp:setProperty name="mb" property="*">	=> 전체값
	  	  	=> 	String name=request.getParameter("name");
				String sex=request.getParameter("sex");
				String age=request.getParameter("age");
				String address=request.getParameter("address");
				String tel=request.getParameter("tel");
				
				mb.setName(name);
				mb.setSex(sex);
				mb.setAge(Integer.parseInt(age));
				mb.setAddress(address);
				mb.setTel(tel);
	  	  <jsp:setProperty name="mb" property="name">	
	  	  	=> mb.setName(request.getParameter("name"))
	<jsp:getProperty>
	  <jsp:getProperty name="객체명" property="name">
	  	=> <%= mb.getName() %>
	<jsp:include> : JSP 안 특정부분에 다른 JSP 추가 => Spring => 조립식
	  => pageContext.include()
	<jsp:forward> : 오버라이드 => 화면 변경 (URL 변경X => request 보전)					   
 --%>
<jsp:useBean id="mb" class="com.sist.dao.MemberBean">
  <jsp:setProperty name="bean" property="*"/>
</jsp:useBean>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  이름 : <%=mb.getName() %><br>
  이름 : <jsp:getProperty property="name" name="mb"/>
  성별 : <%=mb.getSex() %><br>
  나이 : <%=mb.getAge() %><br>
  주소 : <%=mb.getAddress() %><br>
  전화 : <%=mb.getTel() %>
</body>
</html>