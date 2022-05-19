<%@page import="coin.vo.MemberVO"%>
<%@page import="coin.service.IcoinService"%>
<%@page import="coin.service.CoinServiceImpl"%>
<%@page import="coin.dao.CoinDaoImpl"%>
<%@page import="Util.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 인증된 세션이 없는경우, 해당페이지를 볼 수 없게 함.
	String memId;
	String uid = "ChargingCoin-";
	MemberVO memVO = null;
	
    if (session.getAttribute("memId") == null) {
        response.sendRedirect("login.jsp");
    }else {
    	
 	// 세션아이디로 회원정보를 불러옴.
 	memId = (String) session.getAttribute("memId");
 	IcoinService service = CoinServiceImpl.getInstance();
 	memVO = service.getMember(memId);
 	String seq = service.getChistroySeq();
 	
 	uid = uid + seq;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- jQuery -->
<!-- <script src="../js/jquery-3.6.0.min.js"></script> -->
  <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
  
<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>

<link rel="stylesheet" href="../css/bootstrap.min.css">
<script src="../js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<style>
body {
	margin: 30px;
}
</style>
<body>
	<h1><span class="badge bg-secondary"><h4> ■ ■ 코딩코인 충전 ■ ■ </h4></span></h1>
<table>

<tr>
<br><input type="radio" name=coin class="radio-value" value="1000"> 1000원 (코인)<br>
<br><input type="radio" name=coin class="radio-value" value="5000"> 5000원 (코인)<br>
<br><input type="radio" name=coin class="radio-value" value="10000"> 10000원 (코인)<br>
<br><input type="radio" name=coin class="radio-value" value="20000"> 20000원 (코인)<br>
<br><input type="radio" name=coin class="radio-value" value="50000"> 50000원 (코인)<br>
<br><input type="radio" name=coin class="radio-value" value="" checked>직접 입력
<input type="text" name=coin class="radio-value-detail" placeholder="직접입력" value="1000" /> 원 (코인)<br>
</tr>
</td>
</table>

<br>
<button type="button" class="btn btn-primary" onclick="requestPay()">충전하기</button>
<input type="hidden" class=memId value="<%=memVO.getMemMail()%>">
  <script>

	var IMP = window.IMP; // 생략 가능
	
	IMP.init("imp51583940"); // 예: imp00000000 //아임포트 관리자페이지-시스템설정- 가명점식별코드
	
	//충전금액 선택
	$('.radio-value').on('click', function() {

	    let valueCheck = $('.radio-value:checked').val(); // 체크된 Radio 버튼의 값을 가져옵니다.
	    if ( valueCheck == '' ) {
	        $('.radio-value-detail').attr('disabled', false); // 금액 종류를 입력하는 input 을 활성화합니다.
	        $('.radio-value-detail').focus(); // 금액 종류를 입력하는 input 에 커서를 이동시킵니다.
	    } else {
	        $('.radio-value-detail').val(''); // 입력된 금액 종류 값이 있으면, 초기화합니다.
	        $('.radio-value-detail').attr('disabled', true); // 금액 종류를 입력하는 input 을 비활성화합니다.
	    }
	});
	
	//충전하기 버튼 클릭
	function requestPay() {
	 	let valueCheck = $('.radio-value:checked').val();
     	let coin; 
			if ( valueCheck == '' ) {
			 coin = $('.radio-value-detail').val();
		    } else {
			 coin = $('input[name="coin"]:checked').val();
				 
		    } // if ''
		    if(coin < 1000) {
				 alert("최소 1000원 이상 입력해야합니다.")
			} else {
			      // IMP.request_pay(param, callback) 결제창 호출
			      IMP.request_pay({ // param
			          pg: "charging coin",
			          pay_method: "card",
			          merchant_uid: "<%=uid%>",
			          name: "코딩코인",
			          amount: coin,
			          buyer_email: "<%=memVO.getMemMail()%>",
			          buyer_name: "<%=memVO.getMemName()%>",
			          buyer_tel: "<%=memVO.getMemTel()%>",
			          buyer_addr: "<%=memVO.getMemAdd1() + memVO.getMemAdd2()%>",
			          buyer_postcode: "<%=memVO.getMemZip()%>"
			      }, function (rsp) { // callback
			          if (rsp.success) {// 결제 성공 시: 결제 승인 또는 가상계좌 발급에 성공한 경우
			        	  alert("결제가 완료되었습니다.");
			        	  console.log(coin);
			        	  $.ajax({
			  				type : 'post'
			  				,url : '/CoinChargeServlet.do'		//요청
			  				,dataType : 'json'			//응답(필수)
			  				,data : {'coin' : coin,
			  					"memId": "<%=memVO.getMemId()%>",
			  					"seq" : "<%=seq%>"
			  					}
			  				,success : function(data){
			  					if(data.cnt == '1') {
			  					alert("충전이 완료되었습니다.");
// 			  					location.href='/mainhome.jsp';
								window.close();
			  					}
			  				}	//응답(필수)
			  				,error : function(xhr){
// 			  					alert("상태 >> " + xhr.status);
								window.close();
			  				}						//응답(필수)
			  			});
			       } else {
			        	  alert("결제에 실패하였습니다. 에러 내용: " +  rsp.error_msg);
			          }
			      });
				 
			 } //if 1000
      

    }
	<%
	}
	%>
  </script>
</body>
</html>