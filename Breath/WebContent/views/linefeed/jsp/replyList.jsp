<%@page import="java.util.concurrent.TimeUnit"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.sql.Date"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalTime"%>
<%@page import="reply.vo.ReplyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<ReplyVO> replyList = (List<ReplyVO>) request.getAttribute("replyList");
	
	
%>
	{
	"data" : [
<%
	for (int i = 0; i < replyList.size(); i++) {
		ReplyVO rv = replyList.get(i);
		
		String time = rv.getCommDt();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String strDate = time;	
		long now =  System.currentTimeMillis();
		long past = sdf.parse(strDate).getTime();
		long timeLog1 = now - past;
		long timeLog2 = TimeUnit.MILLISECONDS.toMinutes(timeLog1);
		
		if (rv.getStatus() == "4") {
			continue;
		}
		
		if (i > 0) out.print(",");
%>
	{
		"commNum" : "<%=rv.getCommentNum()%>",
		"postNum" : "<%=rv.getPostNum()%>",
		"nickName" : "<%=rv.getNickName()%>",
		"content" : "<%=rv.getContent()%>",
		"timeLog" : "<%=timeLog2%>분전",
		"status" : "<%=rv.getStatus()%>"
	}	
<%
	} // for end
%>
		     ]
	}