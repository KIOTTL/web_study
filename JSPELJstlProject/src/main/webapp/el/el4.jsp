<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%
	List<String> list = new ArrayList<String>();
	list.add("red");
	list.add("blue");
	list.add("green");
	list.add("yellow");
	list.add("white");
	
	request.setAttribute("list",list);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h3>자바</h3>
  <ul>
    <li><%=list.get(0) %></li>
    <li><%=list.get(1) %></li>
    <li><%=list.get(2) %></li>
    <li><%=list.get(3) %></li>
    <li><%=list.get(4) %></li>
  </ul>
  <h3>자바 루프1</h3>
  <ul>
  <%
  	for(int i=0; i<list.size(); i++) {
  %>
  		<li><%=list.get(i) %></li>
  <%
  	}
  %>
  </ul>
  <h3>자바 루프2</h3>
  <ul>
  <%
  	for(String color:list) {
  %>
  		<li><%=color %></li>
  <%
  	}
  %>
  </ul>
  
  <h3>EL</h3>
  <ul>
    <li>${list[0] }</li>
    <li>${list[1] }</li>
    <li>${list[2] }</li>
    <li>${list[3] }</li>
    <li>${list[4] }</li>
  </ul>
</body>
</html>