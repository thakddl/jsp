<%@page import="point.history.VO.PointHistoryVO"%>
<%@page import="coin.vo.CoinHistoryVO"%>
<%@page import="java.util.List"%>
<%@page import="coin.service.CoinServiceImpl"%>
<%@page import="coin.service.IcoinService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Coding People</title>
<link rel="stylesheet" href="../css/coding.css">
<script src="../js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="../css/lhbcss.css">
<script src="../js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		$('#header').load("header/loginheader.jsp");
		$('#aside').load("side/side2.jsp");
		$('#footer').load("footer/footer.jsp");
	});
</script>
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
			<section id="contents_point">
				<%-- 포인트 메인 --%>
				<div id="point_center">
					<div id="pointsite">
						<div id="point1">
							<p>사이트머니</p>
							<!--                  <br><h2 id="title">사이트머니 변동내역 </h2><br> -->
							<table class="table">
								<thead>
									<tr>
										<th scope="col">#</th>
										<th scope="col">구분</th>
										<th scope="col">사용금액</th>
										<th scope="col">사용 후 잔액</th>
										<th scope="col">날짜</th>
									</tr>
								</thead>
								<%
									String memId = (String) session.getAttribute("memId");
									IcoinService service = CoinServiceImpl.getInstance();
									List<CoinHistoryVO> list = service.getCHistoryList(memId);
									int cnt = 0;
									for (CoinHistoryVO vo : list) {
										cnt++;
								%>
								<tbody>
									<tr>
										<th scope="row"><%=vo.getcHistoryNo()%></th>
										<td><%=vo.getcEventId()%></td>
										<%
											if (vo.getcHistoryCoin().charAt(0) == '+') {
										%>
										<td><span style="color: limegreen"><%=vo.getcHistoryCoin()%></span></td>
										<%
											} else if (vo.getcHistoryCoin().charAt(0) == '-') {
										%>
										<td><span style="color: red"><%=vo.getcHistoryCoin()%></span></td>
										<%
											}
										%>
										<td><%=vo.getcHistoryBalance()%></td>
										<td><%=vo.getcHistoryDate()%></td>
									</tr>
								</tbody>
								<%
									} //for
									if (cnt == 0) {
								%>
								<tr>
									<td colspan="5">사용내역이 존재 하지 않습니다.</td>
								</tr>
								<%
									}
								%>

							</table>
						</div>
						<div>
							<div id="pointbottom">
								<p>
									<a href="coinhistory.jsp" style="color: black">More>></a>
								</p>
							</div>
						</div>
					</div>
					<div id="pointactivity">
						<div id="point2">
							<p>활동포인트</p>
							<div class="mouseover">
								<p>
									포인트 적립<br>가입하기 15p<br>글쓰기 30p<br>댓글 10p<br>----------------<br>500p
									달성시 등급up
									<우수회원>
								</p>
							</div>
							<table class="table">
								<thead>
									<tr>
										<th scope="col">#</th>
										<th scope="col">구분</th>
										<th scope="col">포인트변동</th>
										<th scope="col">변동 후 포인트</th>
										<th scope="col">날짜</th>
									</tr>
								</thead>
								<%
									memId = (String) session.getAttribute("memId");
									List<PointHistoryVO> list2 = service.getPHistoryList(memId);
									cnt = 0;
									for (PointHistoryVO vo : list2) {
										cnt++;
								%>
								<tbody>
									<tr>
										<th scope="row"><%=vo.getPhistoryNo()%></th>
										<td><%=vo.getPeventId()%></td>
										<%
											if (vo.getPhistoryPoint().charAt(0) == '+') {
										%>
										<td><span style="color: limegreen"><%=vo.getPhistoryPoint()%></span></td>
										<%
											} else if (vo.getPhistoryPoint().charAt(0) == '-') {
										%>
										<td><span style="color: red"><%=vo.getPhistoryPoint()%></span></td>
										<%
											}
										%>
										<td><%=vo.getPhistoryBanlance()%></td>
										<td><%=vo.getPhistoryDate()%></td>
									</tr>
								</tbody>
								<%
									} //for
									if (cnt == 0) {
								%>
								<tr>
									<td colspan="5">내역이 존재 하지 않습니다.</td>
								</tr>
								<%
									}
								%>

							</table>

							<!--포인트내역조회 끝 -->
						</div>
						<div id="pointbottom2">
							<p>
								<a href="pointhistory.jsp" style="color: black">More>></a>
							</p>
						</div>
					</div>
				</div>
			</section>
			<%-- 푸터 --%>
			<footer id="footer"> </footer>
		</div>
</body>
</html>