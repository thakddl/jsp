<%@page import="notice.vo.NoticeVO"%>
<%@page import="java.util.List"%>
<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO mv = (MemberVO) session.getAttribute("memVO");
	List<NoticeVO> list = (List<NoticeVO>) request.getAttribute("list");
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
<script src="./js/summernote/lang/summernote-ko-KR.js"></script>
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
  
<title>Notice Board</title> 
  
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
	
<div class="container">
	<table class="table">
		<tr>
			<th>NO</th>
			<th>작성자</th>
			<th>제목</th>
			<th>날짜</th>
		</tr>
<% 
	if (list != null && list.size() > 0){	
		
		for(int i = 0 ; i < list.size(); i++){
%>
		<tr class="nline">
			<td><%=list.get(i).getPostNum() %></td>
			<td><%=list.get(i).getNickName() %></td>
			<td style="cursor:pointer;" onclick="location.href='<%=request.getContextPath()%>/NoticeDetail.do?postNum=<%=list.get(i).getPostNum()%>'"><%=list.get(i).getTitle() %></td>
			<td><%=list.get(i).getPostDt() %></td>
		</tr>
<% 
		}
		
	} else {
%>
		<tr>
			<td colspan="4">목록이 없습니다!</td>
		</tr>
<%		
	}
%>
	</table>
<%	
	if (mv.getAthrtCode().equals("0")) {
%>
		<button type="button" class="btn btn-success btn-sm" id="wbtn" onclick="location.href='/Breath/insertNotice.do'">글쓰기</button>
		<br>
<%
	}	
%>		
</div>	

<!-- <form action="serchNotice" method="post"> -->

<!-- 	<select name="searchKey" > -->
<!-- 		<option value="title">제목</option> -->
<!-- 		<option value="content">내용</option> -->
<!-- 	</select>  -->
<!-- 	<input type="text" name="searchValue" /> -->
	
<!-- 	<input type="submit" value="검색" /> -->
	
<!-- </form> -->

<jsp:include page="/mainFooter.jsp" flush="true"/>

<script>

$(document).on('mouseover', '.nline', function() {
	$(this).css({
		"background-color" : "lightblue"
	});
});
$(document).on('mouseout', '.nline', function() {
	$(this).css({
		"background-color" : "white"
	});
});




</script>



</body>
</html>