<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="notice.vo.NoticeVO"%>
<%@page import="notice.sevice.INoticeService"%>
<%@page import="notice.sevice.NoticeServiceImpl"%>
<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String msg = request.getParameter("msg") == null ? "" : request.getParameter("msg");	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Breading</title>

  <script src="./js/jquery-3.6.0.min.js"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="./css/main.css" />

  <script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.17.21/lodash.min.js" integrity="sha512-WFN04846sdKMIP5LKNphMaWzU7YpMyCU245etK3g/2ARYbPK9Ub18eG+ljU96qKRCWh+quCY7yefSmlkQw1ANQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.8.0/gsap.min.js" integrity="sha512-eP6ippJojIKXKO8EPLtsUMS+/sAGHGo1UN/38swqZa1ypfcD4I0V/ac5G3VzaHfDaklFmQLEs51lhkkVaqg60Q==" crossorigin="anonymous" referrerpolicy="no-referrer"></script> 
 <link rel="stylesheet" href="https://unpkg.com/swiper@6.8.4/swiper-bundle.min.css" />
  <script src="https://unpkg.com/swiper@6.8.4/swiper-bundle.min.js"></script>
  <!—ScrollMagic—>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/ScrollMagic/2.0.8/ScrollMagic.min.js"></script>
  <!—Lodash—>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.17.20/lodash.min.js" integrity="sha512-90vH1Z83AJY9DmlWa8WkjkV79yfS2n2Oxhsi2dZbIv0nC4E6m5AbH8Nh156kkM7JePmqD6tcZsfad1ueoaovww==" crossorigin="anonymous"></script>
  <script defer src="./js/main.js"></script>
  
</head>
<body>
  <% 
  	// 공지사항 불러오기.
  	INoticeService nService = NoticeServiceImpl.getInstance();
  	
  	List<NoticeVO> list = new ArrayList<>();
  	
  	list = nService.noticeList();
  %>

<!-- Header -->
	<jsp:include page="/mainHeader.jsp" flush="true"></jsp:include>
<!-- Header -->
  
  <!-- visual -->
  <section class="visual">
    <div class="inner">
      <!-- <div class="title fade-in">
        <img src="./images/visual_title.png" alt="STARBUCKS DELIGHTFUL START TO THE YEARS" />
        <a href="javascript:void(0)" class="btn btn--brown">자세히 보기</a>
      </div> -->
      <div class="fade-in">
        <p class="title">Workout Beats.</p>
      </div>
      <!-- <div class="fade-in">
        <img src="./midProjectPic_images/couplesWorkOut.jpg" alt="Spoon" class="couplesWorkOut" />
      </div> -->
    </div>
  </section>
  
  <section class="notice">

    <div class="notice-line">
      <div class="bg-left"></div>
      <div class="bg-right"></div>
      <div class="inner">
        
        <div class="inner__left">
          <h2>공지사항</h2>
          <div class="swiper-container">
          	<div class="swiper-wrapper">
          	
<%
			for(int i = 0; i < list.size(); i++) {
%>				
				<div class="swiper-slide">
                	<a href="/Breath/NoticeDetail.do?postNum=<%=list.get(i).getPostNum() %>"><%=list.get(i).getTitle() %></a>
              	</div>			
<%				
			}
%>          	
            </div>
          </div>
          <a href="javascript:void(0)" class="notice-line__more">
            <div class="material-icons" onclick="location.href='/Breath/NoticeList.do'">
              add_circle
            </div>
          </a>
        </div>
        <div class="inner__right">
          <!-- <h2>로그인</h2>
          <div class="toggle-promotion">
            <div class="material-icons">upload</div>
          </div> -->
        </div>
      </div>
    </div>
  </section>

  <section class="rewards">

    <div class="inner">

      <div class="btn-group">
        <div id="log-out1" class="btn sign-in">로그아웃</div>
      </div>

    </div>
  </section>

  <section class="main-ad">
    <div class="inner">
      
      <div class="text-chloe" class="description back-to-position to-left delay-2">
        <p>22M 유튜버와 함께하는</p><br>
        <p class="sen-text"> 바디 챌린지</p>
      </div>
        <a href="/Breath/trainerHome/detail.do" class="btn btn—reverse detail">자세히 보기</a>
      
      <div class="chloe-pic" >
        <img src="https://chloeting.com/static/media/chloeting-header.94e23885.png" alt="Chloe" class="title back-to-position to-left delay-1">
      </div>
    </div>
  </section>
	<%@include file="/mainFooter.jsp" %>
<script>
$('#log-out, #log-out1').on('click',function(){
	let result = confirm("로그아웃 하시겠습니까?");
	if(result){
	alert("로그아웃 되었습니다.");
 	location.replace("./views/signin/logout.jsp");
	}
}); 
</script>
</body>
</html>