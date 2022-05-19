<%@page import="book.VO.BookInfoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	
	List<BookInfoVO> list = (List<BookInfoVO>) request.getAttribute("list");

for(int i=0; i<list.size() ; i++) {
	
%>
	<option value="<%=list.get(i).getBookInfoId() %>"><%=list.get(i).getBookInfoNm() %></option>
<% 	
	} //for end
%>