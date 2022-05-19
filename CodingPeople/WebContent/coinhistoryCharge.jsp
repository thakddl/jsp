<%@page import="coin.service.CoinServiceImpl"%>
<%@page import="coin.vo.CoinHistoryVO"%>
<%@page import="java.util.List"%>
<%@page import="coin.service.IcoinService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<br><h2 id="title">사이트머니 충전내역 </h2><br>
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">구분</th>
      <th scope="col">충전금액</th>
      <th scope="col">충전 후 잔액</th>
      <th scope="col">날짜</th>
    </tr>
  </thead>
 <%
 	String memId = (String) session.getAttribute("memId");
  	IcoinService service =  CoinServiceImpl.getInstance();
  	List<CoinHistoryVO> list = service.getCHistoryList(memId);
  	int cnt = 0;
  	for(CoinHistoryVO vo : list) {
 	if(vo.getcEventId().equals("충전")){
  		cnt++;
 %>
  <tbody>
    <tr>
      <th scope="row"><%=vo.getcHistoryNo()%> </th>
      <td><%=vo.getcEventId()%></td>
      <td><span style="color: limegreen"><%=vo.getcHistoryCoin()%></span></td>
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
	 <td colspan="5">충전내용이 존재 하지 않습니다.</td>
	 </tr>
 <%
 	}
 %>
 
 </table>
<!--                 <p> 사이트머니 충전내역 조회 끝</p> -->
