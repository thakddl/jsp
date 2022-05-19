<%@page import="Board.VO.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script src="../js/board.js"></script>
<script src="../js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="../css/lhbcss.css">
<script src="../js/bootstrap.min.js"></script>
<style>
#pager {
	text-align: center;
 }	
</style>
<script>
    	
//     	let currentPage = 1;
    
// 		listServer(1);    	
    </script>

<%
	List<BoardVO> boardList = (List<BoardVO>) request.getAttribute("boardList");
	List<String> pbList = (List<String>) request.getAttribute("pbList");
	String msg = request.getParameter("msg") == null ? "" : request.getParameter("msg");
	String boardId = boardList.get(0).getBoardId();
	int nowPage = Integer.parseInt((String) request.getAttribute("nowPage"));
	int pageLange = Integer.parseInt((String) request.getAttribute("pageLange"));
	int totalPageQty = Integer.parseInt((String) request.getAttribute("totalPageQty"));

%>
<div id="tablearea">
<table class="table" border="1">
	<tr>
		<th scope="col">번호</th>
	<% if(boardId.equals("2")) {	%>
		<th scope="col">보상(C)</th>
		<th scope="col">답변채택</th>
	<%}	%>
		<th scope="col">제목</th>
		<th scope="col">글쓴이</th>
		<th scope="col">조회수</th>
		<th scope="col">작성일</th>
	</tr>
<%
	if(boardList.size()>0) {
		for(BoardVO bvo : boardList) {
%>
			<tr class="line">
				<td scope="row"><%=bvo.getPostId()%></td>
		<% if(boardId.equals("2")) {	
				String cmt = "미채택";
				if(bvo.getPostReplyId() != null) {
					cmt = "채택완료";
				}
		%>
				<td scope="col"><%=bvo.getPostPoint()%></td>
				<td scope="col"><%=cmt%></td>
		<%}	%>
				<td><%= bvo.getPostTitle()%></td>
				<td><%= bvo.getMemId()%></td>
				<td><%= bvo.getPostViews()%></td>
				<td><%= bvo.getPostDate().substring(0,10)%></td>
			</tr>

	<%	
		}
	%>

	<%
	} else {
	%>
		<tr>
			<td colspan="5">게시글이 없습니다.</td>
		</tr>
		<%		
	}
%>
	</table>
	<div id="pager">
		<ul class="pagination">
	<%
	for(String pb : pbList) {
		String pbv = pb;
		if(pb.equals("pre")){
			pbv = String.valueOf( (nowPage - pageLange) > 0 ?
					(nowPage - pageLange) : 1 ) ;
		}
		if(pb.equals("next")){
			pbv = String.valueOf( (nowPage + pageLange) > totalPageQty ?
					totalPageQty : (nowPage + pageLange)   ) ;
		}

		if(pb.equals(String.valueOf(nowPage))) {
	%>
	
		<li class="page-item active" aria-current="page">
		
	<%	
		} else {
	%>
	
		<li  class="page-item">

	<%
		}	//if(pb.equals(String.valueOf(nowPage)))
	%>
		<a class="page-link" value="<%=pbv%>" href="#"> <%=pb%></a>
	<%
	}	//for
	%>
	
		</ul>
	</div>
	<script>
		$('.page-link').on("click", function(){
			$.ajax({
				 type : 'get'
				,url : '/board/list.do'		//요청
				,data : {"boardId" : "<%=boardId%>",
					"nowPage" : $(this).attr('value')}
				,dataType : 'html'			//응답(필수)
				,success : function(data){
				  $('#freeboard1').html(data);
				}	//응답(필수)
				,error : function(xhr){
					alert("상태 >> " + xhr.status);
				}						//응답(필수)
	   		});			
		});
	</script>
<%-- 	request.getAttribute("nowpage")=<%=request.getAttribute("nowPage") %> --%>
<%-- 	request.getAttribute("pageLange")=<%=request.getAttribute("pageLange") %> --%>
</div>
<div ></div>
