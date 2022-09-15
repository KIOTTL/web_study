<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JOIN</title>
<link rel="stylesheet" href="../css/join.css" type="text/css">
<script type="text/javascript" src="http://jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	
	// 이메일 중복 체크
	$('#eBtn').click(function(){	
			let email=$('#email').val();
			if(email.trim()==""){
				$("#email").focus();
				$('#ePrint').text("이메일을 입력하세요")
				return;
			}
			
			 $.ajax({
				type:'post',
				url:'../account/email_check.do',
				data:{"email":email},
				success:function(result){
					let count=parseInt(result.trim());
					if(count==0){
						$('#ePrint').text("사용가능한 이메일입니다");
						$('#email').attr('readonly',true);
					} else {
						$('#ePrint').text("사용 중인 이메일입니다");
						$('#email').val("");
						$('#email').focus();
					}
				}
				
			}) 
	})
	
	// 전화번호 중복 체크
	$('#tBtn').click(function(){	
			let tel=$('#tel').val();
			if(tel.trim()==""){
				$("#tel").focus();
				$('#tPrint').text("전화번호를 입력하세요")
				return;
			}
			
			$.ajax({
				type:'post',
				url:'../account/tel_check.do',
				data:{"tel":tel},
				success:function(result){
					let count=parseInt(result.trim());
					if(count==0){
						$('#tPrint').text("사용가능한 전화번호입니다");
						$('#tel').attr('readonly',true);
					} else {
						$('#tPrint').text("사용 중인 전화번호입니다");
						$('#tel').val("");
						$('#tel').focus();
					}
				}
				
			})
	})
	
 	$('#joinBtn').click(function(){
		// 유효성 검사
		$('#join_frm').submit();	
		// <input type=submit>
	}) 
})
</script>

</head>
<jsp:include page="../main/header.jsp"></jsp:include>
<jsp:include page="../main/nav.jsp"></jsp:include>
<body>
	<form class="wrapper" method="post" action="../account/join_ok.do" name="join_frm" id="join_frm">
			<div class="join_container">
				<div class="join_title">
					<div class="joinmember">JOIN MEMBER</div>
					<div class="join_logo">SHOECREAM</div>
				</div>
				<div class="join_input">
					<p>
						<label class="join_label">이메일</label>
					</p>
					<input type="email" placeholder="이메일 주소" name="email" id="email">
					<input type="button" id="eBtn" value="이메일 확인">
					&nbsp;<span style="color:blue" id="ePrint"></span>

					<p>
						<label class="join_label">비밀번호</label>
					</p>
					<input class="eye" type="password"
						placeholder="비밀번호 (영문, 숫자 조합 최소 8자)" name="pwd" id=join_pwd><br>

					<p>
						<label class="join_label">이름</label>
					</p>
					<input type="text" placeholder="ex)홍길동" name="name" id=name>

					<p>
						<label class="join_label">핸드폰번호</label>
					</p>
					<input type="number" placeholder="ex)010-0000-0000" name="tel" id=tel>
					<input type="button" id="tBtn" value="전화번호 확인">
					&nbsp;<span style="color:blue" id="tPrint"></span>
				</div>
				<div class="agree">
					<input type="checkbox">서비스 이용약관에 동의합니다. (필수)<br> <input
						type="checkbox">개인정보 수집 및 이용에 동의합니다. (필수)
				</div>
				<div>
					<input class="join_submit" type="submit" value="회원가입" id="joinBtn">
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