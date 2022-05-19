<%@page import="trainerHome.vo.TrainerHomeVO"%>
<%@page import="trainerVideo.vo.TrainerVideoVO"%>
<%@page import="java.util.List"%>
<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<TrainerVideoVO> videoList = (List<TrainerVideoVO>) request.getAttribute("videoList");

	String msg = request.getParameter("msg") == null ? "" : request.getParameter("msg");
	
	TrainerHomeVO tvo = (TrainerHomeVO) request.getAttribute("tvo");
	MemberVO vo = (MemberVO) session.getAttribute("memVO");
	String trainerId = /* vo.getMemId(); */ "a100";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../../js/jquery-3.6.0.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<style>
#video{
 text-align: center;
}
</style>

</head>
<body>
	<section class="main-intro">
	<div id="video">
		<%
			int videoSize = videoList.size();
			if (videoSize > 0) {
				for (int i = 0; i < videoSize; i++) {
					if (videoList.get(i).getStatus() == "4") {
						continue;
					}
		%>
		<br>
		<div class="video">
			<video preload="metadata" controls width="500px" height="300px"> 
				<source src="/Breath/showImage.LineFeed?url=<%=videoList.get(i).getFilePath()%>#t=1.5" type="video/mp4">
				</source>
			</video>
		</div>
		<div class="contentNum">
			<span>게시번호 - NO.<%=videoList.get(i).getContentNum()%></span>
		</div>
		<br>
		<div class="content">
			<span><%=videoList.get(i).getContent()%></span>
		</div>
		<br>
		<div class="form-group">
		<button type="button" class="btn btn-info" id="update<%=videoList.get(i).getContentNum()%>">수정</button>
		<button type="button" class="btn btn-danger" id="delete<%=videoList.get(i).getContentNum()%>">삭제</button>
		</div>
		<br>
		<%
			  }
			} else {
		%>
		<div>비디오 정보가 없습니다.</div>
		<%
			}
		%>
	</div>
	</section>
	<script>
	  $('video').on('click', function() {
		  
		  if(this.requestFullScreen){ 
			  this.requestFullScreen(); 
		  } else if(this.webkitRequestFullScreen){ 
			  this.webkitRequestFullScreen(); 
		  } else if(this.mozRequestFullScreen) {
			  this.mozRequestFullScreen();
		  }
	  });
	  
	  $('[id^=update]').on('click', function(){ 
			 var id = $(this).attr("id"); 
			 var number = id.replace("update", "");
			 			 
			 updatefile(number); 
		 });
		  
		 $('[id^=delete]').on('click', function(){ 
			 var id = $(this).attr("id"); 
			 var number2 = id.replace("delete", ""); 

			 deletefile(number2); 
		 });
  </script>
</body>
</html>
