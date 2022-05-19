<%@page import="adminMember.vo.AllMembershipInfoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	AllMembershipInfoVO MemVO = (AllMembershipInfoVO) request.getAttribute("allMembershipInfoVO");	
%>


<ul id="topMenu">
	<li><a href="/mypage.jsp">마이페이지</a></li>
	<li><a href="/mypage.jsp"><%=MemVO.getMemName() %>고객님</a></li>
	<li><a href="/LoginPro.do">로그아웃</a></li>
</ul>
<ul id="topMenu">
	<li><a href="#" onclick=signIn()>충전</a></li>
	<li><a href="/point.jsp">코딩코인 : <%=MemVO.getMemCoin() %>C
	</a></li>
</ul>
<script>
       function signIn() {
    <%
    	   if (session.getAttribute("memId") == null) {
    	        response.sendRedirect("/login.jsp");
    	    }else {
   	%>
	window.open("/requestPay.jsp", "pop1", "width=550, height=600, left=300, top=50");
    <%
    	    }
    %>
  		}
    </script>