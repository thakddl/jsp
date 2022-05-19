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
        <section id="contents_lecturereview">
          <%-- 리뷰 메인 --%>
          <%-- <div id="lecturereview_center"> --%> 
          <div id="userreview">        
            <div id="review1">
              <p> 강좌 리뷰 </p>
            </div>
            <div>
              <div id="reviewbottom">
                <p><a href="userreview.jsp" style="color:black">More>></a></p>
              </div>
            </div>
          </div>
          <div id="myreview">          
            <div id="review2">
              <p> 내가 쓴 리뷰 </p>
            </div>
            <div>
              <div id="reviewbottom2">
                <p><a href="myreview.jsp" style="color:black">More>></a></p>
              </div>
            </div>
          </div>
          <div class="button_lecturereview">
            <div id="button_lecturereview">
              <button type="button" onclick="location.href='lecture.jsp' ">뒤로가기</button>
            </div>
          </div>
          <%-- </div> --%>
        </section>
      </div>
      <%-- 푸터영역 --%>
      <footer id="footer">
      </footer>
    </div>
  </body>
</html>