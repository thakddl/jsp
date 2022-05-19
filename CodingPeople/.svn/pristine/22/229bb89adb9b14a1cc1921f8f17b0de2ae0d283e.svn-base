<%@page import="adminCategory.vo.AdminCategoryVO"%>
<%@page import="adminMember.vo.AllMembershipInfoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	AdminCategoryVO categoryVo = (AdminCategoryVO)request.getAttribute("ctgrListVo");
%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Coding People > 카테고리 관리 > 카테고리 수정</title>
<!--     <link rel="stylesheet" href="/css/coding.css"> -->
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
<!--           <div>
          <input type="text" id="categorySearch" autofocus placeholder="카테고리 검색">
          <input type="button" class="btn btn-default" id="memberlist_buttons" value="검색하기" onclick="aa();">
          </div> -->
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
          <div class="container">
			  <form class="form-horizontal" action="/admin/UpdateCategory.do" method="POST">
			    <div class="form-group">
			      <label class="control-label col-sm-2" for="email">카테고리ID</label>
			      <div class="col-sm-10">
			        <input class="form-control" id="ctgrId"  name="ctgrId" readonly value="<%=categoryVo.getCategoryId()%>">
			      </div>
			    </div>
			    <div class="form-group">
			      <label class="control-label col-sm-2" for="pwd">카테고리명</label>
			      <div class="col-sm-10">          
			        <input type="text" class="form-control" id="ctgrName" name="ctgrName" value="<%=categoryVo.getCategoryName()%>">
			      </div>
			    </div>
			    <div class="form-group">        
			      <div class="col-sm-offset-2 col-sm-10">
			      </div>
			    </div>
			    <div class="form-group">        
			      <div class="col-sm-offset-2 col-sm-10">
			        <button type="button" class="btn btn-default" onclick="location.href='/admin/SelectAllCategories.do' ">카테고리 목록</button>
			        <button type="submit" class="btn btn-default">수정</button>
			        <button type="reset" class="btn btn-default">취소</button>
			      </div>
			    </div>
			  </form>
			</div>
          <div class="button_memberlist">
            <div id="button_memberlist">
            </div>
          </div>
        </section>
      </div>
      <%-- 푸터영역 --%>
      <footer id="footer">
      </footer>
    </div>
    
<!--     <script>
    	function aa(){
      		let keyword = $('#categorySearch').val();
       		location.href = "/admin/searchCategory.do?keyword=" + keyword + ""; 
      	}
    </script> -->
      
  </body>
</html>