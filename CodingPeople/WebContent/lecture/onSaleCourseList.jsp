<%@page import="lecture.vo.CourseVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<CourseVO> CsList = (List<CourseVO>)request.getAttribute("list");

%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script src="../js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function(){
			
		$(".line").on("mouseover",function(){
			$(this).css({"background-color" : "skyblue"});
		});
		$(".line").on("mouseout",function(){
			$(this).css({"background-color" : "white"});
		});
		// 줄 클릭시 수정양식 열기
		$(".line").on("click",function(){
			$.ajax({
				type : 'post'
				,url : '/lecture/detail.do'		//요청
				,data : {'courseId': $(this).children().eq(0).text()}
				,dataType : 'html'			//응답(필수)
				,success : function(data){
					$(".lectureDetail").html(data);
				}	//응답(필수)
				,error : function(xhr){
					alert("상태 >> " + xhr.status);
				}						//응답(필수)
			});
		});
		
		// 삭제 버튼 클릭시 삭제
		$(document).on("click",".deleteBtn",function(){
			let courseId = $("input[name=courseId]").val();
			alert(courseId);
			$.ajax({
				type : 'get'
				,url : '/lecture/delete.do'		//요청
				,data : {'courseId': courseId}
				,dataType : 'html'			//응답(필수)
				,success : function(data){
					alert("삭제에 "+data+"했습니다!");
				}	//응답(필수)
				,error : function(xhr){
					alert("상태 >> " + xhr.status);
				}						//응답(필수)
			});
		});
	 });
		// 강의 영상 등록 버튼 클릭시 등록양식출력
		$(document).on("click",".insertBtn",function(){
			let courseId = $("input[name=courseId]").val();
	 		$.ajax({
	 			type : 'get'
	 			,url : '/lecture/insertLecture.do'		//요청
	 			,data : {'courseId': courseId}
	 			,dataType : 'html'			//응답(필수)
	 			,success : function(data){
	 				$(".submitlecture").html(data);
	 			}	//응답(필수)
	 			,error : function(xhr){
	 				alert("상태 >> " + xhr.status);
	 			}						//응답(필수)
	 		});
		});
		
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>동영상강의 판매 대기 목록</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style>
.outerdiv:after {
	display:block; clear:both; content:"";
}

</style>
</head>
<body>
	<div>
		<h2>요청강의 목록</h2>
		<select>
			<option>번호</option>
			<option>제목</option>
			<option>글쓴이</option>
			<option>작성일</option>
		</select>
	<input type="search" id="boardsearch" placeholder="게시글 검색" required>
	<input type="button" id="freeboard_buttons" value="검색하기">
	</div>
	<div class="outerdiv">
		<div class=list style="border: 1px solid black; float: left; width: 66%;">
			<table class="table table-striped">
			  <thead>
			    <tr>
			  <th>강의ID</th>
			  <th>유저ID</th>
			  <th>강의명</th>
			  <th>강의수</th>
			  <th>강의가격</th>
			  <th>요청일</th>
			  <th>강의교재</th>
			  <th>현재상태</th>
			    </tr>
			  </thead>
			  <tbody>
			   <%
			   		 for(int i = 0 ; i < CsList.size()  ; i++){
			   %>	
			    <tr class=line>
				  <td><%=CsList.get(i).getCourseId() %></td>
				  <td><%=CsList.get(i).getMemId() %></td>
				  <td><%=CsList.get(i).getCourseTitle() %></td>
				  <td><%=CsList.get(i).getCourseComposition() %></td>
				  <td><%=CsList.get(i).getCoursePrice() %></td>
				  <td><%=CsList.get(i).getCourseDate() %></td>
				  <td><%=CsList.get(i).getBookinfoId() %></td>
				  <td><%=CsList.get(i).getLectureApprovalId() %></td>
			    </tr> 
			    <%
			   		 } //for end
			    %>
			  </tbody>
			</table> 
		</div>
		<div class=lectureDetail style="border: 1px solid black; float: left; width: 33%;">
			
		</div>
	</div>
	<br>
	<div class=submitlecture></div>
</body>
</html>