<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String memId = (String)session.getAttribute("memId");

	String msg = request.getParameter("msg")==null?"":request.getParameter("msg");
%>

<html>
  <head>
    <meta charset="UTF-8">
    <title>Coding People</title>
    <link rel="stylesheet" href="css/coding.css">
    <script src="../js/jquery-3.6.0.min.js"></script>
    <script>
		
   	  $(document).ready(function(){
   		let msg = "<%=msg %>";
       	 if(msg==("성공")){
       		alert("요청이 완료되었습니다!!");	
       	 } else if(msg == "실패") {
    		 window.open("/requestPay.jsp", "pop1", "width=550, height=600, left=300, top=50");
		 }
   	    $('#header').load("header/loginheader.jsp");
        $('#aside').load("side/side3.jsp");
        $('#footer').load("footer/footer.jsp");
        
      $.ajax({
	     url : '/lecture/list.do'
	    ,type : 'post'
	    ,success:function(aa){
	    	$('#singupselect').html(aa);
	    }
	    ,error:function(xhr){
	    	alert("상태 : " + xhr.status);
	    }
	    ,dataType: 'html'
      });
      
      $(document).on('change','#singupselect',function(){
    	  let categoryId = $('#singupselect').val();
	      $.ajax({
		     url : '/lecture/getBookName.do'
		    ,type : 'post'
		    ,data : {'categoryId' : categoryId }
		    ,success:function(aa){
		    	$('#signupbook').html(aa);
		    }
		    ,error:function(xhr){
		    	alert("상태 : " + xhr.status);
		    }
		    ,dataType: 'html'
	      });
      });
   	});   
    </script>
    <style>
    #lecturesignup_center {
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
        <section id="contents_lecturesignup">
          <%-- 강의판매 메인 --%>
          <div id="lecturesignup_center">          
            <div id="lecturesignup1">
              <p> 강의 판매요청 </p>
            </div>
            <fieldset class="lecturesignup_box"> 
              <form action="/lecture/insertReq.do" method="post" enctype="multipart/form-data">
              <input type="hidden" name="memId" value="<%=memId %>">
              <ul id="lecturesignupul">
                <li>
                  <label for="singupselect">강의구분</label>
                  <select id="singupselect" name="categoryId">
                  	
                  </select>
                </li>
                <li>
                  <label for="singupname">강의명</label>
                  <input type="text" id="singupname" name="courseTitle" required> 
                </li>     
                <li>
                  <label for="singupexplanation">강의 설명글</label>
                  <textarea id="singupexplanation" rows="6" cols="30" name="courseIntroduction" required></textarea>
                </li>     
                <li id="mk2">
                  <label for="signupbook">강의구분</label>
                  <select id="signupbook" name="bookinfoId">
                  	
                  </select>
                </li>  
                <li>
                  <label for="singuphow">강의가격</label>
                  <input type="text" id="singuphow" name="coursePrice" required>원
                </li>              
                <li id="mk1">
                  <label for="signupnumber">강좌 수</label>
                  <input type="number" id="signupnumber" name="courseComposition" required> <br>
                </li>    
                <li>
                  <label for="file">첨부파일</label>
                  <input type="file" id="file" name="atchFile" multiple="multiple" required>
                </li>              
              </ul>      
          </div>
          <div class="button_lecturesignup">
            <div id="button_lecturesignup">
              <input class="lecturesignup_buttons" type="submit" value="등록요청">
              </form>
            </fieldset>
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