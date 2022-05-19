<%@page import="QuestionBoard.VO.QuestionBoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	QuestionBoardVO bv = (QuestionBoardVO) request.getAttribute("bv");
%>    
<html>
  <head>
    <meta charset="UTF-8">
	<title>글 수정</title>
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
	<form action="update.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="boardId" value="<%=bv.getBoardId() %>">
		<table border="1">
			<tr>
				<td>번호</td>
				<td><%=bv.getPostId() %><input type="hidden" name="postId" value="<%=bv.getPostId() %>"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><textarea name="postTitle" rows="1" cols="50"><%=bv.getPostTitle() %></textarea></td>
			</tr>
			<tr>
				<td>글쓴이</td>
				<td><%=bv.getMemId()%><input type="hidden" name="memId" value="<%=bv.getMemId()%>"></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><%=bv.getPostDate()%><input type="hidden" name="postDate" value="<%=bv.getPostDate()%>"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="postContent" rows="7" cols="80"><%=bv.getPostContent() %></textarea></td>
			</tr>
		</table>
		<input type="submit" value="수정완료">
	</form>
	 </div>
            <div id="questionboard2">
              <button type="button" onclick="location.href='questionboard/insert.do'">게시글작성</button>
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