<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="trainerHome.vo.TrainerHomeVO"%>

<%
	List<TrainerHomeVO> trainerHomeList = (List<TrainerHomeVO>) request.getAttribute("trainerList");
	String msg = request.getParameter("msg") == null ? "" : request.getParameter("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전체 회원홈 목록</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>트레이너ID</th>
			<th>이름</th>
			<th>sub_content</th>
			<th>main_content</th>
		</tr>
		
		<%
			int trainerSize = trainerHomeList.size();
			if(trainerSize > 0) {
				for(int i =0; i<trainerSize; i++){
		%>
		<tr>
			<td><%=trainerHomeList.get(i).getTrainerId() %></td>
			<td><%=trainerHomeList.get(i).getIntroNm() %></td>
			<td><%=trainerHomeList.get(i).getIntroSub() %></td>
			<td><%=trainerHomeList.get(i).getIntroMain() %></td>
		</tr>
		<%
				}
			} else {
		%>
		<tr>
			<td colspan = "4"> 회원정보가 없습니다.</td>
		</tr>
				
		<%
			}
		%>
		
	</table>
	
	<%
		if(msg.equals("성공")){
	%>
		<script>
		 alert("정상적으로 처리되었습니다.");
		</script>		
	<% 		
		} else
	%>
</body>
</html>