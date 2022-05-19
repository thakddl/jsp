<%@page import="adminCategory.vo.AdminCategoryVO"%>
<%@page import="adminMember.vo.AllMembershipInfoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<AdminCategoryVO> categoryList = (List<AdminCategoryVO>)request.getAttribute("categoryList");
%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Coding People > 카테고리 관리</title>
    <script src="../js/jquery-3.6.0.min.js"></script>
    <!-- bootstrap 소스 start -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<!-- bootstrap 소스 end -->
  </head>

  <body>
    <%-- 전체 --%>
    <div id="wrap-container">
      <%-- 헤더 호출 --%>
<!--       <header id="header">        
      </header> -->
      <div class="container">
        <div class="page-header">
          <h2>관리자 > 카테고리 관리</h2> <br>
		  <button type="button" class="btn btn-default" onclick="location.href='/managermain.jsp' ">관리자 메인</button>
          <button type="button" class="btn btn-default" onclick="location.href='/admin/SelectAllCategories.do' ">카테고리 전체목록</button>
        </div>

      </div>
      
		<br>
      <%-- 사이드바+본문 --%>
      <div class="container">
        <%-- 사이드바 --%>
        <aside id="aside">
        </aside>

        <%-- 본문 --%>
        <section id="contents_memberlist">
          <%-- 멤버리스트 메인 --%>
           <div id="memberlist_center">          
            <div id="memberlist">
            </div>
            <div id="memberlist1"> 
            <%-- 본문몸통 --%>
            <!-- 전체회원 정보 가져오기 -->
             <!-- 작업파일 붙여넣기 시작 -->
                <!-- <h2>회원목록</h2> -->
			    <table class="table table-striped">
			      <thead>
			        <tr>
					  <th>ID</th>
					  <th>카테고리명</th>
					  <th>삭제</th>
			        </tr>
			      </thead>
			      <tbody><!-- 회원조회 -->
			       <%
			       	 int ListSize = categoryList.size();
			       	 if(ListSize > 0){
			       		 for(int i = 0 ; i < ListSize ; i++){
			       %>	
			 	    <tr>
					  <td><a href="/admin/UpdateCategory.do?ctgrId=<%=categoryList.get(i).getCategoryId() %>"><%=categoryList.get(i).getCategoryId() %></a></td> <!-- 아이디 -->
					  <td><%=categoryList.get(i).getCategoryName() %></td> 
					  <%-- <td><input type="button" value="삭제"><a href="/admin/deleteCategory.do?ctgrId=<%=categoryList.get(i).getCategoryId() %>"></a></td> <!-- 아이디 --> --%>
			          <td><button type="button" class="btn btn-default" onclick="location.href='/admin/deleteCategory.do?ctgrId=<%=categoryList.get(i).getCategoryId() %>' ">삭제</button></td>
			        </tr> 
<%-- 			 	    <tr>
					  <td><input name="ctgrId" placeholder="카테고리 아이디를 입력하세요"></td> <!-- 아이디 -->
					  <td><input name="ctgrName" placeholder="카테고리명을 입력하세요"></td> 
					  <td><input type="button" value="삭제"><a href="/admin/deleteCategory.do?ctgrId=<%=categoryList.get(i).getCategoryId() %>"></a></td> <!-- 아이디 -->
			          <td><button type="button" class="btn btn-default" onclick="location.href='/admin/deleteCategory.do?ctgrId=<%=categoryList.get(i).getCategoryId() %>' ">삭제</button></td>
			        </tr>  --%>
			        <%
			       		 } // for end
			       	 } // if end
			       %>
			      </tbody>
			       <form  class="form-horizontal" action="/admin/insertCategory.do" method="POST">
			      	<tr>
					  <th><input type="text" name="ctgrId" class="form-control" placeholder="등록할 카테고리 아이디를 입력하세요"></th>
					  <th><input type="text" name="ctgrName" class="form-control" placeholder="등록할 카테고리 명을 입력하세요"></th>
					  <th><button type="submit" class="btn btn-default">등록</button></th>
			        </tr>
			       </form>
			    </table>
            <!-- 작업파일 붙여넣기 끝 -->
            </div><!-- memberlist1 end-->
          </div>
          <div class="button_memberlist">
	        <div>
	            <input type="text" class="form-control" id="categorySearch" value="${param.keyword}" placeholder="카테고리 검색" autofocus required>
	            <input type="button"  class="btn btn-default"  name="keyword" id="memberlist_buttons" value="검색하기" onclick="aa();">
	        </div>
            <!-- <div id="button_memberlist">
            </div> -->
          </div>
        </section>
      </div>
      <%-- 푸터영역 --%>
      <footer id="footer">
      </footer>
    </div>
    
    <script>
    	function aa(){
      		let keyword = $('#categorySearch').val();
       		location.href = "/admin/searchCategory.do?keyword=" + keyword + ""; 
      	};
      	// 카테고리 업데이트 수행 시 작업 수행 성공/실패여부 팝업
      	$(document).ready(function(){
    		<%
    			if(request.getAttribute("updateMsg")=="성공"){
    		%>
    				alert("카테고리 수정이 완료되었습니다.");
    		<%
    			}else if(request.getAttribute("updateMsg")=="실패"){
    		%>
    				alert("카테고리 수정에 실패했습니다.");
			<%
				}
    		%>
    	});
      	// 카테고리 업데이트 수행 시 작업 수행 성공/실패여부 팝업
      	$(document).ready(function(){
    		<%
    			if(request.getAttribute("insertMsg")=="성공"){
    		%>
    				alert("카테고리 등록이 완료되었습니다.");
    		<%
    			}else if(request.getAttribute("insertMsg")=="실패"){
    		%>
    				alert("카테고리 등록에 실패했습니다.");
			<%
				}
    		%>
    	});
      	// 카테고리 삭제 수행 시 작업 수행 성공/실패여부 팝업
      	$(document).ready(function(){
    		<%
    			if(request.getAttribute("deleteMsg")=="성공"){
    		%>
    				alert("카테고리 삭제가 완료되었습니다.");
    		<%
    			}else if(request.getAttribute("deleteMsg")=="실패"){
    		%>
    				alert("카테고리 삭제에 실패했습니다.");
			<%
				}
    		%>
    	});
    </script>
      
  </body>
</html>