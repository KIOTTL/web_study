<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html style="font-size: 16px;" lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<meta name="keywords" content="">
<meta name="description" content="">
<title>style</title>
<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script>
function nickname(value) {
	
//	String email=request.getParameter("email");
//	System.out.println("email="+email);
//	int index=email.indexOf("@");
//	String nickname=email.substring(0,index);
    var index=value.indexOf("@");
    var nickname=value.substring(0,index);

    console.log(index);
    console.log(nickname);
    
   /*  var nick = document.getElementsByClassName("nickname");
    console.log(nick);
    
    
   for(var i = 0; i<nick.length; i++){
      return nick[i].innerHTML = nickname; 
    }; */
    
    return document.querySelector(".nickname").text = nickname;

    
    /* return document.getElementById("nickname${vo.id}").innerHTML = nickname; */
}

document.getElementById('sid').submit(); 
</script>

<style type="text/css">
@charset "UTF-8";

header {
	z-index:1;
    display: flex;
    justify-content: space-between;
    align-items: center;
    position: fixed;
    top:0;
    width: 100%;
    background-color: #fff;
    height: 60px;
}

.pagination{
	display: block;
	text-align: center;
}

.pagination > li > a{
	float: none;
	color: black;
	background-color: white;
}
.pagination > li > a:hover{
	color: white;
	background-color: black;
}

.pagination > .active > a, 
.pagination > .active > span, 
.pagination > .active > a:hover, 
.pagination > .active > span:hover, 
.pagination > .active > a:focus, 
.pagination > .active > span:focus {
  background: black;
  color: white;
  border-color: black;
}



</style>

<link rel="stylesheet" href="../home/style/Copy-of-style3.css" media="screen">
<link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
<link id="u-page-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i|Ubuntu:300,300i,400,400i,500,500i,700,700i">
<link id="u-page-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i|Ubuntu:300,300i,400,400i,500,500i,700,700i">
</head>
  <body class="u-body u-xl-mode" data-lang="en">
    <section class="u-align-center u-clearfix u-white u-section-1" id="carousel_4ddb">
      <div class="u-clearfix u-sheet u-sheet-1">
        <div class="u-expanded-width u-tab-links-align-center u-tabs u-tabs-1">
          <ul class="u-spacing-15 u-tab-list u-unstyled" role="tablist">
            <li class="u-tab-item" role="presentation">
              <a class="active u-active-black u-border-3 u-border-active-palette-5-base u-border-no-bottom u-border-no-left u-border-no-right u-button-style u-radius-50 u-tab-link u-text-active-white u-text-body-color u-text-hover-grey-75 u-tab-link-1" id="link-tab-0da5" href="#tab-0da5" role="tab" aria-controls="tab-0da5" aria-selected="true">인기</a>
            </li>
            <li class="u-tab-item" role="presentation">
              <a class="u-active-black u-border-3 u-border-active-palette-5-base u-border-no-bottom u-border-no-left u-border-no-right u-button-style u-radius-50 u-tab-link u-text-active-white u-text-body-color u-text-hover-grey-75 u-tab-link-2" id="link-tab-2917" href="#tab-2917" role="tab" aria-controls="tab-2917" aria-selected="false">최신</a>
            </li>
          </ul>
          <div class="u-tab-content">
            <div class="u-align-left u-container-style u-tab-active u-tab-pane" id="tab-0da5" role="tabpanel" aria-labelledby="link-tab-0da5">
              <div class="u-container-layout u-container-layout-1">
                <div class="u-list u-list-1">
                  <div class="u-repeater u-repeater-1">
                    <div class="u-border-2 u-border-grey-15 u-container-style u-list-item u-radius-50 u-repeater-item u-shape-round" style="border: solid 2px #d9d9d9 ">
                      <div class="u-container-layout u-similar-container u-container-layout-2">
                        <ul class="u-align-center u-custom-list u-spacing-0 u-text u-text-1">
                          <a href="../style/tag.do?tag=nike"><li style="padding-left: 0px; color: black">
                            <div class="u-list-icon">
                              <div xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" xml:space="preserve" class="u-svg-content">#</div>
                            </div>NIKE
                          </li></a>
                        </ul>
                      </div>
                    </div>
                    <div class="u-align-center u-border-2 u-border-grey-15 u-container-style u-list-item u-radius-50 u-repeater-item u-shape-round" style="border: solid 2px #d9d9d9 ">
                      <div class="u-container-layout u-similar-container u-container-layout-3">
                        <ul class="u-align-center u-custom-list u-spacing-0 u-text u-text-2">
                          <a href="../style/tag.do?tag=스트릿"><li style="padding-left: 0px; color: black">
                            <div class="u-list-icon">
                              <div xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" xml:space="preserve" class="u-svg-content">#</div>
                            </div>스트릿
                          </li></a>
                        </ul>
                      </div>
                    </div>
                    <div class="u-align-center u-border-2 u-border-grey-15 u-container-style u-list-item u-radius-50 u-repeater-item u-shape-round" style="border: solid 2px #d9d9d9 ">
                      <div class="u-container-layout u-similar-container u-container-layout-4">
                        <ul class="u-align-center u-custom-list u-spacing-0 u-text u-text-3">
                          <a href="../style/tag.do?tag=OOTD"><li style="padding-left: 0px; color: black">
                            <div class="u-list-icon">
                              <div xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" xml:space="preserve" class="u-svg-content">#</div>
                            </div>OOTD
                          </li></a>
                        </ul>
                      </div>
                    </div>
                    <div class="u-align-center u-border-2 u-border-grey-15 u-container-style u-list-item u-radius-50 u-repeater-item u-shape-round" style="border: solid 2px #d9d9d9 ">
                      <div class="u-container-layout u-similar-container u-container-layout-5">
                        <ul class="u-align-center u-custom-list u-spacing-0 u-text u-text-4">
                          <a href="../style/tag.do?tag=오늘뭐신지"><li style="padding-left: 0px; color: black">
                            <div class="u-list-icon">
                              <div xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" xml:space="preserve" class="u-svg-content">#</div>
                            </div>오늘뭐신지
                          </li></a>
                        </ul>
                      </div>
                    </div>
                    <div class="u-align-center u-border-2 u-border-grey-15 u-container-style u-list-item u-radius-50 u-repeater-item u-shape-round" style="border: solid 2px #d9d9d9 ">
                      <div class="u-container-layout u-similar-container u-container-layout-6">
                        <ul class="u-align-center u-custom-list u-spacing-0 u-text u-text-5">
                          <a href="../style/tag.do?tag=챌린지"><li style="padding-left: 0px; color: black">
                            <div class="u-list-icon">
                              <div xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" xml:space="preserve" class="u-svg-content">#</div>
                            </div>챌린지
                          </li></a>
                        </ul>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="u-list u-list-2">
                  <div class="u-repeater u-repeater-2">
                  <c:forEach var="vo" items="${list2 }">
                    <div class="u-container-style u-list-item u-repeater-item u-shape-rectangle u-white u-list-item-6" style="box-shadow: none;">
                      <div class="u-container-layout u-similar-container u-container-layout-7">
                      <a href="../style/style_detail_before.do?id=${vo.id }"><img class="u-expanded-width u-image u-image-round u-radius-27 u-image-1" alt="" data-image-width="571" data-image-height="713" src="${vo.img }" alt=""></a>
                      <span class="u-file-icon u-icon u-text-palette-5-base u-white u-icon-1" style="margin: 12px auto 0 6px;"><img src="../images/style//64572.png" alt=""></span>
                      <h6 class="u-custom-font u-font-source-sans-pro u-text u-text-default u-text-6 nickname" id="nickname" >${fn:substringBefore(vo.email,'@')}</h6>
                        <input type="hidden" name=id value="${vo.id }">
                        <input type="hidden" name=user_id value="${vo.user_id }">
                        <input type="hidden" name=email value="${vo.email }">
                        <div style="clear: both;"></div>
                        <p class="u-align-left u-small-text u-text u-text-variant u-text-7" style="margin: 15px 16px 0;"><a href="#">${vo.content }</a><br></p>
                        <p class="u-small-text u-text u-text-default u-text-variant u-text-8">${vo.bookmark }&nbsp;</p>
                        <p class="u-small-text u-text u-text-default u-text-variant u-text-9" style="margin: -19px auto 0 85px;">${vo.rcount }&nbsp;</p>
                        <span class="u-file-icon u-icon u-icon-2">
                          <img src="../images/style/heart.png" alt="" style="margin-top: -2px;">
                        </span>
                        <span class="u-file-icon u-icon u-icon-3" style="margin: -26px auto 0 58px; width: 25px; height: 24px;"><img src="../images/style/chat.png" alt=""></span>
                      </div>
                    </div>
                    </c:forEach>
                  </div>
                </div>
              </div>
            </div>
            <div class="u-align-left u-container-style u-tab-pane" id="tab-2917" role="tabpanel" aria-labelledby="link-tab-2917">
              <div class="u-container-layout u-container-layout-11">
              <div class="u-list u-list-3">
                <div class="u-repeater u-repeater-3">
                <c:forEach var="vo" items="${list }">
                  <div class="u-container-style u-list-item u-repeater-item u-shape-rectangle u-white u-list-item-10" style="box-shadow: none;">
                    <div class="u-container-layout u-similar-container u-container-layout-12">
                    <a href="../style/style_detail_before.do?id=${vo.id }"><img class="u-expanded-width u-image u-image-round u-radius-27 u-image-5" alt="" data-image-width="571" data-image-height="713" src="${vo.img }" alt=""></a>
                    <span class="u-file-icon u-icon u-text-palette-5-base u-white u-icon-13"><img src="../images/style//64572.png" alt=""></span>
                      <h6 class="u-custom-font u-font-source-sans-pro u-text u-text-default u-text-22">${fn:substringBefore(vo.email ,'@')}</h6>
                      <input type="hidden" name=id value="${vo.id }">
                      <input type="hidden" name=user_id value="${vo.user_id }">
                      <input type="hidden" name=email value="${vo.email }">
                      <div style="clear: both;"></div>
                        <p class="u-align-left u-small-text u-text u-text-variant u-text-23"><a href="#">${vo.content }</a><br></p>
                        <p class="u-small-text u-text u-text-default u-text-variant u-text-24" style=" margin: 14px auto 0 40px;">${vo.bookmark }&nbsp;</p>
                        <p class="u-small-text u-text u-text-default u-text-variant u-text-25" style="font-size: 0.75rem; margin: -19px auto 0 90px;">${vo.rcount }&nbsp;</p>
                        <span class="u-file-icon u-icon u-icon-14"><img src="../images/style/heart.png" alt="" style="width: 21px; height: 20px"></span>
                        <span class="u-file-icon u-icon u-icon-15"><img src="../images/style/chat.png" alt="" style="margin-top: -3px; width: 25px; height: 24px;"></span>
                    </div>
                  </div>
                </c:forEach>
                </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    
    <div style= "margin-top:100px"></div>
    <nav aria-label="Page navigation example">
		  <ul class="pagination" style="margin-bottom: 0px;">
		    <li class="page-item">
	      
		      <c:if test="${startPage > 1 }">
		      <a class="page-link" href="../nav/nav_style.do?page=${startPage-1 }" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		        <span class="sr-only">Previous</span>
		      </a>
		      </c:if>  
		        
		    </li>
		    
		    <c:forEach var="i" begin="${startPage }" end="${endPage }">            
	            <c:if test="${i==curpage }">
	              <c:set var="style" value="class=active" />
	            </c:if>
	            
	            <c:if test="${i!=curpage }">
	              <c:set var="style" value=""/>
	            </c:if>
	            
	            <li ${style } ><a href="../nav/nav_style.do?page=${i }" >${i }</a></li>
	       </c:forEach>

		    <li class="page-item">
		    
		      <c:if test="${endPage < totalpage }">
		      <a class="page-link" href="../nav/nav_style.do?page=${endPage+1 }" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		        <span class="sr-only">Next</span>
		      </a>
		      </c:if>
		      
		    </li>
		  </ul>
		</nav>
    
    <section class="Bold Brooksspanspan DOCTYPE Inter Regular Semi Storyspanspan absolute all and background background-position background-repeat background-size being body border-bottom-left-radius border-bottom-right-radius border-box border-radius border-top-left-radius border-top-right-radius box-sizing brbr center classnamedivdiv classv3_100divdivdiv classv3_105divdiv classv3_106div classv3_108div classv3_113divdivdivspan classv3_114Your classv3_115philyallenspanspan classv3_116kimross_spanspan classv3_117sandranegraspanspan classv3_118tispandiv classv3_119divspan classv3_122see classv3_123enjoy classv3_124xanderwyattspanspan classv3_125kyia_kaysspanspan classv3_126The classv3_127142 classv3_132divdiv classv3_133divspan classv3_134Liam classv3_135just_liamspandivbodyhtml classv3_71div classv3_72divdiv classv3_73divdiv classv3_74divdiv classv3_75div classv3_76divdivspan classv3_77lovelyspandiv classv3_78divdiv classv3_82div classv3_83divdiv classv3_84divdivdiv classv3_85divdiv classv3_86divdiv classv3_87divdiv classv3_88divdiv classv3_90divdiv classv3_91divdiv classv3_92divdiv classv3_93divdiv classv3_94divdiv classv3_95divdiv classv3_96divdiv classv3_97div classv3_98divdiv classv3_99divdiv color cover easiest existencespanspan fff font-family font-size font-weight fontsgoogleapiscomcssfamilyInterdisplayswap harmonious headbodydiv height hrefhttps htmlhtmlheadlink inner is itspanspan left life likesspandiv name no-repeat of opacity overflow peace position px relative relstylesheet reviews rgba0 rgba225 rgba237 rgba239 rgba38 rgba78 spanspan stress style text-align the top type u-clearfix urlimagesv3_106png urlimagesv3_108png urlimagesv3_113png urlimagesv3_132png urlimagesv3_133png urlimagesv3_72png urlimagesv3_75png urlimagesv3_82png urlimagesv3_85png urlimagesv3_86png urlimagesv3_87png urlimagesv3_88png urlimagesv3_90png urlimagesv3_91png urlimagesv3_92png urlimagesv3_93png urlimagesv3_94png urlimagesv3_95png urlimagesv3_96png urlimagesv3_97png v3_100 v3_105 v3_106 v3_108 v3_113 v3_114 v3_115 v3_116 v3_117 v3_118 v3_119 v3_122 v3_123 v3_124 v3_125 v3_126 v3_127 v3_132 v3_133 v3_134 v3_135 v3_71 v3_72 v3_73 v3_74 v3_75 v3_76 v3_77 v3_78 v3_82 v3_83 v3_84 v3_85 v3_86 v3_87 v3_88 v3_90 v3_91 v3_92 v3_93 v3_94 v3_95 v3_96 v3_97 v3_98 v3_99 width without u-section-2" id="sec-2be0">
      <div class="u-clearfix u-sheet u-sheet-1">
        <a href="../style/insert.do" class="u-border-2 u-border-grey-80 u-btn u-btn-round u-button-style u-custom-font u-font-ubuntu u-grey-80 u-radius-2 u-text-body-alt-color u-btn-1">Write </a>
      </div>
    </section>
    
    <section class="u-backlink u-clearfix u-grey-80">
      <a class="u-link" href="https://nicepage.com/templates" target="_blank">
        <span>Templates</span>
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