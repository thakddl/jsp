<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Coding People</title>
    <link rel="stylesheet" href="css/coding.css">
    <script src="../js/jquery-3.6.0.min.js"></script>
    <script>
   	  $(document).ready(function(){
   	    $('#header').load("header/loginheader.jsp");
        $('#aside').load("side/side2.jsp");
        $('#footer').load("footer/footer.jsp");
   	});   
    </script>
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
        <section id="contents_mypage">
          <%-- 고객정보 메인 --%>
          <div id="mypage_center">
            <ul id="list-ul">
              <li id="list-li"><a href="/client/UpdateMypage.do" style="color:black">고객정보 상세 조회/수정</a></li>
              <li id="list-li"><a href="secession.jsp" style="color:black">회원탈퇴</a></li>
            </ul>
          </div>
        </section>
      </div>    
      
      <%-- 푸터 --%>
      <footer id="footer">
      </footer>        
    </div>
  </body>
</html>