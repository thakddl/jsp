<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<% pageContext.setAttribute("msg", "pagecontext");%>
<% request.setAttribute("msg", "request");%>
<% session.setAttribute("msg", "session");%>
<% application.setAttribute("msg", "application");%>

스코프 확인
<h1>EL : ${msg}</h1>

<!-- 가까운것부터 불러보고 가장 가까운거 반환 -->
</body>
</html>