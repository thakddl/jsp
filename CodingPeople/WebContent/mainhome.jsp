<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
if (session.getAttribute("memId") != null) {
	if (session.getAttribute("memId").equals("admin1")) {
	    response.sendRedirect("../managermain.jsp");
	}
}
%>


<html>
  <head>
    <meta charset="UTF-8">
    <title>Coding People</title>
    <link rel="stylesheet" href="css/coding.css">
    <script src="../js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ab170c97639c98e2a8287792fdb7f6dd"></script>
    
    <script>
   	  $(document).ready(function(){
   	    $('#header').load("header/loginheader.jsp");
        $('#aside').load("side/side1.jsp");
        $('#footer').load("footer/footer.jsp");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
        
		$.ajax({
			type : 'get'
			,url : '/board/list.do'		//요청
			,data : {"boardId" : "1",
				"nowPage" : "1"}
			,dataType : 'html'			//응답(필수)
			,success : function(data){
			  $('#border').html(data);
			}	//응답(필수)
			,error : function(xhr){
				alert("상태 >> " + xhr.status);
			}						//응답(필수)
      
   		});
		
		$.ajax({
			type : 'get'
			,url : '/groupStudy/SimpleList.do'		//요청
			,dataType : 'html'			//응답(필수)
			,success : function(data){
			  $('#study').html(data);
			}	//응답(필수)
			,error : function(xhr){
				alert("상태 >> " + xhr.status);
			}						//응답(필수)
      
   		});
		
   	});   
    </script> 
<style>
	table {
	  border-collapse: collapse;
	  text-align: left;
	  line-height: 1.5;
	  margin : 20px 10px;
	}
	table th {
	  padding: 10px;
	  font-weight: bold;
	  vertical-align: top;
	  color: #369;
	  border-bottom: 3px solid #036;
	}
	table td {
	  padding: 10px;
	  vertical-align: top;
	  border: 1px solid #ccc;
	}
	#border{
	  height: 270px;
	  overflow: hidden;
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
        <section id="contents_mainhome">
          <%-- 비디오메인화면 --%>
            <div id="videomain">
              <div id="video1">
                <p align="middle"> <video class="video1" src="../video/정보처리문제1.mp4"></p>
                <p align="middle"> 정보처리 연습문제 풀이 </p>
              </div>
              <div id="video2">
                <p align="middle"> <video class="video2" src="../video/Java설치.mp4"> </p>
                <p align="middle"> JAVA 시작하기 </p>
              </div>
              <div>
                <div id="bottom">
                  <p><a href="/lecture/getCourseList.do" style="color:black">More>></a></p>
                </div>
              </div>
            </div>        
          <%-- 게시판메인화면 --%>
          <div id="bordermain">
            <div id="border">
            </div>
            <div>
              <div id="bottom2">
                <p><a href="/freeboard.jsp" style="color:black">More>></a></p>
              </div>
            </div>
          </div>
          <%-- 스터디메인화면 --%>
          <div id="studymain">
            <div id="study">


            </div>
            <div>
              <div id="bottom3">
                <p><a href="/studygroup.jsp" style="color:black">More>></a></p>
              <div>
            </div>
          </div>          
        </section> <%-- 본문 끝 --%>
      </div> <%-- 사이드+본문 끝 --%> 
      <%-- 푸터 --%>   
      <footer id="footer">
      </footer> <%-- 푸터 끝 --%>    
    </div> <%-- 전체 끝 --%>
  </body>
</html>