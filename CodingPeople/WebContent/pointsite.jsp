<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="coin.service.CoinServiceImpl"%>
<%@page import="coin.service.IcoinService"%>
<%@page import="coin.vo.CoinHistoryVO"%>
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
//         $('#pointsite_s').load("pointsiteTarget.jsp");
   	});   
    </script>
<style>
td,th {
	text-align: center;
	font-size: 17px
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
        <section id="cotents_pointsite">
          <%-- 사이트머니 메인 --%>
          <div id="pointsite_center">
            <div id="pointsite_s">
<!--                 <h2> 사이트머니 사용내역 조회</h2> -->
 <!--사이트머니사용내역조회 시작 -->
 <br><h2 id="title">사이트머니 사용내역 </h2><br>
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">구분</th>
      <th scope="col">사용금액</th>
      <th scope="col">사용 후 잔액</th>
      <th scope="col">날짜</th>
    </tr>
  </thead>
 <%
 	String memId = (String) session.getAttribute("memId");
  	IcoinService service =  CoinServiceImpl.getInstance();
  	List<CoinHistoryVO> list = service.getCHistoryList(memId);
  	int cnt = 0;
  	for(CoinHistoryVO vo : list) {
 	if(vo.getcEventId().equals("use")){
  		cnt++;
 %>
  <tbody>
    <tr>
      <th scope="row"><%=cnt%> </th>
      <td>충전</td>
      <td><span style="color: red"><%=vo.getcHistoryCoin()%></span></td>
      <td><%=vo.getcHistoryBalance()%></td>
      <td><%=vo.getcHistoryDate()%></td>
    </tr>
  </tbody>
 <%
		} //if
	} //for
 	if(cnt == 0) {
 %>
	 <tr>
	 <td colspan="5">사용내역이 존재 하지 않습니다.</td>
	 </tr>
 <%
 	}
 %>
 
 </table>
 
 <!--사이트머니사용내역조회 끝 -->
            </div>
          </div>
          <div class="button_pointsite">
            <div id="button_pointsite">
              <input class="pointsite_buttons" type="button" value="충전하기">
              <button type="button" onclick="location.href='pointhistory.jsp' ">충전내역</button>
              <button type="button" onclick="location.href='point.jsp' ">뒤로가기</button>
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