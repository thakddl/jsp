<%@page import="lecture.vo.CourseVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CourseVO cv = (CourseVO)request.getAttribute("cv");

	int endIndex = Integer.parseInt(cv.getCourseComposition());
%>
	<form id="lecInsertData" action="/lecture/update2.do" method="get">
	<table>
<%	
	for(int i = 1; i<=endIndex ; i++){
%>
	<tr>
		<td><input type="text" name="lectureNo" value="<%=i %>" readonly="readonly"><td>
		<td></td>
		<td>강의아이디</td>
		<td><input type="text" name="courseId" value="<%=cv.getCourseId() %>" readonly></td>
		<td></td>
		<td>영상이름</td>
		<td><input type="text" name="lectureTitle"></td>
	</tr>
<%
	}
%>
	</table>
	<button type="submit">강의 등록</button>
	</form>

	