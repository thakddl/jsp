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
import book.VO.BookListSearchVO;

@WebServlet("/admin/selectBookList.do")
public class AdminSelectBookListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 서비스 객체 생성
		IBookService service = BookServiceImpl.getInstance();
		
		// 회원정보 조회
		List<BookListSearchVO> bookList = service.getAdminBookList();
		
		// req객체에 저장
		req.setAttribute("bookList", bookList);
		
		// jsp(화면)에게 forword
		RequestDispatcher dispatcher = req.getRequestDispatcher("/book/adminBookList.jsp");
		dispatcher.forward(req, resp);
	}
}
