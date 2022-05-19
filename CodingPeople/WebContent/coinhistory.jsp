<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="coin.service.CoinServiceImpl"%>
<%@page import="coin.service.IcoinService"%>
<%@page import="coin.vo.CoinHistoryVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%  // 인증된 세션이 없는경우, 해당페이지를 볼 수 없게 함.
    if (session.getAttribute("memId") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Coding People</title>
    
    <link rel="stylesheet" href="css/coding.css">
    <script src="../js/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="../css/lhbcss.css">
	<script src="../js/bootstrap.min.js"></script> 
    
    <script>
   	  $(document).ready(function(){
   	    $('#header').load("header/loginheader.jsp");
        $('#aside').load("side/side2.jsp");
        $('#footer').load("footer/footer.jsp");
//         $('#pointsite_s').load("pointsiteTarget.jsp");
   	});   
    </script>
<style>
td,th {
	text-align: center;
	font-size: 17px
}
#pointsite_center {
	overflow: scroll;
}
</style>
  </head>

  <body>
    <%-- 전체 --%>
    <div id="wrap-container">
      <%-- 헤더 호출 --%>
      <header id="header">        
      </header>

      <%-- 사이드바+본문 --%>
      <div class="container">
        <%-- 사이드바 --%>
        <aside id="aside">
        </aside>

        <%-- 본문 --%>
        <section id="cotents_pointsite">
          <%-- 사이트머니 메인 --%>
          <div id="pointsite_center">
            <div id="pointsite_s">
 <!--사이트머니사용내역조회 시작 -->

 <!--사이트머니사용내역조회 끝 -->
            </div>
          </div>
          <div class="button_pointsite">
            <div id="button_pointsite">
              <button type="button" onclick="fetchPage('coinhistoryAll.jsp')">전체내역</button>
              <button type="button" onclick="fetchPage('coinhistoryUse.jsp')">사용내역</button>
              <button type="button" onclick="fetchPage('coinhistoryCharge.jsp')">충전내역</button>
            </div>
          </div>
        </section>
      </div>
      <%-- 푸터영역 --%>
      <footer id="footer">
      </footer>
    </div>
  </body>
<script>
$(function(){ // 실행할 기능을 정의해주세요. 
	fetchPage('coinhistoryAll.jsp');
// 	$('#pointsite_s').load("coinhistoryCharge.jsp");
	});

function fetchPage(name){
  fetch(name).then(function(response){
    response.text().then(function(text){
      document.querySelector('#pointsite_s').innerHTML = text;
    })
  });
}
</script>
</html>