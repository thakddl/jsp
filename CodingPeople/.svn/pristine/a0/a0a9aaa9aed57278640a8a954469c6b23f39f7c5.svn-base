<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String memId = (String) session.getAttribute("memId");
%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Coding People</title>
    <link rel="stylesheet" href="css/coding.css">
    <style>
     	 table {
     	  display: inline-block;
		  border-collapse: collapse;
		  text-align: left;
		  line-height: 1.5;
		  margin : 20px 10px;
		  width: 100%;
		}
		table th {
		  border: 1px solid black;
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
		.aa {
		  display: inline-block;
		  width: 48%;
		}
		#GroupStudy {
		  width: 100%;
		}
		#aa {
		  width: 48%;
		  float: left;
		}
		#bb {
		  width: 46%;
		  float: left;
		}
    </style>
    <script src="../js/jquery-3.6.0.min.js"></script>
    <script>
   	  $(document).ready(function(){
   	    $('#header').load("header/loginheader.jsp");
        $('#aside').load("side/side2.jsp");
        $('#footer').load("footer/footer.jsp");
        
		/* location.href="/groupStudy/detail.do?memId="+memId; */
		$.ajax({
			type : 'get'
			,url : '/mygroupdetail.do'		//요청
			,dataType : 'html'			//응답(필수)
			,data : { 'memId' : "<%=memId%>" }
			,success : function(data){
			  $('#GroupStudy').html(data);
			}	//응답(필수)
			,error : function(xhr){
				alert("상태 >> " + xhr.status);
			}						//응답(필수)
		});
        
        
        
        
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
        <section id="contents_mypage">
            <div id="GroupStudy">
            
            </div>
          <%-- 고객정보 메인 --%>
          <div id="mypage_center">
          </div>
        </section>
      </div>    
      
      <%-- 푸터 --%>
      <footer id="footer">
      </footer>        
    </div>
  </body>
</html>