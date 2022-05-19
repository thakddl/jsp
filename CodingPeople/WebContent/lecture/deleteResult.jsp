<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String msg = "";
if((int)request.getAttribute("c")>0){
	msg = "강의 삭제 성공";
} else {
	msg = "강의 삭제 실패";
}
%>