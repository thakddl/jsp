<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String memName = request.getParameter("Nm");
  String memHp = request.getParameter("Hp");
  
  Class.forName("oracle.jdbc.driver.OracleDriver");
  String url = "jdbc:oracle:thin:@112.220.114.130:1521:xe";
  Connection conn = DriverManager.getConnection(url, "team2_202110M", "java");
  Statement stmt = conn.createStatement();
  String sql = "SELECT * FROM MEMBER WHERE MEM_NM = '" + memName + "' AND HP = '"+ memHp +"' AND STATUS != 5";
  ResultSet rs = stmt.executeQuery(sql);
  
  if(rs.next()){
	String a = rs.getString(1);
	String b = a.substring(3);
	String c = a.substring(0, 3);
	String d = b.replaceAll("[a-zA-Z0-9]", "*");
	String e = c+d;
%>
  {
    "rst" : "<%=e %>"
  }
<% 
  }
%> 