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
        <section id="contents_lecturebuy">
          <%-- 구매한 강의 메인 --%>
          <div id="lecturebuy_center">          
            <div id="lecturebuy1">
              <p> 구매한 강의 </p>
            </div>
          </div>
          <div class="button_lecturebuy">
            <div id="button_lecturebuy">
              <button type="button" onclick="location.href='lecturestudy.jsp' ">강의이동</button>
              <button type="button" onclick="location.href='lecture.jsp' ">뒤로가기</button>
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