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
import book.VO.BookInfoVO;

@WebServlet("/bookInfo.do")
public class BookInfoContontroller extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String categoryId = req.getParameter("categoryId");
		
		IBookService service = BookServiceImpl.getInstance();
		
		List<BookInfoVO> list = service.getBookInfoNm(categoryId);
		
		
		req.setAttribute("list", list);
		RequestDispatcher disp = req.getRequestDispatcher("/book/bookInfoNm.jsp");
		
		disp.forward(req, resp);
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
}
