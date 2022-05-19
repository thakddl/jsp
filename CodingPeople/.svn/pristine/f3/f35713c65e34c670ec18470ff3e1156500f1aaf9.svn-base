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
import lecture.vo.CourseVO;

@WebServlet("/lecture/adminInspection.do")
public class displaycourseList extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 쿼리를 실행할 service 객체 가져오기
		ILectureService lectureService = lectureServiceImpl.getInstance();
		
		// 2. 쿼리 실행
		List<CourseVO> list = lectureService.displayRequestList();
		
		// 3. jsp파일로 보낼 객체 담기
		req.setAttribute("list", list);
		
		// 4. jps파일로 전송
		RequestDispatcher dispatcher = req.getRequestDispatcher("/lecture/requestList.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
