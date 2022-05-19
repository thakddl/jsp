package lecture.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
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

@WebServlet("/lecture/view.do")
public class viewLectureDetail extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 파라미터정보 가져오기
		String courseId = req.getParameter("courseId");
		
		// 2. 서비스 객체 가져오기
		ILectureService lectureService = lectureServiceImpl.getInstance();
		
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		
		// 파라미터 정보를 담을 객체 생성
		List<LectureVO> lvList = new ArrayList<LectureVO>();
		CourseVO cv = new CourseVO();
		
		
		lvList = lectureService.lectureList(courseId);
		cv = lectureService.getDetail(courseId);
		
		
		if( cv.getAtchFileId() > 0) { // 첨부파일이 존재하면...
			// 첨부파일 정보 조회
			AtchFileVO fileVO = new AtchFileVO();
			fileVO.setAtchFileId(cv.getAtchFileId());
			List<AtchFileVO> atchFileList = null;
			
			try {
				atchFileList = fileService.getAtchFileList(fileVO);
				
			} catch(Exception ex) {
				ex.printStackTrace();
			}
			
			req.setAttribute("atchFileList", atchFileList);
		}
		
		req.setAttribute("lvList", lvList);
		req.setAttribute("cv", cv);
		
		// 결과를 VIEW화면에 출력하기
		req.getRequestDispatcher("/lecturestudy.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
