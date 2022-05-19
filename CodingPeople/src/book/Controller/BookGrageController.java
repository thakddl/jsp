package book.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.Service.BookServiceImpl;
import book.Service.IBookService;
import book.VO.BookVO;

@WebServlet("/bookgrade.do")
public class BookGrageController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String bookinfoId = req.getParameter("bookInfoId");
		
		IBookService service = BookServiceImpl.getInstance();
		
		List<BookVO> list = service.getBookGrade(bookinfoId);
		
		req.setAttribute("list", list);
		RequestDispatcher disp = req.getRequestDispatcher("/book/bookGrade.jsp");
		
		disp.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String bookGradeId = req.getParameter("bookGradeId");
		String bookInfoId = req.getParameter("bookInfoId");
		
		IBookService service = BookServiceImpl.getInstance();
		
		BookVO bv = new BookVO();
		bv.setBookGradeId(bookGradeId);
		bv.setBookinfoId(bookInfoId);
		
		BookVO bv2 = service.getSaleStock(bv);
		
		req.setAttribute("bv", bv2);
		RequestDispatcher disp = req.getRequestDispatcher("/book/bookStock.jsp");
		
		disp.forward(req, resp);
		
		
	}
	
	
}
