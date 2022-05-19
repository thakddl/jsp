<%@page import="lecture.vo.CourseVO"%>
<%@page import="atch.VO.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CourseVO lv = (CourseVO) request.getAttribute("lv");

	List<AtchFileVO> atchFileList = (List<AtchFileVO>) request.getAttribute("atchFileList");
	
%>
            <div id="freeboard1">
            	<form id="updata" action="/lecture/insertLecture.do" method="post" enctype="multipart/form-data">
            		<table>
						<tr>
							<td>강의아이디</td>
							<td><input type="text" name="courseId" value="<%=lv.getCourseId() %>" readonly></td>
							<td>책제목</td>
							<td><input type="text" name="bookinfoId" value="<%=lv.getBookinfoId() %>"></td>
						</tr>
						<tr>
							<td>카테고리ID</td>
							<td><input type="text" name="categoryId" value="<%= lv.getCategoryId() %>"></td>
							<td>현재상태</td>
							<td><select id="updata" name="lectureApprovalId">
							<%
							if(lv.getLectureApprovalId().equals("wait")){
								%>
								<option value="wait" selected>승인대기</option>
								<option value="sale">판매중</option>
								<option value="delete">판매중지</option>
								<%
							} else if(lv.getLectureApprovalId().equals("sale")){
								%>
								<option value="wait" >승인대기</option>
								<option value="sale" selected>판매중</option>
								<option value="delete">판매중지</option>
								<%
							} else {
								%>
								<option value="wait" >승인대기</option>
								<option value="sale" >판매중</option>
								<option value="delete" selected>판매중지</option>
								<%
							}
							%>
							</select></td>
						</tr>
						<tr>
							<td>작성자ID</td>
							<td><input type="text" name="memId" value="<%= lv.getMemId() %>"></td>
							<td>강의명</td>
							<td><input type="text" name="courseTitle" value="<%= lv.getCourseTitle()%>"></td>
						</tr>
						<tr>
							<td>동영상개수</td>
							<td><input type="text" name="courseComposition" value="<%= lv.getCourseComposition()%>"></td>
							<td>요청일자</td>
							<td><input type="text" name="courseDate" value="<%= lv.getCourseDate()%>"></td>
						</tr>
						<tr>
							<td>강의가격</td>
							<td><input type="text" name="coursePrice" value="<%= lv.getCoursePrice()%>"></td>
							<td>판매횟수</td>
							<td><input type="text" name="courseSales" value="<%= lv.getCourseSales()%>"></td>
						</tr>
						<tr>
					  	  	<td>기존 첨부파일</td>
					  	  	<td colspan="3">
					  	  	  <%
					  	  	    if(atchFileList != null) {
					  	  	    	for(AtchFileVO fileVO : atchFileList) {
					  	  	  %>
					  	  	  		 <div><a href="<%=request.getContextPath() %>/download.do?fileId=<%=fileVO.getAtchFileId()%>&fileSn=<%=fileVO.getFileSn()%>"><%=fileVO.getOrignlFileNm() %></a></div>
					  	  	  <%
					  	  	    	}
					  	  	    }	
					  	  	  %>
					  	  	</td>
					  	  </tr>
					  	  <tr>
					  	    <td>새로운 첨부파일</td>
					  	    <td><input type="file" name="atchFile" multiple="multiple"></td>
					  	  </tr>
						<tr>
							<td colspan="4">내용</td>	
						</tr>
						<tr><td colspan="4">
							<textarea name="courseIntroduction" cols="70" rows="5">
							<%= lv.getCourseIntroduction().replace("\r\n", "<br>") %></textarea>
							</td>	
						</tr>
						
            		</table>
	 				<button type="submit">강의 정보수정</button>
					<button class="deleteBtn" type="button">강의 등록거절</button>
					<button class="insertBtn" type="button">강의 영상등록</button>
            	</form>
			</div>