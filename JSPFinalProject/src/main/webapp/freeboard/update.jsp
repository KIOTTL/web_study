<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#writeBtn').hide();
	$('#writeBtn').click(function(){
		let name=$('#name').val(); 	// 입력한 값 가져오기
		if (name.trim()=="") {		// name 입력 안 했을 경우 커서 깜박임
			$('#name').focus();
			return;
		}
		
		let subject=$('#subject').val(); 	// 입력한 값 가져오기
		if (subject.trim()=="") {
			$('#subject').focus();
			return;
		}
		
		let content=$('#content').val(); 	// 입력한 값 가져오기
		if (content.trim()=="") {
			$('#content').focus();
			return;
		}
		
		let pwd=$('#pwd').val(); 	// 입력한 값 가져오기
		if (pwd.trim()=="") {
			$('#pwd').focus();
			return;
		}
		
		$('#frm').submit();	// 데이터 보내기
		
	})
	
	/*
		vuejs
		axios.get('url',{
			params:{
				no:1,
				pwd:'1234'
			}
		}).then(result=>{})
	*/
	
	$('#pwd').keyup(function(){
		let pwd=$('#pwd').val();
		let no=$('#no').val();
		$.ajax({
			type:'post',
			url:'../freeboard/pwd_check.do',
			data:{"pwd":pwd, "no":no},	// pwd_check.do?pwd=1234&no=1
					
			success:function(result){
				let res=result.trim();
				if (res==="yes"){
					$('#writeBtn').show();
					$('#print').text("")
				} else {
					$('#print').text("비밀번호가 틀렸습니다");
					
				}
			}
		})
	})
})
</script>
</head>
<body>
<div class="wrapper row3">
  <div id="breadcrumb" class="clear"> 
    <!-- ################################################################################################ -->
    <ul>
      <li><a href="#">Home</a></li>
      <li><a href="#">커뮤니티</a></li>
      <li><a href="#">수정하기</a></li>
    </ul>
    <!-- ################################################################################################ --> 
  </div>
</div>
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->
<div class="wrapper row3">
  <main class="container clear"> 
    <!-- main body --> 
    <h3 class="sectiontitle">수정하기(Ajax)</h3>
    <div class="two_third first">
    <form method=post action="../freeboard/update_ok.do" id="frm">
      <table class="table">
        <tr>
          <th width=20% class="text-right">이름</th>
          <td width=80%>
            <input type=text name=name size=15 class="input-sm" id="name" value="${vo.name }">
            <input type=hidden name=no value="${vo.no }" id="no">
          </td>
        </tr>
        <tr>
          <th width=20% class="text-right">제목</th>
          <td width=80%>
            <input type=text name=subject size=50 class="input-sm" id="subject" value="${vo.subject }">
          </td>
        </tr>
        <tr>
          <th width=20% class="text-right">내용</th>
          <td width=80%>
            <textarea rows="10" cols="50" name=content id="content">${vo.content }</textarea>
          </td>
        </tr>
        <tr>
          <th width=20% class="text-right">비밀번호</th>
          <td width=80% class="inline">
            <input type="password" name=pwd size=10 class="input-sm" id="pwd">
            <span id="print" style="color: red"></span>
          </td>
        </tr>
        <tr>
          <td colspan="2" class="text-center">
            <input type=button value="글쓰기" class="btn btn-sm btn-success" id="writeBtn">
            <input type=button value="취소" class="btn btn-sm btn-info" onclick="javascript:history.back()">
          </td>
        </tr>
      </table>
    </form>
    </div>
    <div class="one_third">2/3</div>
  </main>
</div>
</body>
</html>