// 라인피드 리스트 보여주기
getAllList = function(url) {
	$.ajax({
		async: true,
		url : '/Breath/getAllPostList.LineFeed',
		type : 'post',
		data : {
			'url' : url
		},
		success : function(res) {
			getAllPost(res);
		},
		error : function(xhr) {
			alert(xhr.status);
		},
		dataType : 'json'
		
	});

}

//새 게시물 등록
insertPost = function() {
	console.log('js');
		// e.preventDefault;
		let form = $('#insert')[0];
		let formData = new FormData(form);
		$.ajax({
			url : '/Breath/insert.LineFeed',
			type : 'post',
			data : formData,
			success : function(res) {
				alert("게시물 등록을 완료하였습니다.");
				getAllPost(res);
			},
			error : function(xhr) {
				alert(xhr.status);
			},
			dataType : 'json',
			async: true,
			cache : false,
			contentType : false,
			processData : false
		});
		$('.file_input').css('visibility', 'visible');
		$('.lFzco').val("");
		$('.file_input_img_btn').css('visibility', 'hidden');
		$('.file_input_img_btn').attr('src', '');
		$('.file_input_hidden').val("");
}
// 게시물 수정 메서드
updatePost = function() {
	$('#update').on('click', function() {
		// e.preventDefault;
		let form = $('#updated')[0];
		let formData = new FormData(form);
		$.ajax({
			url : '/Breath/update.LineFeed',
			type : 'post',
			data : formData,
			success : function(res) {
				alert("게시물 수정을 완료하였습니다.");
				getAllPost(res);
			},
			error : function(xhr) {
				alert(xhr.status);
			},
			dataType : 'json',
			async: true,
			cache : false,
			contentType : false,
			processData : false
		});
		$('.file_input').css('visibility', 'visible');
		$('.lFzco').val("");
		$('.file_input_img_btn').css('visibility', 'hidden');
		$('.file_input_img_btn').attr('src', '');
		$('.file_input_hidden').val("");
	});
}

// 게시물 삭제 메서드
deletePost = function(lnfdNum) {
		$.ajax({
			url : '/Breath/delete.LineFeed',
			type : 'post',
			data : {
				'lnfdNum' : lnfdNum
			},
			success : function(res) {
				alert('성공적으로 삭제되었습니다.');
				getAllPost(res);
			},
			error : function(xhr) {
				alert(xhr.status)
			},
			dataType : 'json'
		});
}


// 화면을 띄워주는 메서드
function getAllPost(res) {
	let code = "";
	let idx = 0;
	$.each(res.data, function(i) {
		if (this.status != 4) {
		code += `<form id="submit-comment" name="submit-comment" method="post" idx="${this.lnfdNum}">`;
		code += `<article class="lnfdNum" value="${this.lnfdNum}">`;
		code += `<header>`;
		code += `<div class="profile-of-article">`;
		code += `<img class="img-profile pic" src="./images/사진1.jfif" alt="${this.postDt}님의 프로필 사진">`;
		code += `<span class="userID main-id point-span">Cloe Ting</span>`;
		code += `</div>`;
		code += `<img class="icon-react icon-more" src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/bearu/more.png" alt="more">`;
		code += `</header>`;
		code += `<div class="main-image">`;
		code += `<img src="/Breath/showImage.LineFeed?url=${this.filePath}" alt="$Cloe Ting님의 피드 사진" class="mainPic">`;
		code += `</div>`;
		code += `<div class="icons-react">`;
		code += `<div class="icons-left">`;
		code += `<img class="icon-react" src="./images/heart.png" alt="좋아요">`;
		code += `<img class="viewComment icon-react" src="./images/chat.png" alt="답글달기">`;
		code += `<img class="icon-react" src="./images/direct-instagram.png" alt="DM">`;
		code += `</div>`;
		code += `<img class="icon-react" src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/bearu/bookmark.png" alt="북마크">`;
		code += `</div>`;
		code += `<div class="reaction">`;
		code += `<div class="liked-people">`;
		code += `<img class="pic" src="./images/iu2.jpg" alt="johnnyjsuh님의 프로필 사진">`;
		code += `<p><span class="point-span">johnnyjsuh</span>님 <span class="point-span">외 2,412,751명</span>이 좋아합니다</p>`;
		code += `</div>`;
		code += `<div class="description">`;
		code += `<p><span class="point-span userID">${this.content}</span></p>`;
		code += `</div>`;
		code += `</div>`;
		// 댓글구간
		code += `<div class="comment">`;
		code += `<div class="comment-section" id="comment-section${i}">`;
		code += `</div>`;
		code += `<input id="input-comment" class="input-comment" type="text" placeholder="댓글 달기..." >`;
		code += `<input type="hidden" id="commentValue" val="">`;
		code += `<button type="button" class="submit-comment">게시</button>`;
		code += `</div>`;
		code += `</article>`;
		getAllReply(this.lnfdNum, "comment-section"+i);
		}
	});
	$('.feeds').html(code);
}
// 댓글을 삭제하는 메서드
function deleteReply(url, commNum, lnfdNum) {
	let data = {
			'url' : url,
			'commNum' : commNum,
			'lnfdNum' : lnfdNum
	}
	$.ajax({
		url : '/Breath/delete.Reply',
		type : 'post',
		data : data,
		async : true,
		success : function(res) {
			getAllList(url);
			alert("댓글 삭제를 완료하였습니다.");
		},
		dataType : 'json'
	});
	console.log('내부 함수 작동');
}

// 댓글을 띄워주는 메서드
function getAllReply(lnfdNum, id) {
	let data = {
			'lnfdNum' : lnfdNum
	}
	$.ajax({
		 url : '/Breath/getAllReplyList.Reply',
		 type : 'post',
		 data : data,
		 success : function(res) {
			 
			 let code = "";
			 $.each(res.data, function(i) {
				 if (this.status != 4) {
				 code += `<div class="comment-box">`; 
				 code += `<ul class="comments" value="${this.commNum}">`;
				 code += `<li>`;
				 code += `<span class="comment-value"><span class="point-span userId">${this.nickName}</span>&nbsp&nbsp&nbsp${this.content}</span>`;
				 code += `<img class="comment-heart" src="./images/x.png" alt="x" value="${lnfdNum}">`
				 code += `</li>`;
				 code += `</ul>`;
				 code += `<div class="time-log">`;
				 code += `<span>${this.timeLog}</span>`;
				 code += `</div>`;
				 code += `</div>`;
				 }
				});
				$(`#${id}`).html(code);
		 },
		 error : function(xhr) {
		 alert(xhr.status);
		 },
		 dataType : 'json'
	});
}
// 신고하기 기능
function insertReport() {
	let form = $('#reportForm');
	let rprtDId = $('#rprtDId').val();
	let rprtRsn = $('#rprtRsn').val();
	$.ajax({
		url : '/Breath/insert.Report',
		type : 'post',
		data : {
			'rprtDId' : rprtDId,
			'rprtRsn' : rprtRsn
		},
		success : function(res) {
			alert('접수가 완료되었습니다.');
			getAllPost(res);
		},
		error : function(xhr) {
			alert(xhr.status);
		},
		dataType : 'json'
	}); 
}


// 댓글달기 버튼 활성화 및
insertReply = function(lnfdNum, idx) {
	let content = $('.input-comment').eq(idx).val();
	let url = window.location.href;
	let data = {
			'url' : url,
			'content' : content,
			'lnfdNum' : lnfdNum
	}
	$.ajax({
		 url : '/Breath/insert.Reply',
		 type : 'post',
		 data : data,
		 async: true,
		 success : function(res) {
			 getAllList(url);
			 alert('댓글 등록이 완료되었습니다.');
			 
		 },
		 error : function(xhr) {
		 alert(xhr.status);
		 },
		 dataType : 'json'
	});
}

