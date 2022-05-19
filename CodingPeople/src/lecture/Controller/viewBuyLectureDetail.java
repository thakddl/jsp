package lecture.Controller;

import java.io.IOException;
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

@WebServlet("/lecture/detail2.do")
public class viewBuyLectureDetail extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 파라미터정보 가져오기
		String courseId = req.getParameter("courseId");
		
		// 2. 서비스 객체 가져오기
		ILectureService lectureService = lectureServiceImpl.getInstance();
		
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		
		// 파라미터 정보를 담을 vo 객체 생성
		CourseVO lv = new CourseVO();
		
		lv = lectureService.getDetail(courseId);
		
		if( lv.getAtchFileId() > 0) { // 첨부파일이 존재하면...
			// 첨부파일 정보 조회
			AtchFileVO fileVO = new AtchFileVO();
			fileVO.setAtchFileId(lv.getAtchFileId());
			List<AtchFileVO> atchFileList = null;
			
			try {
				atchFileList = fileService.getAtchFileList(fileVO);
				
			} catch(Exception ex) {
				ex.printStackTrace();
			}
			
			req.setAttribute("atchFileList", atchFileList);
		}
		
		req.setAttribute("lv", lv);
		
		// 결과를 VIEW화면에 출력하기
		req.getRequestDispatcher("/lecture/lectureDetailUser.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
