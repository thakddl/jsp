<%@page import="adminMember.vo.AllMembershipInfoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<AllMembershipInfoVO> memList = (List<AllMembershipInfoVO>)request.getAttribute("memList");
	/* String msg = request.getParameter("msg")==null?"":request.getParameter("msg"); */
%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Coding People > 회원정보</title>
<!--     <link rel="stylesheet" href="/css/coding.css"> -->
    <script src="../js/jquery-3.6.0.min.js"></script>
    <!-- bootstrap 소스 start -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<!-- bootstrap 소스 end -->
	<script>
//    	  $(document).ready(function(){
//    	    $('#header').load("/header/loginheader.jsp");
//         $('#aside').load("/side/managerside.jsp");
//         $('#footer').load("/footer/footer.jsp");
//    	});   
    </script>
  </head>

  <body>
    <%-- 전체 --%>
    <div id="wrap-container">
      <%-- 헤더 호출 --%>
<!--       <header id="header">        
      </header> -->
      <div class="container">
        <div class="page-header">
          <h2>관리자 > 회원목록 조회</h2> <br>
          <button type="button" class="btn btn-default" onclick="location.href='/managermain.jsp' ">관리자 메인</button>
          <button type="button" class="btn btn-default" onclick="location.href='/admin/selectAll.do' ">회원 전체목록</button>
        </div>
          <div>
          <input type="text" id="membersearch" autofocus placeholder="회원 검색"  required>&nbsp;&nbsp;
          <input type="button" class="btn btn-default" id="memberlist_buttons" value="검색하기" onclick="aa();">
          </div>
      </div>
      
		<br>
      <%-- 사이드바+본문 --%>
      <div class="container">
        <%-- 사이드바 --%>
        <aside id="aside">
        </aside>

        <%-- 본문 --%>
        <section id="contents_memberlist">
          <%-- 멤버리스트 메인 --%>
          <div id="memberlist_center">          
            <div id="memberlist">
            </div>
            <div id="memberlist1">
            <%-- 본문몸통 --%>
            <!-- 전체회원 정보 가져오기 -->
             <!-- 작업파일 붙여넣기 시작 -->
                <!-- <h2>회원목록</h2> -->
			    <table class="table table-striped">
			      <thead>
			        <tr>
					  <th>ID</th>
					  <th>이름</th>
					  <th>회원등급</th>
					  <th>전화번호</th>
					  <th>코딩코인</th>
					  <th>활동포인트</th>
					  <th>회원상태</th>
					  <th>가입날짜</th>
			        </tr>
			      </thead>
			      <tbody><!-- 회원조회 -->
			       <%
			       	 int memSize = memList.size();
			       	 if(memSize > 0){
			       		 for(int i = 0 ; i < memSize ; i++){
			       %>	
			 	    <tr>
					  <td><a href="/admin/UpdateMember.do?memId=<%=memList.get(i).getMemId() %>"><%=memList.get(i).getMemId() %></a></td> <!-- 아이디 -->
					  <td><%=memList.get(i).getMemName() %></td> <!-- 회원명 -->
					  <td><%=memList.get(i).getMgId() %></td><!-- 회원등급 -->
					  <td><%=memList.get(i).getMemTel() %></td><!-- 전화번호 -->
					  <td><%=memList.get(i).getMemCoin() %></td><!-- 코딩코인 -->
					  <td><%=memList.get(i).getMemPoint() %></td><!-- 활동포인트 -->
					  <td><%=memList.get(i).getMsId() %></td><!-- 회원상태 -->
					  <td><%=memList.get(i).getMemDate() %></td><!-- 가입날짜 -->
					  <!-- <td><button type="button" onclick="location.href='/admin/UpdateMember.do' ">정보수정</button></td> -->
			        </tr> 
			        <%
			       		 } // for end
			       	 } // if end
			       %>
			      </tbody>
			    </table>
<%-- 			    <%
			      if(msg.equals("성공")){
			    %>
			    <script>
			       alert("정상적으로 처리되었습니다.");
			    </script>
			    <%
			      } /* 업데이트 성공 시 알람창 if절 끝 */
			    %>  --%>
            <!-- 작업파일 붙여넣기 끝 -->
            </div><!-- memberlist1 end-->
          </div>
          <div class="button_memberlist">
            <div id="button_memberlist">

            </div>
          </div>
        </section>
      </div>
      <%-- 푸터영역 --%>
      <footer id="footer">
      </footer>
    </div>
    
    <script>
      	function aa(){
      		let keyword = $('#membersearch').val();
       		location.href = "/admin/searchMember.do?keyword=" + keyword + ""; 
      		console.log(keyword.val());
      		/* location.href = "/admin/searchMember.do?keyword='"keyword"'";  */
      	};
      	$(document).ready(function(){
    		<%
    			if(request.getAttribute("updateMsg")=="성공"){
    		%>
    				alert("회원정보 수정이 완료되었습니다.");
    		<%
    			}else if(request.getAttribute("updateMsg")=="실패"){
    		%>
    				alert("회원정보 수정에 실패했습니다.");
			<%
				}
    		%>
    	});
      </script>
      
  </body>
</html>