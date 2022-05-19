/**
 * 
 */

// 리스트 출력
listServer = function(page){
	$.ajax({
		url		 : '/board/pager.do',
		type	 : 'post',
		data	 : {'page':page},
		success  : function(res){
			
	
	// 페이징 영역 그리기
	let pager ='<div >';
	
	// 이전버튼(prev) 생성
	if(res.sp > 1) {
		
		pager += '<ul class="pager">';
		pager += '  <li><a href="#" class="prev">Prev</a></li>';
		pager += '</ul>';
	
	}
	
	
	// 페이지 번호 출력
	pager += '		<ul class="pagination">';
	// for() str
	for(let i=res.sp; i<=res.ep; i++) {
		// 현재 페이지 확인
		if(currentPage == i) {
			pager += '		  <li class="active"><a href="#" class="paging">'+ i +'</a></li>';
		} else {
			pager += '		  <li><a href="#" class="paging">'+ i +'</a></li>';
		}
		
	}
	pager += '		</ul>';
	// 다음버튼(next) 생성
	
	if(res.ep < res.tp) {
		
		pager += '<ul class="pager">';
		pager += '  <li><a href="#" class="next">Next</a></li>';
		pager += '</ul>';
	
	}
	
	pager += '	 </div>';
	$('#pager').html(pager);
			
			
		},
		error    : function(xhr){
			alert(xhr.status);
		},
		dataType : 'json'
	});
	
} // listServer
$(function(){
	
	// 동적생성요소 -delegate방식으로 접근
	
	// 이전 버튼 이벤트
	$('#pager').on('click','.next',function(){
		// next 클릭했을 때 현재 페이지 기준으로 끝 값을 확인해서 처리
		let vnext = $('.paging').last().text();
		currentPage = parseInt(vnext) + 1;
		listServer(currentPage);
	});
	
	// 번호 버튼 이벤트
	$('#pager').on('click','.paging',function(){
		currentPage = $(this).text();
		listServer(currentPage)
	});
	
	// 다음 버튼 이벤트
	$('#pager').on('click','.prev',function(){
		// next 클릭했을 때 현재 페이지 기준으로 끝 값을 확인해서 처리
		let vprev = $('.paging').first().text();
		currentPage = parseInt(vprev) - 1;
		listServer(currentPage);
	});
	
}); 


