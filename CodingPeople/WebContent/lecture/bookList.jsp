<%@page import="lecture.vo.BookInfoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<BookInfoVO> bList = (List<BookInfoVO>)request.getAttribute("list");
%>
	
	<option value=null>연관도서 없음</option>
<%
	for(int i=0; i<bList.size() ; i++) {
		
%>
	<option value="<%=bList.get(i).getBookinfoId() %>"><%=bList.get(i).getBookinfoNm() %></option>
<% 	
	} //for end
%>
