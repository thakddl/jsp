package lecture.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lecture.Service.ILectureService;
import lecture.Service.lectureServiceImpl;

@WebServlet("/lecture/delete.do")
public class DeleteRequestLecture extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String courseId = req.getParameter("courseId");
		
		// 1. 쿼리를 실행할 service 객체 가져오기
		ILectureService lectureService = lectureServiceImpl.getInstance();
		
		// 2. 쿼리 실행
		int c = lectureService.deleteLecture(courseId);
		
		// 3. jsp파일로 보낼 객체 담기
		req.setAttribute("c", c);
		
		// 4. jps파일로 전송
		RequestDispatcher dispatcher = req.getRequestDispatcher("/lecture/deleteResult.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
}
