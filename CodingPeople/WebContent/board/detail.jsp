<%@page import="atch.VO.AtchFileVO"%>
<%@page import="Reply.VO.ReplyVO"%>
<%@page import="Board.VO.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	BoardVO bv = (BoardVO) request.getAttribute("bv");

	ReplyVO rv = (ReplyVO) request.getAttribute("rv");

	List<AtchFileVO> atchFileList = (List<AtchFileVO>) request.getAttribute("atchFileList");

	List<ReplyVO> list = (List<ReplyVO>) request.getAttribute("replyList");

	String memId = "";
	String boardId = bv.getBoardId();
	if (session.getAttribute("memId") == null) {
%>
<script>
	alert("로그인 후 사용 가능합니다");
	window.location.href = "/login.jsp";
</script>
<%
	} else {
		memId = (String) session.getAttribute("memId");
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Coding People</title>
<link rel="stylesheet" href="../css/coding.css">
<script src="../js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="../css/lhbcss.css">
<script src="../js/bootstrap.min.js"></script>

<script>
	$(document).ready(function() {
		$('#header').load("../header/loginheader.jsp");
		$('#aside').load("../side/side4.jsp");
		$('#footer').load("../footer/footer.jsp");
	});
</script>
<style>
table {
	border-collapse: collapse;
	text-align: center;
	line-height: 1.5;
	margin: 20px 10px;
	width: 950px;
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

.replydiv {
	margin-left: 10px;
	width: 950px;
	height: 80px;
}

.replybutton1 {
	width: 80px;
	height: 60px;
	float: right;
	margin-top: 10px;
	margin-right: 5px;
}

.replylist {
	margin: 10px;
	width: 960px;
	height: 200px;
	overflow: scroll;
}

#ta {
	width: 850px;
	height: 80px;
}

.reply {
	height: 30px;
	display: block
}

.reply button {
	height: 20px;
}

.reply2 {
	height: 40px;
	display: block;
	border: 1px solid black;
}

.buttonreply { 
	float: right;
}
#coin {
  text-align: left;
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
						<%=bm%> <input type="button" id="freeboard_buttons" value="검색하기">
						<input type="search" id="boardsearch" placeholder="게시글 검색"
							required>
					</div>
					<div id="freeboard1">
						<table class="table" border="1">
							<tr>
								<th>번호</th>
								<th><%=bv.getPostId()%></th>
								<th>제목</th>
								<th><%=bv.getPostTitle()%></th>
							</tr>
							<tr>
								<td>글쓴이</td>
								<td><%=bv.getMemId()%></td>
								<td>작성일</td>
								<td><%=bv.getPostDate()%></td>
							</tr>
							<%
								if(bv.getBoardId().equals("2")) {
									String selection = "답변 미채택";
									if(bv.getPostReplyId() != null) {
										selection = "채택 완료";
									}
							%>
							<tr>
								<td>채택보상</td>
								<td id="coin" >&nbsp;&nbsp;&nbsp;<%=bv.getPostPoint() %>코인</td>
								<td>답변채택</td>
								<td id="coin" >&nbsp;&nbsp;&nbsp;<%=selection %></td>
							</tr>
							<%
								}
							%>
							<tr>
								<td colspan="4"><%=bv.getPostContent().replace("\r\n", "<br>")%></td>
							</tr>
							<tr>
								<td>첨부파일</td>
								<td colspan="4">
									<%
										if (atchFileList != null) {
											for (AtchFileVO fileVO : atchFileList) {
									%>
									<div>
										<a
											href="<%=request.getContextPath()%>/download.do?fileId=<%=fileVO.getAtchFileId()%>&fileSn=<%=fileVO.getFileSn()%>"><%=fileVO.getOrignlFileNm()%></a>
									</div> <%
 	}
 	}
 %>
								</td>
							</tr>
						</table>
						<div class='replydiv'>
							<form action="ReplySave.do" method="post">
								<p class="p4">
									<input type="hidden" value="<%=boardId%>" name="boardId"> <input
										type="hidden" value="<%=memId%>" name="memId"> <input
										type="hidden" value="<%=bv.getPostId()%>" name="postId">
									<textarea id="ta" cols="100" name="replyContent"
										style="resize: vertical;"></textarea>
									<input type="submit" class="replybutton1" value="댓글 쓰기">
								</p>
							</form>
						</div>

						<div class="replylist">
							<%
								int boardSize = list.size();
								if (boardSize > 0) {
									for (int i = 0; i < boardSize; i++) {
							%>
							<p class="preply">
							<div class="reply">
								<%=list.get(i).getMemId()%>
								(<%=list.get(i).getReplyDate()%>)
								<%
									if (memId.equals(list.get(i).getMemId())) {
								%>
								
								<button class="buttonreply" type="button"
									onclick="window.open('updatereply.jsp?postId=<%=bv.getPostId()%>&boardId=<%=bv.getBoardId()%>&replyId=<%=list.get(i).getReplyId()%>&replyMemId=<%=list.get(i).getMemId()%>', 'pop1', 'width=650, height=300, left=300, top=50')">댓글
									수정</button>
								<button class="buttonreply" type="button"
									onclick="location.href='ReplyDelete.do?postId=<%=bv.getPostId()%>&boardId=<%=bv.getBoardId()%>&replyId=<%=list.get(i).getReplyId()%>&replyMemId=<%=list.get(i).getMemId()%>' ">댓글
									삭제</button>
								<%
									}
										if(bv.getBoardId().equals("2")&&memId.equals(bv.getMemId())&&bv.getPostReplyId()==null) {
								%>
										<button class="button" type="button" onclick="location.href='selection.do?postId=<%=bv.getPostId()%>&boardId=<%=bv.getBoardId()%>&postMemId=<%=bv.getMemId()%>&postPoint=<%=bv.getPostPoint()%>&replyId=<%=list.get(i).getReplyId()%>&replyMemId=<%=list.get(i).getMemId()%>' ">
										채택</button>
								<%
										}
										if(bv.getBoardId().equals("2")&&bv.getPostReplyId() != null) {
											String pri = bv.getPostReplyId();
											
											if( pri.equals(list.get(i).getReplyId())) {
												%>
												<span style="color:red">채택완료!</span>
												<%
											}
										}
									
								%><hr>


							</div>
							<div class="reply2"><%=list.get(i).getReplyContent()%></div>
							</p>

							<%
								}
								} else {
							%>
							<div>댓글이 없습니다.</div>
							<%
								}
							%>

						</div>
					</div>
					<div id="freeboard2">
<!-- 						<button type="button" onclick="location.href='board/insert.do'">게시글작성</button> -->
						<%
							if (memId.equals(bv.getMemId())) {
						%>
						<button class="btn btn-primary" type="button"
							onclick="location.href='update.do?postId=<%=bv.getPostId()%>&boardId=<%=bv.getBoardId()%>&postMemId=<%=bv.getMemId()%>&postPoint=<%=bv.getPostPoint()%>' ">글
							수정</button>
						<button class="btn btn-primary" type="button"
							onclick="location.href='delete.do?postId=<%=bv.getPostId()%>&boardId=<%=bv.getBoardId()%>&postMemId=<%=bv.getMemId()%>&postPoint=<%=bv.getPostPoint()%>' ">글
							삭제</button>
						<%
							}
						%>
						<button class="btn btn-primary"  type="button"
							onclick="location.href='/freeboard.jsp' ">이전화면</button>
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
