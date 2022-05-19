<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String alert = (String) request.getAttribute("alert");

	if(alert==null) alert = "";
%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Coding People</title>
    <link rel="stylesheet" href="/css/coding.css">
    <script src="../js/jquery-3.6.0.min.js"></script>
    <script>
   	  $(document).ready(function(){
   	    $('#header').load("/header/loginheader.jsp");
        $('#aside').load("/side/side5.jsp");
        $('#footer').load("/footer/footer.jsp");
        if('<%=alert%>' != '') alert('우수회원만 가능합니다.');
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
        <section id="contents_studygroup">
          <%-- 스터디그룹 소개 메인 --%>
          <div id="studygroup_center">          
            <div id="studygroup">
              <div id="study1">
                <p> 스터디그룹이란? </p>
              </div>
              <div id="study2">
                <p>함께 공부를 하기 위하여, 같은 분야에 관심이 있는 사람들끼리 만든 모임</p>
              </div>
              <div id="study1">
                <p> 스터디장이란? </p>
              </div>
              <div id="study2">
                <p>그룹의 장으로 함께 공부하는 사람들의 의견을 조율하여 질을 향상시키는 대표</p>
              </div>
            </div>
            <div class="button_studygroup">
              <div id="button_studygroup">
                <button type="button" onclick="location.href='/groupStudy/Create.do'">스터디 대표 등록</button>
                <button type="button" onclick="location.href='/groupStudy/list.do'">스터디 그룹 가입</button>
            </div>
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