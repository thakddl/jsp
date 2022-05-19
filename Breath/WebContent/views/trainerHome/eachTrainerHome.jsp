<%@page import="trainerHome.vo.TrainerHomeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%
	TrainerHomeVO tvo = (TrainerHomeVO) request.getAttribute("tvo");
%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Breathing</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="../css/trainerInsertForm.css">

<script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.17.21/lodash.min.js" integrity="sha512-WFN04846sdKMIP5LKNphMaWzU7YpMyCU245etK3g/2ARYbPK9Ub18eG+ljU96qKRCWh+quCY7yefSmlkQw1ANQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.8.0/gsap.min.js" integrity="sha512-eP6ippJojIKXKO8EPLtsUMS+/sAGHGo1UN/38swqZa1ypfcD4I0V/ac5G3VzaHfDaklFmQLEs51lhkkVaqg60Q==" crossorigin="anonymous" referrerpolicy="no-referrer"></script> 
<script defer src="../js/tablesort.js"></script>
</head>
<body>
	<table border="1">
		<tr>
			<td>이름:</td>
			<td><%=tvo.getIntroNm()%></td>
		</tr>
		<tr>
			<td>sub_content : </td>
			<td><%=tvo.getIntroSub()%></td>
		</tr>
		<tr>
			<td>main_content : </td>
			<td><%=tvo.getIntroMain()%></td>
		</tr>
	</table>
		
</body>
</html>