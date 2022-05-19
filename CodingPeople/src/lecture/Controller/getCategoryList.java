package lecture.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lecture.Service.ILectureService;
import lecture.Service.lectureServiceImpl;
import lecture.vo.categoryVO;

@WebServlet("/lecture/list.do")
public class getCategoryList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 서비스 객체 얻기
		ILectureService lectureService = lectureServiceImpl.getInstance();
		
		//2. 쿼리 실행하여 list 담기
		List<categoryVO> list = lectureService.getCategoryName();
		
		//3. 리퀘스트 객체에 list 담기
		req.setAttribute("list", list);
		
		// 4. 디스패쳐에 리퀘스트 객체 담기
		RequestDispatcher dispatcher = req.getRequestDispatcher("/lecture/categoryList.jsp");
		
		// 5. 디스패처 포워딩
		dispatcher.forward(req, resp);
	}
}
