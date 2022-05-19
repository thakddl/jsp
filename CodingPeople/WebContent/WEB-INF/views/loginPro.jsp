<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String memId = (String) session.getAttribute("memId");
String msg = (String) request.getAttribute("msg");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <script>alert("<%=msg%>");</script>
  <%
  	if(memId == null){	
  %>
  <script>
  		location.href='/login.jsp';
  </script>
  <%
  	} else{
  %>
  	<script >
  		location.href='/mainhome.jsp';
  	</script>
    <%
  	}
  %>
</body>
</html>