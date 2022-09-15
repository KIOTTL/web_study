<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style_insert.css" media="screen">
<link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
<style type="text/css">
.u-section-1 .u-text-2 {
  font-size: 3rem;
  font-weight: 300;
  text-transform: none;
  text-decoration: none;
  margin: 0 66px;
}

@font-face {
    font-family: 'SBAggroL';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2108@1.1/SBAggroL.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

.custom-file-upload-hidden {
  display: none;
  visibility: hidden;
  position: absolute;
  left: -9999px;
}

.custom-file-upload {
  display: block;
  font-size: 16px;
  margin-top: 30px;
}
.custom-file-upload label {
  display: block;
  margin-bottom: 5px;
}

.file-upload-wrapper {
  position: relative;
  margin-bottom: 5px;
}

.file-upload-input {
  color: black;
  /* font-size: 16px; */
  padding: 11px 17px;
  border: 1px solid black;
  background-color: white;
  -moz-transition: all 0.2s ease-in;
  -o-transition: all 0.2s ease-in;
  -webkit-transition: all 0.2s ease-in;
  transition: all 0.2s ease-in;
  float: left;
  /* IE 9 Fix */
  margin-left:500px;
}

.file-upload-input:hover, .file-upload-input:focus {
  background-color: white;
  outline: 1px solid black;
}

.file-upload-button {
  height: 34px;
  cursor: pointer;
  display: inline-block;
  color:black;
  display: flex;
  align-items:center; 
  font-size: 14px;
  text-transform: uppercase;
  padding: 11px 20px;
  border: 1px solid black;
  margin-left: -1px;
  background-color: white;
  float: left;
  /* IE 9 Fix */
  -moz-transition: all 0.2s ease-in;
  -o-transition: all 0.2s ease-in;
  -webkit-transition: all 0.2s ease-in;
  transition: all 0.2s ease-in;
}
.file-upload-button:hover {
  background-color: black;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
/* $(function(){
	$('#writeBtn').click(function(){
		
		let content=$('#content').val(); 	// 입력한 값 가져오기
		if (content.trim()=="") {
			$('#content').focus();
			return;
		} 
		
		$('#frm').submit();	// 데이터 보내기
	})
}) */

			
 $(function(){
	$('#writeBtn').click(function(){
		
		let img=$('#hide1').val(); 	// 입력한 값 가져오기
		if (img.trim()=="") {
			$('#hide1').focus();
			return;
		} 
		let content=$('#hide2').val(); 	// 입력한 값 가져오기
		if (content.trim()=="") {
			$('#hide2').focus();
			return;
		} 
	
		$('#frm3').submit();	// 데이터 보내기
	})
}) 
		
/*  $(function(){
	$('#sendButton').click(function(){
		
		var fileValue = $("#file").val().split("\\");
	    var fileName = fileValue[fileValue.length-1]; // 파일명
		
		console.log(fileName);
	    
	    let img=fileName;
	    if (img.trim()==""){
	    	$('#file').focus();
	    }
	    
	    $('.frm2').submit(); 
	    
	    let img=$('#').val(); 	// 입력한 값 가져오기
		if (img.trim()=="") {
			$('#file').focus();
			return;
		}
	}) 
}) */ 


</script>
</head>
<iframe name='blankifr' style='display:none;'></iframe>
  <body class="u-body u-xl-mode" data-lang="en">
    <section class="u-align-center u-clearfix u-section-1" id="carousel_a3a0">
   <!--  <form method=post action="../style/insert_ok.do" id="frm" > -->
      <div class="u-clearfix u-sheet u-sheet-1" style="min-height: 905px;">
        <div class="u-container-style u-group u-shape-rectangle u-white u-group-1" style="width: 881px;min-height: 822px;background-image: none;height: auto;margin: 79px auto 4px;">
          <div class="u-container-layout u-container-layout-1" style="padding: 0 0 5px; margin: 0 5 10 5px;">
            <h2 class="u-align-center u-text u-text-2" style="font-family: SBAggroL; font-size: 3rem;font-weight: 300;text-transform: none;margin: 0 66px; text-decoration: none;">Style</h2>
            <div class="u-border-1 u-border-grey-75 u-border-no-bottom u-container-style u-group u-white u-group-2" style="width: 650px; min-height: 340px; background-image: none; height: auto;margin: 22px auto 0; ">
              <div class="u-container-layout u-valign-middle u-container-layout-2" style="padding: 0; margin-top:0px; border-top: solid 1px black; border-right: solid 1px black; border-left: solid 1px black; height:700px;">
                <img class="u-image u-image-contain u-image-default u-image-1" style=" width: 490px;height: auto;margin: 0 auto;" src="" onerror="this.src='bas.png'"alt=""  id="uploadImage" data-image-width="400" data-image-height="265">
              </div>
            </div>
           <form method=post action="../style/input_ok.jsp" class="frm" enctype="multipart/form-data" target="blankifr" id="frm2">
            <div class="u-border-1 u-border-grey-75 u-border-no-top u-container-style u-group u-group-3" style="width: 650px; min-height: 82px; height: auto; margin: 0 auto; border-bottom: 1px solid black; border-right: 1px solid black; border-left: 1px solid black;">
              <div class="custom-file-upload" style="margin-left: 175px;">
              <!--  <form action="../style/insert_ok.do" method="POST" id="frm1" class="u-clearfix u-form-horizontal u-form-spacing-15 u-inner-form"  style="padding: 15px; height: 64px; margin: 13px 151px 0 0;" source="file"> -->
                <div class="u-container-layout u-container-layout-3" style="padding-left: 30px; padding-right: 30px;">
                  <div class="u-form u-form-1" style="height: 64px; margin: 13px 0 0 0;">
                      <!-- <div class="u-form-group u-form-name u-label-top"  >
                        <label for="name-558c" class="u-form-control-hidden u-label"></label>
                        <input type="text" placeholder="파일" id="name-558c" name="name" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-input-1" style="height: 32px;font-size: 0.875rem; border:1px solid #c0c0c0; width: 315px;" required="">
                      </div> -->
		  			  <!--<label for="file">File: </label>--> 
		  			  <%-- <%=application.getRealPath("/") %> --%>
    			      <input type="file" id="file" name="myfiles[]" multiple="" class="custom-file-upload-hidden" tabindex="-1" style="position: absolute; left: -9999px;">
    		  	      <!-- <button class="u-black u-border-1 u-border-black u-btn u-button-style" style="text-transform: uppercase;letter-spacing: 1px; background-image: none;border-style: solid;margin: -68px 0 56px 260px;padding: 5px 20px 4px; font-size: 0.875rem;" >FILE UPLOAD</button> --> 
    			      <!-- <button id="sendButton" style="text-transform: uppercase;letter-spacing: 1px; background-image: none;border-style: solid 1px black;margin: -68px 0 56px 260px;padding: 3px 20px 4px; background-color:black; color:white; font-size: 0.875rem; display: inline-block;">
		                    FILE&nbsp;UPLOAD
		                    <span style="font-size: 0.75rem;"></span>
		                    <span style="font-size: 0.875rem;">FILE&nbsp;UPLOAD</span>
		                  </button> -->
				  	  <script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
					  <script  src="script.js"></script>
                      <!-- <div class="u-form-group u-form-submit" style="weight:100px;">
                        <a href="#" class="u-border-1 u-border-black u-btn u-btn-submit u-button-style u-text-black u-white u-btn-1" style="font-size: 0.875rem;border-style: solid;background-image: none;font-weight: 700;padding: 5px 10px;">파일 선택<br>
                        </a>
                        <input type="submit" value="submit" class="u-form-control-hidden">
                      </div> -->
                      <!-- <div class="u-form-send-message u-form-send-success">Thank you! Your message has been sent.</div>
                      <div class="u-form-send-error u-form-send-message">Unable to send your message. Please fix errors then try again.</div>
                      <input type="hidden" value="" name="recaptchaResponse"> -->
	                  <!-- <a href="#" class="u-black u-border-1 u-border-black u-btn u-button-style u-btn-2" style="text-transform: uppercase;letter-spacing: 1px; background-image: none;border-style: solid;margin: -50px 0 16px auto;padding: 3px 20px 4px;">
	                    <span style="font-size: 0.75rem;"></span>
	                    <span style="font-size: 0.875rem;">file upload</span>
	                  </a> -->
                  </div>
                </div>
               <!-- </form> --> 
			  </div>
			  <input type="submit" class="u-black u-border-1 u-border-black u-btn u-button-style u-btn-2" value="File Upload" id="sendButton" style="text-transform: uppercase;letter-spacing: 1px; background-image: none;border-style: solid;margin: 43px 0 16px 77px;padding: 3px 20px 4px;">
	            <!-- <span style="font-size: 0.75rem;"></span>
	            <span style="font-size: 0.875rem;">file upload</span> -->
	         <!--  </a> -->
            </div>
			</form>
			<form method=post action="../style/insert_ok.do" class="frm" id="frm1" target="blankifr">
            <div class="u-form u-form-2" style="height: 214px;width: 655px;margin: 39px auto 0;">
             <!--  <form action="../style/insert_ok.do" method="POST" id="frm2"  class="u-clearfix u-form-spacing-15 u-form-vertical u-inner-form" style="padding: 0;" source="email" name="form"> -->
                <div class="u-form-group u-form-message u-form-group-3" style="margin-top: 0; margin-bottom: 10px;">
                  <label for="message-f2a8" class="u-label u-label-2" style="font-weight: 700;">Content</label>
                  <textarea placeholder="문구 입력..." rows="4" cols="50" id="content2" name="content2" class="u-border-1 u-border-grey-75 u-input u-input-rectangle" style="border:1px solid #404040" required=""></textarea>
                </div>
                <div class="u-align-center u-form-group u-form-submit">
                 <!--  <a href="#" class="u-black u-btn u-btn-rectangle u-btn-submit u-button-style u-btn-3" id="writeBtn" style="background-image: none; border-style: none; text-transform: uppercase; letter-spacing: 2px; font-weight: 700; margin-top:22px;" >WRITE<br> -->
                  <a href="#" class="u-form-control-hidden" style="background-image: none; border-style: none; text-transform: uppercase; letter-spacing: 2px; font-weight: 700; margin-top:22px;" >WRITE<br>
                  </a>
                  <input type="submit" value="submit" class="u-form-control-hidden">
                </div>
               <!--  <div class="u-form-send-message u-form-send-success"> Thank you! Your message has been sent. </div>
                <div class="u-form-send-error u-form-send-message"> Unable to send your message. Please fix errors then try again. </div>
                <input type="hidden" value="" name="recaptchaResponse"> -->
              <!-- </form> -->
            </div>
            </form>
            <form method=post action="../style/insert_ok.do" class="frm" id="frm3">
			  <input type="hidden" name="img" id="hide1" value="">
			  <input type="hidden" name="content" id="hide2" value="" >
			  <!-- <input type="submit" id="abc"></button> -->
			  <div class="u-align-center u-form-group u-form-submit">
                  <a href="#" class="u-black u-btn u-btn-rectangle u-btn-submit u-button-style u-btn-3" id="writeBtn" style="background-image: none; border-style: none; text-transform: uppercase; letter-spacing: 2px; font-weight: 700; margin-top:22px;" >WRITE<br>
                  </a>
                  <input type="submit" value="submit" class="u-form-control-hidden">
                </div>
			</form>
          </div>
        </div>
      </div>
      <!-- </form> -->
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
  <script>

    document.querySelector("#sendButton").addEventListener('click',()=>{

      let selectFile = document.querySelector("#file").files[0];

      const file = URL.createObjectURL(selectFile);


      document.querySelector("#uploadImage").src = file;
      
    })
    
    document.querySelector("#writeBtn").addEventListener('click',()=>{ 
    	 var fileValue = $("#file").val().split("\\");
   	  	 var fileName = fileValue[fileValue.length-1]; // 파일명
         document.querySelector("#hide1").value = fileName;

         document.querySelector("#hide2").value = $('#content2').val();
    })
    
    
    
    
  </script>
</html>