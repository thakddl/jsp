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
        <section id="cotents_myreview">
          <%-- 강좌리뷰 메인 --%>
          <div id="myreview_center">
            <div id="myreview_1">
                <p> 나의 리뷰 조회</p>
                <%-- 여기에 리뷰 등록/수정/삭제 넣기 --%>
            </div>
          </div>
          <div class="button_myreview">
            <div id="button_myreview">
              <button type="button" onclick="location.href='lecturereview.jsp' ">뒤로가기</button>
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