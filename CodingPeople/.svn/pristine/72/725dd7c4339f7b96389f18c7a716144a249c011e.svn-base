<%@page import="lecture.vo.CourseVO"%>
<%@page import="atch.VO.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	CourseVO lv = (CourseVO) request.getAttribute("lv");

	List<AtchFileVO> atchFileList = (List<AtchFileVO>) request.getAttribute("atchFileList");
	
	String memId = (String) session.getAttribute("memId");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Coding People</title>
<link rel="stylesheet" href="../css/coding.css">
<script src="../js/jquery-3.6.0.min.js"></script>
<script>
   	  $(document).ready(function(){
   	    $('#header').load("../header/loginheader.jsp");
        $('#aside').load("../side/side3.jsp");
        $('#footer').load("../footer/footer.jsp");
        
      	$('#BuyBtn').on('click',function(){
      		let memId = "<%=memId%>";
      		let courseId = "<%=lv.getCourseId()%>"
      		let coursePrice = "<%=lv.getCoursePrice()%>"
      		let courseTitle = '<%="강의구매 -"+lv.getCourseTitle() %>'
      		location.href = '/lecture/insertHistory.do?memId='+memId+
      						'&courseId='+courseId+'&coursePrice='+coursePrice+
      						'&courseTitle='+courseTitle;
      	});
   	});
    </script>

<style>
.imglecturemain{
	margin-left: 80px;
}

img {
	width: 40%;
	height: 500px;
	float: left;
}

#lecturebuymenu {
	width: 50%;
	height: 500px;
	float: left;
}

h1 {
	text-align: center;
	font-size: 50px;
	margin-bottom: 30px;
}

table {
	font-size: 30px;
	border-collapse: collapse;
	width: 100%;
	text-align: center;
}

#lecturebuymenu_center {
	overflow: scroll;
}
</style>
</head>

<body>
	<%-- 전체 --%>
	<div id="wrap-container">
		<%-- 헤더 호출 --%>
		<header id="header"> </header>

		<%-- 사이드바+본문 --%>
		<div class="container">
			<%-- 사이드바 --%>
			<aside id="aside"></aside>

			<%-- 본문 --%>

			<section id="contents_lecturebuymenu">
				<div id="lecturebuymenu_center">
					<h1><%=lv.getCourseTitle() %></h1>
					<div class="imglecturemain">
						<img src="../img/<%=lv.getCourseId().replace(" ", "")%>.jpg">
						<table id="lecturebuymenu" border='1'>
							<tr>
								<td>가격</td>
								<td><%=lv.getCoursePrice() %></td>
							</tr>
							<tr>
								<td>강의수</td>
								<td><%=lv.getCourseComposition() %></td>
							</tr>
							<tr>
								<td>구분</td>
								<td><%=lv.getCategoryId() %></td>
							</tr>
							<tr>
								<td>영상수</td>
								<td><%=lv.getCourseComposition() %></td>
							</tr>
							<tr>
								<td>등록일</td>
								<td><%=lv.getCourseDate().substring(0, 10) %></td>
							</tr>
							<tr>
								<td colspan="2">강의소개</td>
							</tr>
							<tr>
								<td colspan="2" style="font-size: 15px; height: 200px;"><%=lv.getCourseIntroduction().replace("\r\n", "<br>") %></td>
							</tr>
						</table>
					</div>
				</div>
				<div class="button_lecturebuymenu">
					<div id="button_lecturebuymenu">
						<input id="BuyBtn" type="button" value="구매하기"> <input
							type="button" value="뒤로가기" onClick="history.go(-1)">
					</div>
				</div>
			</section>
		</div>
		<%-- 푸터영역 --%>
		<footer id="footer"> </footer>
	</div>
</body>
</html>