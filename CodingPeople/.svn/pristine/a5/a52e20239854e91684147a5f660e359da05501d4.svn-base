package lecture.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture.Service.ILectureService;
import lecture.Service.lectureServiceImpl;
import lecture.vo.CourseVO;

@WebServlet("/lecture/getBuyCourseList.do")
public class GetMyBuyCourseList extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1-1. 쿼리에서 사용할 유저 아이디 세션에서 가져오기
		HttpSession session = req.getSession();
		
		String memId = (String)session.getAttribute("memId");		
		
		//1-2. 서비스 객체 얻기
		ILectureService lectureService = lectureServiceImpl.getInstance();
		
		//2. 쿼리 실행하여 list 담기
		List<CourseVO> list = lectureService.getBuyCourseList(memId);
		
		//3. 리퀘스트 객체에 list 담기
		req.setAttribute("list", list);
		
		// 4. 디스패쳐에 리퀘스트 객체 담기
		RequestDispatcher dispatcher = req.getRequestDispatcher("/lecture/lecturebuymenu.jsp");
		
		// 5. 디스패처 포워딩
		dispatcher.forward(req, resp);
		
	}
}
