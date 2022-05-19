<%@page import="lecture.vo.CourseVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<CourseVO> csList = (List<CourseVO>) request.getAttribute("list");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Coding People</title>
<link rel="stylesheet" href="/css/coding.css">
<script src="../js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {
		$('#header').load("/header/loginheader.jsp");
		$('#aside').load("/side/side3.jsp");
		$('#footer').load("/footer/footer.jsp");
	});
</script>
<style>
.imgtd {
	width: 250px;
	height: 150px;
}

#lectureimg {
	width: 200px;
	height: 130px;
}

table {
	margin: 20px auto;
	border-collapse: collapse;
	text-align: center;
}

.td1 {
	width: 60px;
}

.td2 {
	width: 160px;
}

#lecturebuymenu {
	height: 600px;
	overflow: scroll;
}

.space {
	font-size: 20px;
	border-left: none;
	border-right: none;
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
				<%-- 강의 리스트 메인 --%>
				<div id="lecturebuymenu_center">
					<ul id="lecturebuymenu">
						<li>
							<div id="lecturebuymenudiv2">강의 리스트</div>
							<div id="lecturebuymenu">
								<table>
									<%
										for (int i = 0; i < csList.size(); i++) {
									%>

									<tr>
										<td class="imgtd" rowspan="3"><img
											src="../img/<%=csList.get(i).getCourseId().replace(" ", "")%>.jpg"
											id="lectureimg"></td>
										<td>강의명</td>
										<td colspan="2"><%=csList.get(i).getCourseTitle()%></td>
										<td><button type="button"
												onclick="location.href='/lecture/detail2.do?courseId=<%=csList.get(i).getCourseId()%>'">자세히보기</button></td>
									</tr>
									<tr>
										<td class="td1">강의수</td>
										<td class="td2"><%=csList.get(i).getCourseComposition()%></td>
										<td class="td1">가격</td>
										<td class="td2"><%=csList.get(i).getCoursePrice()%></td>
									</tr>
									<tr>
										<td>등록일</td>
										<td><%=csList.get(i).getCourseDate().substring(0, 10)%></td>
										<td>구분</td>
										<td><%=csList.get(i).getCategoryId()%></td>
									</tr>
									<tr>
										<td colspan="5" class="space"><br></td>
									</tr>
									<%
										} //for end
									%>

								</table>
							</div>
						</li>
					</ul>
					<%-- 여기에 동영상 메뉴 리스트 가져오기 --%>
					<%-- 영상클릭 구매창 활성화하기 --%>
				</div>
				<div class="button_lecturebuymenu">
					<div id="button_lecturebuymenu">
						<input type="button" value="뒤로가기" onClick="history.go(-1)">
					</div>
				</div>
			</section>
		</div>
		<%-- 푸터영역 --%>
		<footer id="footer"> </footer>
	</div>
</body>
</html>