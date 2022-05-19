<%@page import="book.VO.BookInfoVO"%>
<%@page import="book.VO.BbuyHistoryVO"%>
<%@page import="java.util.List"%>
<%@page import="coin.service.CoinServiceImpl"%>
<%@page import="coin.service.IcoinService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%  // 인증된 세션이 없는경우, 해당페이지를 볼 수 없게 함.
    if (session.getAttribute("memId") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Coding People</title>
    <link rel="stylesheet" href="css/coding.css">
    <script src="../js/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="../css/lhbcss.css">
	<script src="../js/bootstrap.min.js"></script> 
    
    <script>
   	  $(document).ready(function(){
   	    $('#header').load("header/loginheader.jsp");
        $('#aside').load("side/side2.jsp");
        $('#footer').load("footer/footer.jsp");
   	});   
    </script>
<style>
td,th {
	text-align: center;
	font-size: 17px
}
#pointsite_center {
	overflow: scroll;
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
        <section id="contents_buybook">
          <%-- 구매내역 메인 --%>
          <div id="buybook_center">          
            <div id="book_b">
<!--               <p> 구매상세내역 </p> -->

<br><h2 id="title">도서 구매내역 </h2><br>
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">책이름</th>
      <th scope="col">책등급</th>
      <th scope="col">수량</th>
      <th scope="col">단가</th>
      <th scope="col">총 구매금액</th>
      <th scope="col">구매날짜</th>
    </tr>
  </thead>
 <%
 	String memId = (String) session.getAttribute("memId");
  	IcoinService service =  CoinServiceImpl.getInstance();
  	List<BbuyHistoryVO> list = service.getBbuyHistoryVO(memId);
  	int cnt = 0;
  	for(BbuyHistoryVO vo : list) {
  			cnt++;
 %>
  <tbody>
    <tr>
      <th scope="row"><%=vo.getBbHistoryNo()%> </th>
      <%
      BookInfoVO bivo = service.getBookInfoVO(vo.getBookinfoId());
      %>
      <td><%=bivo.getBookInfoNm()%></td>
      <td><%=vo.getBookGradeId()%></td>
      <td><%=vo.getBbHistoryQty()%></td>
      <td><%=vo.getBbHistoryPrice()%></td>
      <td><%=vo.getBbHistoryAmt()%></td>
      <td><%=vo.getBbHistoryDate()%></td>
    </tr>
  </tbody>
 <%
	} //for
 	if(cnt == 0) {
 %>
	 <tr>
	 <td colspan="7">구매내역이 존재 하지 않습니다.</td>
	 </tr>
 <%
 	}
 %>
 
 </table>
              
<!--               <p> 구매상세내역 </p> -->
            </div>
          </div>
          <div class="button_buybook">
            <div id="button_buybook">
              <input class="buybook_buttons" type="button" value="환불하기">
              <%-- 환불기능 연결하기 --%>
              <button type="button" onclick="location.href='bookdeal.jsp' ">뒤로가기</button>
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