<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOECREAM</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/earlyaccess/nanumgothic.css"
	type='text/css'>
<link rel="stylesheet" href="../css/header2.css" type="text/css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	
		$('#LOGOUT').click(function(){
		location.href="../account/logout.do";
	})
	
})
</script>
</head>
<body>
	<header>
		<div class="logo">
			<a href="../main/main.do"><img src="../images/logo_b.png" alt=""></a>
		</div>

		<div class="search">
		  <form method="post" action="../main/search.do">
			<input type="text" placeholder=" NIKE" style="width: 93%; font-family: sans-serif; font-size: 16px; id="fd" name="fd" value="${fd}" onKeypress="javascript:if(event.keyCode==13) {search_onclick_submit}" >
			<input type="image" src="../images/search_b.png" id="btn" onclick="search_onclick_submit">
	      </form>
		</div>
		
		<ul>
		  <c:if test="${sessionScope.email==null }">
            <li><a id='LOGIN' href="../account/login.do">LOGIN</a></li>
          </c:if>
          <c:if test="${sessionScope.email!=null }">
            <li><a id='LOGOUT'>LOGOUT</a></li>
          </c:if>
			<!-- <li><a id='LOGIN' href="../account/login.jsp">LOGIN</a></li> -->
			<li><a id='JOIN' href="../account/join.jsp">JOIN</a></li>
			<li><a id='NOTICE' href="../mypage/mypage_style.do">NOTICE</a></li>
		</ul>
		
	</header>
</body>
</html>