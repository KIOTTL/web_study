<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper row3">
  <main class="container clear"> 
    <div class="row">
      <table class="table">
        <tr>
          <%--
          	StringTokenizer => c:forTokens
           --%>
          <c:forTokens items="${vo.poster }" delims="^" var="image">
            <td class="text-center"><img src="${image }" style="width: 100%"></td>
          </c:forTokens>
        </tr>
      </table>
    </div>
    <div class="one_half first">
      <table class="table">
        <tr>
          <td colspan="2">
            <h4>${vo.name }&nbsp;<span style="color:orange">${vo.score }</span></h4>
          </td>
        </tr>
        <tr>
          <td width=30%>주소</td>
          <td width=70%>${addr1 }<br><sub>지번&nbsp;${addr2 }</sub></td>
        </tr>
        <tr>
          <td width=30%>전화</td>
          <td width=70%>${vo.tel }</td>
        </tr>
        <tr>
          <td width=30%>음식 종류</td>
          <td width=70%>${vo.type }</td>
        </tr>
        <tr>
          <td width=30%>가격대</td>
          <td width=70%>${vo.price }</td>
        </tr>
        <tr>
          <td width=30%>주차</td>
          <td width=70%>${vo.parking }</td>
        </tr>
        <tr>
          <td width=30%>영업시간</td>
          <td width=70%>${vo.time }</td>
        </tr>
       <c:if test="${vo.menu!='no' }">
        <tr>
          <td width=30%>메뉴</td>
          <td width=70%>
            <ul>
              <c:forTokens items="${vo.menu }" delims="원" var="m">
                <li>${m }원</li>
              </c:forTokens>
            </ul>
          </td>
        </tr>
       </c:if>
       <tr>
         <td colspan="2" class="text-right">
           <c:if test="${sessionScope.id!=null }">
             <c:if test="${lcount==0 }">
               <a href="#" class="btn btn-sm btn-danger">좋아요(1)</a>
             </c:if>
             <c:if test="${lcount!=0 }">
               <span class="btn btn-sm btn-default">좋아요(1)</span>
             </c:if>
             <c:if test="${jcount==0 }">
               <a href="../food/jjim.do?fno=${vo.fno }" class="btn btn-sm btn-info">찜하기</a>
             </c:if>
             <c:if test="${jcount!=0 }">
               <span class="btn btn-sm btn-default">찜하기</span>
             </c:if>
           </c:if>
           <a href="javascript:history.back()" class="btn btn-sm btn-success">목록</a>
         </td>
       </tr>
      </table>
    </div>
    <div class="one_half">
      <div style="height: 20px"></div>
      <table class="table">
        <tr>
          <td>
            <c:forEach var="rvo" items="${rList }">
              <table class="table">
                <tr>
                  <td width=30% class="text-center" rowspan="3">
                    <img src="${rvo.poster }" style="width: 100%">
                  </td>
                  <td width=70%>${rvo.title }</td>
                </tr>
                <tr>
                  <td width=70%>${rvo.chef }</td>
                </tr>
                <tr>
                  <td width=70%>${vo.type }</td>
                </tr>
              </table>
            </c:forEach>
          </td>
        </tr>
      </table>
    </div>
  </main>
</div>
</body>
</html>