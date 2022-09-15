<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../home/style/style_insert/style.css">
<link rel="stylesheet" href="../home/style/style_insert.css" media="screen">
<link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#writeBtn').click(function(){
		
		let content=$('#content').val(); 	// 입력한 값 가져오기
		if (content.trim()=="") {
			$('#content').focus();
			return;
		}
		
		$('#frm').submit();	// 데이터 보내기
		
	})
})
</script>
</head>
  <body class="u-body u-xl-mode" data-lang="en">
    <section class="u-align-center u-border-2 u-border-grey-75 u-clearfix u-section-1" id="carousel_a3a0">
      <div class="u-clearfix u-sheet u-sheet-1">
        <div class="u-container-style u-group u-shape-rectangle u-white u-group-1" >
          <div class="u-container-layout u-container-layout-1" >
            <h2 class="u-align-center u-text u-text-1" style="font-size: 3rem; font-weight: 300; text-transform: none; text-decoration: underline !important; margin: 27px 66px 0; ">Style</h2>
            <div class="u-border-1 u-border-grey-75 u-container-style u-group u-white u-group-2" style="margin-top:50px;">
                  <form action="#" method="POST" class="u-clearfix u-form-horizontal u-form-spacing-15 u-inner-form" source="file">
              <div class="u-container-layout u-container-layout-2" style="border: 1px solid; ">
                <div class="custom-file-upload">
                  <img class="u-image u-image-default u-image-1" src="" alt="" id="uploadImage" data-image-width="400" data-image-height="265" style=" width: 460px; height: 339px; margin: 22px auto 0 32px;">
    			  <input type="file" id="file" name="myfiles[]" multiple="" class="custom-file-upload-hidden" tabindex="-1" style="position: absolute; left: -9999px;">
    		      <button id="sendButton" style=" margin-left: 799px;">보내기</button>
			    </div>
                  <div class="u-form u-form-1">

					<script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
					<script  src="../home/style/style_insert/script.js"></script>
					
                    <!-- <div class="u-form-send-message u-form-send-success">Thank you! Your message has been sent.</div>
                    <div class="u-form-send-error u-form-send-message">Unable to send your message. Please fix errors then try again.</div> -->
                    <input type="hidden" value="" name="recaptchaResponse">
                  </div>
                </form>
              </div>
            </div>
            <div class="u-form u-form-2">
              <form method=post action="../style/insert_ok.do" id="frm">
              <div class="u-clearfix u-form-spacing-15 u-form-vertical u-inner-form" style="padding: 0;" name="form">
                <div class="u-form-group u-form-message u-form-group-3">
                  <label for="message-f2a8" class="u-label u-label-2" >Content</label>
                  <textarea placeholder="문구 입력..." rows="4" cols="50" name=content class="u-border-1 u-border-grey-75 u-input u-input-rectangle" style="border:1px solid; " required="" id="content"></textarea>
                </div>
                <div class="u-align-center u-form-group u-form-submit">
                  <span class="u-black u-btn u-btn-rectangle u-btn-submit u-button-style u-btn-2" id="writeBtn">wRITE<br>
                  </span>
                  <input type="submit" value="submit" class="u-form-control-hidden">
                </div>
                <div class="u-form-send-message u-form-send-success"> Thank you! Your message has been sent. </div>
                <div class="u-form-send-error u-form-send-message"> Unable to send your message. Please fix errors then try again. </div>
                <input type="hidden" value="" name="recaptchaResponse">
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
  <script>

    document.querySelector("#sendButton").addEventListener('click',()=>{

      let selectFile = document.querySelector("#file").files[0];

      const file = URL.createObjectURL(selectFile);

      document.querySelector("#uploadImage").src = file;

    })

  </script>
</html>