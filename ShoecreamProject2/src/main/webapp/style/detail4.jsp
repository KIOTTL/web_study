<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../home/style/detail/style-detail.css" media="screen">
<link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
<link id="u-page-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
<script>
function timeForToday(value) {
    const today = new Date();
    const timeValue = new Date(value);

    const betweenTime = Math.floor((today.getTime() - timeValue.getTime()) / 1000 / 60);
    if (betweenTime < 1) return '방금전';
    if (betweenTime < 60) {
        return document.getElementById("time").innerHTML = betweenTime+"분 전";
    }

    const betweenTimeHour = Math.floor(betweenTime / 60);
    if (betweenTimeHour < 24) {
        return document.getElementById("time").innerHTML = betweenTimeHour+"시간 전";
    }

    const betweenTimeDay = Math.floor(betweenTime / 60 / 24);
    if (betweenTimeDay < 7) {
        return document.getElementById("time").innerHTML = betweenTimeDay+"일 전";
    }
    
    const betweenTimeWeek = Math.floor(betweenTimeDay / 7);
    if (betweenTimeWeek < 5) {
        return document.getElementById("time").innerHTML = betweenTimeWeek+"주 전";
    }
    
    const betweenTimeMonth = Math.floor(betweenTimeDay / 30);
    if (betweenTimeMonth < 12) {
        return document.getElementById("time").innerHTML = betweenTimeMonth+"개월 전";
    }

    return document.getElementById("time").innerHTML = Math.floor(betweenTimeDay / 365)+"년전";
}

function timeForToday2(value) {
	
	
	var today = new Date();
	var timeValue = new Date(value);
	/* let id=document.getElementByClassName("ti2")[0].value
	console.log(id) */
	
	
	var betweenTime = Math.floor((today.getTime() - timeValue.getTime()) / 1000 / 60);
	if (betweenTime < 1) return '방금전';
	if (betweenTime < 60) {
	    return document.getElementById("time2").innerHTML = betweenTime+"분 전";
	}

	var betweenTimeHour = Math.floor(betweenTime / 60);
	if (betweenTimeHour < 24) {
		console.log(betweenTimeHour);
	    return document.getElementById("time2").innerHTML = betweenTimeHour+"시간 전";
	}

	var betweenTimeDay = Math.floor(betweenTime / 60 / 24);
	if (betweenTimeDay < 7) {
		console.log(betweenTimeDay);
	    return document.getElementById("time2").innerHTML = betweenTimeDay+"일 전";
	}
	
	var betweenTimeWeek = Math.floor(betweenTimeDay / 7);
	if (betweenTimeWeek < 5) {
		console.log(betweenTimeWeek);
	    return document.getElementById("time2").innerHTML = betweenTimeWeek+"주 전";
	}
	
	var betweenTimeMonth = Math.floor(betweenTimeDay / 30);
	if (betweenTimeMonth < 12) {
	    return document.getElementById("time2").innerHTML = betweenTimeMonth+"개월 전";
	}

	return document.getElementById("time2").innerHTML = Math.floor(betweenTimeDay / 365)+"년전";
	

}

</script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let i=0;

$(function(){
	$('.re').click(function(){
		let id=$(this).attr("data-no");
		console.log(id);
		$('.rereply').hide();
		if(i==0){
			$('#reply'+id).show("slow");
			$('#writerp'+id).text("취소")
			i=1;
		} else {
			$('#reply'+id).hide();
			$('#writerp'+id).text("답글쓰기");
			i=0;
		}
	})
}) 
var u=$('#data').attr('data-id');
	console.log(u);
</script>
</head>
<body class="u-body u-xl-mode" data-lang="en">
    <section class="u-clearfix u-section-1" id="sec-3134">
      <div class="u-clearfix u-sheet u-sheet-1"><span class="u-file-icon u-icon u-text-palette-5-base u-white u-icon-1"><img src="../home/style/images/64572.png" alt=""></span>
        <h4 class="u-custom-font u-font-source-sans-pro u-text u-text-default u-text-1">namename</h4>
        <h6 class="u-custom-font u-font-open-sans u-text u-text-default u-text-grey-25 u-text-2 ti" id="time" value="${vo.id }"><script>timeForToday("${vo.dbday}")</script></h6>
      </div>
    </section>
    <section class="u-clearfix u-section-2" id="sec-6e73" style="margin-top: -120px;">
      <div class="u-align-left u-clearfix u-sheet u-sheet-1">
        <img class="u-image u-image-default u-image-1" src="${vo.img }" alt="" data-image-width="571" data-image-height="713">
      </div>
    </section>
    <section class="u-clearfix u-section-3" id="sec-ab75" style="margin-top: -120px;">
      <div class="u-clearfix u-sheet u-valign-middle u-sheet-1">
        <span class="u-file-icon u-icon u-icon-1"><img src="../home/style/images/1077035.png" alt=""></span>
        <span class="u-file-icon u-icon u-icon-2"><img src="../home/style/images/589671.png" alt=""></span>
      </div>
    </section>
    <section class="u-clearfix u-section-4" id="sec-e3a3" style="margin-top: -120px;">
      <div class="u-align-left u-clearfix u-sheet u-valign-middle u-sheet-1">
        <h5 class="u-custom-font u-font-open-sans u-text u-text-1">${vo.content }</h5>
      </div>
    </section>
    <section class="u-clearfix u-section-5" id="sec-0104" style="margin-top: -120px;">
      <div class="u-clearfix u-sheet u-sheet-1">
        <div class="u-container-style u-group u-shape-rectangle u-group-1">
          <div class="u-container-layout u-container-layout-1">
            <h6 class="u-text u-text-default u-text-1">댓글 ${vo.rcount }개</h6>
            <!-- <h6 class="u-custom-font u-font-source-sans-pro u-text u-text-2">namename</h6>
            <h6 class="u-custom-font u-font-source-sans-pro u-text u-text-default u-text-3">안녕하세요</h6>
            <h6 class="u-custom-font u-font-source-sans-pro u-text u-text-default u-text-4">namename2</h6>
            <h6 class="u-custom-font u-font-source-sans-pro u-text u-text-default u-text-5">반갑습니다</h6> -->
            <div class="u-expanded-width u-table u-table-responsive u-table-1">
              <table class="u-table-entity" style="margin-top: 70px;">
                <colgroup>
                  <col width="81.6%">
                  <col width="8.3%">
                  <col width="10.1%">
                </colgroup>
                <tbody class="u-table-body">
                <c:forEach var="svo" items="${list }">
                  <tr style="height: 25px;" id="reply">
                    <td class="u-table-cell u-table-valign-middle u-table-cell-1">
             		  <c:if test="${svo.group_tab>0 }">
		                <%-- for(int i=0; i<vo.getGroup_tab(); i++) --%>
		                <c:forEach var="i" begin="1" end="${svo.group_tab }" step="1">
		                  &nbsp;&nbsp;&nbsp;&nbsp;
		                </c:forEach>
		              </c:if>
                      <span class="u-file-icon u-icon u-text-palette-5-base u-white u-icon-1"><img src="../home/style/images/64572.png" alt=""></span>&nbsp; 
                      ${svo.name }&nbsp;
            		  <span style="font-weight: normal">${svo.content }</span>
                    </td>
                    <td style="display:none" class="data">${svo.id }</td>
                    <td class="u-align-center u-table-cell u-table-valign-middle u-text-grey-25 u-table-cell-2 ti2" style="font-size: 0.675rem;" id="time2" value="${svo.id }"><script>timeForToday2("${svo.dbday }")</script></td>
                    <c:if test="${svo.group_tab<1 }">
                    <td class="u-align-center u-table-cell u-table-valign-middle u-text-palette-5-dark-1 u-table-cell-2 re" data-no="${svo.id }"><a href="#" style="color:#858e99" id="writerp${svo.id}" data-no="${svo.id }" onclick="return false">답글쓰기</a></td>
                    </c:if>
                  </tr>
                  <form method=post action="../stylereply/rereply_insert.do"> 
                  <tr id="reply${svo.id }" style="display:none" class="rereply">
			         <td colspan="3" class="text-right inline" style="display: flex;">
			          <input type=hidden name=sid value="${vo.id }">
			          <input type=hidden name=id value="${svo.id }">
			          <input type=hidden name=group_id value="${svo.group_id }">
			          <input type=hidden name=group_step value="${svo.group_step }">
			          <input type=hidden name=group_tab value="${svo.group_tab }">
			          <input type=hidden name=name value="shim">
			          <textarea placeholder="답글 작성.." rows="1" cols="50" name="content" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-radius-18" required="" style="border: 1px solid; border-color: #b3b3b3; height: 48px;"></textarea>
			          <input type=submit value="작성" class="u-black u-btn u-btn-submit u-button-style u-custom-font u-font-open-sans u-btn-1" id="writeBtn${svo.id }" data-no="${svo.id }" style="margin-left: 10px;  margin-top: 8px;">
			         </td>
			      </tr>
                  </form>
                  <%-- <div style="display:none" id="reply${svo.id }" class="updates">
		            <table class="table">
			          <tr>
			            <td>
			             <form method=post action="../reply/reply_update.do">
			               <input type=hidden name=sid value="${vo.id }">
			               <input type=hidden name=type value="1">
			               <input type=hidden name=id value="${svo.id }">
			               <textarea rows="5" cols="100" name="msg" style="float: left"></textarea>
			               <input type=submit class="btn btn-sm btn-primary" style="height: 105px"
			                value="댓글 수정">
			              </form>
			            </td>
			          </tr>
		            </table>
		          </div> --%>
                  <!-- <tr style="height: 26px;">
                    <td class="u-table-cell u-table-valign-middle u-table-cell-2"><span class="u-file-icon u-icon u-text-white u-white u-icon-2"><img src="../home/style/images/64572-3.png" alt=""></span><span class="u-file-icon u-icon u-text-palette-5-base u-white u-icon-3"><img src="../home/style/images/64572.png" alt=""></span>&nbsp;&nbsp;
                      namename2&nbsp;
            		  <span style="font-weight: normal">반갑습니다</span>
                    </td>
                    <td class="u-align-center u-table-cell u-table-valign-middle u-text-grey-25 u-table-cell-2">어제</td>
                    <td class="u-align-center u-table-cell u-table-valign-middle u-text-palette-5-dark-1 u-table-cell-2">답글쓰기</td>
                  </tr> -->
                  </c:forEach>
                </tbody>
              </table>
            </div>
            <div class="u-form u-form-1">
              <form method=post action="../stylereply/reply_insert.do">
              <%-- <class="u-clearfix u-form-spacing-15 u-form-vertical u-inner-form" style="padding: 15px;" name="form"> --%>
                <input type=hidden name=sid value="${vo.id }">
                <input type=hidden name=name value="hong">
                <div class="u-form-group u-form-message u-label-top u-form-group-1">
                  <!-- <label for="message-6797" class="u-label">Comment</label> -->
                  <textarea placeholder="댓글 작성.." rows="2" cols="50" id="message-6797" name="content" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-radius-18" required="" style="border: 1px solid; border-color: #b3b3b3;"></textarea>
                </div>
                <div class="u-align-right u-form-group u-form-submit u-label-top u-form-group-2">
                  <!-- <a href="#" class="u-black u-btn u-btn-submit u-button-style u-custom-font u-font-open-sans u-btn-1">댓글</a> -->
                  <input type=submit value="댓글" class="u-black u-btn u-btn-submit u-button-style u-custom-font u-font-open-sans u-btn-1">
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </section>
    
    
    
    <section class="u-backlink u-clearfix u-grey-80">
      <a class="u-link" href="https://nicepage.com/website-templates" target="_blank">
        <span>Website Templates</span>
      </a>
      <p class="u-text">
        <span>created with</span>
      </p>
      <a class="u-link" href="" target="_blank">
        <span>Website Builder Software</span>
      </a>. 
    </section>
</body>
</html>