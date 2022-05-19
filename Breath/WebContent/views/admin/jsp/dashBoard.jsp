<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	int memCount = (int) request.getAttribute("memCount");
	int shipCount = (int) request.getAttribute("shipCount");
	int reportCount = (int) request.getAttribute("reportCount");
	int blackCount = (int) request.getAttribute("blackCount");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<caption>DASH BOARD</caption>
		<tr>
			<th class="adth">전체 회원 수</th>
			<th class="adth">멤버십 가입자 수</th>
			<th class="adth">블랙회원 수</th>
			<th class="adth">미처리 신고건 수</th>
		</tr>
		<tr class="#">
			<td><%=memCount %>명</td>
			<td><%=shipCount %>명</td>
			<td><%=blackCount %>명</td>
			<td><%=reportCount %>건</td>
		</tr>
	</table>
</body>
</html>