<%@page import="qnaboard.vo.qnaBoardReplyVO"%>
<%@page import="qnaboard.vo.qnaBoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String msg = request.getParameter("msg") == null ? "" : request.getParameter("msg");

	List<qnaBoardReplyVO> br = (List<qnaBoardReplyVO>)request.getAttribute("boardReplyList");
	
	qnaBoardVO bv = (qnaBoardVO)request.getAttribute("bv");
	String updateDt = bv.getUpdate_dt();
	
	String post_num= (String)request.getAttribute("qbr");

	qnaBoardReplyVO qbrV = (qnaBoardReplyVO)request.getAttribute("qbrV");
	
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="./js/jquery-3.6.0.min.js"></script>


<title>Q&A 게시판</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&display=swap" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="./css/main.css" />
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.17.21/lodash.min.js" integrity="sha512-WFN04846sdKMIP5LKNphMaWzU7YpMyCU245etK3g/2ARYbPK9Ub18eG+ljU96qKRCWh+quCY7yefSmlkQw1ANQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.8.0/gsap.min.js" integrity="sha512-eP6ippJojIKXKO8EPLtsUMS+/sAGHGo1UN/38swqZa1ypfcD4I0V/ac5G3VzaHfDaklFmQLEs51lhkkVaqg60Q==" crossorigin="anonymous" referrerpolicy="no-referrer"></script> 
<script defer src="./js/main.js"></script>
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
      <div class="name">Q & A</div>
    </div>    
  </div>
</div> 

<div class="container">
	<table class="table">
		<tr>
			<td>NO : </td>
			<td><%=bv.getPost_num() %></td>
		</tr>
		<tr>
			<td>작성자 : </td>
			<td><%=bv.getMem_id() %></td>
		</tr>
		
		<tr>
<%
			if (updateDt != null) {
%>		
				<td>날짜:</td>
				<td><%=bv.getUpdate_dt() %> (수정됨)</td>
<%
			} else {
%>
				<td>날짜:</td>
				<td><%=bv.getPost_dt() %></td>
<%				
			}
%>				
		</tr>

		<tr>
			<td>제목 :</td>
			<td><%=bv.getTitle() %></td>
		</tr>
		<tr>
			<td>내용 :</td>
			<td><%=bv.getContent() %></td>
		</tr>
<!-- 		<tr> -->
<!-- 			<td>비밀번호 :</td> -->
<%-- 			<td><%=bv.getV_pass() %></td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>비밀글 :</td> -->
<%-- 			<td><%=bv.getStatus() %></td> --%>
<!-- 		</tr> -->
		
<!-- 		<tr> -->
<!-- 			<td colspan="2"> -->
<%-- 				<a href="BInsertBoardReplyServlet.qnaBoard?post_num=<%=bv.getPost_num() %>">[댓글 작성하러]</a> --%>
<!-- 			</td> -->
<!-- 		</tr> -->
	</table>

	<button type="button" class="btn btn-success btn-sm" id="wbtn" onclick="location.href='/Breath/List.qnaBoard'">목록</button>
	<button type="button" class="btn btn-success btn-sm" id="wbtn" onclick="location.href='/Breath/update.qnaBoard?post_num=<%=bv.getPost_num() %>'">수정</button>
	<button type="button" class="btn btn-success btn-sm" id="wbtn" onclick="location.href='/Breath/delete.qnaBoard?post_num=<%=bv.getPost_num() %>'">삭제</button>
	
	
<!-- 	<form action="detail.qnaBoard"> -->


<!-- 		<table> -->
<!-- 		<tr> -->
<!-- 			<td>댓글 </td> -->
<!-- 			<td><input type="text" name="reply" value=""></td> -->
<!-- 			<td><input type="submit" value="전송"></td> -->
<!-- 		</tr> -->
<!-- 		</table> -->
<!-- 	</form> -->
	
	
</div>
<%
	if(msg.equals("성공")){
%>
	<script>
		alert('정상적으로 처리되었습니다.');
	</script>
<%
	}

%>
<%
	for(int i=0; i<br.size(); i++){
%>
	<table border="1">
	  <tr>
	    <td><%=br.get(i).getComment_num() %></td>
	    <td><%=br.get(i).getMem_id() %></td>
	    <td><%=br.get(i).getComm_dt() %></td>
	    <td><%=br.get(i).getContent() %></td>
	    <td><%=br.get(i).getIp_add() %></td>
	    <td><%=br.get(i).getStatus() %></td>
	  </tr>
	</table>
<%
	}
%>

<jsp:include page="/mainFooter.jsp" flush="true"/>

</body>
</html>