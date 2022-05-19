package book.Controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.Service.BookServiceImpl;
import book.Service.IBookService;
import book.VO.BsellHistoryVO;

@WebServlet("/booksale.do")
public class BookSaleController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String bookInfoId = req.getParameter("bookInfoId");
		String memId = req.getParameter("memId");
		
		System.out.println(memId);
		System.out.println(bookInfoId);
		IBookService service = BookServiceImpl.getInstance();
		
		BsellHistoryVO bsv = new BsellHistoryVO();
		bsv.setBookinfoId(bookInfoId);
		bsv.setMemId(memId);
		
		int cnt = service.insertHistory(bsv);
		
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		
		String redirectUrl = req.getContextPath() + "/book/bookSaleEnd.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
		
		resp.sendRedirect(redirectUrl); // 목록조회 화면으로 리다이렉트
		
		
		
		
		
	}
	
	
}
