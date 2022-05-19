<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	int cnt = (int) request.getAttribute("memCnt");
%>




<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전체 회원 수</title>
</head>
<body>
	
	<table borde="1">
		<tr>
			<th>전체 회원 수</th>
		</tr>
	
		<tr>
			<td><%=cnt %></td>
		</tr>
	
	
	</table>
	
</body>
</html>