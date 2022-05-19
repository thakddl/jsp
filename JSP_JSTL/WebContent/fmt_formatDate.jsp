<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<%
	Date today = new Date();
	out.print("toString():"+today.toString());
	out.print("<br>");
	out.print("getTime():"+today.getTime());
	
	out.print("<br>");
	String todayStr = new SimpleDateFormat("yyyy/MM/dd").format(today);
	out.print("SimpleDateFormat:"+todayStr);
			
%>
<hr>
JSTL fmt:
<c:set var="today" value="<%=new Date() %>"/>
<fmt:formatDate value="${today }" pattern="yyyy/MM/dd" />

</body>
</html>