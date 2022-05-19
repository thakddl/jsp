<%@page import="qnaboard.vo.qnaBoardVO"%>
<%@page import="qnaboard.vo.qnaBoardReplyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	String msg = request.getParameter("msg") == null ? "" : request.getParameter("msg");
	String post_num= (String)request.getAttribute("qbr");
	qnaBoardReplyVO qbrV = (qnaBoardReplyVO)request.getAttribute("qbrV");
	List<qnaBoardReplyVO> br = (List<qnaBoardReplyVO>)request.getAttribute("boardReplyList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 등록</title>
<script src="./js/jquery-3.6.0.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./css/bootstrap.min.css">
</head>
<body>
   	
   	<jsp:include page="/mainHeader.jsp" flush="true"/>
   	
   	
   	<form action="detail.qnaBoard?post_num=<%=post_num %>" method="post">
   	<input type="hidden" name="comment_num" value="<%=qbrV.getComment_num() %>">
   	<input type="hidden" name="comm_dt" value="<%=qbrV.getComm_dt() %>">
   	<input type="hidden" name="post_num" value="<%=qbrV.getPost_num() %>">
   	
   	
   	
		<table>
			<tr>
				<td>글번호 : </td>
				<td><%=post_num%></td>
			</tr>
			<tr>
				<td>댓글 : </td>
				<td>
					<textarea name="content" cols="10" rows="2"></textarea>
				</td>
			</tr>
		</table>
	    <input type="submit" value="댓글달기">
	</form>
	
	<jsp:include page="/mainFooter.jsp" flush="true"/>
	
<%
	if(msg.equals("성공")){
%>
	<script>
		alert('정상적으로 처리되었습니다.');
	</script>
<%
	}

%>
</body>
</html>