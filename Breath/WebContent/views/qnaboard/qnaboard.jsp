<%@page import="qnaboard.vo.qnaBoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<qnaBoardVO> boardList = (List<qnaBoardVO>)request.getAttribute("boardList");

	String msg = request.getParameter("msg") == null ? "" : request.getParameter("msg");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="./js/jquery-3.6.0.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/summernote/summernote-lite.js"></script>
<script src="./js/summernote/lang/summernote-ko-KR.js"></script>d
<link rel="stylesheet" href="./css/summernote/summernote-lite.css">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="./css/main.css" />

<script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.17.21/lodash.min.js" integrity="sha512-WFN04846sdKMIP5LKNphMaWzU7YpMyCU245etK3g/2ARYbPK9Ub18eG+ljU96qKRCWh+quCY7yefSmlkQw1ANQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.8.0/gsap.min.js" integrity="sha512-eP6ippJojIKXKO8EPLtsUMS+/sAGHGo1UN/38swqZa1ypfcD4I0V/ac5G3VzaHfDaklFmQLEs51lhkkVaqg60Q==" crossorigin="anonymous" referrerpolicy="no-referrer"></script> 
<script defer src="./js/main.js"></script>

<title>Insert title here</title>

<style>
.Nwrap {
	margin-top: 90px;
}
.container {
	margin-top: 50px;
}
#wbtn {
	color: white;
	background-color: #24855b;
	border: 0px;
}
a {
    text-decoration: none;
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
	  <thead>
  		<tr>
   			<th>No</th>
   			<th>작성자</th>
   	 		<th>제목</th>
   	 		<th>날짜</th>
 		 </tr>
 	  </thead>
<%
	for(int i=0; i<boardList.size(); i++){
%>
		<tbody>
		  <tr class="qline">
		    <td><%=boardList.get(i).getPost_num() %></td>
		    <td><%=boardList.get(i).getMem_id() %></td>
		    <td style="cursor:pointer;" onclick="location.href='/Breath/detail.qnaBoard?post_num=<%=boardList.get(i).getPost_num() %>'"><%=boardList.get(i).getTitle()%></td>
		    <td><%=boardList.get(i).getPost_dt() %></td>
		  </tr>
		</tbody>
<%
	}
%>
	</table>
	
	
	<!-- <form action="Binsert.qnaBoard" method="post"> -->
<!-- 	<input type="submit" value="글쓰기"> -->
<!-- </form>	 -->
<button type="button" class="btn btn-success btn-sm" id="wbtn" onclick="location.href='/Breath/insert.qnaBoard'">글쓰기</button>
		<br>
		

</div>

<jsp:include page="/mainFooter.jsp" flush="true"/>


<%
	if(msg.equals("성공")){
%>
	<script>
		alert('정상적으로 처리되었습니다.');
	</script>
<%
	}

%>
<!-- <form action="Binsert.qnaBoard" method="post"> -->
<!-- 	<input type="submit" value="글쓰기"> -->
<!-- </form>	 -->
		

<script>

$(document).on('mouseover', '.qline', function() {
	$(this).css({
		"background-color" : "lightblue"
	});
});
$(document).on('mouseout', '.qline', function() {
	$(this).css({
		"background-color" : "white"
	});
});

</script>
</body>
</html>