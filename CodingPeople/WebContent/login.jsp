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
        $('#aside').load("side/side1.jsp");
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
        <section id="contents_login">
          <%-- 로그인 메인 --%>
          <div id="login_center">      
            <h1 id="h_login">환영합니다<br>로그인을 해주세요!!</h1>
              <form action="../LoginPro.do" method="post">
                <fieldset class="login_box">   
                  <ul id="login">
                   <li>
                    <input type="text" id="login_uid" autofocus placeholder="아이디" required
                    name="id"> 
                  </li>
                  <li>
                   <input type="password" id="login_pwd" placeholder="비밀번호" required
                   name="pass"> 
                  </li>     
                  </ul>      
                </fieldset>
                <div>
                  <div>
                    <input class="login_buttons" type="submit" value="로그인">
                    <input class="login_buttons" type="reset" value="취소">
                  </div>
                  <div class="forget_login">
                    <a href="searchId.jsp">아이디 찾기</a>
                    <a>/</a>
                    <a href="newPass.jsp">비밀번호 찾기</a>
                  </div>
                  <div>
                    <a href="membership.jsp">계정이 없으신가요???</a>
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