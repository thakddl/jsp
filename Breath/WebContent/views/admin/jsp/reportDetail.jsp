<%@page import="admin.vo.AdminVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// servlet에서 값 가져 오기
	AdminVO vo = (AdminVO) request.getAttribute("vo");
%>
[
			{
				"memId"		: "<%=vo.getMemId() %>",
				"athrtCode"	: "<%=vo.getAthrtCode() %>",
				"status"	: "<%=vo.getStatus() %>",
				"memNm"		: "<%=vo.getMemNm() %>",
				"nickName"	: "<%=vo.getNickName() %>"
			}			
]