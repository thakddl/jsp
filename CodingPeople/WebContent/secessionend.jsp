<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
session.invalidate();
%>
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
        <section id="contents_secession">
          <%-- 회원탈퇴 메인 --%>
          <div id="secession_center">
            <form>
            	<br><br><br><br><br>
              	<h1>회원 탈퇴가 완료되었습니다.</h1>
              	
                <div id="button_secession">
                </div>
              </div>
              <div>
                <div id="button_secession">
                  <br><br>
                  <button type="button" onclick="location.href='mainhome.jsp' ">홈으로가기</button>
                </div>
              </div>
            </form>
          </div>
        </section>
      </div>
      <%-- 푸터 --%>      
      <footer id="footer">
      </footer>
    </div>
  </body>
</html>