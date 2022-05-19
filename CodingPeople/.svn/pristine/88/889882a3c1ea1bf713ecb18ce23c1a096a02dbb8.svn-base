package coin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coin.service.CoinServiceImpl;
import coin.service.IcoinService;
import coin.vo.CoinHistoryVO;
import coin.vo.MemberVO;

/**
 * Servlet implementation class CoinChargeServlet
 */
@WebServlet("/CoinChargeServlet.do")
public class CoinChargeServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("coin=" + request.getParameter("coin"));
//		System.out.println("memId=" + request.getParameter("memId"));
//		System.out.println("seq=" + request.getParameter("seq"));
		
		//requestPay.jsp에서 ajax로 보낸값 읽음.
		String coin = request.getParameter("coin");
		String memId = request.getParameter("memId");
		String seq = request.getParameter("seq");
		
		
		IcoinService service = CoinServiceImpl.getInstance();
		
		MemberVO memVO = service.getMember(memId); //충전한 사람
		memVO.setMemCoin(coin); //추가할 코인값
		//코인충전 실행
		int cnt = service.updateCoin(memVO);
		
		if(cnt == 1) {
			//충전기록VO 생성
			CoinHistoryVO cHistoryVO = new CoinHistoryVO();
			
			//충전기록값 설정
			cHistoryVO.setcHistoryNo(seq);
			memVO = service.getMember(memId);
			cHistoryVO.setcHistoryBalance(memVO.getMemCoin());
			cHistoryVO.setcHistoryCoin("+" + coin);
			cHistoryVO.setMemId(memId);
			cHistoryVO.setcEventId("충전");
			
			//충전기록  실행
			int cnth = service.insertCoinHistory(cHistoryVO);
			System.out.println(cnth);
		}
		
		request.setAttribute("cnt", String.valueOf(cnt));
		
		//ajax가 요청한 곳으로 되돌아가기 전에 jason으로 가공하기 위한 페이지로 보냄
		request.getRequestDispatcher("cnt.jsp").forward(request, response);		
	}

}
