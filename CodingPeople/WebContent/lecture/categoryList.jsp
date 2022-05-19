<%@page import="lecture.vo.categoryVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<categoryVO> ctlist = (List<categoryVO>)request.getAttribute("list");
	
	for(int i=0; i<ctlist.size() ; i++) {
		
%>
	<option value="<%=ctlist.get(i).getCategoryId() %>"><%=ctlist.get(i).getCategoryName() %></option>
<% 	
	} //for end
%>