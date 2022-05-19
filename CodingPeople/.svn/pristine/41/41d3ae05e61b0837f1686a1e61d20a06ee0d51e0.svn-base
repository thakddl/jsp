<%@page import="adminMember.vo.AllMembershipInfoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
AllMembershipInfoVO memVo = (AllMembershipInfoVO)request.getAttribute("memListVo");
%>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Coding People > 전체 회원관리 > 회원정보 수정</title>
    <!-- <link rel="stylesheet" href="css/coding.css"> -->
    <script src="../js/jquery-3.6.0.min.js"></script>
    <script>
/*    	  $(document).ready(function(){
   	    $('#header').load("header/loginheader.jsp");
        $('#aside').load("side/managerside.jsp");
        $('#footer').load("footer/footer.jsp");
   	});  */  
    </script>
    <!-- 주소검색 api 시작 ▼ -->
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
   <script>
   function findAddr(){
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            let addr = '';
            
            if(data.userSelectedType==='R'){
               addr = data.roadAddress;
            } else {
               addr = data.jibunAddress;
            }
         document.getElementById('zip').value = data.zonecode;
         document.getElementById('memadd1').value = addr;
         document.getElementById('memadd2').focus();
        }
    }).open();
      
   } // findAddr() end
  </script>
  <!-- 주소검색 api 끝 ▲-->
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
<!--           <div>
	          <input type="text" id="membersearch" autofocus placeholder="회원 검색"  required>&nbsp;&nbsp;
	          <input type="button" class="btn btn-default" id="memberlist_buttons" value="검색하기" onclick="aa();">
          </div> -->
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
              <form class="form-horizontal" method="post" action="/admin/UpdateMember.do">
	                  <!-- <ul id="membership"> -->
	                    <div class="form-group">
	                      <label class="control-label col-sm-2" for="memid">아이디</label>
	                      <div class="col-sm-10">
	                      	<input type="text" class="form-control" id="memid" name="memId" readonly value="<%=memVo.getMemId() %>">
	                      </div>
	                    </div>   
	                     
	                    <div class="form-group">
	                      <label class="control-label col-sm-2"  for="memnm">이름</label>
	                      <div class="col-sm-10">
	                      	<input type="text" class="form-control" id="memnm" name="memName" value="<%=memVo.getMemName() %>">
	                      </div>
	                    </div> 
	                       
	                    <div class="form-group">
	                      <label class="control-label col-sm-2"  for="memday">생년월일</label>
	                      <div class="col-sm-10">
	                      	<input type="date" class="form-control" id="memday" name="memBir" value="<%=memVo.getMemBir() %>">
	                      </div>
	                    </div>
	                    
	                    <div class="form-group">
	                      <label class="control-label col-sm-2"  for="zip">우편번호</label>
	                      <div class="col-sm-10">
	                      	<input class="form-control"  type="text" id="zip" name="memZip" readonly value="<%=memVo.getMemZip()%>">
	                      	<input class="btn btn-default" type="button" id="zipsearch" onclick="findAddr();" value="우편검색"> 
	                      </div>
	                    </div>
	                    
	                    <div class="form-group">
	                      <label class="control-label col-sm-2" for="memadd1">주소</label>
	                      <div class="col-sm-10">
		                      <input class="form-control" type="text" id="memadd1" name="memAdd1" readonly value="<%=memVo.getMemAdd1() %>" >
	                      </div>
	                    </div>
	                    
	                    <div class="form-group">
	                      <label class="control-label col-sm-2" for="memadd2">상세주소</label>
	                      <div class="col-sm-10">
	                      	<input class="form-control" type="text" id="memadd2" name="memAdd2" value="<%=memVo.getMemAdd2() %>">
	                      </div>
	                    </div>
	                    
	                    <div class="form-group">
	                      <label class="control-label col-sm-2" for="memtel">전화번호</label>
	                      <div class="col-sm-10">
	                     	 <input class="form-control" type="tel" id="memtel" name="memTel" value="<%=memVo.getMemTel() %>">
	                      </div>
	                    </div>
	                    
	                    <div class="form-group">
	                      <label class="control-label col-sm-2" for="memmail">이메일</label>
	                      <div class="col-sm-10">
	                      	<input class="form-control" type="email" id="memmail" name="memMail" value="<%=memVo.getMemMail() %>">
	                      </div>
	                    </div>
	                    
	                    <div class="form-group">
	                      <label class="control-label col-sm-2" for="mgId">회원등급</label>
	                      <div class="col-sm-10">
	                      	<input class="form-control" type="text" id="mgId" name="mgId" readonly value="<%=memVo.getMgId() %>">
	                      </div>
	                    </div>
	                    
	                    <div class="form-group">
	                      <label class="control-label col-sm-2" for="memCoin">코딩코인</label>
	                      <div class="col-sm-10">
	                     	 <input class="form-control" type="text" id="memCoin" name="memCoin" readonly value="<%=memVo.getMemCoin() %>">
	                     </div>
	                    </div>
	                    
	                    <div class="form-group">
	                      <label class="control-label col-sm-2" for="memPoint">활동포인트</label>
	                      <div class="col-sm-10">
	                      	<input class="form-control" type="text" id="memPoint" name="memPoint" readonly value="<%=memVo.getMemPoint() %>">
	                      </div>
	                    </div>
	                    
	                    <div class="form-group">
	                      <label class="control-label col-sm-2" for="msId">회원상태</label>
	                      <div class="col-sm-10">
		                      <select class="form-control" id="msId" name="msId">
		                          <option>delete</option>
		                          <option>dormancy</option>
		                          <option selected>enable</option>
		                      </select>
		                  </div>
	                    </div>
	                    
	                    <div class="form-group">
	                      <label class="control-label col-sm-2" for="joinDate">가입일자</label>
	                      <div class="col-sm-10">
	                      	<input class="form-control" type="text" id="joinDate" name="add2" readonly value="<%=memVo.getMemDate() %>">
	                      </div>
	                    </div>
	                  <!-- </ul>  -->        
                  <!-- <div> -->
                    <div id="button_membership">
                      <button class="btn btn-default" id="returnMemListBtn" onclick="location.href='/admin/selectAll.do'">전체 회원목록</button>
                      <input class="btn btn-default" type="submit" id="sendBtn" value="수정">
                      <input class="btn btn-default" type="reset" value="취소">
                    </div>
                  <!-- </div> -->
                </form>
              </div>
</html>