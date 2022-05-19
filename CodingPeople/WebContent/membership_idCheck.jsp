<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int cnt = (Integer) request.getAttribute("isExist");

	if(cnt > 0){
%>
		{
			"id" : "ok"
		}
<%		
	}else{
%>
		{
			"id" : "no"
		}
<%
	}
%>