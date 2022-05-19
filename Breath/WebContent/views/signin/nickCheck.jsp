<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String memNickname = request.getParameter("mNick");
  
  Class.forName("oracle.jdbc.driver.OracleDriver");
  String url = "jdbc:oracle:thin:@192.168.144.16:1521:xe";
  Connection conn = DriverManager.getConnection(url, "BREATH", "java");
  Statement stmt = conn.createStatement();
  String sql = "SELECT NICKNAME FROM MEMBER WHERE NICKNAME = '" + memNickname + "'";
  ResultSet rs = stmt.executeQuery(sql);
  if(rs.next()){
%>
  {
    "cd" : "no",
    "str" : "이미 존재하는 닉네임입니다."
  }
<% 
  } else{
%>
  {
    "cd" : "ok",
    "str" : "사용가능한 닉네임입니다."
  }
<% 
  } // if - else end
%>  