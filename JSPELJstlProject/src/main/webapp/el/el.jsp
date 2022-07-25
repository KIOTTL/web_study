<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	EL / JSTL ==> MVC, Spring, Spring-Boot
	--   ---- <% %>
	화면에 데이터 출력 <%= %> 대신 사용 ===> ${데이터}
	--- Java/HTML 분리 (MV)
		Java/HTML 분리, 연결 (MVC)
	프로그램은 태그형 프로그램으로 변경 ==> 유지보수, CSS작업이 쉬어짐
	
	EL
	=> JSP페이지에서 자바코드를 최소화하기 위해 만든 표현식(출력식)
	=> EL(표현식) <%= %> out.println() ==> ${} => 단점 : javascript => Jquery => $
	=> EL
		1) 연산자 (++, -- 존재x)
			이항연산자
			  - 산술연산자 ( + , - , * , / , % )
			  		+ : 순수하게 산술만 가능 (${"10"+"20"} = 30, ${"Java"+"Hello"} = 오류, ${null+10}=10)
			  		+= : 문자열 결합 (${"Java" += "Hello"}=Java Hello)
			  		/ (div) : 0으로 나누면 에러 발생 (정수/정수=실수 => ${10/3} = 3.3333... = ${10 div 3})
			  		% (mod) : 나머지 (${10%3} = 1 = ${10 mod 3})
			  - 비교연산자 ( == , != , < , > , <= , >=) ==> true/false
			  		== (eq)
			  		!= (ne)
			  		< (lt)
			  		> (gt)
			  		<= (le)
			  		>= (ge)
			  		------- 문자열, 날짜 비교 가능
			  		${id=='admin'}
			  - 논리연산자
			  		&& (and) : 직렬연산자 (두 개의 조건이 true일 경우 true)
			  		|| (or) : 병렬연산자 (두 개의 조건 중 한 개 이상 true일 경우 true)
			  		! (not) : 부정연산자
			  - 삼항연산자
			  		(조건)?값1:값2 : 조건이 true => 값1, false => 값2
			  - [], () ==> 배열, List 출력시 []
		2) 내장객체
		3) 객체 출력 => 메서드

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>산술연산자( + , - , * , /(div), %(mod) )</h3>
<!-- $ 출력 => &#36 -->
&#36;{10+20}=${10+20}<br> 
&#36;{"10"+"20"}=${"10"+"20"}, <%="10"+"20" %> <br>
&#36;{null+10}=${null+10} <br>
&#36;{"Java"+="Hello"}=${"Java"+="Hello"} <br>
&#36;{10/3}=${10/3} <br>
&#36;{10/3}=${10 div 3} <br>
&#36;{10%3}=${10%3} <br>
&#36;{10%3}=${10 mod 3} <br>
<h3>비교연산자( ==(eq), !=(ne), <(lt) , >(gt) , <=(le) , >=(ge) )</h3>
&#36;{100==200}=${100==200} <br>
&#36;{100==200}=${100 eq 200} <br>
&#36;{"admin"=="admin"}=${"admin"=="admin"} <br>
&#36;{"admin"=="admin"}=${"admin" eq "admin"} <br>
&#36;{100!=200}=${100!=200} <br>
&#36;{100!=200}=${100 ne 200} <br>
&#36;{100<200}=${100<200} <br>
&#36;{100<200}=${100 lt 200} <br>
&#36;{100>200}=${100>200} <br>
&#36;{100>200}=${100 gt 200} <br>
&#36;{100<=200}=${100<=200} <br>
&#36;{100<=200}=${100 le 200} <br>
&#36;{100>=200}=${100>=200} <br>
&#36;{100>=200}=${100 ge 200} <br>
<h3>논리연산자( &&(and), ||(or) )</h3>
&#36;{(10<8)&&(10!=8)}=${(10<8)&&(10!=8)} <br>
&#36;{(10<8)&&(10!=8)}=${(10<8) and (10!=8)} <br>
&#36;{(10<8)||(10!=8)}=${(10<8)||(10!=8)} <br>
&#36;{(10<8)||(10!=8)}=${(10<8) or (10!=8)} <br>
&#36;{!((10<8)||(10!=8))}=${!((10<8) or (10!=8))} <br>
&#36;{!((10<8)||(10!=8))}=${not((10<8) or (10!=8))} <br>
<h3>삼항연산자 ((조건)?값1:값2)</h3>
&%36;{10%2==0?"짝":"홀"}=${10%2==0?"짝":"홀"}
</body>
</html> --%>