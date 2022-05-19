<%@page import="GroupStudy.VO.GroupStudyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String memId = (String)session.getAttribute("memId");
%>    
    
<html>
  <head>
    <meta charset="UTF-8">
    <title>그룹스터디 개설</title>
    <link rel="stylesheet" href="../css/coding.css">
    <script src="../js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ab170c97639c98e2a8287792fdb7f6dd"></script>
    <script>
   	  $(document).ready(function(){
   	    $('#header').load("../header/loginheader.jsp");
        $('#aside').load("../side/side5.jsp");
        $('#footer').load("../footer/footer.jsp");
   	});   
   	  
   	$(document).ready(function(){
   		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
   	    mapOption = { 
   	        center: new kakao.maps.LatLng(36.32527492596946, 127.4086423964467), // 지도의 중심좌표
   	        level: 3 // 지도의 확대 레벨
   	    };

   		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
   		
   		// 지도를 클릭한 위치에 표출할 마커입니다
   		var marker = new kakao.maps.Marker({ 
   		    // 지도 중심좌표에 마커를 생성합니다 
   		    position: map.getCenter() 
   		}); 
   		// 지도에 마커를 표시합니다
   		marker.setMap(map);
   		
   		// 지도에 클릭 이벤트를 등록합니다
   		// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
   		kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
   		    
   	    // 클릭한 위도, 경도 정보를 가져옵니다 
   	    var latlng = mouseEvent.latLng; 
   	    
   	    // 마커 위치를 클릭한 위치로 옮깁니다
   	    marker.setPosition(latlng);
   	    
   	    var xValue = latlng.getLat();
   	    var yValue = latlng.getLng();
   		
   	    $('input[name=sgroupLatitude]').attr('value',xValue);
   	    $('input[name=sgroupLongitude]').attr('value',yValue);
   	    
   		});
   	});
    </script>
    <style>
    #studyenrollment_center{
    	overflow: scroll;
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
        <section id="contents_studyenrollment">
          <%-- 스터디장 메인 --%>
          <div id="studyenrollment_center">          
            <div id="">
            <!-- 지도를 표시할 div 입니다 -->
<div id="map" style="width:100%;height:350px;"></div>
<p><em>지도를 클릭해주세요!</em></p> 
<div id="clickLatlng"></div>
	<form action="/groupStudy/Create.do" method="post">
   		<input type="hidden" name="memId" value="<%=memId %>">
		<label for="sgroupTitle">제목</label>
   		<input type="text" name="sgroupTitle">
		<label for="sgroupTo">모집인원</label>
    	<input type="number" name="sgroupTo" min="0" max="10"> <br>
		<label for="sgroupPlace">장소명</label>
   		<input type="text" name="sgroupPlace"><br>
		<label for="sgroupLatitude">위도</label>
   		<input type="text" name="sgroupLatitude" readonly="readonly" value=""><br>
		<label for="sgroupLongitude">경도</label>
   		<input type="text" name="sgroupLongitude" readonly="readonly" value=""><br>
		<label for="sgroupSdate">시작일</label>
   		<input type="date" name="sgroupSdate">&emsp;&emsp;
		<label for="sgroupEdate">종료일</label>
   		<input type="date" name="sgroupEdate"> <br>
		<label for="sgroupContent">내용</label><br>
   		<textarea cols="100" rows="30" name="sgroupContent">
스터디 주제 :
스터디 목표 : 
예상 스터디 일정(횟수) :
예상 커리큘럼 간략히 :
예상 모집인원 :
스터디 소개와 개설 이유 : 
스터디 관련 주의사항 : 
   		</textarea><br>
            </div>
          </div>
          <div class="button_studyenrollment">
            <div id="button_studyenrollment">
              <button type="submit" id="submit" >그룹생성</button>
 		</form>
              <button type="button" onclick="location.href='studygroup.jsp' ">뒤로가기</button>
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