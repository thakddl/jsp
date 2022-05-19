package lecture.Controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import atch.Service.AtchFileServiceImpl;
import atch.Service.IAtchFileService;
import atch.VO.AtchFileVO;
import lecture.Service.ILectureService;
import lecture.Service.lectureServiceImpl;
import lecture.vo.CourseVO;
import lecture.vo.LectureVO;

@WebServlet("/lecture/update2.do")
@MultipartConfig(fileSizeThreshold = 1024*1024*3, maxFileSize = 1024*1024*40, maxRequestSize = 1024*1024*50)
public class updateRequestLecture extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] lectureNoArr = req.getParameterValues("lectureNo");
		String[] courseIdArr = req.getParameterValues("courseId");
		String[] lectureTitleArr = req.getParameterValues("lectureTitle");
		
		ILectureService lectureService = lectureServiceImpl.getInstance();
		LectureVO lv = new LectureVO();
		int cnt = 0;
		
		for (int i = 0; i < lectureTitleArr.length; i++) {
			String lectureNo = lectureNoArr[i];
			String courseId = courseIdArr[i];
			String lectureTitle = lectureTitleArr[i];
			LectureVO lv2 = new LectureVO();
			lv2.setLectureNo(lectureNo);
			lv2.setCourseId(courseId);
			lv2.setLectureTitle(lectureTitle);
			
			cnt = lectureService.insertLecture(lv2);
		}
		
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		
		String redirectUrl = req.getContextPath() + "/lecture/adminInspection.do?msg=" + URLEncoder.encode(msg,"UTF-8");
		
		resp.sendRedirect(redirectUrl); // 목록조회 화면으로 리다이렉트
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
