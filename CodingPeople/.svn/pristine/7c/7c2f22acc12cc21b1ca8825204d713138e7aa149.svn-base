<%@page import="book.VO.BsellHistoryVO"%>
<%@page import="book.VO.BookInfoVO"%>
<%@page import="book.VO.BbuyHistoryVO"%>
<%@page import="java.util.List"%>
<%@page import="coin.service.CoinServiceImpl"%>
<%@page import="coin.service.IcoinService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <section id="contents_bookdeal">
          <%-- 도서거래내역 메인 --%>
          <%-- <div id ="bookdeal_center"> --%>
            <div id="buybook">          
              <div id="book1">
                <p> 구매내역 </p>
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
              </div>
              <div>
                <div id="bookbottom">
                  <p><a href="buybook.jsp" style="color:black">More>></a></p>
                </div>
              </div>
            </div>
            <div id="salebook">          
              <div id="book2">
                <p> 판매내역 </p>
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">책이름</th>
      <th scope="col">등급판정</th>
      <th scope="col">수량</th>
      <th scope="col">단가</th>
      <th scope="col">총 판매금액</th>
      <th scope="col">판매날짜</th>
    </tr>
  </thead>
 <%
 	memId = (String) session.getAttribute("memId");
  	service =  CoinServiceImpl.getInstance();
  	List<BsellHistoryVO> list2 = service.getBsellHistoryVO(memId);
  	cnt = 0;
  	for(BsellHistoryVO vo : list2) {
  			cnt++;
 %>
  <tbody>
    <tr>
      <th scope="row"><%=vo.getBsHistoryNo()%> </th>
      <%
      BookInfoVO bivo = service.getBookInfoVO(vo.getBookinfoId());
      %>
      <td><%=bivo.getBookInfoNm()%></td>
      <td><%=vo.getBookGradeId()%></td>
      <td><%=vo.getBsHistoryQty()%></td>
      <td><%=vo.getBsHistoryCost()%></td>
      <td><%=vo.getBsHistoryAmt()%></td>
      <td><%=vo.getBsHistoryDate()%></td>
    </tr>
  </tbody>
 <%
 	} //for
 	if(cnt == 0) {
 %>
	 <tr>
	 <td colspan="7">판매내역이 존재 하지 않습니다.</td>
	 </tr>
 <%
 	}
 %>
 
 </table>
              </div>
              <div>
                <div id="bookbottom2">
                  <p><a href="salebook.jsp" style="color:black">More>></a></p>
                </div>
              </div>
            </div>
          <%-- </div> --%>
        </section>
      </div>
      <%-- 푸터 --%>
      <footer id="footer">
      </footer>
    </div>
  </body>
</html>