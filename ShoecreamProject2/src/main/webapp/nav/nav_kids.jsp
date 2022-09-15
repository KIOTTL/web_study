<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html style="font-size: 16px;" lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<meta name="keywords" content="">
<meta name="description" content="">
<title>Insert title here</title>
<link rel="stylesheet" href="../home/nicepage2.css" media="screen">
<link rel="stylesheet" href="../home/Home2.css" media="screen">
<script class="u-script" type="text/javascript" src="../home/jquery2.js" "="" defer=""></script>
<script class="u-script" type="text/javascript" src="../home/nicepage2.js" "="" defer=""></script>
<meta name="generator" content="Nicepage 4.15.8, nicepage.com">
<link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
      
      
<script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "",
		"logo": "images/default-logo.png"
}</script>
<meta name="theme-color" content="#478ac9">
<meta property="og:title" content="Home">
<meta property="og:type" content="website">
<meta charset="UTF-8">
</head>
<body class="u-body u-xl-mode" data-lang="en">
<section class="u-clearfix u-section-1" id="sec-6bda">
  <div class="u-clearfix u-sheet u-sheet-1">
  <p class="u-text u-text-default u-text-1">KIDS</p>
  <p class="u-text u-text-default u-text-2">Home &gt; KIDS &gt; 스니커즈</p>
  <div class="u-border-1 u-border-grey-dark-1 u-line u-line-horizontal u-line-1"></div>
  <div class="u-border-1 u-border-grey-dark-1 u-line u-line-horizontal u-line-2"></div>
  <div class="u-list u-list-1">
    <div class="u-repeater u-repeater-1">
      <c:forEach var="vo" items="${list }" varStatus="s">
       	<c:if test="${s.index>=0 && s.index<12 }">
       	  <div class="u-container-style u-list-item u-repeater-item">
            <div class="u-container-layout u-similar-container u-container-layout-1">
              <a href="../shoes/men_list.do?goods_id=${vo.goods_id }"><img class="u-expanded-width u-image u-image-default u-image-1" src="${vo.img }" alt="" data-image-width="400" data-image-height="265"></a>
              <span class="u-icon u-text-palette-1-base u-icon-1">
                <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 51.997 51.997" style="">
                  <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-96b0">
                  </use>
                </svg>
                <svg class="u-svg-content" viewBox="0 0 51.997 51.997" x="0px" y="0px" id="svg-96b0" style="enable-background:new 0 0 51.997 51.997;">
                  <g><path d="M51.911,16.242C51.152,7.888,45.239,1.827,37.839,1.827c-4.93,0-9.444,2.653-11.984,6.905
								c-2.517-4.307-6.846-6.906-11.697-6.906c-7.399,0-13.313,6.061-14.071,14.415c-0.06,0.369-0.306,2.311,0.442,5.478
								c1.078,4.568,3.568,8.723,7.199,12.013l18.115,16.439l18.426-16.438c3.631-3.291,6.121-7.445,7.199-12.014
								C52.216,18.553,51.97,16.611,51.911,16.242z M49.521,21.261c-0.984,4.172-3.265,7.973-6.59,10.985L25.855,47.481L9.072,32.25
								c-3.331-3.018-5.611-6.818-6.596-10.99c-0.708-2.997-0.417-4.69-0.416-4.701l0.015-0.101C2.725,9.139,7.806,3.826,14.158,3.826
								c4.687,0,8.813,2.88,10.771,7.515l0.921,2.183l0.921-2.183c1.927-4.564,6.271-7.514,11.069-7.514
								c6.351,0,11.433,5.313,12.096,12.727C49.938,16.57,50.229,18.264,49.521,21.261z"></path></g>
                </svg>
              </span>
              <p class="u-text u-text-default u-text-3">
              <a href="../shoes/shoes_list.do?brand=${vo.brand }" style="color:black"><span style="text-decoration: underline !important;">${vo.brand }<br></span></a>
              <br>
              </p>
              <p class="u-text u-text-default u-text-4"><a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }" style="color:black">${vo.name_eng }</a></p>
              <p class="u-text u-text-default u-text-4"><a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }" style="color:black">${vo.name_kor }</a></p>
              <a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }" style="color:black"><p class="u-text u-text-default u-text-6"><fmt:formatNumber pattern="#,###" value="${vo.im_buy }"/>원<br></p></a>
              <p class="u-text u-text-default u-text-7">즉시 구매가</p>
              <p class="u-text u-text-default u-text-8">${vo.bookmark }</p>
              <span class="u-icon u-text-palette-1-base u-icon-2">
                <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 51.997 51.997" style="">
                  <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-3069">
                  </use>
                </svg>
                <svg class="u-svg-content" viewBox="0 0 51.997 51.997" x="0px" y="0px" id="svg-3069" style="enable-background:new 0 0 51.997 51.997;">
                <g><path d="M51.911,16.242C51.152,7.888,45.239,1.827,37.839,1.827c-4.93,0-9.444,2.653-11.984,6.905
						c-2.517-4.307-6.846-6.906-11.697-6.906c-7.399,0-13.313,6.061-14.071,14.415c-0.06,0.369-0.306,2.311,0.442,5.478
						c1.078,4.568,3.568,8.723,7.199,12.013l18.115,16.439l18.426-16.438c3.631-3.291,6.121-7.445,7.199-12.014
						C52.216,18.553,51.97,16.611,51.911,16.242z M49.521,21.261c-0.984,4.172-3.265,7.973-6.59,10.985L25.855,47.481L9.072,32.25
						c-3.331-3.018-5.611-6.818-6.596-10.99c-0.708-2.997-0.417-4.69-0.416-4.701l0.015-0.101C2.725,9.139,7.806,3.826,14.158,3.826
						c4.687,0,8.813,2.88,10.771,7.515l0.921,2.183l0.921-2.183c1.927-4.564,6.271-7.514,11.069-7.514
						c6.351,0,11.433,5.313,12.096,12.727C49.938,16.57,50.229,18.264,49.521,21.261z"></path></g>
                </svg>
              </span>
            </div>
       	  </div>
            
        </c:if>
      </c:forEach>
      <!--  -->
            
            
      </div>
    </div>
  </div>
</section>
</body>
</html>