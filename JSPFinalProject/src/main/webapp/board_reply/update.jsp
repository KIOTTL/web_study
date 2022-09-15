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
      <li><a href="#">묻고 답하기</a></li>
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
    <h3 class="sectiontitle">수정하기</h3>
    <div class="two_third first">
    <form method=post action="../board_reply/update_ok.do" id="frm">
      <table class="table">
        <tr>
          <th width=20% class="text-right">이름</th>
          <td width=80%>
            <input type=text name=name size=15 class="input-sm" id="name" value="${vo.name }">
            <input type=hidden name=no value="${vo.no }">
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
          <td width=80%>
            <input type="password" name=pwd size=10 class="input-sm" id="pwd" readonly value=${vo.pwd }>
          </td>
        </tr>
        <tr>
          <td colspan="2" class="text-center">
            <input type=button value="수정하기" class="btn btn-sm btn-success" id="writeBtn">
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