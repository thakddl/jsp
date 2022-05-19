<%@page import="QuestionBoard.VO.QuestionBoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <script src="../js/questionboard.js"></script>
    

<%
	List<QuestionBoardVO> boardList = (List<QuestionBoardVO>) request.getAttribute("boardList");
	List<QuestionBoardVO> List = (List<QuestionBoardVO>) request.getAttribute("list");	
	
	String msg = request.getParameter("msg") == null ? "" : request.getParameter("msg");
	
%>
<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>글쓴이</th>
		<th>조회수</th>
		<th>작성일</th>
	</tr>
<%
	int boardSize = boardList.size();
	if( boardSize > 0){
		for(int i=0; i<boardSize; i++){
%>
			<tr class="line">
				<td><%= boardList.get(i).getPostId()%></td>
				<td><%= boardList.get(i).getPostTitle()%></td>
				<td><%= boardList.get(i).getMemId()%></td>
				<td><%= boardList.get(i).getPostViews()%></td>
				<td><%= boardList.get(i).getPostDate().substring(0,10)%></td>
			</tr>
<%			
		}
	} else {
%>
		<tr>
			<td colspan="5">게시글이 없습니다.</td>
		</tr>
<%		
	}
%>	
</table>
<div id="pager"></div>