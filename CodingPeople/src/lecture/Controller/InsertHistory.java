package lecture.Controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lecture.Service.ILectureService;
import lecture.Service.lectureServiceImpl;
import lecture.vo.LHistoryVO;

/**
 * 1.현재수강생 테이블에 정보 등록
 * 2.수강이력 테이블에 정보 등록
 * 3.회원 사이트머니 삭감
 * @author PC-25
 *
 */
@WebServlet("/lecture/insertHistory.do")
public class InsertHistory extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memId = req.getParameter("memId");
		String courseId = req.getParameter("courseId");
		String coursePrice = req.getParameter("coursePrice");
		String courseTitle = req.getParameter("courseTitle");
		
		LHistoryVO lhv = new LHistoryVO();
		lhv.setCourseId(courseId);
		lhv.setMemId(memId);
		lhv.setCoursePrice(coursePrice);
		lhv.setCourseTitle(courseTitle);
		
//		CurStudentVO csv = new CurStudentVO();
//		csv.setCourseId(courseId);
//		csv.setMemId(memId);
		
		ILectureService lectureService = lectureServiceImpl.getInstance();
		int c = lectureService.insertHistory(lhv);
		if(c<0) {
			String msg = "실패";
			
			String redirectUrl = req.getContextPath() + "/lecturesignup.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
			
			resp.sendRedirect(redirectUrl); // 목록조회 화면으로 리다이렉트	
		} else {
			String msg = "성공";
			
			String redirectUrl = req.getContextPath() + "/lecturesignup.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
			
			resp.sendRedirect(redirectUrl); // 목록조회 화면으로 리다이렉트
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
