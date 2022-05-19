<%@page import="QuestionReply.VO.QuestionReplyVO"%>
<%@page import="QuestionBoard.VO.QuestionBoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	QuestionBoardVO bv = (QuestionBoardVO) request.getAttribute("bv");

	QuestionReplyVO rv = (QuestionReplyVO) request.getAttribute("rv");

	List<QuestionReplyVO> list = (List<QuestionReplyVO>)request.getAttribute("replyList");
	
	String memId = "";
	if (session.getAttribute("memId") == null) {
%>
<script>
		alert("로그인 후 사용 가능합니다");
		window.location.href="/login.jsp";
</script>
<%
	} else {
		memId = (String)session.getAttribute("memId");
	}
%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Coding People</title>
    <link rel="stylesheet" href="../css/coding.css">
    <script src="../js/jquery-3.6.0.min.js"></script>
    
    <script>
   	  $(document).ready(function(){
   	    $('#header').load("../header/loginheader.jsp");
        $('#aside').load("../side/side4.jsp");
        $('#footer').load("../footer/footer.jsp");
   	  });
    </script>
<style>
table {
  border-collapse: collapse;
  text-align: left;
  line-height: 1.5;
  margin : 20px 10px;
  width: 750px;
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
.replydiv{
 padding: 5px;
 width: 500px;
 height : 150px;
 border: 1px solid black;
}
.replylist{
 padding: 5px;
 width: 500px;
 height : 300px;
 border: 1px solid black;
 overflow:  scroll;
}
#ta {
 width: 450px;
 height : 80px;
 border: 1px solid black;
}
.reply {
  border: 1px solid black;
  display: block
}
</style>
    
  </head>

  <body>
    <%-- 전체 --%>
    <div id="wrap-container">
      <%-- 헤더 호출 --%>
      <header id="header">        
      </header>

      <%-- 사이드바+본문 --%>
      <div class="container">
        <%-- 사이드바 --%>
        <aside id="aside">
        </aside>

        <%-- 본문 --%>
        <section id="contents_questionboard">
          <%-- 자유게시판 메인 --%>
          <div id="questionboard_center">          
            <div id="questionboard">
				<form action="search.jsp">
					<select>
						<option>번호</option>
						<option>제목</option>
						<option>글쓴이</option>
						<option>작성일</option>
					</select>
		            <input type="search" id="questionboardsearch" placeholder="게시글 검색" required>
		            <input type="button" id="questionboard_buttons" value="검색하기">
				</form>
            </div>
            <div id="questionboard1">
			            	<table border="1">
					<tr>
						<th>번호</th>
						<th><%= bv.getPostId() %> </th>
						<th>제목</th>
						<th><%= bv.getPostTitle() %> </th>
					</tr>
					<tr>
						<td>글쓴이</td>
						<td><%= bv.getMemId() %> </td>
						<td>작성일</td>
						<td><%= bv.getPostDate() %> </td>
					</tr>
					<tr>
						<td colspan="4">내용</td>	
					</tr>
					<tr>
						<td colspan="4"><%= bv.getPostContent().replace("\r\n", "<br>") %></td>	
					</tr>					
				</table>
				<button class="button" type="button" onclick="location.href='/questionboard.jsp' ">이전화면</button>
				<button class="button" type="button" onclick="location.href='update.do?postId=<%=bv.getPostId() %>&boardId=<%=bv.getBoardId() %>&postMemId=<%= bv.getMemId() %>' ">글 수정</button>
				<button class="button" type="button" onclick="location.href='delete.do?postId=<%=bv.getPostId() %>&boardId=<%=bv.getBoardId() %>&postMemId=<%= bv.getMemId() %>' ">글 삭제</button>
				<br><br>
				
				<div class='replydiv'>
				  <form action="ReplySave.do" method="post">
					<p class="p4">
					  <input type="hidden" value="1" name="boardId">
					  <input type="hidden" value="<%=memId %>" name="memId">
					  <input type="hidden" value="<%= bv.getPostId() %>" name="postId">
				      <textarea id="ta" cols="100" name="replyContent"></textarea>
				    </p>
					<input type="submit" value="댓글 쓰기">
				</form>
				</div>
				
				<div class="replylist">
			<%
				int boardSize = list.size();
				if( boardSize > 0){
					for(int i=0; i<boardSize; i++){
			%>
					<P>
						<div class="reply">
							<%= list.get(i).getMemId()%> <br>
							<%= list.get(i).getReplyDate()%> <br><hr>
							내용 <br>
							<%= list.get(i).getReplyContent()%> <br>
							
				<button class="button" type="button" onclick="location.href='updatereply.jsp?postId=<%=bv.getPostId() %>&boardId=<%=bv.getBoardId() %>&replyId=<%=list.get(i).getReplyId() %>&replyMemId=<%= list.get(i).getMemId()%>' ">댓글 수정</button>
				<button class="button" type="button" onclick="location.href='ReplyDelete.do?postId=<%=bv.getPostId() %>&boardId=<%=bv.getBoardId() %>&replyId=<%=list.get(i).getReplyId() %>&replyMemId=<%= list.get(i).getMemId()%>' ">댓글 삭제</button>
						</div>
					</P>
							
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
            <div id="questionboard2">
              <button type="button" onclick="location.href='/questionboard/insert.do'">게시글작성</button>
            </div>
          </div>
          <div class="button_questionboard">
            <div id="button_questionboard">
              <input type="button" value="뒤로가기" onClick="history.go(-1)">
            </div>
          </div>
        </section>
      </div>
      <%-- 푸터영역 --%>
      <footer id="footer">
      </footer>
    </div>
  </body>
</html>  
