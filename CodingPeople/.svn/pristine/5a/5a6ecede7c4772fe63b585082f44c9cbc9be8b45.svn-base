<%@page import="lecture.vo.CourseVO"%>
<%@page import="lecture.vo.LectureVO"%>
<%@page import="atch.VO.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<AtchFileVO> atchFileList = (List<AtchFileVO>)request.getAttribute("atchFileList");
	List<LectureVO> lvList = (List<LectureVO>) request.getAttribute("lvList");
	CourseVO cv = (CourseVO) request.getAttribute("cv");
	int index = (int) request.getAttribute("index");
%>
	<video autoplay="autoplay" controls>
 	 <source src="../uploadfile/<%=atchFileList.get(index).getStreFileNm()%>" type="video/mp4">
		Your browser does not support the video tag.
	</video>