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
        $('#aside').load("side/side3.jsp");
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
        <section id="contents_lecturebuyselect">
          <%-- 강의판매 메인 --%>
          <div id="lecturebuyselect_center">          
            <div id="lecturebuyselect1">
              <p> 강의 신청하기 </p>
            </div>
            <fieldset class="lecturebuyselect_box"> 
            <%-- 선택한 강의에 대한 정보 가져오기 --%>
              <ul id="lecturebuyselectul">
                <li>
                  <label for="selectname">강의명</label>
                  <input type="text" id="selectname" required> 
                </li>     
                <li>
                  <label for="selectnumber">구성 강의수</label>
                  <input type="text" id="selectnumber" required> 
                </li>    
                <li>
                  <label for="selectbook">강의도서</label>
                  <input type="text" id="selectbook" required> 
                </li>    
                <li>
                  <label for="selecthow">강의가격</label>
                  <input type="text" id="selecthow" required>원
                </li>
                <li>
                  <label for="selectmoney">보유머니</label>
                  <input type="text" id="selectmoney" required>원
                </li>                 
              </ul>      
            </fieldset>
          </div>
          <div class="button_lecturebuyselect">
            <div id="button_lecturebuyselect">
              <%-- 결제api넣기 --%>
              <input class="lecturebuyselect_buttons" type="button" value="즉시결제">
              <button type="button" onclick="location.href='basketlecture.jsp' ">강의담기</button>
              <input type="button" value="뒤로가기" onClick="history.go(-1)">
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