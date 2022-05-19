<%@page import="coin.vo.MemberVO"%>
<%@page import="coin.service.CoinServiceImpl"%>
<%@page import="coin.service.IcoinService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String memId = "";
	String boardId = "";
	String boardNm;
	MemberVO mv= null;
	//어느 게시판에서 왔는지 검사
	System.out.println("insertform= boardid" + request.getAttribute("boardId"));
	if (request.getAttribute("boardId") != null) {
		boardId = (String) request.getAttribute("boardId");
		if (boardId.equals("2")) {
			boardNm = "질의응답게시판";
		} else {
			boardNm = "문의게시판";
		}
	} else {
		boardId = "1";
		boardNm = "자유게시판";
	}
	if (session.getAttribute("memId") == null) {
%>
<script>
	alert("로그인 후 사용 가능합니다");
	window.location.href = "/login.jsp";
</script>
<%
	} else {
		if (boardId == null) {
			boardId = "1";
		}
		memId = (String) session.getAttribute("memId");
		IcoinService service = CoinServiceImpl.getInstance();
		mv = service.getMember(memId);
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Coding People</title>
<link rel="stylesheet" href="../css/coding.css">
<script src="../js/jquery-3.6.0.min.js"></script>


<script>
	$(document).ready(function() {
		$('#header').load("../header/loginheader.jsp");
		$('#aside').load("../side/side4.jsp");
		$('#footer').load("../footer/footer.jsp");
		
		$('#selection').on('change',function(){
			if(<%=mv.getMemCoin()%> < $('#selection').val()){
			$('#selection').val(<%=mv.getMemCoin()%>);
			alert("코인이 부족합니다.");
			}
		});
	});
	
	$(document).on("mouseover", ".line", function() {
		$(this).css({
			"background-color" : "skyblue"
		});
	});
	$(document).on("mouseout", ".line", function() {
		$(this).css({
			"background-color" : "white"
		});
	});

	$(document).on("click", ".line", function() {
		let val = $(this).children().eq(0).text();
		location.href = "/board/detail.do?boardId=1&postId=" + val;
	});

	$(document).on("load", function() {
		if (msg.equals("성공")) {
			alert('정상적으로 처리되었습니다.');
		}
	});
</script>
<style>
table {
	border-collapse: collapse;
	margin: 5px 10px;
	width: 950px;
}

table th {
	padding: 10px;
	font-weight: bold;
	color: #369;
	border-bottom: 3px solid #036;
}

table td {
	padding: 10px;
	border: 1px solid #ccc;
}

#insert {
	margin-left: 425px;
	text-align: center;
	width: 150px;
	height: 40px;
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
					<div id="freeboard" action="search.jsp">
					<% String bm = "자유게시판"; 
					if(boardId.equals("2")){
						bm = "질의응답게시판";
					} else if(boardId.equals("3")){
						bm = "문의게시판";
					}
					%>
						<%=bm%> <input type="search" id="boardsearch" placeholder="게시글 검색"
							required> <input type="button" id="freeboard_buttons"
							value="검색하기">
					</div>
					<div id="freeboard1">
						<form action="insert.do" method="post"
							enctype="multipart/form-data">
							<table>
								<%
									if (boardId.equals("2")) {
								%>
								<tr>
									<td>보상걸기</td>
									<td><input id="selection" type="text" name="postPoint" min="0" max="<%=mv.getMemCoin()%>"></td>
								</tr>
								<%
									}
								%>
								<tr>
									<td>제목</td>
									<td><textarea name="postTitle" rows="2" cols="50"
											style="resize: vertical; width: 800px; height: 30px;"></textarea></td>
								</tr>
								<tr>
									<td>글쓴이</td>
									<td><input type="text" name="memId" value="<%=memId%>"
										readonly style="width: 800px; height: 20px;"></td>
								</tr>
								<tr>
									<td>내용</td>
									<td><textarea name="postContent" rows="20" cols="50"
											style="resize: vertical; width: 800px; height: 250px; overflow: scroll;"></textarea></td>
								</tr>
								<tr>
									<td>첨부파일 :</td>
									<td><input type="file" name="atchFile" multiple="multiple"></td>
								</tr>
							</table>
							<input type="hidden" name=boardId value="<%=boardId%>">
							<input id="insert" type="submit" value="글 쓰기">
						</form>
					</div>
					<div id="freeboard2"></div>
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