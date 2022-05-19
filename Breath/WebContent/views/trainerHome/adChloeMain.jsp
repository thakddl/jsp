<%@page import="member.vo.MemberVO"%>
<%@page import="trainerHome.vo.TrainerHomeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	TrainerHomeVO tvo = (TrainerHomeVO) request.getAttribute("tvo");
	MemberVO vo = (MemberVO) session.getAttribute("memVO");
	String trainerId = /* vo.getMemId(); */ "a100";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="../css/trainerHome.css">

<script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.17.21/lodash.min.js" integrity="sha512-WFN04846sdKMIP5LKNphMaWzU7YpMyCU245etK3g/2ARYbPK9Ub18eG+ljU96qKRCWh+quCY7yefSmlkQw1ANQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.8.0/gsap.min.js" integrity="sha512-eP6ippJojIKXKO8EPLtsUMS+/sAGHGo1UN/38swqZa1ypfcD4I0V/ac5G3VzaHfDaklFmQLEs51lhkkVaqg60Q==" crossorigin="anonymous" referrerpolicy="no-referrer"></script> 


</head>
<body>
	<!-- HEADER -->
  <header>
    <div class="inner">

      <div class="logo" onclick="location.href='/Breath/index.jsp'">ChloeTing</div>

      <ul class="main-menu">
        <li class="item">
          <div class="item__name" onclick="location.href='/Breath/trainerHome/detail.do'">about</div>
        </li>
        <li class="item">
<%--           <div class="item__name"><a href="/Breath/views/linefeed/list.html?trainerId=<%=tvo.getTrainerId()%>">피드</a></div> --%>
          <div class="item__name" onclick="location.href='/Breath/views/linefeed/list.html?trainerId=<%=tvo.getTrainerId()%>'">피드</div>
        </li>
        <li class="item">
          <div class="item__name" onclick="location.href='/Breath/views/trainerHome/watchVideo.html'">트레이닝</div>
        </li>
        <li class="item">
          <div class="item__name" onclick=signIn()>가입</div>
        </li>
       
      </ul>
    </div>
  </header>
  
  <section class="main-intro">
    <div class="inner">
      <!-- <div class="contents"> -->
        <div class="contents-text">
          <div>
           
<%
	if(vo.getMemId().equals("a100")) {
%>          
           <button class="edit">
           	<div class="edit-icon" onclick="location.href='/Breath/trainerHome/update.do'">
              <div class="material-icons">edit</div>
            </div>
            </button>
 <%
	}
%>            
            <div class="box intro-name">
            <%=tvo.getIntroNm()%>
          </div>
            <div class="intro-sub">
            <%=tvo.getIntroSub()%>
          </div>
            <div class="intro-main">
            <%=tvo.getIntroMain()%>
          </div>
          </div>
        </div>
        <div class="contents-pic">
          <img src="/Breath/showImage.LineFeed?url=<%=tvo.getFilePath().replace("\\", "/")%>">
        </div>
      <!-- </div> --> 
    </div>
  </section>
  <script>
     function signIn() {
      window.open("/Breath/views/pay/pay.jsp", "pop1", "width=800, height=600, left=300, top=50");
     }
  </script>
  
</body>

</html>