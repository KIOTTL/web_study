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
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	var key,val,entries;
	$(document).ready(function(){
		showAll();//저장된 로컬스토리지 값을 불러오기
		$('#btn').click(function(){
			var vval = $('#fd').val();
			localStorage.setItem(vval,"");
			$('#fd').val("");
			showAll();
		});
		$('#remove').click(function(){
			var vval = $('#fd').val();
			localStorage.removeItem(vval);
			$('#fd').val("");
			showAll();
		});
		$('#entries').change(function(){ //줄 선택할 때마다 텍스트 필드에 똑같이 뿌려져야 함.
			var str = $(this).val(); //키만 받아옴.
			$('#fd').val(str);
		});
	});
	
	function showAll(){
		val=document.getElementById("fd");
		entries=document.getElementById("entries");
		
		entries.innerHTML="";//이전 항목들을 모두 삭제
		for(var i=0; i<localStorage.length; i++){
			var k=localStorage.key(i);
			entries.options[entries.options.length]=new Option(k);
			//마지막 k가 value값이 되고 그 전에 있는 것들이 option사이의 값들이 된다
		}
	}
/* 	$('#fd').mousedown(function(){
		var x = document.getElementById("entries");    
		x.style.display = "none";
		
	})
	
let test = document.getElementById("fd");	
test.addEventListener("mousedown", function (event) {
	var x = document.getElementById("entries");    
	x.style.display = "none";
}, false); */
let i=0;
function fdclick(){
	if (i==0) {
 		var x = document.getElementById("entries");    
		x.style.display = "inline";
 		var y=document.getElementById("search");
 		y.style.marginTop="10px";
 		i=1;
	} else {
		var x = document.getElementById("entries");
		x.style.display = "none";
		var y=document.getElementById("search");
 		y.style.marginTop="-60px";
		i=0;
	}
	/* var y = document.getElementById("fd");
	y.style.margin-top = "-63px;";
	var z=document.getElementById("entries");
	z.style.margin-top="-70px;"; */
}  
</script>
</head>
<body>
	<header>
		<div class="logo">
			<a href="../main/main.do"><img src="../images/logo_b.png" alt=""></a>
		</div>

		<div class="search" style="margin-top: -60px;" id="search">
		<!-- margin-top: 9px; -->
			<input type="text" placeholder=" NIKE" style=" width: 93%; font-family: sans-serif; font-size: 16px; " id="fd" name="fd" onclick="return fdclick();" >
			<input type="image" src="../images/search_b.png" id="btn" style="">
			<select id="entries" size="5" style="display:none; width: 416px;position: relative; z-index: 2; margin-top: -17px;"></select>
			<input type=button id="remove" style="display: flex; position: relative; z-index: 3;width: 34px; height: 23px; border: lightgrey 1px solid; font-size: 13px; padding-left: 3px; margin-top: -125px; margin-left: 352px; background-color: white;" value="삭제">
<!-- 			<input type="text" placeholder=" NIKE" style="width: 93%; font-family: sans-serif; font-size: 16px; " id="fd" name="fd" onclick="return fdclick();" >
			<input type="image" src="../images/search_b.png" id="btn" style="margin-top: -9px;">
			<select id="entries" size="5" style="width: 416px; position: relative; z-index: 2; margin-top: -18px;"></select>
			<input type=button id="remove" style="display: flex; margin-top: -128px; position: relative; z-index: 3; margin-left: 354px; width: 34px; height: 23px; border: lightgrey 1px solid; font-size: 13px; padding-left: 3px;" value="삭제"> -->
		</div>
		
		<ul>
			<li><a id='LOGIN' href="../account/login.jsp">LOGIN</a></li>
			<li><a id='JOIN' href="../account/join.jsp">JOIN</a></li>
			<li><a id='NOTICE' href="../notice/notice.do">NOTICE</a></li>
		</ul>
		
	</header>
</body>
</html>