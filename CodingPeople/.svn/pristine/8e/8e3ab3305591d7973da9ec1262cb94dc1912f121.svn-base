<%@page import="GroupStudy.VO.JoinVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	List<JoinVO> gsList = (List<JoinVO>)request.getAttribute("gsList");
%> 
    <script src="../js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ab170c97639c98e2a8287792fdb7f6dd"></script>
    <script>

   	$(document).ready(function(){
  		
   		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(36.32527492596946, 127.4086423964467), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };
	
	// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
	var map = new kakao.maps.Map(mapContainer, mapOption); 
		var positions = [
	<%
			//마커를 표시할 위치와 title 객체 배열입니다 
			for (int i = 0; i < gsList.size();  i++) {
				if(i>0) out.print(",");
	%>		
			    {
			    	content: '<div><%=gsList.get(i).getSgroupTitle()%></div>',
			    	
			        latlng: new kakao.maps.LatLng("<%=gsList.get(i).getSgroupLatitude()%>", "<%=gsList.get(i).getSgroupLongitude()%>")
			    }
	<%
		} //for end
	%>
		];
		// 마커 이미지의 이미지 주소입니다
		var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
	    
	    // 마커 이미지의 이미지 크기 입니다
	    var imageSize = new kakao.maps.Size(24, 35); 
	    
		for (var i = 0; i < positions.length; i ++) {
		    
		    // 마커 이미지를 생성합니다    
		    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
		    
		    // 마커를 생성합니다
		    var marker = new kakao.maps.Marker({
		        map: map, // 마커를 표시할 지도
		        position: positions[i].latlng, // 마커를 표시할 위치
		        image : markerImage, // 마커 이미지 
		        clickable:true
		    });
	        
	    // 인포윈도우를 생성합니다
	    var infowindow = new kakao.maps.InfoWindow({
	        content : positions[i].content
	    });
	    
	    // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
	    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
	    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
	    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
	    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow))
	}
	      
	//인포윈도우를 표시하는 클로저를 만드는 함수입니다 
	function makeOverListener(map, marker, infowindow) {
	    return function() {
	        infowindow.open(map, marker);
	    };
	}
	
	// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
	function makeOutListener(infowindow) {
	    return function() {
	        infowindow.close();
	    };
	}
});
    </script>
    <style>
#map{
	width:100%;
	height:300px;
}
#studymember_center{
	overflow: scroll;
}
</style>

		<div id="map"></div>
