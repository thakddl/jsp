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
        <section id="contents_refund">
          <%-- 환불하기 메인 --%>
          <%-- <div id="refund_center"> --%>
            <div id="refundbook">          
              <div id="refund1">
                <p> 도서구매내역 </p>
              </div>
              <div>
                <div id="refundbottom">
                  <p><a href="buybook.jsp" style="color:black">More>></a></p>
                </div>
              </div>
            </div>
            <div id="refundlecture">          
              <div id="refund2">
                <p> 강좌구매내역 </p>
              </div>
              <div>
                <div id="refundbottom2">
                  <p><a href="lecturebuy.jsp" style="color:black">More>></a></p>
                </div>
              </div>
            </div>
          <%-- </div> --%>
        </section>
      </div>
      <%-- 푸터 --%>
      <footer id="footer">
      </footer>
    </div>
  </body>
</html>