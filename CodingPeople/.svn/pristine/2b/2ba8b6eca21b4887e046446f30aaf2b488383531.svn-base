<%@page import="GroupStudy.VO.SMemberVO"%>
<%@page import="GroupStudy.VO.JoinVO"%>
<%@page import="java.util.List"%>
<%@page import="GroupStudy.VO.GroupStudyVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	GroupStudyVO gsDetail = (GroupStudyVO) request.getAttribute("gsDetail");
	List<SMemberVO> memList = (List<SMemberVO>) request.getAttribute("memList");
	String memId = (String)session.getAttribute("memId");
	
%>    
	<div style="border: 1px solid black; float: left; width: 66%;">
		<table border="1">
			<tr>
				<th colspan="5">내용</th>
			</tr>
			<tr>
				<th colspan="5"><%=gsDetail.getSgroupContent().replace("\r\n", "<br>") %></th>
			</tr>
		</table>
	</div>
	<div style="border: 1px solid black; float: left; width: 33%;">
		<table border="1">
			<tr>
				<th>회원ID</th>
				<th>구분</th>
			</tr>
<%
				for(int i=0; i<memList.size(); i++){
					String status = memList.get(i).getSmemberStatusId();
						if(status.equals("sgreader")){
							status = "스터디그룹장";
						} else {
							status = "스터디그룹원";
						}
%>
					<tr>
						<td><%=memList.get(i).getMemId() %></td>
						<td><%=status %></td>
					</tr>
<%
				}
%>
		</table>
		<input id="submit" type="button" value="가입신청" onclick="location.href='/groupStudy/applicationJoin.do?memId=<%=memId %>&sGroupId=<%=gsDetail.getSgroupId() %>'">
	</div>
	
<!--  			<tr> -->
<!-- 				<th>그룹스터디장ID</th> -->
<!-- 				<th>그룹명</th> -->
<!-- 				<th>장소명</th> -->
<!-- 				<th>그룹총원</th> -->
<!-- 				<th>시작일</th> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<%-- 				<th><%=gsDetail.getMemId() %></th> --%>
<%-- 				<th><%=gsDetail.getSgroupTitle() %></th> --%>
<%-- 				<th><%=gsDetail.getSgroupPlace() %></th> --%>
<%-- 				<th><%=gsDetail.getSgroupTo() %></th> --%>
<%-- 				<th><%=gsDetail.getSgroupSdate().substring(0,10) %></th> --%>
<!-- 			</tr>  -->
