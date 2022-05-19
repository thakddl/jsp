<%@page import="admin.vo.AdminVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	AdminVO vo = (AdminVO) request.getAttribute("vo");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
th {
	width: 150px;
	height: 50px;
	background-color: skyblue;
	text-align: center;
	align-items: center;
}

td {
	width: 150px;
	height: 50px;
	text-align: center;
}

#th1 {
	width: 70px;
}

caption {
	font-size: 2.0em;
	text-align: center;
}
</style>
</head>
<body>
<div></div>
	<div class="container"></div>
	<table class="table">
		<caption>회원 정보</caption>
		<tr>
			<th>회원 ID</th>
			<td><%=vo.getMemId()%></td>
		</tr>
		<tr>
			<th>권한코드</th>
			<td><%=vo.getAthrtCode()%></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=vo.getMemNm()%></td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td><%=vo.getNickName()%></td>
		</tr>
		<!-- 	<tr> -->
		<!-- 		<th>성별</th> -->
		<%-- 		<td><%=vo.getGender() %></td> --%>
		<!-- 	</tr> -->
		<tr>
			<th>이메일</th>
			<td><%=vo.getEmail()%></td>
		</tr>
		<!-- 	<tr> -->
		<!-- 		<th>핸드폰번호</th> -->
		<%-- 		<td><%=vo.getHp() %></td> --%>
		<!-- 	</tr> -->
		<tr>
			<th>가입일자</th>
			<td><%=vo.getRgstDt()%></td>
		</tr>
		<!-- 	<tr> -->
		<!-- 		<th>생년월일</th> -->
		<%-- 		<td><%=vo.getBirthDt() %></td> --%>
		<!-- 	</tr> -->
		<tr>
			<th>상태코드</th>
			<td><%=vo.getStatus()%></td>
		</tr>
		<!-- 	<tr> -->
		<!-- 		<th>우편번호</th> -->
		<%-- 		<td><%=vo.getZip() %></td> --%>
		<!-- 	</tr> -->
		<!-- 	<tr> -->
		<!-- 		<th>주소</th> -->
		<%-- 		<td><%=vo.getMemAdd() %></td> --%>
		<!-- 	</tr> -->
		<!-- 	<tr> -->
		<!-- 		<th>상세주소</th> -->
		<%-- 		<td><%=vo.getDetailAdd() %></td> --%>
		<!-- 	</tr> -->

	</table>
</div>
</body>
</html>