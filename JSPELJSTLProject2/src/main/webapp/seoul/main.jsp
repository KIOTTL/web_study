<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 50px;
}
.row{
	margin: 0px auto;
	width: 700px;
}
</style>
<script type="text/javascript">
/*
 * 	1. 이벤트 구동 방식 => 사용자가 행위를 했을 때 처리해주는 기능
 	2. 자동 지정 변수를 가지고 있다
 		let(ES6), var(ES5)
 		const(상수형 변수)
 		
 		var의 단점 ==> scope가 명확하지 않다
 		let ==> scoper가 명확하다
 		
 		function func_name() {
 			if () {
 				var i=10;	// {}블럭을 벗어나도 사용 가능
 				let j=20;	// {}블럭 안에서만 사용 가능 ==> 지역변수가 명확
 			}
 			alert(i);
 			alert(j);
 		}
 		
 		let a=10; ==> a:int
 		let a=10.5; ==> a:double	
 		let a='aaa'; ==> a:String
 		let a=[]; ==> a:Array
 		let a={}; ==> a:Object
 		let a=function(){} ==> a:function
 		==> 자동으로 인식
 		
 		function funcName() {		==> 리턴형x, 매개변수에 데이터형x
 			return 값 (필수x)
 		}

 		function funcName(let a) {		==> 오류
 			return 값
 		}

 		function funcName(a) {		
 			return 값
 		}
 		
 		let func_name=function(){}
 		
 		let func_name()=>{} 	==========> 람다식
 					  ---- function, return을 제외 (함수 포인터)
 	3. 변수 설정 => 연산자
 				  제어문 => map(), for-of for-in
 	4. 내장 객체
 	5. DOMScript
 	6. 객체지향 => 클래스형
 	---------------------------------------------------------
 	7. 라이브러리(Jquery(ajax), Vue, React, vuex, Redux)
 			  -------------
 			  로그인, 아이디 중복 체크, 검색, ...
 */
function locationLink() {
 	location.href="location.jsp";	// locBtn 버튼 클릭시 화면 이동
}
let natureLink=()=>{
	location.href="nature.jsp";		// natBtn 버튼 클릭시 화면 이동
}
let foodLink=()=>{
	location.href="../food/category.jsp";
}
let boardLink=()=>{
	location.href="../board/list.jsp";
}
</script>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="text-center">
        <input type=button id="locBtn" value="명소" class="btn btn-lg btn-success" onclick="locationLink()">
        <input type=button id="natBtn" value="자연" class="btn btn-lg btn-info" onclick="natureLink()">
        <input type=button id="foodBtn" value="맛집" class="btn btn-lg btn-danger" onclick="foodLink()">
        <input type=button id="boardBtn" value="자유게시판" class="btn btn-lg btn-warning" onclick="boardLink()">
      </div>
    </div>
  </div>
</body>
</html>














