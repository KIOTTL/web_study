<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
img {
	background-color: #f9f9f9;
}
.u-text-3 {
	font-size: 15px;
	text-decoration : underline;
	font-weight: bold;
}
.u-text-5 {
	font-weight: bolder;
}
.u-text-6 {
	font-size: 13px;
}

</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let i=0;
$(function(){
	$('#popmore').click(function(){
		if(i==0){
			$('#popTr').show("slow");
			$('#popmore').hide()
		}
	})
	$('#newmore').click(function(){
		if(i==0){
			$('#newTr').show("slow");
			$('#newmore').hide()
		}
	})
	$('#premore').click(function(){
		if(i==0){
			$('#preTr').show("slow");
			$('#premore').hide()
		}
	})
})

</script>
</head>
<body>
  <section class="u-carousel u-slide u-block-24a1-1" id="carousel_1d20" data-interval="5000" data-u-ride="carousel">
    <ol class="u-absolute-hcenter u-carousel-indicators u-block-24a1-2">
      <li data-u-target="#carousel_1d20" class="u-active u-grey-30" data-u-slide-to="0"></li>
    </ol>
    <div class="u-carousel-inner" role="listbox">
      <div class="u-active u-carousel-item u-clearfix u-section-1-1">
        <div class="u-clearfix u-sheet u-sheet-1"></div>
      </div>
    </div>
    <a class="u-absolute-vcenter u-carousel-control u-carousel-control-prev u-text-grey-30 u-block-24a1-3" href="#carousel_1d20" role="button" data-u-slide="prev">
      <span aria-hidden="true">
        <svg viewBox="0 0 451.847 451.847"><path d="M97.141,225.92c0-8.095,3.091-16.192,9.259-22.366L300.689,9.27c12.359-12.359,32.397-12.359,44.751,0
						c12.354,12.354,12.354,32.388,0,44.748L173.525,225.92l171.903,171.909c12.354,12.354,12.354,32.391,0,44.744
						c-12.354,12.365-32.386,12.365-44.745,0l-194.29-194.281C100.226,242.115,97.141,234.018,97.141,225.92z"></path>
        </svg>
      </span>
      <span class="sr-only">
        <svg viewBox="0 0 451.847 451.847"><path d="M97.141,225.92c0-8.095,3.091-16.192,9.259-22.366L300.689,9.27c12.359-12.359,32.397-12.359,44.751,0
						c12.354,12.354,12.354,32.388,0,44.748L173.525,225.92l171.903,171.909c12.354,12.354,12.354,32.391,0,44.744
						c-12.354,12.365-32.386,12.365-44.745,0l-194.29-194.281C100.226,242.115,97.141,234.018,97.141,225.92z"></path>
        </svg>
      </span>
    </a>
    <a class="u-absolute-vcenter u-carousel-control u-carousel-control-next u-text-grey-30 u-block-24a1-4" href="#carousel_1d20" role="button" data-u-slide="next">
      <span aria-hidden="true">
        <svg viewBox="0 0 451.846 451.847"><path d="M345.441,248.292L151.154,442.573c-12.359,12.365-32.397,12.365-44.75,0c-12.354-12.354-12.354-32.391,0-44.744
						L278.318,225.92L106.409,54.017c-12.354-12.359-12.354-32.394,0-44.748c12.354-12.359,32.391-12.359,44.75,0l194.287,194.284
						c6.177,6.18,9.262,14.271,9.262,22.366C354.708,234.018,351.617,242.115,345.441,248.292z"></path>
        </svg>
      </span>
      <span class="sr-only">
        <svg viewBox="0 0 451.846 451.847"><path d="M345.441,248.292L151.154,442.573c-12.359,12.365-32.397,12.365-44.75,0c-12.354-12.354-12.354-32.391,0-44.744
						L278.318,225.92L106.409,54.017c-12.354-12.359-12.354-32.394,0-44.748c12.354-12.359,32.391-12.359,44.75,0l194.287,194.284
						c6.177,6.18,9.262,14.271,9.262,22.366C354.708,234.018,351.617,242.115,345.441,248.292z"></path>
		</svg>
      </span>
    </a>
  </section>
  
  <div  class="home_margin" >
  <div style= "margin-top:100px"></div>
  <section class="u-clearfix u-section-2" id="sec-9192">
    <div class="u-clearfix u-sheet u-sheet-1">
      <p class="u-large-text u-text u-text-default u-text-variant u-text-1" style="font-weight: 650">Most Popular</p>
      <p class="u-text u-text-default u-text-2" style="color: #8C8C8C">인기 상품</p>
      <div class="u-expanded-width u-list u-list-1">
        <div class="u-repeater u-repeater-1">
        <c:forEach var="vo" items="${list }" varStatus="s">
        <c:if test="${s.index>=0 && s.index<8 }">
          <div class="u-align-left u-container-style u-list-item u-repeater-item">
            <div class="u-container-layout u-similar-container u-container-layout-1">
              <a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }"><img class="u-expanded-width u-image u-image-default u-image-1" src="${vo.img }" alt="" data-image-width="400" data-image-height="265" ></a>
              <span class="u-icon u-text-palette-1-base u-icon-1">
                <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 51.997 51.997" style="">
                  <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-46bd"></use>
                </svg>
                <svg class="u-svg-content" viewBox="0 0 51.997 51.997" x="0px" y="0px" id="svg-46bd" style="enable-background:new 0 0 51.997 51.997;">
                  <g><path d="M51.911,16.242C51.152,7.888,45.239,1.827,37.839,1.827c-4.93,0-9.444,2.653-11.984,6.905
							c-2.517-4.307-6.846-6.906-11.697-6.906c-7.399,0-13.313,6.061-14.071,14.415c-0.06,0.369-0.306,2.311,0.442,5.478
							c1.078,4.568,3.568,8.723,7.199,12.013l18.115,16.439l18.426-16.438c3.631-3.291,6.121-7.445,7.199-12.014
							C52.216,18.553,51.97,16.611,51.911,16.242z M49.521,21.261c-0.984,4.172-3.265,7.973-6.59,10.985L25.855,47.481L9.072,32.25
							c-3.331-3.018-5.611-6.818-6.596-10.99c-0.708-2.997-0.417-4.69-0.416-4.701l0.015-0.101C2.725,9.139,7.806,3.826,14.158,3.826
							c4.687,0,8.813,2.88,10.771,7.515l0.921,2.183l0.921-2.183c1.927-4.564,6.271-7.514,11.069-7.514
							c6.351,0,11.433,5.313,12.096,12.727C49.938,16.57,50.229,18.264,49.521,21.261z">
				  </path></g>
			    </svg>
              </span>
              <a href="../shoes/shoes_list.do?brand=${vo.brand }" style="color:black"><p class="u-text u-text-default u-text-3">${vo.brand }<br></p></a>
              <p class="u-text u-text-default u-text-4"><a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }" style="color:black">${vo.name_eng }</a></p>
              <a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }" style="color:black"><p class="u-text u-text-default u-text-5"><fmt:formatNumber pattern="#,###" value="${vo.im_buy }"/>원<br></p></a>
              <p class="u-text u-text-default u-text-6"><a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }" style="color:#A6A6A6">즉시구매가</a><br></p>
            </div>
          </div>
        </c:if>
        </c:forEach>
        </div>
      </div>
      <span class="u-border-2 u-border-hover-palette-1-base u-border-palette-1-base u-btn u-btn-round u-button-style u-hover-palette-1-base u-none u-radius-50 u-btn-1" id="popmore">more</span>
       <div class="u-expanded-width u-list u-list-1" id="popTr" style="display:none">
        <div class="u-repeater u-repeater-1">
        <c:forEach var="vo" items="${list }" varStatus="s">
        <c:if test="${s.index>=8 && s.index<16 }">
          <div class="u-align-left u-container-style u-list-item u-repeater-item">
            <div class="u-container-layout u-similar-container u-container-layout-1">
              <a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }"><img class="u-expanded-width u-image u-image-default u-image-1" src="${vo.img }" alt="" data-image-width="400" data-image-height="265" ></a>
              <span class="u-icon u-text-palette-1-base u-icon-1">
                <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 51.997 51.997" style="">
                  <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-46bd"></use>
                </svg>
                <svg class="u-svg-content" viewBox="0 0 51.997 51.997" x="0px" y="0px" id="svg-46bd" style="enable-background:new 0 0 51.997 51.997;">
                  <g><path d="M51.911,16.242C51.152,7.888,45.239,1.827,37.839,1.827c-4.93,0-9.444,2.653-11.984,6.905
							c-2.517-4.307-6.846-6.906-11.697-6.906c-7.399,0-13.313,6.061-14.071,14.415c-0.06,0.369-0.306,2.311,0.442,5.478
							c1.078,4.568,3.568,8.723,7.199,12.013l18.115,16.439l18.426-16.438c3.631-3.291,6.121-7.445,7.199-12.014
							C52.216,18.553,51.97,16.611,51.911,16.242z M49.521,21.261c-0.984,4.172-3.265,7.973-6.59,10.985L25.855,47.481L9.072,32.25
							c-3.331-3.018-5.611-6.818-6.596-10.99c-0.708-2.997-0.417-4.69-0.416-4.701l0.015-0.101C2.725,9.139,7.806,3.826,14.158,3.826
							c4.687,0,8.813,2.88,10.771,7.515l0.921,2.183l0.921-2.183c1.927-4.564,6.271-7.514,11.069-7.514
							c6.351,0,11.433,5.313,12.096,12.727C49.938,16.57,50.229,18.264,49.521,21.261z">
				  </path></g>
			    </svg>
              </span>
              <a href="../shoes/shoes_list.do?brand=${vo.brand }" style="color:black"><p class="u-text u-text-default u-text-3">${vo.brand }<br></p></a>
              <p class="u-text u-text-default u-text-4"><a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }" style="color:black">${vo.name_eng }</a></p>
              <a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }" style="color:black"><p class="u-text u-text-default u-text-5"><fmt:formatNumber pattern="#,###" value="${vo.im_buy }"/>원<br></p></a>
              <p class="u-text u-text-default u-text-6"><a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }" style="color:#A6A6A6">즉시구매가</a><br></p>
            </div>
          </div>
        </c:if>
        </c:forEach>
        </div>
      </div>
    </div>
  </section>
  <div style= "margin-top:100px"></div>
  <section class="u-align-center u-clearfix u-section-3" id="sec-5be6">
    <div class="u-clearfix u-sheet u-sheet-1">
      <h1 class="u-text u-text-default u-text-1">Style</h1>
      <div class="u-list u-list-1">
        <div class="u-repeater u-repeater-1">
          <div class="u-container-style u-list-item u-repeater-item">
            <div class="u-container-layout u-similar-container u-container-layout-1">
              <p class="u-custom-item u-text u-text-2">#style</p>
            </div>
          </div>
          <div class="u-container-style u-list-item u-repeater-item">
            <div class="u-container-layout u-similar-container u-container-layout-2">
              <p class="u-custom-item u-text u-text-default u-text-3" style="font-size: 16px; text-decoration-line: none; font-weight: normal">#style</p>
            </div>
          </div>
          <div class="u-container-style u-list-item u-repeater-item">
            <div class="u-container-layout u-similar-container u-container-layout-3">
              <p class="u-custom-item u-text u-text-default u-text-4" style="font-size: 16px">#style</p>
            </div>
          </div>
          <div class="u-container-style u-list-item u-repeater-item">
            <div class="u-container-layout u-similar-container u-container-layout-4">
              <p class="u-custom-item u-text u-text-default u-text-5" style="font-size: 16px; font-weight: normal">#style</p>
            </div>
          </div>
          <div class="u-container-style u-list-item u-repeater-item">
            <div class="u-container-layout u-similar-container u-container-layout-5">
              <p class="u-custom-item u-text u-text-default u-text-6" style="font-size: 16px">#style</p>
            </div>
          </div>
        </div>
      </div>
      <div class="u-expanded-width u-gallery u-layout-horizontal u-lightbox u-no-transition u-show-text-always u-width-fixed u-gallery-1">
        <div class="u-gallery-inner">
          <div class="u-gallery-item u-gallery-item-1">
            <div class="u-back-slide">
              <img class="u-back-image u-back-image-1" src="../images/5.svg" alt="user_id">
            </div>
            <div class="u-align-left u-over-slide u-valign-bottom u-over-slide-1">
              <h3 class="u-gallery-heading u-text-white" style="margin-left: 0px; margin-right: auto; font-weight: 700; background-image: none; font-size: 1rem;">user_id</h3>
              <p class="u-gallery-text" style="margin-left: 0px; margin-right: auto; margin-top: 0px;"></p>
            </div>
          </div>
          <div class="u-gallery-item u-gallery-item-2">
            <div class="u-back-slide">
              <img class="u-back-image u-back-image-2" src="../images/5.svg">
            </div>
            <div class="u-align-left u-over-slide u-valign-bottom u-over-slide-2">
              <h3 class="u-gallery-heading u-text-white" style="margin-left: 0px; margin-right: auto; font-weight: 700; background-image: none; font-size: 1rem;"></h3>
              <p class="u-gallery-text" style="margin-left: 0px; margin-right: auto; margin-top: 0px;"></p>
            </div>
          </div>
          <div class="u-gallery-item u-gallery-item-3">
            <div class="u-back-slide">
              <img class="u-back-image u-back-image-3" src="../images/5.svg">
            </div>
            <div class="u-align-left u-over-slide u-valign-bottom u-over-slide-3">
              <h3 class="u-gallery-heading u-text-white" style="margin-left: 0px; margin-right: auto; font-weight: 700; background-image: none; font-size: 1rem;"></h3>
              <p class="u-gallery-text" style="margin-left: 0px; margin-right: auto; margin-top: 0px;"></p>
            </div>
          </div>
          <div class="u-gallery-item u-gallery-item-4">
            <div class="u-back-slide">
              <img class="u-back-image u-back-image-4" src="../images/5.svg">
            </div>
            <div class="u-align-left u-over-slide u-valign-bottom u-over-slide-4">
              <h3 class="u-gallery-heading u-text-white" style="margin-left: 0px; margin-right: auto; font-weight: 700; background-image: none; font-size: 1rem;"></h3>
              <p class="u-gallery-text" style="margin-left: 0px; margin-right: auto; margin-top: 0px;"></p>
            </div>
          </div>
          <div class="u-gallery-item u-gallery-item-5">
            <div class="u-back-slide">
              <img class="u-back-image u-back-image-5" src="../images/5.svg">
            </div>
            <div class="u-align-left u-over-slide u-valign-bottom u-over-slide-5">
              <h3 class="u-gallery-heading u-text-white" style="margin-left: 0px; margin-right: auto; font-weight: 700; background-image: none; font-size: 1rem;"></h3>
              <p class="u-gallery-text" style="margin-left: 0px; margin-right: auto; margin-top: 0px;"></p>
            </div>
          </div>
          <div class="u-gallery-item u-gallery-item-6">
            <div class="u-back-slide">
              <img class="u-back-image u-back-image-6" src="../images/5.svg">
            </div>
            <div class="u-align-left u-over-slide u-valign-bottom u-over-slide-6">
              <h3 class="u-gallery-heading u-text-white" style="margin-left: 0px; margin-right: auto; font-weight: 700; background-image: none; font-size: 1rem;"></h3>
              <p class="u-gallery-text" style="margin-left: 0px; margin-right: auto; margin-top: 0px;"></p>
            </div>
          </div>
        </div>
        <a class="u-absolute-vcenter u-gallery-nav u-gallery-nav-prev u-opacity u-opacity-70 u-spacing-10 u-text-white u-gallery-nav-1" href="#" role="button">
          <span aria-hidden="true">
            <svg viewBox="0 0 451.847 451.847">
              <path d="M97.141,225.92c0-8.095,3.091-16.192,9.259-22.366L300.689,9.27c12.359-12.359,32.397-12.359,44.751,0
					c12.354,12.354,12.354,32.388,0,44.748L173.525,225.92l171.903,171.909c12.354,12.354,12.354,32.391,0,44.744
					c-12.354,12.365-32.386,12.365-44.745,0l-194.29-194.281C100.226,242.115,97.141,234.018,97.141,225.92z">
			  </path>
			</svg>
          </span>
          <span class="sr-only">
   		    <svg viewBox="0 0 451.847 451.847">
   		      <path d="M97.141,225.92c0-8.095,3.091-16.192,9.259-22.366L300.689,9.27c12.359-12.359,32.397-12.359,44.751,0
						c12.354,12.354,12.354,32.388,0,44.748L173.525,225.92l171.903,171.909c12.354,12.354,12.354,32.391,0,44.744
						c-12.354,12.365-32.386,12.365-44.745,0l-194.29-194.281C100.226,242.115,97.141,234.018,97.141,225.92z">
   		      </path>
   		    </svg>
          </span>
        </a>
        <a class="u-absolute-vcenter u-gallery-nav u-gallery-nav-next u-opacity u-opacity-70 u-spacing-10 u-text-white u-gallery-nav-2" href="#" role="button">
          <span aria-hidden="true">
            <svg viewBox="0 0 451.846 451.847">
              <path d="M345.441,248.292L151.154,442.573c-12.359,12.365-32.397,12.365-44.75,0c-12.354-12.354-12.354-32.391,0-44.744
						L278.318,225.92L106.409,54.017c-12.354-12.359-12.354-32.394,0-44.748c12.354-12.359,32.391-12.359,44.75,0l194.287,194.284
						c6.177,6.18,9.262,14.271,9.262,22.366C354.708,234.018,351.617,242.115,345.441,248.292z">
			  </path>
			</svg>
          </span>
          <span class="sr-only">
            <svg viewBox="0 0 451.846 451.847">
              <path d="M345.441,248.292L151.154,442.573c-12.359,12.365-32.397,12.365-44.75,0c-12.354-12.354-12.354-32.391,0-44.744
						L278.318,225.92L106.409,54.017c-12.354-12.359-12.354-32.394,0-44.748c12.354-12.359,32.391-12.359,44.75,0l194.287,194.284
						c6.177,6.18,9.262,14.271,9.262,22.366C354.708,234.018,351.617,242.115,345.441,248.292z">
              </path>
            </svg>
          </span>
        </a>
      </div>
    </div>
  </section>
  <div style= "margin-top:100px"></div>
  <section class="u-border-1 u-border-black u-border-no-left u-border-no-right u-clearfix u-section-4" id="sec-494d">
    <div class="u-clearfix u-sheet u-valign-middle u-sheet-1">
      <p class="u-large-text u-text u-text-default u-text-variant u-text-1" style="font-weight: 650" >Major Brands</p>
      <p class="u-text u-text-default u-text-2" style="color:#8C8C8C">주요 브랜드</p>
      <div class="u-list u-list-1">
        <div class="u-repeater u-repeater-1">
          <div class="u-container-style u-list-item u-repeater-item" >
            <div class="u-container-layout u-similar-container u-container-layout-1">
              <a href="../shoes/shoes_list.do?brand=Nike">
              <img src="../images/brand/brand_1.png" width="100px" height="55px" ></a>
            </div>
          </div>
          <div class="u-container-style u-list-item u-repeater-item">
            <div class="u-container-layout u-similar-container u-container-layout-2">
              <a href="../shoes/shoes_list.do?brand=Adidas">
              <img src="../images/brand/brand_2.png" width="100px" height="55px" ></a>
            </div>
          </div>
          <div class="u-container-style u-list-item u-repeater-item">
            <div class="u-container-layout u-similar-container u-container-layout-3">
              <a href="../shoes/shoes_list.do?brand=New Balance">
              <img src="../images/brand/brand_3.png" width="100px" height="55px" ></a>
            </div>
          </div>
          <div class="u-container-style u-list-item u-repeater-item">
            <div class="u-container-layout u-similar-container u-container-layout-4">
              <a href="../shoes/shoes_list.do?brand=Hoke One One">
              <img src="../images/brand/brand_4.png" width="100px" height="55px" ></a>
            </div>
          </div>
          <div class="u-container-style u-list-item u-repeater-item">
            <div class="u-container-layout u-similar-container u-container-layout-5">
              <a href="../shoes/shoes_list.do?brand=Asics">
              <img src="../images/brand/brand_5.png" width="100px" height="55px" ></a>
            </div>
          </div>
          <div class="u-container-style u-list-item u-repeater-item">
            <div class="u-container-layout u-similar-container u-container-layout-6">
              <a href="../shoes/shoes_list.do?brand=Mihara Yasuhiro">
              <img src="../images/brand/brand_6.png" width="100px" height="55px" ></a>
            </div>
          </div>
          <div class="u-container-style u-list-item u-repeater-item">
            <div class="u-container-layout u-similar-container u-container-layout-7">
              <a href="../shoes/shoes_list.do?brand=Autry">
              <img src="../images/brand/brand_7.png" width="100px" height="55px" ></a>
            </div>
          </div>
          <div class="u-container-style u-list-item u-repeater-item">
            <div class="u-container-layout u-similar-container u-container-layout-8">
              <a href="../shoes/shoes_list.do?brand=Oofos">
              <img src="../images/brand/brand_8.png" width="100px" height="55px" ></a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <div style= "margin-top:100px"></div>
  <section class="u-clearfix u-section-2" id="sec-9192">
    <div class="u-clearfix u-sheet u-sheet-1">
      <p class="u-large-text u-text u-text-default u-text-variant u-text-1" style="font-weight: 650">New In</p>
      <p class="u-text u-text-default u-text-2" style="color: #8C8C8C">최신 상품</p>
      <div class="u-expanded-width u-list u-list-1">
        <div class="u-repeater u-repeater-1">
        <c:forEach var="vo" items="${list2 }" varStatus="s">
        <c:if test="${s.index>=0 && s.index<8 }">     
          <div class="u-align-left u-container-style u-list-item u-repeater-item">
            <div class="u-container-layout u-similar-container u-container-layout-1">
              <a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }"><img class="u-expanded-width u-image u-image-default u-image-1" src="${vo.img }" alt="" data-image-width="400" data-image-height="265"></a>
                <span class="u-icon u-text-palette-1-base u-icon-1">
                  <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 51.997 51.997" style="">
                    <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-46bd"></use>
                  </svg>
                  <svg class="u-svg-content" viewBox="0 0 51.997 51.997" x="0px" y="0px" id="svg-46bd" style="enable-background:new 0 0 51.997 51.997;">
                    <g><path d="M51.911,16.242C51.152,7.888,45.239,1.827,37.839,1.827c-4.93,0-9.444,2.653-11.984,6.905
								c-2.517-4.307-6.846-6.906-11.697-6.906c-7.399,0-13.313,6.061-14.071,14.415c-0.06,0.369-0.306,2.311,0.442,5.478
								c1.078,4.568,3.568,8.723,7.199,12.013l18.115,16.439l18.426-16.438c3.631-3.291,6.121-7.445,7.199-12.014
								C52.216,18.553,51.97,16.611,51.911,16.242z M49.521,21.261c-0.984,4.172-3.265,7.973-6.59,10.985L25.855,47.481L9.072,32.25
								c-3.331-3.018-5.611-6.818-6.596-10.99c-0.708-2.997-0.417-4.69-0.416-4.701l0.015-0.101C2.725,9.139,7.806,3.826,14.158,3.826
								c4.687,0,8.813,2.88,10.771,7.515l0.921,2.183l0.921-2.183c1.927-4.564,6.271-7.514,11.069-7.514
								c6.351,0,11.433,5.313,12.096,12.727C49.938,16.57,50.229,18.264,49.521,21.261z"></path></g>
                  </svg>
                </span>
                <a href="../shoes/shoes_list.do?brand=${vo.brand }" style="color:black"><p class="u-text u-text-default u-text-3">${vo.brand }<br></p></a>
                <p class="u-text u-text-default u-text-4"><a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }" style="color:black">${vo.name_eng }</a></p>
                <a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }" style="color:black"><p class="u-text u-text-default u-text-5"><fmt:formatNumber pattern="#,###" value="${vo.im_buy }"/>원<br></p></a>
                <p class="u-text u-text-default u-text-6"><a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }" style="color:#A6A6A6">즉시구매가</a><br></p>
            </div>
          </div>
        </c:if>
        </c:forEach>
        </div>
      </div>
      <span class="u-border-2 u-border-hover-palette-1-base u-border-palette-1-base u-btn u-btn-round u-button-style u-hover-palette-1-base u-none u-radius-50 u-btn-1" id="newmore">more</span>
      <div class="u-expanded-width u-list u-list-1" id="newTr" style="display:none">
        <div class="u-repeater u-repeater-1">
        <c:forEach var="vo" items="${list2 }" varStatus="s">
        <c:if test="${s.index>=8 && s.index<16 }">
          <div class="u-align-left u-container-style u-list-item u-repeater-item">
            <div class="u-container-layout u-similar-container u-container-layout-1">
              <a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }"><img class="u-expanded-width u-image u-image-default u-image-1" src="${vo.img }" alt="" data-image-width="400" data-image-height="265" ></a>
              <span class="u-icon u-text-palette-1-base u-icon-1">
                <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 51.997 51.997" style="">
                  <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-46bd"></use>
                </svg>
                <svg class="u-svg-content" viewBox="0 0 51.997 51.997" x="0px" y="0px" id="svg-46bd" style="enable-background:new 0 0 51.997 51.997;">
                  <g><path d="M51.911,16.242C51.152,7.888,45.239,1.827,37.839,1.827c-4.93,0-9.444,2.653-11.984,6.905
							c-2.517-4.307-6.846-6.906-11.697-6.906c-7.399,0-13.313,6.061-14.071,14.415c-0.06,0.369-0.306,2.311,0.442,5.478
							c1.078,4.568,3.568,8.723,7.199,12.013l18.115,16.439l18.426-16.438c3.631-3.291,6.121-7.445,7.199-12.014
							C52.216,18.553,51.97,16.611,51.911,16.242z M49.521,21.261c-0.984,4.172-3.265,7.973-6.59,10.985L25.855,47.481L9.072,32.25
							c-3.331-3.018-5.611-6.818-6.596-10.99c-0.708-2.997-0.417-4.69-0.416-4.701l0.015-0.101C2.725,9.139,7.806,3.826,14.158,3.826
							c4.687,0,8.813,2.88,10.771,7.515l0.921,2.183l0.921-2.183c1.927-4.564,6.271-7.514,11.069-7.514
							c6.351,0,11.433,5.313,12.096,12.727C49.938,16.57,50.229,18.264,49.521,21.261z">
				  </path></g>
			    </svg>
              </span>
              <a href="../shoes/shoes_list.do?brand=${vo.brand }" style="color:black"><p class="u-text u-text-default u-text-3">${vo.brand }<br></p></a>
              <p class="u-text u-text-default u-text-4"><a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }" style="color:black">${vo.name_eng }</a></p>
              <a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }" style="color:black"><p class="u-text u-text-default u-text-5"><fmt:formatNumber pattern="#,###" value="${vo.im_buy }"/>원<br></p></a>
              <p class="u-text u-text-default u-text-6"><a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }" style="color:#A6A6A6">즉시구매가</a><br></p>
            </div>
          </div>
        </c:if>
        </c:forEach>
        </div>
      </div>
    </div>
  </section>
  <div style= "margin-top:100px"></div>
  <section class="u-clearfix u-section-2" id="sec-9192">
    <div class="u-clearfix u-sheet u-sheet-1">
      <p class="u-large-text u-text u-text-default u-text-variant u-text-1" style="font-weight: 650">Most Premium</p>
      <p class="u-text u-text-default u-text-2" style="color: #8C8C8C">프리미엄 상품</p>
      <div class="u-expanded-width u-list u-list-1">
        <div class="u-repeater u-repeater-1">
        <c:forEach var="vo" items="${list3 }" varStatus="s3">
        <c:if test="${s3.index>=0 && s3.index<8 }">
          <div class="u-align-left u-container-style u-list-item u-repeater-item">
            <div class="u-container-layout u-similar-container u-container-layout-1">
              <a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }"><img class="u-expanded-width u-image u-image-default u-image-1" src="${vo.img }" alt="" data-image-width="400" data-image-height="265"></a>
              <span class="u-icon u-text-palette-1-base u-icon-1">
                <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 51.997 51.997" style="">
                  <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-46bd"></use>
                </svg>
                <svg class="u-svg-content" viewBox="0 0 51.997 51.997" x="0px" y="0px" id="svg-46bd" style="enable-background:new 0 0 51.997 51.997;">
                  <g><path d="M51.911,16.242C51.152,7.888,45.239,1.827,37.839,1.827c-4.93,0-9.444,2.653-11.984,6.905
								c-2.517-4.307-6.846-6.906-11.697-6.906c-7.399,0-13.313,6.061-14.071,14.415c-0.06,0.369-0.306,2.311,0.442,5.478
								c1.078,4.568,3.568,8.723,7.199,12.013l18.115,16.439l18.426-16.438c3.631-3.291,6.121-7.445,7.199-12.014
								C52.216,18.553,51.97,16.611,51.911,16.242z M49.521,21.261c-0.984,4.172-3.265,7.973-6.59,10.985L25.855,47.481L9.072,32.25
								c-3.331-3.018-5.611-6.818-6.596-10.99c-0.708-2.997-0.417-4.69-0.416-4.701l0.015-0.101C2.725,9.139,7.806,3.826,14.158,3.826
								c4.687,0,8.813,2.88,10.771,7.515l0.921,2.183l0.921-2.183c1.927-4.564,6.271-7.514,11.069-7.514
								c6.351,0,11.433,5.313,12.096,12.727C49.938,16.57,50.229,18.264,49.521,21.261z"></path></g>
                </svg>
              </span>
              <a href="../shoes/shoes_list.do?brand=${vo.brand }" style="color:black"><p class="u-text u-text-default u-text-3">${vo.brand }<br></p></a>
              <p class="u-text u-text-default u-text-4"><a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }" style="color:black">${vo.name_eng }</a></p>
              <a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }" style="color:black"><p class="u-text u-text-default u-text-5"><fmt:formatNumber pattern="#,###" value="${vo.im_buy }"/>원<br></p></a>
              <p class="u-text u-text-default u-text-6"><a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }" style="color:#A6A6A6">즉시구매가</a><br></p>
            </div>
          </div>
        </c:if>
        </c:forEach>
        </div>
      </div>
      <span class="u-border-2 u-border-hover-palette-1-base u-border-palette-1-base u-btn u-btn-round u-button-style u-hover-palette-1-base u-none u-radius-50 u-btn-1" id="premore">more</span>
      <div class="u-expanded-width u-list u-list-1" id="preTr" style="display:none">
        <div class="u-repeater u-repeater-1">
        <c:forEach var="vo" items="${list3 }" varStatus="s">
        <c:if test="${s.index>=8 && s.index<12 }">
          <div class="u-align-left u-container-style u-list-item u-repeater-item" >
            <div class="u-container-layout u-similar-container u-container-layout-1">
              <a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }"><img class="u-expanded-width u-image u-image-default u-image-1" src="${vo.img }" alt="" data-image-width="400" data-image-height="265" ></a>
              <span class="u-icon u-text-palette-1-base u-icon-1">
                <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 51.997 51.997" style="">
                  <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-46bd"></use>
                </svg>
                <svg class="u-svg-content" viewBox="0 0 51.997 51.997" x="0px" y="0px" id="svg-46bd" style="enable-background:new 0 0 51.997 51.997;">
                  <g><path d="M51.911,16.242C51.152,7.888,45.239,1.827,37.839,1.827c-4.93,0-9.444,2.653-11.984,6.905
							c-2.517-4.307-6.846-6.906-11.697-6.906c-7.399,0-13.313,6.061-14.071,14.415c-0.06,0.369-0.306,2.311,0.442,5.478
							c1.078,4.568,3.568,8.723,7.199,12.013l18.115,16.439l18.426-16.438c3.631-3.291,6.121-7.445,7.199-12.014
							C52.216,18.553,51.97,16.611,51.911,16.242z M49.521,21.261c-0.984,4.172-3.265,7.973-6.59,10.985L25.855,47.481L9.072,32.25
							c-3.331-3.018-5.611-6.818-6.596-10.99c-0.708-2.997-0.417-4.69-0.416-4.701l0.015-0.101C2.725,9.139,7.806,3.826,14.158,3.826
							c4.687,0,8.813,2.88,10.771,7.515l0.921,2.183l0.921-2.183c1.927-4.564,6.271-7.514,11.069-7.514
							c6.351,0,11.433,5.313,12.096,12.727C49.938,16.57,50.229,18.264,49.521,21.261z">
				  </path></g>
			    </svg>
              </span>
              <a href="../shoes/shoes_list.do?brand=${vo.brand }" style="color:black"><p class="u-text u-text-default u-text-3">${vo.brand }<br></p></a>
              <p class="u-text u-text-default u-text-4"><a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }" style="color:black">${vo.name_eng }</a></p>
              <a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }" style="color:black"><p class="u-text u-text-default u-text-5"><fmt:formatNumber pattern="#,###" value="${vo.im_buy }"/>원<br></p></a>
              <p class="u-text u-text-default u-text-6"><a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }" style="color:#A6A6A6">즉시구매가</a><br></p>
            </div>
          </div>
        </c:if>
        </c:forEach>
         <c:forEach var="vo" items="${list3 }" varStatus="s">
        <c:if test="${s.index>=12 && s.index<16 }">
          <div class="u-align-left u-container-style u-list-item u-repeater-item" style="margin-bottom:150px;" >
            <div class="u-container-layout u-similar-container u-container-layout-1">
              <a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }"><img class="u-expanded-width u-image u-image-default u-image-1" src="${vo.img }" alt="" data-image-width="400" data-image-height="265" ></a>
              <span class="u-icon u-text-palette-1-base u-icon-1">
                <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 51.997 51.997" style="">
                  <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-46bd"></use>
                </svg>
                <svg class="u-svg-content" viewBox="0 0 51.997 51.997" x="0px" y="0px" id="svg-46bd" style="enable-background:new 0 0 51.997 51.997;">
                  <g><path d="M51.911,16.242C51.152,7.888,45.239,1.827,37.839,1.827c-4.93,0-9.444,2.653-11.984,6.905
							c-2.517-4.307-6.846-6.906-11.697-6.906c-7.399,0-13.313,6.061-14.071,14.415c-0.06,0.369-0.306,2.311,0.442,5.478
							c1.078,4.568,3.568,8.723,7.199,12.013l18.115,16.439l18.426-16.438c3.631-3.291,6.121-7.445,7.199-12.014
							C52.216,18.553,51.97,16.611,51.911,16.242z M49.521,21.261c-0.984,4.172-3.265,7.973-6.59,10.985L25.855,47.481L9.072,32.25
							c-3.331-3.018-5.611-6.818-6.596-10.99c-0.708-2.997-0.417-4.69-0.416-4.701l0.015-0.101C2.725,9.139,7.806,3.826,14.158,3.826
							c4.687,0,8.813,2.88,10.771,7.515l0.921,2.183l0.921-2.183c1.927-4.564,6.271-7.514,11.069-7.514
							c6.351,0,11.433,5.313,12.096,12.727C49.938,16.57,50.229,18.264,49.521,21.261z">
				  </path></g>
			    </svg>
              </span>
              <a href="../shoes/shoes_list.do?brand=${vo.brand }" style="color:black"><p class="u-text u-text-default u-text-3">${vo.brand }<br></p></a>
              <p class="u-text u-text-default u-text-4"><a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }" style="color:black">${vo.name_eng }</a></p>
              <a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }" style="color:black"><p class="u-text u-text-default u-text-5"><fmt:formatNumber pattern="#,###" value="${vo.im_buy }"/>원<br></p></a>
              <p class="u-text u-text-default u-text-6"><a href="../shoes/shoes_detail_before.do?goods_id=${vo.goods_id }" style="color:#A6A6A6">즉시구매가</a><br></p>
            </div>
          </div>
        </c:if>
        </c:forEach>
        </div>
      </div>
    </div>
  </section>
  <div style= "margin-top:100px"></div>
  </div>
</body>
</html>