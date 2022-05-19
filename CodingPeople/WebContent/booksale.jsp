<%@page import="book.VO.BookCategoryVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
List<BookCategoryVO> categoryList = (List<BookCategoryVO>) request.getAttribute("categoryList");

String memId = (String) session.getAttribute("memId");

%>

<html>
<head>
<meta charset="UTF-8">
<title>Coding People</title>
<link rel="stylesheet" href="css/coding.css">
<script src="../js/jquery-3.6.0.min.js"></script>
<script>
    
    let categoryId = $('#bookselect').val();
    var bookInfoId = $('#bookname').val();
    
    
    
        $(document).ready(function(){
          $('#header').load("header/loginheader.jsp");
        $('#aside').load("side/side3.jsp");
        $('#footer').load("footer/footer.jsp");
      });   
        
       
   	
   	$(document).on('change','#bookselect', function(){
   		categoryId = $('#bookselect').val();
   		$.ajax({
   			url : '/bookInfo.do', // context root가 '/'일 때 url mapping만 입력
   			data : {'categoryId' : categoryId},
   			success : function(asd){
   		         
   		         $('#bookname').html(asd);
   	
   		      },
   			error : function(xhr){
   				alert(xhr.status);
   			},
   			dataType : 'html'
   		});
   	});
   	document.getElementById('bookInfoId').value = bookInfoId;
   	
    </script>
</head>

<body>
	<%-- 전체 --%>
	<div id="wrap-container">
		<%-- 헤더 호출 --%>
		<header id="header"> </header>

		<%-- 사이드바+본문 --%>
		<div class="container">
			<%-- 사이드바 --%>
			<aside id="aside"></aside>

			<%-- 본문 --%>
			<section id="contents_booksale">
				<%-- 도서 판매 메인 --%>
				<div id="booksale_center">
					<div id="booksale">
						<p>판매도서 등록하기</p>
					</div>
						<div id="mouse1">
								<p>도서등급안내&nbsp; &nbsp; &nbsp; </p>
								<div class="mouseover1">
									<p>
										perfect&nbsp;| 낙서와 페이지 손실이 없는 새것과 비슷한 상태<br>
										great&nbsp;&nbsp;&nbsp;| 낙서가 있지만 페이지 손실은 없는 상태<br>
										good&nbsp;&nbsp;&nbsp;| 낙서가 없고 페이지 손실이 있는 상태<br>
										bad&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| 낙서가 있고 페이지 손실이 있는 상태 
									</p>
								</div>
							</div>
					<fieldset class="booksale_box">
						<form action="/booksale.do" method="post">
							<ul id="booksaleul">
								<li><label for="bookselect">카테고리</label> <select
									id="bookselect" class="fieldset-control">

										<%                 
		int listSize = categoryList.size();
		if( listSize > 0){
		
		for(int i=0; i<listSize; i++){  
    					
%>
										<option value="<%=categoryList.get(i).getCategoryId()%>"><%=categoryList.get(i).getCategoryName() %></option>
										<%
			    				} // for end
			    				
								} // if end
%>

								</select></li>
								<li><label for="bookname">책제목</label> <select id="bookname"
									name="bookInfoId" class="fieldset-control">

								</select></li>
							</ul>
							<div id="booksale2">
								<p style="color: red">책 상태를관리자가 검수 후</p>
								<p>금액 책정하여 안내드립니다.</p>
							</div>
							<div id="booksale3">
								<p>책정 예상 소요일은 1~2일 소요됩니다</p>
								<br>
							</div>
				</div>

				<input type="hidden" name="memId" value="<%=memId %>">
				<div class="button_booksale">
					<div id="button_booksale">

						<input class="booksale_buttons" type="submit" value="등록요청">
						</form>
						</fieldset>
						<input type="button" value="뒤로가기" onClick="history.go(-1)">
					</div>
				</div>
			</section>
		</div>
		<%-- 푸터영역 --%>
		<footer id="footer"> </footer>
	</div>
	<script>
    
    </script>
</body>
</html>