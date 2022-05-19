<%@page import="GroupStudy.VO.SMemberVO"%>
<%@page import="GroupStudy.VO.JoinVO"%>
<%@page import="java.util.List"%>
<%@page import="GroupStudy.VO.GroupStudyVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	GroupStudyVO gsDetail = (GroupStudyVO) request.getAttribute("gsDetail");
	List<SMemberVO> memList = (List<SMemberVO>) request.getAttribute("memList");
	List<JoinVO> groupStudyList = (List<JoinVO>) request.getAttribute("groupStudyList");
	String memId = (String)session.getAttribute("memId");
	
	
	if(gsDetail != null && memList != null && groupStudyList != null) {
	
%>    
	<div class="aa" id="aa">
		<table>
			<tr>
				<th colspan="5">내용</th>
			</tr>
			<tr>
				<th colspan="5"><%=gsDetail.getSgroupContent().replace("\r\n", "<br>") %></th>
			</tr>
		</table>
	</div>
	<div class="aa" id="bb">
		<table>
			<tr>
				<th>회원ID</th>
				<th>구분</th>
				<th>상태</th>
				<th>처리</th>
			</tr>
<%
			if(groupStudyList.size() > 0) {
				for(int i=0; i<groupStudyList.size(); i++){
					String status = groupStudyList.get(i).getSmemberStatusId();
						if(status.equals("sgreader")){
							status = "스터디그룹장";
						} else {
							status = "스터디그룹원";
						}
%>
					<tr>
						<td><%=groupStudyList.get(i).getMemId() %></td>
						<td><%=status %></td>
						<td><%=groupStudyList.get(i).getSmemberStatusId() %></td>
						<td>
							<%
								if(groupStudyList.get(i).getSmemberStatusId().equals("wait")) {
									%>
										<form action="/smemberupdate.do" method="post">
										  <input type="hidden" name="sgroupId" value="<%=groupStudyList.get(i).getSgroupId()%>">
										  <input type="hidden" name="memId" value="<%=groupStudyList.get(i).getMemId()%>">
										  <input type="submit" value="수락">
										</form>
										<form action="/smemberdelete.do" method="post">
										  <input type="hidden" name="sgroupId" value="<%=groupStudyList.get(i).getSgroupId()%>">
										  <input type="hidden" name="memId" value="<%=groupStudyList.get(i).getMemId()%>">
										  <input type="submit" value="거절">
										</form>
									<%
								} else if(groupStudyList.get(i).getSmemberStatusId().equals("sgmember")) {
									%>
									<form action="/smemberdelete.do" method="post">
									  <input type="hidden" name="sgroupId" value="<%=groupStudyList.get(i).getSgroupId()%>">
									  <input type="hidden" name="memId" value="<%=groupStudyList.get(i).getMemId()%>">
									  <input type="submit" value="추방">
									</form>
									<%
								}
							%>
						</td>
					</tr>
<%
				}
			} else {
%>				

		</table>
				
	</div>
<%				
			}

	} else {
%>		
		<br>
		<h1 style="text-align : center" >스터디 그룹 정보가 없습니다.</h1>
<%		
	}
%>
	
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
