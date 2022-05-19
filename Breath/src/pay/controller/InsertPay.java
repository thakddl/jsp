package pay.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.vo.MemberVO;
import membership.service.IMembershipService;
import membership.service.MembershipServiceImpl;
import membership.vo.MembershipVO;
import pay.sevice.IPayService;
import pay.sevice.PayServiceImpl;
import pay.vo.PayVO;

@WebServlet("/insertPay.do")
public class InsertPay extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/Breath/pay/pay.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 세션에서 필요한 정보 가져오기
		
		
		HttpSession session = req.getSession();
		MemberVO vo = (MemberVO) session.getAttribute("memVO");
		String memId = vo.getMemId();
		
		String payMethod = req.getParameter("payMethod");
		System.out.println(memId);
		// 파라미터로 받은 정보 변수에 담기
//		String trainerId = "a100";
//		int amount = "100"
		
		
//		String trainerId = req.getParameter("trainerId");
//		int amount = Integer.parseInt(req.getParameter("amount"));
		int amount = 100;
		String trainerId = "a100";
		int payMethNum = 1;
		System.out.println(trainerId);
		System.out.println(amount);
		System.out.println(payMethNum);
		
		// DB에 inset 할 객체 생성해서 정보 담기
		PayVO pv = new PayVO();
		pv.setMemId(memId);
		pv.setClientId(memId);
		pv.setTrainerId(trainerId);
		pv.setPayAmount(amount);
		pv.setPayMethNum(payMethNum);
		
		IPayService payService = PayServiceImpl.getInstance();
		IMembershipService shipService = MembershipServiceImpl.getInstance();
		
		// 결제 등록
		if (payService.inserPay(pv) < 1) {
			System.out.println("결제 등록 실패!");
		} else {
			// 결제 정보 DB 등록 성공 후 멤버쉽 DB 등록.
			MembershipVO mv = new MembershipVO();
			mv.setClientId(memId);
			mv.setTrainerId(trainerId);
			
			// 멤버쉽내역 DB 등록 및 회원 권한 변경
			shipService.inserMembership(mv);
			shipService.updateAthrt(memId);
			
			System.out.println("결제 등록 성공 !");
		}
				
		req.getRequestDispatcher("/views/pay/pay.jsp").forward(req, resp);
	}
}
