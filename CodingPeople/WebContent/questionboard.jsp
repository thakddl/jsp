<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

String msg = request.getParameter("msg") == null ? "" : request.getParameter("msg");
String nowPage = (String) request.getAttribute("nowPage");
if(nowPage == null) {
	nowPage = "1";
}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Coding People</title>
<link rel="stylesheet" href="css/coding.css">
<script src="../js/jquery-3.6.0.min.js"></script>



<script>
    
//     	listServer();
    
   	  $(document).ready(function(){
   	    $('#header').load("header/loginheader.jsp");
        $('#aside').load("side/side4.jsp");
        $('#footer').load("footer/footer.jsp");
        
		$.ajax({
			 type : 'get'
			,url : '/board/list.do'		//요청
			,dataType : 'html'			//응답(필수)
			,data : {"boardId" : "3"
					,"nowPage" : "<%=nowPage%>"}
			,success : function(data){
			  $('#freeboard1').html(data);
			}	//응답(필수)
			,error : function(xhr){
				alert("상태 >> " + xhr.status);
			}						//응답(필수)
   		});
   	  });
		
		$(document).on("mouseover",".line",function(){
			$(this).css({"background-color" : "skyblue"});
		});
		$(document).on("mouseout",".line",function(){
			$(this).css({"background-color" : "white"});
		});
		
		$(document).on("click",".line",function(){
			let val = $(this).children().eq(0).text();
			location.href="/board/detail.do?boardId=3&postId="+val;
		});
		
		$(document).on("load",function(){
			if(msg.equals("성공")){
				alert('정상적으로 처리되었습니다.');	
			}
		});
	
    </script>
<style>
table {
	border-collapse: collapse;
	text-align: left;
	line-height: 1.5;
	margin: 20px 10px;
}

table th {
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	color: #369;
	border-bottom: 3px solid #036;
}

table td {
	padding: 10px;
	vertical-align: top;
	border: 1px solid #ccc;
}
#freeboard1 {
	overflow: visible;
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
			<section id="contents_freeboard">
				<%-- 자유게시판 메인 --%>
				<div id="freeboard_center">
					<div id="freeboard">
						문의게시판 <input type="button" id="questionboard_buttons" value="검색하기">
						<input type="search" id="questionboardsearch" placeholder="게시글 검색"
							required>
					</div>
					<div id="freeboard1">
						<%-- 본문몸통 --%>
					</div>
					<div id="freeboard2">
						<button type="button" class="btn btn-primary"
							onclick="location.href='/board/insert.do?boardId=3'">게시글작성</button>
					</div>
				</div>
				<div class="button_freeboard">
					<div id="button_freeboard">
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