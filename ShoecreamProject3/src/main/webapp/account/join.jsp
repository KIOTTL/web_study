<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JOIN</title>
<link rel="stylesheet" href="../css/join.css" type="text/css">
</head>
<jsp:include page="../main/header.jsp"></jsp:include>
<jsp:include page="../main/nav.jsp"></jsp:include>
<body>
	<form class="wrapper">
			<div class="join_container">
				<div class="join_title">
					<div class="joinmember">JOIN MEMBER</div>
					<div class="join_logo">SHOECREAM</div>
				</div>
				<div class="join_input">
					<p>
						<label class="join_label">이메일</label>
					</p>
					<input type="email" placeholder="이메일 주소">

					<p>
						<label class="join_label">비밀번호</label>
					</p>
					<input class="eye" type="password"
						placeholder="비밀번호 (영문, 숫자 조합 최소 8자)"><br>

					<p>
						<label class="join_label">이름</label>
					</p>
					<input type="text" placeholder="ex)홍길동">

					<p>
						<label class="join_label">핸드폰번호</label>
					</p>
					<input type="number" placeholder="ex)010-0000-0000">
				</div>
				<div class="agree">
					<input type="checkbox">서비스 이용약관에 동의합니다. (필수)<br> <input
						type="checkbox">개인정보 수집 및 이용에 동의합니다. (필수)
				</div>
				<div>
					<input class="join_submit" type="submit" value="회원가입">
				</div>
				<div>
					<input class="join_submit_k" class="kakao" type="submit"
						value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;카카오로 시작하기">
				</div>
			</div>

	</form>

	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>