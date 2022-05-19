<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String alert = (String) request.getAttribute("alert");
%>

<html>
  <head>
    <meta charset="UTF-8">
    <title>Coding People</title>
    <link rel="stylesheet" href="css/coding.css">
    <style>
    	input {
    	  width: 400px;
    	  height: 50px;
    	}
    	.size {
    		width: 200px;
    		height: 50px;
    	}
    </style>
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
            <form action="newPass.do" method="post">
		
				<h2>가입할 때 입력한 이메일로 새로운 비밀번호 전송하기</h2><br><br>
				<h3>아이디를 입력해 주세요</h3><br><br>
				<input type="text" name="memId"><br><br>
		
				<button class="size" type="button" onclick="location.href='login.jsp'">이전화면</button><br><br>
				<input class="size" type="submit" value="새로운 비밀번호 발송"><br><br>
			</form>
          </div>
          
               <%
				if(alert != null) { 
					if(alert.equals("yes")) {
				%>	
					
					<script>
						alert("이메일이 발송되었습니다.")
						location.href='login.jsp'
						console.log(<%=alert%>)
					</script>
				<%		
					} else {
				%>
					<script>
						alert("아이디가 없습니다.")
						location.href='newPass.jsp'
						console.log(<%=alert%>)
					</script>
				<%
					}
				}
				%>
          
        </section>
      </div>
      <%-- 푸터 --%>     
      <footer id="footer">
      </footer>
    </div>
  </body>
</html>