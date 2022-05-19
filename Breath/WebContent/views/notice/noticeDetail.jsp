<%@page import="notice.vo.NoticeVO"%>
<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	NoticeVO nv = (NoticeVO) request.getAttribute("nv");
	String updateDt = nv.getUpdateDt();
	
	if (nv.getContent() != null) {
		String content = nv.getContent().replace("\r\n", "<br>");
	}
	
	MemberVO mv = (MemberVO) session.getAttribute("memVO");
	String memId = mv.getMemId();
	
	if (memId == null) {
		memId = "";
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="./js/jquery-3.6.0.min.js"></script>
  
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="./css/main.css" />
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.17.21/lodash.min.js" integrity="sha512-WFN04846sdKMIP5LKNphMaWzU7YpMyCU245etK3g/2ARYbPK9Ub18eG+ljU96qKRCWh+quCY7yefSmlkQw1ANQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.8.0/gsap.min.js" integrity="sha512-eP6ippJojIKXKO8EPLtsUMS+/sAGHGo1UN/38swqZa1ypfcD4I0V/ac5G3VzaHfDaklFmQLEs51lhkkVaqg60Q==" crossorigin="anonymous" referrerpolicy="no-referrer"></script> 
  <script defer src="./js/main.js"></script>
  
  <title>공지사항 상세보기</title>
  
<style>
.Nwrap {
	margin-top: 100px;
}
.container {
	margin-top: 50px;
}
#wbtn {
	color: white;
	background-color: #24855b;
	border: 0px;
	display: inline;
}
#tput{
	width: 800px;
}
</style>
</head>
<body>
	
<jsp:include page="/mainHeader.jsp" flush="true"/>


<div class="Nwrap">
  <div class="greenContainer">
    <div>
<!--       <div class="grade">트레이너</div> -->
      <div class="name">공지사항</div>
    </div>    
  </div>
</div> 

	<div class="container mt-3">
		<table class="table">
			<tr>
				<td>제목:</td>
				<td><%=nv.getTitle() %></td>
			</tr>
			<tr>
				<td>작성자:</td>
				<td><%=nv.getNickName() %></td>
			</tr>
			
			<tr>
<%
			if (updateDt != null) {
%>		
				<td>날짜:</td>
				<td><%=nv.getUpdateDt() %> (수정됨)</td>
<%
			} else {
%>
				<td>날짜:</td>
				<td><%=nv.getPostDt() %></td>
<%				
			}
%>				
			</tr>
			<tr>
				<td>내용:</td>
				<td><%=nv.getContent() %></td>
			</tr>

			<tr>
				<td colspan="2">
					<button type="button" class="btn btn-success btn-sm" id="wbtn" onclick="location.href='/Breath/NoticeList.do'">목록</button>
					<button type="button" class="btn btn-success btn-sm" id="wbtn" onclick="location.href='/Breath/updateNotice.do?postNum=<%=nv.getPostNum() %>'">수정</button>
					<button type="button" class="btn btn-success btn-sm" id="wbtn" onclick="location.href='/Breath/deleteNotice.do?postNum=<%=nv.getPostNum() %>'">삭제</button>
				</td>
			</tr>
		</table>
	
	<%@include file="/mainFooter.jsp" %>
	
	</div>

</body>
</html>