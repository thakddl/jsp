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
import book.VO.BookCategoryVO;

@WebServlet("/bookCategory.do")
public class BookCategoryController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		IBookService bookService = BookServiceImpl.getInstance();
		
		List<BookCategoryVO> categoryList = bookService.displayCategory();
		
		req.setAttribute("categoryList", categoryList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/booksale.jsp");
		
		
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
}
