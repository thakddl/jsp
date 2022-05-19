<%@page import="com.sun.org.apache.xalan.internal.xsltc.runtime.Parameter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<%
	String memId = (String) session.getAttribute("memId");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <aside id="left-sidebar">
    <div id="side-mp">
      <h1 id="h1-mp">프로그래밍</h1>
    </div>
    <div id="side2=mp">
      <ul id="side2-ul">
        <li id="side2-li">강의 관련</a></li>
          <li id="side3-li"><a href="/lecturesignup.jsp" style="color:black">강의 판매</a></li>
          <li id="side3-li"><a href="/lecture/getCourseList.do" style="color:black">강의 구매</a></li>          
          <li id="side3-li"><a href="/lecture/getBuyCourseList.do" style="color:black">강의 보기</a></li>          
        <li id="side2-li">도서 거래</a></li>
          <li id="side3-li"><a href="/bookCategory.do" style="color:black">도서 판매</a></li>
          <li id="side3-li"><a href="/bookbuy.do" style="color:black">도서 구매</a></li>          
      </ul>
    </div>
  </aside>
</body>
</html>