<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

</head>
<body>
	<header>
		<div class="logo">
			<a href="../main/main.do"><img src="../images/logo_b.png" alt=""></a>
		</div>

		<div class="search">
		  <form method=post action="../main/search.do" id="fd" name="fd" style="display:inline;">
			<input type="text" placeholder="검색어 입력" style="width: 93%">
			<input type="image" src="../images/search_b.png">
		  </form>
		</div>
		
		<ul>
			<li><a id='LOGIN' href="../account/login.jsp">LOGIN</a></li>
			<li><a id='JOIN' href="../account/join.jsp">JOIN</a></li>
			<li><a id='NOTICE' href="../notice/notice.do">NOTICE</a></li>
		</ul>
		
	</header>
</body>
</html>