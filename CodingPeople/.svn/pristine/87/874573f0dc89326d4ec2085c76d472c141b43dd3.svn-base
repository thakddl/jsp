<%@page import="book.VO.BookCategoryVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
List<BookCategoryVO> categoryList = (List<BookCategoryVO>) request.getAttribute("bookInfoId");

String memId = (String) session.getAttribute("memId");

%>

<html>
  <head>
    <meta charset="UTF-8">
    <title>Coding People</title>
    <link rel="stylesheet" href="../css/coding.css">
    <script src="../js/jquery-3.6.0.min.js"></script>
    <script>
    
	    $(document).ready(function(){
	        $('#header').load("../header/loginheader.jsp");
	      $('#aside').load("../side/side3.jsp");
	      $('#footer').load("../footer/footer.jsp");
	    });   
	      
 
        
    </script>
    <style>
      input {
        width: 200px;
        height: 50px;
      }
    </style>
  </head>

  <body>
    <%-- 전체 --%>
    <div id="wrap-container">
      <%-- 헤더 호출 --%>
      <header id="header">        
      </header>

      <%-- 사이드바+본문 --%>
      <div class="container">
        <%-- 사이드바 --%>
        <aside id="aside">
        </aside>

        <%-- 본문 --%>
        <section id="contents_booksale">
          <%-- 도서 판매 메인 --%>
          <div id="booksale_center">          
            <div id="booksale">
            <br><br><br><br><br><br><br>
					<h1>구매가 완료되었습니다.</h1>
			<br><br><br>
			   <input type="button" value="뒤로가기" onClick="history.go(-1)">
            </div>
          </div>
        </section>
      </div>
      <%-- 푸터영역 --%>
      <footer id="footer">
      </footer>
    </div>
    <script>
    
    </script>
  </body>
</html>