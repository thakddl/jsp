<%@page import="common.vo.AtchFileVO"%>
<%@page import="trainerHome.vo.TrainerHomeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	TrainerHomeVO tvo = (TrainerHomeVO)request.getAttribute("tvo");
	AtchFileVO avo = (AtchFileVO) request.getAttribute("avo");
	
%>	    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="../css/trainerHomeInsert.css">

<script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.17.21/lodash.min.js" integrity="sha512-WFN04846sdKMIP5LKNphMaWzU7YpMyCU245etK3g/2ARYbPK9Ub18eG+ljU96qKRCWh+quCY7yefSmlkQw1ANQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.8.0/gsap.min.js" integrity="sha512-eP6ippJojIKXKO8EPLtsUMS+/sAGHGo1UN/38swqZa1ypfcD4I0V/ac5G3VzaHfDaklFmQLEs51lhkkVaqg60Q==" crossorigin="anonymous" referrerpolicy="no-referrer"></script> 
</head>

<body>

<header>
        <div class="inner">
    
          <a href="/Breath/trainerHome/detail.do" class="logo">
            Chloeting
          </a>
    
          <ul class="main-menu">
            <li class="item">
              <div class="item__name">about</div>
            </li>
            <li class="item">
              <div class="item__name">피드</div>
            </li>
            <li class="item">
              <div class="item__name">트레이닝</div>
            </li>
            <li class="item">
              <div class="item__name">가입</div>
            </li>
           
          </ul>
        </div>
      </header>
	
	<section class="main-intro">
        <div class="inner">
	
	<form action="<%-- <%=request.getContextPath()%>/ --%>update.do" method ="post" enctype="multipart/form-data">
 	<input type="hidden" name="trainerId" value="<%=tvo.getTrainerId()%>">
		
		<div class="input-wraper">
			    <div class="trainerNm-intro">
				<div>name :</div>
				<textarea name="introNm" rows="3" cols="20"><%=tvo.getIntroNm()%></textarea>
			</div>
			    <div class="subcontent-intro">
				<div>sub :</div>
				<textarea name="introSub" rows="3" cols="20"><%=tvo.getIntroSub()%></textarea>
			</div>
				 <div class="maincontent-intro">
            <div>main :</div>
				<textarea name="introMain" rows="3" cols="20"><%=tvo.getIntroMain()%></textarea>
			</div>
			
			<%-- <tr>
				<td>기존첨부파일:</td>
				<td>
					<%
					if(avo != null){
					%>
						<div><a href="#"><%=avo.getOrgnlNm() %></a></div>
					<%
											
					}	
					%> 
				</td>
			</tr> --%>
			<div class="put-img">
				    <div>picture :</div>
			    	<input type="file" name ="atchFile">
			    </div>
		    <input type="submit" value="홈 등록" class="likeBtn">
      </div>
	      </form>
        </div>
        </section>
    </body>
</html>