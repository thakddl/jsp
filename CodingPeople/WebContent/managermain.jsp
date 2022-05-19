<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Coding People</title>
    <link rel="stylesheet" href="css/coding.css">
    <script src="../js/jquery-3.6.0.min.js"></script>
    <script>
   	  $(document).ready(function(){
   	    $('#header').load("header/loginheader.jsp");
        $('#aside').load("side/managerside.jsp");
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
        <section id="contents_managermain">
          <%-- 포인트 메인 --%> 
          <div id="managermain_center">
            <div id="managermain">
              <p>관리자모드 List</p>               
              <div id="managermain_menu">
                <div id="button_managermain">                
                  <button type="button" onclick="location.href='/admin/selectAll.do' ">회원 관리</button>                
                  <button type="button" onclick="location.href='/admin/selectBookList.do' ">도서 관리</button>
                </div>
                <div id="button_managermain"> 
                  <button type="button" onclick="location.href='/lecture/adminInspection.do' ">강의검수</button>
<!--                   <button type="button" onclick="location.href='salevideolist.jsp' ">판매강의 관리</button> -->
                  <button type="button" onclick="location.href='/admin/SelectAllCategories.do' ">카테고리 관리</button>
                </div>
                <div id="button_managermain"> 
             <!-- <button type="button" onclick="location.href='category.jsp' ">카테고리 관리</button> -->
                  <!-- <button type="button" onclick="location.href='salesstatus.jsp' ">매출현황</button> -->
                </div>
              </div>
            </div>
          </div>
        </section>
      </div>
      <%-- 푸터 --%> 
      <footer id="footer">
      </footer>
    </div>
  </body>
</html>