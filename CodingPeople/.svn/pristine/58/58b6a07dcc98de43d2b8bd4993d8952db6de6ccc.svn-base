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
        <section id="cotents_basketlecture">
          <%-- 장바구니<강좌>메인 --%>
          <div id="basketlecture_center">
            <div id="basketlecture_b">
                <p> 장바구니<강좌> </p>
            </div>
          </div>
          <div class="button_basketlecture">
            <div id="button_basketlecture">
              <input class="basketlecture_buttons" type="button" value="구매하기">
              <%-- 구매연결하기 --%>
              <input type="button" value="뒤로가기" onClick="history.go(-1)">
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