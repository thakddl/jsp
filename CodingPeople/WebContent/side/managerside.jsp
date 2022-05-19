<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <aside id="left-sidebar">
    <div id="side-mp">
      <h1 id="h1-mp">관리자모드</h1>
    </div>
    <div id="side2=mp">
      <ul id="side2-ul">
        <li id="side2-li"><a href="/admin/selectAll.do" style="color:black">회원관리</a>
<!--           <li id="side3-li"><a href="/admin/selectAll.do" style="color:black">회원목록</a></li>
          <li id="side3-li"><a href="blacklist.jsp" style="color:black">블랙리스트</a></li> -->
        </li>
        <li id="side2-li"><a href="/admin/selectBookList.do" style="color:black">도서관리</a></li>
        <li id="side2-li"><a href="/lecture/adminInspection.do" style="color:black">강의검수</a></li>
        <li id="side2-li"><a href="/admin/SelectAllCategories.do" style="color:black">카테고리관리</a></li>
        <!-- <li id="side2-li"><a href="salesstatus.jsp" style="color:black">매출현황</a></li> -->
      </ul>
    </div>
  </aside>
</body>
</html>