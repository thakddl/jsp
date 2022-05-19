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
        $('#aside').load("side/managerside.jsp");
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
        <section id="contents_blacklist">
          <%-- 블랙리스트 메인 --%>
          <div id="blacklist_center">          
            <div id="blacklist">
              블랙 회원 조회
              <input type="search" id="blacksearch" autofocus placeholder="회원 검색" required>
              <input type="button" id="blacklist_buttons" value="검색하기">
            </div>
            <div id="blacklist1">
            <%-- 본문몸통 --%>
            블랙리스트 가져오기
            </div>
          </div>
          <div class="button_blacklist">
            <div id="button_blacklist">
              <button type="button" onclick="location.href='managermain.jsp' ">관리자 메인</button>
            </div>
          </div>
        </section>
      </div>
      <%-- 푸터영역 --%>
      <footer id="footer">
      </footer>
    </div>
  </body>
</html>