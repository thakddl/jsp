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

@WebServlet("/lecture/insertReq.do")
@MultipartConfig(fileSizeThreshold = 1024*1024*3, maxFileSize = 1024*1024*40, maxRequestSize = 1024*1024*50)
public class InsertRequestLecture extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1-1. 요청 파라미터 정보 가져오기
		String categoryId = req.getParameter("categoryId");
		String courseTitle = req.getParameter("courseTitle");
		String courseIntroduction = req.getParameter("courseIntroduction");
		String courseComposition = req.getParameter("courseComposition");
		String bookinfoId = req.getParameter("bookinfoId");
		String coursePrice = req.getParameter("coursePrice");
		String memId = req.getParameter("memId");
		
		// 1-2. 가져온 파라미터 정보 VO에 담기
		CourseVO cv = new CourseVO();
		cv.setCategoryId(categoryId);
		cv.setCourseTitle(courseTitle);
		cv.setCourseIntroduction(courseIntroduction);
		cv.setCourseComposition(courseComposition);
		cv.setBookinfoId(bookinfoId);
		cv.setCoursePrice(coursePrice);
		cv.setMemId(memId);
		
		// 2. 서비스 객체 생성하기
		ILectureService lectureService = lectureServiceImpl.getInstance();
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		AtchFileVO atchFileVO = new AtchFileVO();
		
		try {
			atchFileVO = fileService.saveAtchFileList(req);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cv.setAtchFileId(atchFileVO.getAtchFileId());
		
		int cnt = lectureService.insertRequest(cv);
		
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		
		String redirectUrl = req.getContextPath() + "/lecturesignup.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
		
		resp.sendRedirect(redirectUrl); // 목록조회 화면으로 리다이렉트
	}
}
