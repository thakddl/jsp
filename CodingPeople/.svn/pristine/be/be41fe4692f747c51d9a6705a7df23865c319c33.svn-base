<%@page import="member.vo.JoinMemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
 
 	JoinMemberVO mv = (JoinMemberVO) request.getAttribute("mv");
 	
 	String memId = (String) request.getAttribute("memId");
 
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
            <form action="searchId.do" method="post">
		
				<h1>아이디 찾기</h1><br><br>
				<h3>이름을 입력해 주세요.</h3><br><br>
				<input type="text" name="memName"><br><br>
				<h3>생년월일을 입력해 주세요.</h3><br><br>
				<input type="text" name="memBir"><br><br>
		
				<button class="size" type="button" onclick="location.href='login.jsp'">이전화면</button><br><br>
				<input class="size" type="submit" value="아이디 찾기"><br><br>
			</form>
			<br><br>
	
				<%
					if(memId != null) { 
						if(memId.equals("no")) {
				%>		
						<script>
							alert("가입하신 정보가 없습니다.")
						</script>
						
						
				<%		
						} else {
				%>
						<%=mv.getMemName() %>님의 아이디는 <%=memId %> 입니다.	
				<%
						}
					}
				%>
          </div>
        </section>
      </div>
      <%-- 푸터 --%>     
      <footer id="footer">
      </footer>
    </div>
  </body>
</html>