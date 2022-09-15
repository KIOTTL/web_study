<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let i=0;
let u=0;
$(function(){
	$('#del').click(function(){
		if(i==0){
			$('#delTr').show("slow");
			$('#del').text("취소")
			i=1;
		} else {
			$('#delTr').hide();
			$('#del').text("삭제");
			i=0;
		}
	})
	
	// 삭제
	/*
		$('#delBtn')
		let btn=document.querySelector("delBtn")
		=> 태그명($(태그명)), 아이디명($(#아이디명)), 클래스명($(.클래스명))
		인접($(태그명+태그명)), 후손($(태그명 태그명)), 자손(태그명>태그명)
		
		이벤트
		  onclick
		    $("태그명").click(function(){
		    	처리 내용
		    })
		    $("태그명").on("click",function(){
		    	
		    })
		  onmouseover
		  hover
		    $("태그명").hover(function(){
		    	
		    })
		  onchange
		    <select> 
			$('태그명').change(function(){
				
			})
		  onkeydown, onkeyup (searchbar)
		  
		  
		  <input value=> ==> val() 
		  <td>JQuery</td> ==> $("td").text()
		  <a href="data"><img src="data">  ==> $("a").attr("href"), $("img").attr("src")
	*/
	$('#delBtn').on("click",function(){
		let pwd=$('#delPwd').val();
		let no=$(this).attr("data-no");
		if(pwd.trim()==""){
			$("#delPwd").focus();
			return;
		}
		// ajax 요청, 데이터 받기
		//alert("password : "+pwd+"\n번호 : "+no)
		/*
			type => GET/POST
			url => 처리할 URL 주소 => .do
			data => ?() 물음표 뒤의 값		../freeboard/delete.do?no=1&pwd=1111
			success:function(result){
				정상 수행 : 200 ==> text, xml, json			
			}
			error:function(ex){
				에러 : 404, 500, 412, 415, 403, ... 
			}
				
			
			HttpRequest request; // 브라우저에 존재
			request.open("post", "../freeboard/delete.do", true)
			                                               ----비동기
		*/
		$.ajax({
			type:'post',
			url:'../freeboard/delete.do',
			data:{"no":no, "pwd":pwd},
			success:function(result){
				let res=result.trim();
				/* alert(res); */
				if(res=="yes") {	// 정상 수행 (비밀번호가 맞을때)
					location.href="../freeboard/list.do"; // sendRedirect()
				} else {
					alert("비밀번호가 틀립니다");
					$('#delPwd').val("");	// 비밀번호 지우기
					$('#delPwd').focus();
				}
			},
			error:function(err){
				/* alert(err); */
			}
			
		})
	})
	
	// 댓글 수정
	$('.up').click(function(){
		$('.updates').hide();	// 한 개씩 뜨게
		let no=$(this).attr("data-no");
		console.log(no);
		if(u==0) {
			$('#update'+no).show();
			u=1;
		} else {
			$('#update'+no).hide();
			u=0;
		}
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
      <li><a href="#">상세보기</a></li>
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
    <h3 class="sectiontitle">내용보기</h3>
    <div class="two_third first">
     <table class="table">
       <tr>
         <th width=20% class="text-center">번호</th>
         <td width=30% class="text-center">${vo.no }</td>
         <th width=20% class="text-center">작성일</th>
         <td width=30% class="text-center">${vo.dbday }</td>
       </tr>
       <tr>
         <th width=20% class="text-center">이름</th>
         <td width=30% class="text-center">${vo.name }</td>
         <th width=20% class="text-center">조회수</th>
         <td width=30% class="text-center">${vo.hit }</td>
       </tr>
       <tr>
         <th width=20% class="text-center">제목</th>
         <td colspan="3">${vo.subject }</td>
       </tr>
       <tr>
        <td colspan="4" height="200" valign="top" class="text-left">
          <pre style="white-space: pre-wrap;background-color: white;border:none">${vo.content }</pre>
        </td>
       </tr>
       <tr>
         <td colspan="4" class="text-right">
           <a href="../freeboard/update.do?no=${vo.no }" class="btn btn-xs btn-danger">수정</a>
           <span class="btn btn-xs btn-info" id="del">삭제</span>
           <a href="../freeboard/list.do" class="btn btn-xs btn-warning">목록</a>
         </td>
       </tr>
       <tr id="delTr" style="display:none">
         <td colspan="4" class="text-right inline">
          <span>비밀번호:</span><input type=password name=pwd size=10 class="input-sm" id="delPwd">
          <input type=button value="삭제" class="btn btn-sm btn-danger" id="delBtn" data-no="${vo.no }">
         </td>
       </tr>
     </table>
     <div id="comments">    
        <h3>댓글</h3>
        <ul>
         <c:forEach var="rvo" items="${list }">
          <li>
            <article>
              <header>
                <figure class="avatar">
                 <c:if test="${sessionScope.id==rvo.id}"><%-- 본인이면 --%>
                  <span class="btn btn-xs btn-danger up" style="color:black; background-color: white" data-no="${rvo.no }">수정</span>
                  <a href="../reply/reply_delete.do?no=${rvo.no }&bno=${vo.no}" class="btn btn-xs btn-success" style="color:black">삭제</a>
                 </c:if>
                </figure>
                <address>
                By <a href="#">${rvo.name }&nbsp;(${rvo.dbday })</a>
                </address>
              </header>
              <div class="comcont">
                <p><pre style="white-space: pre-wrap;background-color:white;border:none">${rvo.msg }</pre></p>
              </div>
            </article>
            <div style="display:none" id="update${rvo.no }" class="updates">
            <table class="table">
	          <tr>
	            <td>
	             <form method=post action="../reply/reply_update.do">
	               <input type=hidden name=bno value="${vo.no }">
	               <input type=hidden name=type value="1">
	               <input type=hidden name=no value="${rvo.no }">
	               <textarea rows="5" cols="100" name="msg" style="float: left">${rvo.msg }</textarea>
	               <input type=submit class="btn btn-sm btn-primary" style="height: 105px"
	                value="댓글 수정">
	              </form>
	            </td>
	          </tr>
            </table>
            </div>
          </li>
          </c:forEach>
        </ul> 
       </div>
       <c:if test="${sessionScope.id!=null }"><%--로그인시에만 보여준다 --%>
        <table class="table">
          <tr>
            <td>
             <form method=post action="../reply/reply_insert.do">
               <input type=hidden name=bno value="${vo.no }">
               <input type=hidden name=type value="1">
               <textarea rows="5" cols="100" name="msg" style="float: left"></textarea>
               <input type=submit class="btn btn-sm btn-primary" style="height: 105px"
                value="댓글쓰기">
              </form>
            </td>
          </tr>
        </table>
       </c:if>
      </div>
    <div class="one_third">2/3</div>
   </main>
</div>
</body>
</html>