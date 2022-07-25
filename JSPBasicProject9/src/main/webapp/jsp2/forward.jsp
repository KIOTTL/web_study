<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <jsp:forward page="output.jsp"></jsp:forward> --%>
<%
	RequestDispatcher rd = request.getRequestDispatcher("output.jsp");
	rd.forward(request, response);
%>