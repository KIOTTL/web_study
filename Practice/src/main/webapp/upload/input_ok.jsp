<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.oreilly.servlet.*"%>
<%@ page import="com.oreilly.servlet.multipart.*" %>

<%
	ServletContext context = getServletContext();
	String path = context.getRealPath("/upload");
	System.out.println(path);
	// String path = "C:\\webDev\\webStudy\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\ShoecreamProject2\\style\\image";
	MultipartRequest mr = new MultipartRequest(request, path, 1024*1024*100, "UTF-8", new DefaultFileRenamePolicy());

	// 화면 이동
 	response.sendRedirect("../style/insert.jsp"); 
%>   
