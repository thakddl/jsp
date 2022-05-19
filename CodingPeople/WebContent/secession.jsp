<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String memId = (String) session.getAttribute("memId");
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
            <form action="/secession.do" method="post">
            <input type="hidden" name="memId" value="<%=memId %>">
              <p><%=memId %>고객님</p>
              <p>지금 탈퇴하게 되면 잔여 마일리지가 소멸되며,</p>
              <p>재가입은 한달 이후 가능한 점 안내드립니다.</p>
              <p>정말 탈퇴하시겠습니까?</p>
              <div>
                <div id="button_secession">
                  <input class="secession_buttons" type="submit" value="탈퇴하기"> <%-- 탈퇴연결하기 --%>
                </div>
              </div>
              <div>
                <div id="button_secession">
                  <button type="button" onclick="location.href='mypage.jsp' ">뒤로가기</button>
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