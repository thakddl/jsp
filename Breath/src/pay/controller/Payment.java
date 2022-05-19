package pay.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pay.sevice.IPayService;
import pay.sevice.PayServiceImpl;
import pay.vo.BuyerVO;

@WebServlet("/payment.do")
public class Payment extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BuyerVO vo = new BuyerVO();

		IPayService service = PayServiceImpl.getInstance();
		
		
		req.setAttribute("vo", vo);
		
		req.getRequestDispatcher("payform.jsp").forward(req, resp);
		
	}
//		String buyName = (String)req.getParameter("buyName");
//		int totalPrice = Integer.parseInt(req.getParameter("totalPrice"));
//		String memEmail = (String)req.getParameter("memEmail");
//		String memName = (String)req.getParameter("memName");
//		String memTel = (String)req.getParameter("memTel");
//		
//		req.setAttribute("buyName", buyName);
//		req.setAttribute("totalPrice", totalPrice);
//		req.setAttribute("memEmail", memEmail);
//		req.setAttribute("memName", memName);
//		req.setAttribute("memTel", memTel);
//		req.setAttribute("memAddr", memAddr);
//		req.setAttribute("memZip", memZip);
//		
//		req.getRequestDispatcher("pay.jsp").forward(req, resp);
		
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	

	
}
