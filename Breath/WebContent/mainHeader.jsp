<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	MemberVO mv = (MemberVO) session.getAttribute("memVO");
	String athrtCode = mv.getAthrtCode();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <!-- HEADER -->
  <header>
    <div class="inner">

      <a href="/Breath/index.jsp" onClick="" class="logo">
        BES
      </a>

      <div class="sub-menu">
        <ul class="menu">
          <li id="li1">
            <a href="#"><div><%=mv.getNickName() %>님 로그인 중...</div></a>
          </li>
<% 
	    if(athrtCode.equals("0")) {
%>        
          <li id="li1">
            <a href="/Breath/views/admin/admin.html"><div>Admin Page</div></a>
          </li>
<%
	    }
%>        
          <li>
            <a href="/Breath/views/mypage/mypage.jsp">My Page</a>
          </li>
          <li>
            <a href="javascript:void(0)">Customer Service</a>
          </li>
        </ul>
        <div class="search">
          <input type="text" />
          <div class="material-icons">search</div>
        </div>
           &nbsp;&nbsp;&nbsp;<div id="log-out" class="btn sign-in" onclick="location.href='/Breath/views/signin/logout.jsp'">로그아웃</div>
      </div>

      <ul class="main-menu">
        <li class="item">
          <div class="item__name" onclick="location.href='/Breath/trainer/trainerList.do'">TRAINER</div>
          <div class="item__contents">
            <div class="contents__menu">
              <ul class="inner">
                <li>
                  <h4>구독자</h4>
                </li>
                <li>
                  <h4>멤버쉽</h4>
                </li>
                <li>
                  <h4>운동종류</h4>
                </li>
                <li>
                  <h4>트레이너명</h4>
                </li>
              </ul>
            </div>
            
          </div>
        </li>
        <li class="item">
          <div class="item__name" onclick="location.reload();">REVIEW</div>
          <div class="item__contents">
            <div class="contents__menu">
              <ul class="inner">
                <li>
                  <h4>리뷰 조회</h4>
                </li>
                <li>
                  <h4>리뷰 작성</h4>
                </li>
              </ul>
            </div>
        
          </div>
        </li>
        <li class="item">
          <div class="item__name" onclick="location.href='/Breath/List.qnaBoard'">Q&A</div>
          <div class="item__contents">
            <div class="contents__menu">
              <ul class="inner">
                <li>
                  <h4>문의글 조회</h4>
                </li>
                <li>
                  <h4>문의글 작성</h4>
                </li>
              </ul>
            </div>
            
          </div>
        </li>
        <li class="item">
          <div class="item__name" onclick="location.href='/Breath/NoticeList.do'">NOTICE</div>
          <div class="item__contents">
            <div class="contents__menu">
              <ul class="inner">
                <li>
                  <h4>공지사항</h4>
                </li>
                <li>
                  <h4>자주 묻는 질문</h4>
                </li>
              </ul>
            </div>
            
          </div>
        </li>
        
      </ul>
    </div>

<!--     <div class="badges"> -->
<!--       <div class="badge"> -->
<!--         배너 -->
<!--         <img src="./images/badge1.jpg" alt="Badge" /> -->
<!--       </div> -->
<!--       <div class="badge">
<!--         <img src="./images/badge2.jpg" alt="Badge" /> -->
<!--       </div> -->
<!--     </div> -->

  </header>
  <!-- Header End -->
  
<script>
/* $('#log-out, #log-out1').on('click',function(){
	let result = confirm("로그아웃 하시겠습니까?");
	if(result){
	alert("로그아웃 되었습니다.");
 	location.replace("./views/signin/logout.jsp");
	}
}); */
</script>
</body>
</html>