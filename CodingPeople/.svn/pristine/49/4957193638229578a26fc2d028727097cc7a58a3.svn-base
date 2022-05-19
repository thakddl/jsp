<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String memId = "";
	if (session.getAttribute("memId") == null) {
%>
<script>
		alert("로그인 후 사용 가능합니다");
		window.location.href="/login.jsp";
</script>
<%
	} else {
		memId = (String)session.getAttribute("memId");
	}
%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Coding People</title>
    <link rel="stylesheet" href="../css/coding.css">
    <script src="../js/jquery-3.6.0.min.js"></script>
    

    <script>
   	  $(document).ready(function(){
   	    $('#header').load("../header/loginheader.jsp");
        $('#aside').load("../side/side4.jsp");
        $('#footer').load("../footer/footer.jsp");
        
   	  });
		
		$(document).on("mouseover",".line",function(){
			$(this).css({"background-color" : "skyblue"});
		});
		$(document).on("mouseout",".line",function(){
			$(this).css({"background-color" : "white"});
		});
		
		$(document).on("click",".line",function(){
			let val = $(this).children().eq(0).text();
			location.href="/questionboard/detail.do?boardId=3&postId="+val;
		});
		
		$(document).on("load",function(){
			if(msg.equals("성공")){
				alert('정상적으로 처리되었습니다.');	
			}
		});
	
    </script>
<style>
	table {
	  border-collapse: collapse;
	  text-align: left;
	  line-height: 1.5;
	  margin : 20px 10px;
	  width: 750px;
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
        <section id="contents_questionboard">
          <%-- 자유게시판 메인 --%>
          <div id="questionboard_center">          
            <div id="questionboard">
				<form action="search.jsp">
					<select>
						<option>번호</option>
						<option>제목</option>
						<option>글쓴이</option>
						<option>작성일</option>
					</select>
		            <input type="search" id="questionboardsearch" placeholder="게시글 검색" required>
		            <input type="button" id="questionboard_buttons" value="검색하기">
				</form>
            </div>
            <div id="questionboard1">
           <form action="insert.do" method="post" enctype="multipart/form-data">
				<table>
					<tr>
						<td>제목</td>
						<td><textarea name="postTitle" rows="2" cols="50"></textarea></td>
					</tr>
					<tr>
						<td>글쓴이</td>
						<td><input type="text" name="memId" value="<%=memId %>" readonly></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea name="postContent" rows="20" cols="50"></textarea></td>
					</tr>
				</table>
				<button type="button" onclick="location.href='/questionboard.jsp'">이전화면</button>
				<input type="submit" value="글 쓰기">
			</form>
            </div>
            <div id="questionboard2">
            </div>
          </div>
          <div class="button_questionboard">
            <div id="button_questionboard">
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


</head>
<body>
	
</body>
</html>