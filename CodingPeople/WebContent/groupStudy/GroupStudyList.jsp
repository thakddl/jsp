<%@page import="GroupStudy.VO.GroupStudyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<GroupStudyVO> gsList = (List<GroupStudyVO>) request.getAttribute("gsList");
%>
    <script src="../js/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function(){
		// 게시판 한줄 마우스 올릴떄, 클릭시 이벤트 생성
		// 클릭시 상세보기로 이동
		$(".line").on("mouseover",function(){
			$(this).css({"background-color" : "skyblue"});
		});
		$(".line").on("mouseout",function(){
			$(this).css({"background-color" : "white"});
		});
		$(".line").on("click",function(){
			let memId = $(this).children().eq(0).text();
			/* location.href="/groupStudy/detail.do?memId="+memId; */
			$.ajax({
				type : 'get'
				,url : '/groupStudy/detail.do'		//요청
				,dataType : 'html'			//응답(필수)
				,data : { 'memId' : memId }
				,success : function(data){
				  $('#GroupStudy').html(data);
				}	//응답(필수)
				,error : function(xhr){
					alert("상태 >> " + xhr.status);
				}						//응답(필수)
			});
		});
    });
</script>
	

	<table border="1">
		<tr>
			<th>그룹스터디장ID</th>
			<th>그룹명</th>
			<th>장소명</th>
			<th>그룹총원</th>
			<th>시작일</th>
		</tr>
<%
	int gsSize = gsList.size();
	if( gsSize > 0){
		for(int i=0; i<gsSize; i++){
%>
			<tr class="line">
				<td><%= gsList.get(i).getMemId()%></td>
				<td><%= gsList.get(i).getSgroupTitle()%></td>
				<td><%= gsList.get(i).getSgroupPlace()%></td>
				<td><%= gsList.get(i).getSgroupTo()%></td>
				<td><%= gsList.get(i).getSgroupSdate().substring(0, 10)%></td>
			</tr>
<%			
		}
	} else {
%>
		<tr>
			<td colspan="4">회원 정보가 없습니다.</td>
		</tr>
<%		
	}
%>	
	</table>
	<hr>
	<div id="GroupStudy"></div>