<%@page import="book.VO.BookCategoryVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	List<BookCategoryVO> categoryList = (List<BookCategoryVO>) request.getAttribute("categoryList");

	String memId = (String) session.getAttribute("memId");
	
	String charge = (String) request.getAttribute("charge");
	if(charge==null) charge = "";
%>

<html>
<head>
<meta charset="UTF-8">
<title>Coding People</title>
<link rel="stylesheet" href="css/coding.css">
<style>
#bookgrade {
	width: 200px;
	height: 40px;
}

#buy {
	width: 200px;
	height: 40px;
}
</style>
<script src="../js/jquery-3.6.0.min.js"></script>
<script>
   	  $(document).ready(function(){
   	    $('#header').load("header/loginheader.jsp");
        $('#aside').load("side/side3.jsp");
        $('#footer').load("footer/footer.jsp");
   	    if('<%=charge%>' != '') window.open("/requestPay.jsp", "pop1", "width=550, height=600, left=300, top=50");
	    
   	});   
   	  
   	  
   	$(document).on('change','#bookselect', function(){
   		let categoryId = $('#bookselect').val();
   		$.ajax({
   			url : '/bookbuy.do', // context root가 '/'일 때 url mapping만 입력
   			type : 'post',
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
   	
   	$(document).on('change','#bookname', function(){
   		let bookInfoId = $('#bookname').val();
   		$.ajax({
   			url : '/bookgrade.do', // context root가 '/'일 때 url mapping만 입력
   			data : {'bookInfoId' : bookInfoId},
   			success : function(asd){
   		         
   		         $('#bookgrade').html(asd);
   	
   		      },
   			error : function(xhr){
   				alert(xhr.status);
   			},
   			dataType : 'html'
   		});
   	});
   	
   	$(document).on('change','#bookgrade', function(){
   		let bookGradeId = $('#bookgrade').val();
   		let bookInfoId = $('#bookname').val();
   		$.ajax({
   			url : '/bookgrade.do', // context root가 '/'일 때 url mapping만 입력
   			type : 'post',
   			data : {'bookGradeId' : bookGradeId
   				   ,'bookInfoId'  : bookInfoId},
   			success : function(asd){
   		         
   		         $('#stock').html(asd);
   	
   		      },
   			error : function(xhr){
   				alert(xhr.status);
   			},
   			dataType : 'html'
   		});
   	});
   	
   	  
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
			<section id="contents_bookbuy">
				<%-- 도서 판매 메인 --%>
				<div id="bookbuy_center">
					<div id="bookbuy">
						<p>구매도서 담기</p>
					</div>
					<div id="mouse2">
						<p>도서등급안내&nbsp; &nbsp; &nbsp;</p>
						<div class="mouseover2">
							<p>
								perfect&nbsp;| 낙서와 페이지 손실이 없는 새것과 비슷한 상태<br>
								great&nbsp;&nbsp;&nbsp;| 낙서가 있지만 페이지 손실은 없는 상태<br>
								good&nbsp;&nbsp;&nbsp;| 낙서가 없고 페이지 손실이 있는 상태<br>
								bad&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| 낙서가 있고 페이지 손실이 있는 상태
							</p>
						</div>
					</div>
					<fieldset class="bookbuy_box">
						<form action="/buyHistory.do" method="post">
							<ul id="bookbuyul">

								<li><label for="bookselect">카테고리</label> <select
									id="bookselect">
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


								<li><label for="bookgrade">도서등급</label> <select
									id="bookgrade" name="bookGrade">

								</select></li>
								<li>
									<div id="stock"></div>
								</li>
							</ul>
							<input id="buy" class="lecturebuyselect_buttons" type="submit"
								value="즉시구매"> <input type="hidden" name="memId"
								value="<%=memId %>">
						</form>
					</fieldset>
				</div>
				<div class="button_bookbuy">
					<div id="button_bookbuy">
						<button type="button" onclick="location.href='basketbook.jsp' ">도서담기</button>
						<input type="button" value="뒤로가기" onClick="history.go(-1)">
					</div>
				</div>
			</section>
		</div>
		<%-- 푸터영역 --%>
		<footer id="footer"> </footer>
	</div>
</body>
</html>