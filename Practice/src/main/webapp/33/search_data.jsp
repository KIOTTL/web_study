<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Local Storage</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	var key,val,entries;
	$(document).ready(function(){
		showAll();//저장된 로컬스토리지 값을 불러오기
		$('#save').click(function(){
			var kval = $('#k').val();
			var vval = $('#v').val();
			localStorage.setItem(kval, vval);
			$('#k').val(""); //입력된 값들 초기화
			$('#v').val("");
			showAll();
		});
		$('#remove').click(function(){
			var kval = $('#k').val();
			var vval = $('#v').val();
			localStorage.removeItem(kval, vval);
			$('#k').val(""); //입력된 값들 초기화
			$('#v').val("");
			showAll();
		});
		$('#entries').change(function(){ //줄 선택할 때마다 텍스트 필드에 똑같이 뿌려져야 함.
			var str = $(this).val(); //키만 받아옴.
			$('#k').val(str);
			$('#v').val(localStorage.getItem(str));
		});
	});
	
	function showAll(){
		key=document.getElementById("k");
		val=document.getElementById("v");
		entries=document.getElementById("entries");
		
		entries.innerHTML="";//이전 항목들을 모두 삭제
		for(var i=0; i<localStorage.length; i++){
			var k=localStorage.key(i);
			entries.options[entries.options.length]=new Option(k+":"+localStorage[k],k);
			//마지막 k가 value값이 되고 그 전에 있는 것들이 option사이의 값들이 된다
		}
	}

</script>
</head>
<body>
<h1>로컬 스토리지  뷰어</h1>
<!-- 키와 값을 폼으로 받게 함. -->
키 : <input type="text" id="k"><br>
값 : <input type="text" id="v"><br><br>
<button id="save">저장</button>
<button id="remove">삭제</button>
<hr>
<select id="entries" size="5"></select>
<button type="button"> <img src="https://bit.ly/3BF9FD7" height ="80" width="100" /></button>
</body>
</html>