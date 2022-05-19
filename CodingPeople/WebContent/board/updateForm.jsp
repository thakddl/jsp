<%@page import="coin.service.CoinServiceImpl"%>
<%@page import="coin.service.IcoinService"%>
<%@page import="coin.vo.MemberVO"%>
<%@page import="atch.VO.AtchFileVO"%>
<%@page import="Board.VO.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	
	String memId = (String) session.getAttribute("memId");
	IcoinService service = CoinServiceImpl.getInstance();
	MemberVO mv = service.getMember(memId);
	BoardVO bv = (BoardVO) request.getAttribute("bv");

	List<AtchFileVO> atchFileList = (List<AtchFileVO>) request.getAttribute("atchFileList");
	String boardId = bv.getBoardId();
%>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
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

#update {
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
						<form action="update.do" method="post"
							enctype="multipart/form-data">
							<input type="hidden" name="boardId" value="<%=bv.getBoardId()%>">
							<table border="1">
							<%
								if(bv.getBoardId().equals("2")) {
							%>		
								<tr>
									<td>보상걸기</td><input type="hidden" name="beforePoint" value="<%=bv.getPostPoint()%>">
									<td><input id="selection" type="text" name="postPoint" min="0" max="<%=mv.getMemCoin()%>" value="<%=bv.getPostPoint()%>"></td>
								</tr>
							<%
								}
							%>	
								<tr>
									<td>번호</td>
									<td><%=bv.getPostId()%><input type="hidden" name="postId"
										value="<%=bv.getPostId()%>"></td>
								</tr>
								<tr>
									<td>제목</td>
									<td><textarea name="postTitle" rows="1" cols="50"
											style="resize: vertical; width: 800px; height: 20px;"><%=bv.getPostTitle()%></textarea></td>
								</tr>
								<tr>
									<td>글쓴이</td>
									<td><%=bv.getMemId()%><input type="hidden" name="memId"
										value="<%=bv.getMemId()%>"></td>
								</tr>
								<tr>
									<td>작성일</td>
									<td><%=bv.getPostDate()%><input type="hidden"
										name="postDate" value="<%=bv.getPostDate()%>"></td>
								</tr>
								<tr>
									<td>내용</td>
									<td><textarea name="postContent" rows="7" cols="80"
											style="resize: vertical; width: 800px; height: 150px; overflow: scroll;"><%=bv.getPostContent()%></textarea></td>
								</tr>
								<tr>
									<td>기존 첨부파일:</td>
									<td>
										<%
											if (atchFileList != null) {
												for (AtchFileVO fileVO : atchFileList) {
										%>
										<div>
											<a href="#"><%=fileVO.getOrignlFileNm()%></a>
										</div> <%
 	}
 	}
 %>

									</td>
								</tr>
								<tr>
									<td>새로운 첨부파일:</td>
									<td><input type="file" name="atchFile" multiple="multiple"></td>
								</tr>
							</table>
							<input id="update" type="submit" value="수정완료">
						</form>
					</div>
					<div id="freeboard2">
						<button type="button" onclick="location.href='/board/insert.do'">게시글작성</button>
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
