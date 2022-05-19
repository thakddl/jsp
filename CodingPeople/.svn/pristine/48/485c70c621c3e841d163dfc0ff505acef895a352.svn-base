<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="coin.service.CoinServiceImpl"%>
<%@page import="coin.service.IcoinService"%>
<%@page import="coin.vo.CoinHistoryVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<br><h2 id="title">사이트머니 변동내역 </h2><br>
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">구분</th>
      <th scope="col">사용금액</th>
      <th scope="col">변동 후 잔액</th>
      <th scope="col">날짜</th>
    </tr>
  </thead>
 <%
 	String memId = (String) session.getAttribute("memId");
  	IcoinService service =  CoinServiceImpl.getInstance();
  	List<CoinHistoryVO> list = service.getCHistoryList(memId);
  	int cnt = 0;
  	for(CoinHistoryVO vo : list) {
  			cnt++;
 %>
  <tbody>
    <tr>
      <th scope="row"><%=vo.getcHistoryNo()%> </th>
      <td><%=vo.getcEventId()%></td>
 <%
			if(vo.getcHistoryCoin().charAt(0) == '+' ){
 %>
      <td><span style="color: limegreen	"><%=vo.getcHistoryCoin()%></span></td>
 <%
			} else if(vo.getcHistoryCoin().charAt(0) == '-' ){
 %>
      <td><span style="color: red	"><%=vo.getcHistoryCoin()%></span></td>
 <%
			}
 %>
      <td><%=vo.getcHistoryBalance()%></td>
      <td><%=vo.getcHistoryDate()%></td>
    </tr>
  </tbody>
 <%
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
