<%@page import="QuestionReply.VO.QuestionReplyVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	String postId = request.getParameter("postId");
	String boardId = request.getParameter("boardId");
	String replyId = request.getParameter("replyId");
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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>댓글 수정</title>
</head>
<body>
	<form action="QuestionReplyUpdate.do" method="post">

		<table>
			<tr>
				<td><input type="hidden" value="<%=boardId %>" name="boardId"></td>
		 		<td><input type="hidden" value="<%=postId %>" name="postId"></td>
		 		<td><input type="hidden" value="<%=replyId %>" name="replyId"></td>
		 		<td><input type="hidden" value="<%=memId %>" name="memId"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="replyContent" id="ta" cols="100" ></textarea></td>
			</tr>
		  	  
		</table>
		<input type="submit" value="댓글 수정">
	</form>


</body>
</html>