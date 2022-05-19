let idChkValue=false; // 아이디 체크(중복검사 체크) 여부

//중복체크 버튼 클릭 시 실행 기능
function idchkBtn() {
	let idVal = $('#memid').val().trim();
	if (idVal.length < 5) {
		alert("5자리 이상 입력하세요");
		return false;
	} 
	$.ajax({
		url : "/member/idCheck.do", // 이동 할 주소줄. 주로 데이터를 조회해서 결과가 필요할 때 사용
		type : 'post', // 통신방식 설정
		data : {
			"memId" : idVal
		},
		dataType : 'text', // 리턴으로 받는 데이터 타입
		success : function(aa) {
			if (aa == "1") {		
				alert("이미 사용중인 아이디입니다.");
			}
			else {
				alert("사용가능한 아이디입니다 : ");
				idChkValue = true;
			}
		},
		error : function(xhr) {
			alert(xhr.status);
		}
	});
}; // idchkBtn() end


// 입력항목 유효성 검사
function chkAll(){
	event.preventDefault(); // submit 이벤트를 막아 페이지 리로드를 방지
	// 아이디 중복검사 체크, 아이디 중복검사 하지 않은 경우 경고
	let idValue = $('#memid').val().trim();
	let pw = $('#mempw').val().trim();
	let pw2 = $('#mempw2').val().trim();
	let name = $('#memnm').val().trim();
	let tel = $('#memtel').val().trim();
	//let zip = $('#memadd1').val().trim();
	
	if(idChkValue==false){
		alert("아이디 중복체크를 해주세요.");
		return false;
	} else if(!chkId(idValue)){
		return false;
	} else if(!chkPw(idValue, pw, pw2)){
		return false;
	} else if(!chkNm(name)){
		return false;
	} else if(!chkTel(tel)){
		return false;
	} 
/*	else if(!chkZip(zip)){
		return false;
	}*/

	let formData = $('form').serialize();  // form 영역 데이터 직렬화
	
	$.ajax({
		url : "/member/joinMember.do", // 이동 할 주소줄. 주로 데이터를 조회해서 결과가 필요할 때 사용
		type : 'post', // 통신방식 설정
		data : formData,
		dataType : 'json', // 전송할 데이터 타입
		success : function(aa) {
			if (aa.id == "ok") {
				alert("회원가입이 완료되었습니다." );
				location.href = "mainhome.jsp";
			}else {
				alert("회원가입에 실패했습니다." );
			}
		},
		error : function(xhr) {
			/*alert("회원가입 실패. \n관리자에게 문의하세요");*/
			alert(xhr.status);
		}
	});
}; // chkAll() end


$('#sendBtn').on('click',chkAll);

// 아이디 유효성검사 - chkId()
function chkId(id){
	let regId = /^.*(?=.{5,8})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
	if(!regId.test(id)){ // 영문+숫자 5~8자리로 설정
		alert("아이디는 영문+숫자 5~8자리로 입력해야 합니다.");
		form.id.value="";
		form.id.focus();
		return false;
	};
	return true;
}

// 비밀번호 유효성검사 - chkPw
function chkPw(id,pw,pw2){
	let regPass = /^[a-z0-9]{5,12}$/; // 영문+숫자 5~12자리 설정
	if(!regPass.test(pw)){ // 최초입력 비밀번호 유효성 검사
		alert("비밀번호는 영문+숫자 5~12자리로 입력해야 합니다.");
		form.pw.value="";
		form.pw.focus();
		return false;
	}
	// 비밀번호1, 비밀번호2 일치여부 확인
	if(pw!=pw2){
		alert("입력한 비밀번호가 서로 일치하지 않습니다.");
		form.pw.value = "";
        form.pw2.value = "";
        form.pw2.focus();
        return false;
	}
	// 아이디=비밀번호 인 경우 방지
	if(id==pw){
		alert("아이디와 비밀번호는 같을 수 없습니다");
		form.pw.value = "";
        form.pw2.value = "";
        form.pw.focus();
        return false;
	}
	return true; // 확인이 완료되면 true를 리턴
};


// 이름 유효성검사 - chkNm
function chkNm(name){
	let regName = /^[가-힣]{2,4}$/; // 한글 2~4글자
	if(!regName.test(name)){
		alert("이름이 올바르지 않습니다.");
		return false;
	};
	return true;
};


// 전화번호 유효성검사 - chkTel
function chkTel(tel){
	let regTel = /^[0-9]{4,12}$/;
    if(!regTel.test(tel)){
    	alert("전화번호는 숫자로만 입력해주세요");
    	form.tel.focus();
    	return false;
    }
    return true;
};


// 주소 유효성 검사 - chkZip
function chkZip(zip){
	if(zip.length<1){
		alert("우편번호를 검색하여 입력하세요");
	return false;
	};
	return true;
};

