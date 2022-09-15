<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSTL / EL
	---------
	EL
		사용법 : ${}
			   ${자바의 일반 변수(X)}
			   ${request.getAttribute()}
			   ${session.getAttribute()}
			   ${application.getAttribute()}
			   ${request.getParameter()}
			   ${request.getParameterValues()}
			   => request, session, application => JSP 내장 객체
			   	  => 기존의 저장된 데이터 + 추가 데이터 (setAttribute)
		--------------------------------------------------------
		MVC(MV) => 재사용, 확장기능 (자바, HTML분리) => JSP단점은 1회용
												  보안이 취약 (JSP는 파일을 전체 전송)
		JSP ------ Java ------ 오라클
			request     요청된 데이터 가지고 오기
			   <===========
			 request, session에 결과값 추가해서 전송
		--------------------------------------------------------
		EL 연산자 : 산술연산자 : + , - , * , /(div) , %(mod)
										-------- 정수/정수=실수
							"10"+"20" => 1020(x), 30(o)
							null + 1 = 1 => null은 0으로 계산
							문자열 결합은 +=
				  논리연산자 : &&(and) , ||(or)
				  비교연산자 : == , !=, < , > , <= , >=
				  			모든 데이터 비교 가능
	JSTL : 제어문, 변수 선언, 화면이동, 날짜변환, 숫자변환, String 메서드
		   -------------------------------------------------- 자바 코딩 없이 태그형으로 제작
		   HTML/CSS JavaScript JAVA SQL
		       |        |        |   |
		     퍼블리셔    Front    Back DBA
		  
		  	XML로 제작
		  	--------- 대소문자 구분, 여는 태그와 닫는 태그 반드시 하기, 지원하는 속성만 사용 가능, 속성값 반드시 ""
		  			  MyBatis / JPA / Spring / SpringBoot
		  			  VueJS, ReactJS ==> jsx(JavaScript+XML) 
		  			  JSON / Annotation
		  			  RestFul
		  1. <c:set>
		     <c:set var="" value=""> : 변수 설정 ===> MVC에서는 사용 빈도 없음
		           ------- --------
		             변수명     값     ===> ${var에 저장된 변수}
		  2. <c:out> : 화면 출력 (JavaSvript) ==> Jquery => $
		  			   $('태그,id,class').click()  => JS연동
		  			   <c:out value="">
		  			   		  --------- 출력할 내용
		  3. <c:forEach> : for문
		  				   for (int i=1; i<=10; i++)
		  				   <c:forEach var="i" begin="1" end="10" step="1">  step="1" 생략 가능, - 사용 불가
		  				   		      ------
		  				   		      루프변수
		  				   		      
		  				   for(String name:list)  
		  				   <c:forEach var="name" items="list" varStatus="s">
		  				   			  ---------- ------------ --------------
		  				   			    받는변수	   배열/컬렉션	     인덱스 번호
		  4. <c:if> : if문
		  			  <c:if test="조건문">  ==> <c:else> 없음
		  5. <c:choose> : 다중 조건문
		  				  <c:choose>
		  				    <c:when test="조건문">출력</c:when>  if
		  				    <c:when test="조건문">출력</c:when>  else if
		  				    <c:when test="조건문">출력</c:when>  else if
		  				    <c:otherwise></c:otherwise>       else
		  				  </c:choose>
		  6. <c:redirect> : sendRedirect("url") 화면 이동
		  					<c:redirect url="">
		  7. <fmt:formatDate> : SimpleDateFormat
		  						<fmt:formatDate value="${today}" pattern="yyyy-MM-dd">
		  						TO_CHAR(regdate, 'YYYY-MM-DD')
		  8. <fmt:formatNumber> : NumberFormat
		  						  <fmt:formatNumber value="10000" pattern="99,999">
		  						  TO_CHAR(won,'L000,000')
		     
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>