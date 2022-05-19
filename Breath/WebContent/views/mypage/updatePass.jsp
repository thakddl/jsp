<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO vo = (MemberVO) session.getAttribute("memVO");

	String msg = request.getParameter("msg") == null ? "" : request.getParameter("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
	margin-top: 100px;
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
#ship{
	display : inline-block;
	float : left;
	padding-top : 50px;
	margin-left: 350px;

}
.greenContainer{
	padding-top : 220px;
}
#myMenu{
	display:inline-block;
	float: left;
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
<div class="wrap">
  <div class="greenContainer">
    <div>
<!--       <div class="grade">트레이너</div> -->
      <div class="name"><%=vo.getMemNm() %></div>
    </div>    
    <div class="modify">i</div>    
  </div>
   
  <div class="listContainer" id="myMenu">
    <a href="/Breath/updateMypage" class="item" id="myInformation">
        <div class="icon">ii</div>
        <div class="text">내정보<span class="circle"></span></div>
        <div class="right"> > </div>
    </a>
    <a href="/Breath/updatePass" class="item">
        <div class="icon">ii</div>
        <div class="text">비밀번호변경</div>
        <div class="right"> > </div>
    </a>
    <a href="/Breath/getShipList" class="item">
        <div class="icon">ii</div>
        <div class="text">멤버쉽 결제내역</div>
        <div class="right"> > </div>
    </a>
<!--     <a href="#" class="item"> -->
<!--         <div class="icon">ii</div> -->
<!--         <div class="text">스케줄캘린더</div> -->
<!--         <div class="right"> > </div> -->
<!--     </a> -->
        <a href="/Breath/delete.Member" class="item">
        <div class="icon">ii</div>
        <div class="text">회원탈퇴하기</div>
        <div class="right"> > </div>
    </a>
  </div>
</div>
<article class="container">
<div class="col-sm-6 col-md-offset-3">
	<form action="updatePass" method="post">
	<input type="hidden" value="<%=vo.getMemId() %>" name="memId">
	<input type="hidden" value="<%=vo.getMemPass() %>" name="memPass">
			<div class="form-group">
				<label>현재 비밀번호</label>
				<input type="password" class="form-control" name="presentMemPass">
			</div>
			<div class="form-group">
				<label>변경할 비밀번호</label>
				<input type="password" class="form-control" name="changeMemPass">
			</div>
			<div class="form-group">
				<label>비밀번호 확인</label>
				<input type="password" class="form-control" name="correctChangeMemPass">
			</div>
		<input type="submit" class="btn btn-success btn-sm" id="wbtn"value="전송">
	</form>
</div>
</article>
<%
	if(msg.equals("성공")){
%>
	<script>
		alert('정상적으로 처리되었습니다.');
	</script>
<%
	}
%>

</body>

</html>