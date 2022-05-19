<%@page import="clientMyPage.vo.ClientMyPageVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	ClientMyPageVO mypageVo = (ClientMyPageVO)request.getAttribute("mypageVo");
 	if (session.getAttribute("memId") == null) {
	    response.sendRedirect("/login.jsp");
	}
	String memId = (String) session.getAttribute("memId");
	String msg = (String)request.getAttribute("updateMsg");
%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Coding People</title>
    <link rel="stylesheet" href="../css/coding.css">
    <script src="../js/jquery-3.6.0.min.js"></script>
    <script>
   	  $(document).ready(function(){
   	    $('#header').load("/header/loginheader.jsp");
        $('#aside').load("/side/side2.jsp");
        $('#footer').load("/footer/footer.jsp");
   	
	<%
		if(request.getAttribute("updateMsg")=="성공"){
	%>
			alert("회원정보가 수정되었습니다.");
	<%
		}else if(request.getAttribute("updateMsg")=="실패"){
	%>
			alert("회원정보가 수정에 실패했습니다..");
	<%
		}
	%>
   	  });   
   	  
    </script>
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
        <section id="contents_readmore">
          <%-- 정보수정 메인 --%>
          <div class="readmore_center">
            <div id="readmoreedit">
              <p> 고객정보 조회/수정 </p>
            </div>
            <!-- <form method="post" onsubmit="chk();"> -->
            <form id="submit" method="post" onsubmit="chkPw();" action="/client/UpdateMypage.do">
            <fieldset class="membership_box"> 
                <ul id="membership">
                  <li>
                    <label for="memid">아이디</label>
                    <input type="text" id="memid" name="id" value="<%=memId %>" readonly>
                  </li>    
                  <li>
                    <label for="mempw">비밀번호</label>
                    <input type="password" class="pw" id="mempw" name="memPass" placeholder="변경할 비밀번호 입력" required>
                  </li>    
                  <li>
                    <label for="mempw2">비밀번호확인</label>
                    <input type="password" class="pw" id="mempw2" name="password2" placeholder="한번 더 입력해주세요." required>
                  </li>
                  <li>
                    <label for="memnm">이름</label>
                    <input type="text" id="memnm" name="memName" value="<%=mypageVo.getMemName() %>" required>
                  </li>    
                  <li>
                    <label for="memday">생년월일</label>
                    <input type="date" id="memday" name="memBir" value="<%=mypageVo.getMemBir() %>" required> 
                  </li>
                  <li>
                    <label for="memmail">이메일</label>
                    <input type="email" id="memmail" name="memMail" value="<%=mypageVo.getMemMail() %>" required>
                  </li>
                  <li>
                    <label for="memtel">전화번호</label>
                    <input type="tel" id="memtel" name="memTel" value="<%=mypageVo.getMemTel() %>" required>
                  </li>
                  <li>
                    <label for="memaddr">우편번호</label>
                    <input type="text" id="zip" name="memZip" readonly value="<%=mypageVo.getMemZip() %>" required>
                    <input type="button" id="zipsearch" onclick="findAddr();" value="우편검색"> 
                  </li>
                  <li>
                    <label for="memaddr">주소</label>
                    <input type="text" id="memadd1" name="memAdd1" readonly value="<%=mypageVo.getMemAdd1() %>" required>
                  </li>
                  <li>
                    <label for="memaddr">상세주소</label>
                    <input type="text" id="memadd2" name="memAdd2" value="<%=mypageVo.getMemAdd2() %>" required>
                  </li>
                </ul>      
            </fieldset>
            <div>
              <div id="button_membership">
                <input class="membershipo_buttons" type="submit" id="sendBtn" value="회원정보 수정">
                <!-- <button class="membershipo_buttons" type="button" id="sendBtn" >회원정보 수정</button> -->
                <input class="membershipo_buttons" type="reset" value="취소">
              </div>
            </div>
          </form>
          </div>
        </select>
      </div>
      <%-- 푸터 --%>      
      <footer id="footer">
      </footer>
    </div>
<!--     <script>
    function chkPw(id,pw,pw2){
    	event.preventDefault(); // submit 이벤트를 막아 페이지 리로드를 방지

    	let id = $('#memid').val().trim();
    	let pw = $('#mempw').val().trim();
    	let pw2 = $('#mempw2').val().trim();
    	let regPass = /^[a-z0-9]{5,12}$/; // 영문+숫자 5~12자리 설정

    	if(!regPass.test(pw)){ // 최초입력 비밀번호 유효성 검사
    		alert("비밀번호는 영문+숫자 5~12자리로 입력해야 합니다.");
    		form.pw.value="";
    		form.pw.focus();
    		return false;
    	} else if(pw!=pw2){ // 비밀번호1, 비밀번호2 일치여부 확인
    		alert("입력한 비밀번호가 서로 일치하지 않습니다.");
    		form.pw.value = "";
            form.pw2.value = "";
            form.pw2.focus();
            return false;
    	} 
    	return true; // 확인이 완료되면 true를 리턴
    };
   		 //$('#sendBtn').on('click',chk);
    </script> -->
  </body>
</html>