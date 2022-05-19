<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>회원가입을 환영합니다</title>
     <link rel="stylesheet" href="css/coding.css">
    <script src="./js/jquery-3.6.0.min.js"></script>
   <script src="./js/membership_joinMember.js"></script>
   <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
   <script>
   
    $(document).ready(function(){
		$('#header').load("header/loginheader.jsp");
	    $('#aside').load("side/side1.jsp");
	    $('#footer').load("footer/footer.jsp");
   	});   
	  
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
      
   }
</script>
     <link rel="stylesheet" href="../css/coding.css">
       <script>
         $(document).ready(function(){
             $('#header').load("header.jsp");
             $('#aside').load("side.jsp");
         });
     </script>

  </head>

  <body>
      <%-- 전체 --%>
 <div id="wrap-container">
        <header id="header">
        </header>
      <%-- 사이드바+몸통 --%>
      <div class="container">
      <%-- 사이드바 --%>
     <aside id="aside">
     </aside>

      <div class="container_membership">
         <section id="contents_membership">
      <div class="membership_center">
        <h1 id="h_membership">회원가입 정보를 입력해주세요!</h1>
          <form method="post" onsubmit="chkAll();">
            <fieldset class="membership_box"> 
                <ul id="membership">
                  <li>
                    <label for="memid">아이디</label>
                    <input type="text" id="memid" name="id" autofocus placeholder="5글자 이상" required>
                    <!-- <input type="submit" value="중복검사"> -->
                    <button type="button" id="idChk" onclick="idchkBtn();">중복검사</button>
                  </li>    
                  <li>
                    <label for="mempw">비밀번호</label>
                    <input type="password" class="pw" id="mempw" name="password" autofocus placeholder="영어+숫자 8글자이상" required> 
                  </li>    
                  <li>
                    <label for="mempw2">비밀번호확인</label>
                    <input type="password" class="pw" id="mempw2" name="password2"  autofocus placeholder="한번 더 입력해주세요." required> 
                  </li>    
                  <li>
                    <label for="memnm">이름</label>
                    <input type="text" id="memnm" name="name" autofocus required> 
                  </li>    
                  <li>
                    <label for="memday">생년월일</label>
                    <input type="date" id="memday" name="bir" autofocus required> 
                  </li>
                  <li>
                    <label for="memmail">이메일</label>
                    <input type="email" id="memmail" name="mail" placeholder="aaa@aaa.aaa" required>
<!--                     <select id="memmail">
                    <option value="mail1">naver.com</option>
                    <option value="mail2">hanmail.net</option>
                    <option value="mail3">google.com</option>
                    <option value="mail4">nate.com</option>
                    </select> -->
                  </li>
                  <li>
                    <label for="memtel">전화번호</label>
                    <input type="tel" id="memtel" name="tel" autofocus placeholder="하이폰(-) 제외" required> 
                  </li>
                  <li>
                    <label for="memaddr">우편번호</label>
                    <input type="text" id="zip" name="memZip" readonly placeholder="우측 우편번호 검색" required>
                    <input type="button" id="zipsearch" onclick="findAddr();" value="우편검색"> 
                  </li>
                  <li>
                    <label for="memaddr">주소</label>
                    <input type="text" id="memadd1" name="add1" readonly required>
                  </li>
                  <li>
                    <label for="memaddr">상세주소</label>
                    <input type="text" id="memadd2" name="add2" placeholder="상세 주소 입력" required>
                  </li>
                </ul>      
            </fieldset>
            <div>
              <div id="button_membership">
                <input class="membershipo_buttons" type="submit" id="sendBtn" value="가입하기">
                <input class="membershipo_buttons" type="reset" value="취소">
              </div>
            </div>
          </form>
          
      </div>
      </div>      
        <footer id="footer">
        </footer>
    </div>
    </div>
  </body>
</html>