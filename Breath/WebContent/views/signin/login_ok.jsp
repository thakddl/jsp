<%@page import="linefeed.controller.GetAllPostServlet"%>
<%@page import="member.vo.MemberVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	MemberVO vo = (MemberVO) request.getAttribute("vo");
 	
  	if(vo != null){
//   	session.setAttribute("memVO", vo);
%>
  {
    "cd" : "ok",
    "str" : "<%=vo.getNickName() %>님 환영합니다 ^^"
  }
<% 
  } else{
%>
  {
    "cd" : "no",
    "str" : "아이디 또는 비밀번호를 확인하세요!"
  }
<% 
  } // if - else end
%>  