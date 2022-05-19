<%@page import="point.history.VO.PointHistoryVO"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="coin.service.CoinServiceImpl"%>
<%@page import="coin.service.IcoinService"%>
<%@page import="coin.vo.CoinHistoryVO"%>
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
//         $('#pointsite_s').load("pointsiteTarget.jsp");
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
        <section id="cotents_pointsite">
          <%-- 사이트머니 메인 --%>
          <div id="pointsite_center">
            <div id="pointsite_s">
<!--                 <h2> 포인트내역 조회</h2> -->
 <!--포인트내역조회 시작 -->
<br><h2 id="title">포인트 변동내역 </h2><br>
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">구분</th>
      <th scope="col">포인트변동</th>
      <th scope="col">변동 후 포인트</th>
      <th scope="col">날짜</th>
    </tr>
  </thead>
 <%
 	String memId = (String) session.getAttribute("memId");
  	IcoinService service =  CoinServiceImpl.getInstance();
  	List<PointHistoryVO> list = service.getPHistoryList(memId);
  	int cnt = 0;
  	for(PointHistoryVO vo : list) {
  			cnt++;
 %>
  <tbody>
    <tr>
      <th scope="row"><%=vo.getPhistoryNo()%> </th>
      <td><%=vo.getPeventId()%></td>
 <%
			if(vo.getPhistoryPoint().charAt(0) == '+' ){
 %>
      <td><span style="color: limegreen	"><%=vo.getPhistoryPoint()%></span></td>
 <%
			} else if(vo.getPhistoryPoint().charAt(0) == '-' ){
 %>
      <td><span style="color: red	"><%=vo.getPhistoryPoint()%></span></td>
 <%
			}
 %>
      <td><%=vo.getPhistoryBanlance()%></td>
      <td><%=vo.getPhistoryDate()%></td>
    </tr>
  </tbody>
 <%
	} //for
 	if(cnt == 0) {
 %>
	 <tr>
	 <td colspan="5">내역이 존재 하지 않습니다.</td>
	 </tr>
 <%
 	}
 %>
 
 </table>
 
 <!--포인트내역조회 끝 -->
            </div>
          </div>
          <div class="button_pointsite">
            <div id="button_pointsite">
<!--               <button type="button" onclick="location.href='#' ">전체내역</button> -->
<!--               <button type="button" onclick="location.href='coinhistoryUse.jsp' ">사용내역</button> -->
<!--               <button type="button" onclick="location.href='coinhistoryCharge.jsp' ">충전내역</button> -->
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