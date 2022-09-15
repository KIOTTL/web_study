<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
// request 객체로부터 파라미터를 가져옴.
String content = request.getParameter("content");
String img = request.getParameter("img");
System.out.println(content);
System.out.println(img);
%>

