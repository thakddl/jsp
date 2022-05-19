<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%  // 인증된 세션이 없는경우, 해당페이지를 볼 수 없게 함.
    if (session.getAttribute("memId") == null) {
        response.sendRedirect("header.jsp");
    } else 	if (session.getAttribute("memId").equals("admin1")) {
	    response.sendRedirect("managerHeader.jsp");
	}
	String memId = (String) session.getAttribute("memId");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="../js/jquery-3.6.0.min.js"></script>
<script>
	  $(document).ready(function(){
		  let memId = "<%= memId %>";
			$.ajax({
				type : 'get'
				,url : '/Member/info.do'		//요청
				,dataType : 'html'			//응답(필수)
				,data : { 'memId' : memId }
				,success : function(data){
				  $('.nav1').html(data);
				}	//응답(필수)
				,error : function(xhr){
					alert("상태 >> " + xhr.status);
				}						//응답(필수)
			});   
	  });   
   </script>
<link rel="stylesheet" href="/css/coding.css">
</head>
<body>
	<div id="logo">
		<a href="/mainhome.jsp">
			<h1>Coding People</h1>
		</a>
	</div>
	<nav class="nav1"> </nav>
	<nav class="nav2">
	<ul id="bottomMenu">
		<li><a href="/lecturesignup.jsp">프로그래밍</a></li>
		<li id=bottomMenuli>/</li>
		<li><a href="/freeboard.jsp">커뮤니티</a></li>
		<li id=bottomMenuli>/</li>
		<li><a href="/studygroup.jsp">스터디그룹</a></li>
	</ul>
	</nav>
</body>
</html>