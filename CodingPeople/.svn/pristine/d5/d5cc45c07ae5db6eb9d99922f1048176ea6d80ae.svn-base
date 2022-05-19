<%@page import="book.VO.BookVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<BookVO> list = (List<BookVO>) request.getAttribute("list");	


	for(int i=0; i<list.size() ; i++) {
%>
	<option value="<%=list.get(i).getBookGradeId() %>"><%=list.get(i).getBookGradeId() %></option>
<% 	
	} //for end
%>