<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List<String> list = new ArrayList<String>();
	list.add("홍길동");
	list.add("심청이");
	list.add("춘향이");
	list.add("박문수");
	list.add("이순신");
	
	// request.setAttribute("list", list);
%>
<c:set var="list" value="<%=list %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h3>자바 for문(일반)</h3>
  <%
  	for(int i=1; i<=10; i++) {
  %>
  		<%=i %>&nbsp;
  <%
  	}
  %>
  <h3>JSTL for문(일반)</h3>
  <%-- end는 포함 end="10" => 10포함 --%>
  <c:forEach var="i" begin="1" end="10" step="1"> <%-- step이 1일 경우 생략 가능, 증가는 가능하지만 감소는 불가능 --%>
    ${i }&nbsp;
  </c:forEach>
  <h3>자바 for-Each</h3>
  <%
  	for (String name:list) {
  %>
  		<%=name %><br>
  <%
  	}
  %>
  <h3>JSTL for-Each</h3>
  <c:forEach var="name" items="${list }">
    ${name }<br>
  </c:forEach>
  <h3>자바 데이터 구분</h3>
  <%
  	String data = "red, green, blue, yellow, white";
  	StringTokenizer st = new StringTokenizer(data, ",");
  	while (st.hasMoreTokens()) {
  %>
  		<%=st.nextToken() %>&nbsp;
  <%
  	}
  %>
  <h3>JSTL 데이터 구분</h3>
  <c:forTokens items="red, green, blue, yellow, white" delims="," var="color">
    ${color }&nbsp;
  </c:forTokens>
</body>
</html>











