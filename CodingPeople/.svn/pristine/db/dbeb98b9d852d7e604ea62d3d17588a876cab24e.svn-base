<%@page import="book.VO.BookListSearchVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<BookListSearchVO> bookList = (List<BookListSearchVO>)request.getAttribute("bookList");
%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Coding People > 도서관리</title>
<!--     <link rel="stylesheet" href="/css/coding.css"> -->
    <script src="../js/jquery-3.6.0.min.js"></script>
    <!-- bootstrap 소스 start -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<!-- bootstrap 소스 end -->
	<script>
//    	  $(document).ready(function(){
//    	    $('#header').load("/header/loginheader.jsp");
//         $('#aside').load("/side/managerside.jsp");
//         $('#footer').load("/footer/footer.jsp");
//    	});   
    </script>
  </head>

  <body>
    <%-- 전체 --%>
    <div id="wrap-container">
      <%-- 헤더 호출 --%>
<!--       <header id="header">        
      </header> -->
      <div class="container">
        <div class="page-header">
          <h2>관리자 > 도서 조회</h2> <br>
          <button type="button" class="btn btn-default" onclick="location.href='/managermain.jsp' ">관리자 메인</button>
          <button type="button" class="btn btn-default" onclick="location.href='/admin/selectBookList.do' ">도서 전체목록</button>
<!--         </div>
          <div>
          <input type="text" id="membersearch" autofocus placeholder="회원 검색"  required>&nbsp;&nbsp;
          <input type="button" class="btn btn-default" id="memberlist_buttons" value="검색하기" onclick="aa();">
          </div>
      </div> -->
      
		<br>
      <%-- 사이드바+본문 --%>
      <div class="container">
        <%-- 사이드바 --%>
        <aside id="aside">
        </aside>

        <%-- 본문 --%>
        <section id="contents_memberlist">
          <%-- 멤버리스트 메인 --%>
          <div id="booklist_center">          
            <div id="booklist">
            </div>
            <div id="booklist1">
            <%-- 본문몸통 --%>
            <!-- 전체회원 정보 가져오기 -->
             <!-- 작업파일 붙여넣기 시작 -->
                <!-- <h2>회원목록</h2> -->
			    <table class="table table-striped">
			      <thead>
			        <tr>
					  <th>카테고리ID</th>
					  <th>도서명</th>
					  <th>상태</th>
					  <th>재고</th>
					  <th>판매가</th>
					  <th>매입가</th>
					  <th>정가</th>
			        </tr>
			      </thead>
			      <tbody><!-- 회원조회 -->
			       <%
			       	 int bookListSize = bookList.size();
			       	 if(bookListSize > 0){
			       		 for(int i = 0 ; i < bookListSize ; i++){
			       %>	
			 	    <tr>
					  <td><a href=""><%=bookList.get(i).getCategoryId() %></a></td> <!-- 카테고리아이디 -->
					  <td><%=bookList.get(i).getBookinfoNm() %></td> 				<!-- 책이름        -->
					  <td><%=bookList.get(i).getBookGradeId() %></td>				<!-- 도서상태       -->
					  <td><%=bookList.get(i).getBookStock() %></td>					<!-- 도서재고(수량)   -->
					  <td><%=bookList.get(i).getBookSale() %></td>					<!-- 도서판매가      -->
					  <td><%=bookList.get(i).getBookCost() %></td>					<!-- 도서매입가      -->
					  <td><%=bookList.get(i).getBookPrice() %></td>					<!-- 도서정가       -->
			        </tr> 
			        <%
			       		 } // for end
			       	 } // if end
			       %>
			      </tbody>
			    </table>
<%-- 			    <%
			      if(msg.equals("성공")){
			    %>
			    <script>
			       alert("정상적으로 처리되었습니다.");
			    </script>
			    <%
			      } /* 업데이트 성공 시 알람창 if절 끝 */
			    %>  --%>
            <!-- 작업파일 붙여넣기 끝 -->
            </div><!-- memberlist1 end-->
          </div>
          <div class="button_booklist">
            <div id="button_booklist">

            </div>
          </div>
        </section>
      </div>
      <%-- 푸터영역 --%>
      <footer id="footer">
      </footer>
    </div>
      
  </body>
</html>