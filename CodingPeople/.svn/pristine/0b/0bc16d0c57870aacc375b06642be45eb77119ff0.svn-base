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
        <section id="contents_category">
          <%-- 카테고리 메인 --%>
          <div id="category_center">          
            <div id="category">
              카테고리 관리
              <input type="search" id="categorysearch" required>
              <input type="button" id="category_buttons" value="검색하기">
            </div>
            <div id="category1">
            <%-- 본문몸통 --%>
            카테고리 가져오기
            </div>
          </div>
          <div class="button_category">
            <div id="button_category">
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