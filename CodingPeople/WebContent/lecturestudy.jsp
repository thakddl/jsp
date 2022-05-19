<%@page import="lecture.vo.LectureVO"%>
<%@page import="lecture.vo.CourseVO"%>
<%@page import="atch.VO.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String msg = (String) request.getAttribute("msg");

	List<AtchFileVO> atchFileList = (List<AtchFileVO>) request.getAttribute("atchFileList");
	List<LectureVO> lvList = (List<LectureVO>) request.getAttribute("lvList");
	CourseVO cv = (CourseVO) request.getAttribute("cv");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Coding People</title>
<script src="../js/jquery-3.6.0.min.js"></script>
<script>
 	  	$(document).ready(function(){
 	  	<%if (session.getAttribute("memId") == null) {
				response.sendRedirect("login.jsp");
			} else {%>
				let msg = "<%=msg%>";
				if(msg == "성공"){
					alert('정상적으로 처리되었습니다.');	
				}
		<%} // else end%>
 	  		
 	  		$('.line').on('mouseover',function(){
 	  			$(this).css({"background-color" : "skyblue"});
 	  		});
 	  		
 	  		$('.line').on('mouseout',function(){
 	  			$(this).css({"background-color" : "white"});
 	  		});
 	  		
 	  		$('.line').on('click',function(){
 	  			let index = $(this).attr("id");
 	  			let courseId = "<%=cv.getCourseId()%>";
							$.ajax({
								type : 'get',
								url : '/lecture/transition.do' //요청
								,
								data : {
									'index' : index,
									'courseId' : courseId
								},
								dataType : 'html' //응답(필수)
								,
								success : function(data) {
									$('.mainview').html(data);
								} //응답(필수)
								,
								error : function(xhr) {
									alert("상태 >> " + xhr.status);
								} //응답(필수)
							});
						});
					});
</script>
<style>
#mainform {
	width: 1300px;
	height: 800px;
	margin: 20px auto;
}

.title {
	text-align: center;
	font-size: 40px;
}

.mainview {
	border: 1px solid black;
	float: left;
	text-align: center;
	width: 65%;
	margin: 20px auto;
}

.list {
	border: 1px solid black;
	float: left;
	width: 30%;
	margin-top: 20px;
}

.line{
	text-align: center;
}

video {
	width: 800px;
	height: 600px;
	margin: 20px auto;
}

img {
	width: 800px;
	height: 600px;
	margin: 20px auto;
}
</style>
</head>
<body>
	<div class=title>
		<%=cv.getCourseTitle()%>
	</div>
	<form id="mainform">
		<div class="mainview">
				<img src="../img/videoMain.jpg">
		</div>
		<div class="list">
			<table border="1">
				<tr>
					<td colspan="2"><%=cv.getCourseIntroduction()%></td>
				</tr>
				<%
					for (int i = 0; i < lvList.size(); i++) {
				%>
				<tr class="line" id="<%=i%>">
					<td><%=i + 1%></td>
					<td><%=lvList.get(i).getLectureTitle()%></td>
				</tr>
				<%
					} // for end
				%>
			</table>
		</div>
	</form>
</body>
</html>