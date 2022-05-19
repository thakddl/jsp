<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	MemberVO vo = (MemberVO) session.getAttribute("memVO");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>멤버십</title>
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<script src="../../js/jquery-3.6.0.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
<style>
body {
	padding-left: 25px;
}
h2 {
	text-align: center;
}
.intro {
	font-size: 24px;
}
.content {
	font-size: 14px;
	family-name: fantasy;
	color: #91A8d0;
}
.price {
	font-size: 24px;
}
</style>
</head>
<body>

	<h2>멤버십 가입</h2>
	<hr>
	<br>
	
	<div class="intro">멤버십 가입을 통해 트레이너의 더 많은 혜택을 받아보세요</div>
	<br>
	
	<div>
		<span class="price">₩9,900/월</span>
		<div>
			<button id="payment" type="button" class="btn btn-success">가입</button>
			<button id="cansel" type="button" class="btn btn-warning" onclick=window.close()>취소</button>
		</div>
	</div>
	
	<br>
	
	<div class="content">멤버십은 월단위 자동결제 되며 언제든지 취소할 수 있습니다.</div>
	<br>
	<div class="content">멤버십 혜택은 크리에이터에 따라 다를 수 있으며 트레이너가 언제든 혜택을 업데이트 할 수 있습니다.</div>
	
	


	<script type="text/javascript">
	
	$("#payment").click(function() {
		window.resizeTo(950,750);
		var IMP = window.IMP; // 생략가능
		IMP.init('imp97388463');
		
		let memId = '<%=vo.getMemId() %>';
		let memNm = '<%=vo.getMemNm() %>';
		let email = '<%=vo.getEmail() %>';
		let hp = '<%=vo.getHp() %>';
		let price = '9900';
		let name = 'a100' + ' 멤버십';
		let trainerId = 'a100';
		
		
		IMP.request_pay({
			pg : 'html5_inicis',
			pay_method : 'card',
			merchant_uid : 'merchant_' + new Date().getTime(),
			name : '<%=vo.getMemId() %>',
			amount : price,
			buyer_email : '<%=vo.getEmail() %>',
			buyer_name : '<%=vo.getMemId() %>',
			buyer_tel : '<%=vo.getHp() %>',
			buyer_addr : '<%=vo.getMemAdd() %>',
			buyer_postcode : '<%=vo.getZip() %>'
		}, function(rsp) {
			if (rsp.success) {
				var msg = '결제가 완료되었습니다.';
// 				msg += '고유ID : ' + rsp.imp_uid;
// 				msg += '상점 거래ID : ' + rsp.merchant_uid;
// 				msg += '결제 금액 : ' + rsp.paid_amount;
// 				msg += '카드 승인번호 : ' + rsp.apply_num;

				$.ajax({
					url: "/Breath/insertPay.do",
					method: "post",
        			headers: { "Content-Type": "application/json" },
        			data: {
            			imp_uid: rsp.imp_uid,
            			merchant_uid: rsp.merchant_uid,
            			trainerId: trainerId,
            			amount: price,
            			payMethod: 'card'
        			},
        			success	: function(res) {
//         				alert(msg);
        				window.close();
//         				location.href = "orderComplete.do";
        			},
        			error	: function(xhr){
        				alert(xhr.status);
        			}
        			
				});

			} else {
		    	//결제 시작 페이지로 리디렉션되기 전에 오류가 난 경우
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
			}
			alert(msg);
		});
	});
	</script>
</body>
</html>
