<%@page import="exercise.vo.ExerciseVO"%>
<%@page import="member.vo.MemberVO"%>
<%@page import="membership.vo.MembershipVO"%>
<%@page import="subscribe.vo.SubscribeVO"%>
<%@page import="trainerChnl.vo.TrainerChnlVO"%>
<%@page import="trainerList.vo.TrainerVO"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	//가상의 VO(TrainerVO)에서 관리하는 list
	List<TrainerVO> trainerList = (List<TrainerVO>) request.getAttribute("tList");

	MemberVO mv = (MemberVO) session.getAttribute("memVO");
	String athrtCode = mv.getAthrtCode();

	/* String msg = request.getParameter("msg") == null ? "" : request.getParameter("msg"); */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="../js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="../css/tablesort.css">
<link rel="stylesheet" href="../css/main.css" />

<script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.17.21/lodash.min.js" integrity="sha512-WFN04846sdKMIP5LKNphMaWzU7YpMyCU245etK3g/2ARYbPK9Ub18eG+ljU96qKRCWh+quCY7yefSmlkQw1ANQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.8.0/gsap.min.js" integrity="sha512-eP6ippJojIKXKO8EPLtsUMS+/sAGHGo1UN/38swqZa1ypfcD4I0V/ac5G3VzaHfDaklFmQLEs51lhkkVaqg60Q==" crossorigin="anonymous" referrerpolicy="no-referrer"></script> 
<link rel="stylesheet" href="https://unpkg.com/swiper@6.8.4/swiper-bundle.min.css" />
<script src="../https://unpkg.com/swiper@6.8.4/swiper-bundle.min.js"></script>
<script defer src="../js/tablesort.js"></script>
<script defer src="../js/main.js"></script>

<title>Breathing</title>
</head>
<body>

<jsp:include page="/mainHeader.jsp" flush="true"></jsp:include>


<section class="tablesort-part">
<div class="inner">
	<table border="1" class="table table-sortable">
		<thead>
			<tr>
				<th>멤버쉽 수</th>
<!-- 				<th>멤버쉽 수</th> -->
				<!-- 	<th>트레이너 ID</th>  -->
				<th>운동 종류</th>
				<th>트레이너 이름</th>
			</tr>
		</thead>
		
		<tbody>
			<%
				int trainerSize = trainerList.size();

				for (int i = 0; i < trainerSize; i++) {
			%>
			<tr>
				<td><%=trainerList.get(i).getSubscribeCnt()%></td>
<%-- 				<td><%=trainerList.get(i).getMembershipCnt()%></td> --%>
				<td><%=trainerList.get(i).getExcsNm()%></td>
				<%-- <td><a href="/Breath/trainerHome/detail.do"><%=trainerList.get(i).getTrainerNikNm() %></a></td> --%>
				<td style="cursor:pointer;" onclick="location.href='/Breath/trainerHome/detail.do'"><%=trainerList.get(i).getTrainerNikNm()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
		

	</table>
</div>
</section>

<br>
<br>
<br>
<br>

<jsp:include page="/mainFooter.jsp" flush="true" />

</body>
</html>