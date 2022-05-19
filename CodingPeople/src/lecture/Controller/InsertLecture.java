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

@WebServlet("/lecture/insertLecture.do")
@MultipartConfig(fileSizeThreshold = 1024*1024*3, maxFileSize = 1024*1024*40, maxRequestSize = 1024*1024*50)
public class InsertLecture extends HttpServlet{
	
	// get방식일 경우 입력 양식 호출
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1-1 요청 파라미터 정보 가져오기
		String courseId = req.getParameter("courseId");
		
		ILectureService lectureService = lectureServiceImpl.getInstance();
		
		CourseVO cv = new CourseVO();
		
		cv = lectureService.getDetail(courseId);
		
		req.setAttribute("cv", cv);
		
		// 결과를 VIEW화면에 출력하기
		req.getRequestDispatcher("/lecture/lectureInsertForm.jsp").forward(req, resp);
	}
	
	// post방식일 경우 실제 등록
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1-1. 요청 파라미터 정보 가져오기
		String courseId = req.getParameter("courseId");
		String bookinfoId = req.getParameter("bookinfoId");
		String categoryId = req.getParameter("categoryId");
		String lectureApprovalId = req.getParameter("lectureApprovalId");
		String memId = req.getParameter("memId");
		String courseTitle = req.getParameter("courseTitle");
		String courseComposition = req.getParameter("courseComposition");
		String courseIntroduction = req.getParameter("courseIntroduction");
		String coursePrice = req.getParameter("coursePrice");
		String courseSales = req.getParameter("courseSales");
		String atchFileId = req.getParameter("atchFileId");
		
		// 1-2. 가져온 파라미터 정보 VO에 담기
		CourseVO cv = new CourseVO();
		cv.setCourseId(courseId);
		cv.setBookinfoId(bookinfoId);
		cv.setCategoryId(categoryId);
		cv.setLectureApprovalId(lectureApprovalId);
		cv.setMemId(memId);
		cv.setCourseTitle(courseTitle);
		cv.setCourseComposition(courseComposition);
		cv.setCourseIntroduction(courseIntroduction);
		cv.setCoursePrice(coursePrice);
		cv.setCourseSales(courseSales);
		
		
		
		// 2. 서비스 객체 생성하기
		ILectureService lectureService = lectureServiceImpl.getInstance();
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		AtchFileVO atchFileVO = null;
		
		try {
			// 첨부파일 목록저장(공통기능)
			atchFileVO = fileService.saveAtchFileList(req);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(atchFileVO==null) {
			cv.setAtchFileId(Long.parseLong(atchFileId));
		} else {
			cv.setAtchFileId(atchFileVO.getAtchFileId());
		}
		
		int cnt = lectureService.updateRequest(cv);
		
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		
		String redirectUrl = req.getContextPath() + "/lecture/adminInspection.do?msg=" + URLEncoder.encode(msg,"UTF-8");
		
		resp.sendRedirect(redirectUrl); // 목록조회 화면으로 리다이렉트
	}
}
