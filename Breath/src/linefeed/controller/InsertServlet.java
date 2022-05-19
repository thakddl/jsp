package linefeed.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.service.AtchFileServiceImpl;
import common.service.IAtchFileService;
import common.vo.AtchFileVO;
import linefeed.service.ILineFeedService;
import linefeed.service.LineFeedServiceImpl;
import linefeed.vo.LineFeedVO;

@WebServlet("/insert.LineFeed")
@MultipartConfig(
		fileSizeThreshold = 1024*1024*3
		, maxFileSize = 1024*1024*1024
		, maxRequestSize = 1024*1024*50)
public class InsertServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		req.getRequestDispatcher("/views/linefeed/jsp/insert.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 요청 파라미터 정보 가져오기
		String trainerId = req.getParameter("trainerId");
		String content = req.getParameter("content");
		 
		String ipAdd = req.getRemoteAddr();
		String status = "0";
		
		// 2. 서비스 객체 생성하기
		ILineFeedService service = LineFeedServiceImpl.getInstance();
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		AtchFileVO av = new AtchFileVO();
		
		// 3. 라인피드 게시물 등록
		
		// 첨부파일 목록 저장(공통기능)
		try {
			av = fileService.saveAtchFileList(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		LineFeedVO lv = new LineFeedVO();
		trainerId = "destiny";
		
		lv.setTrainerId(trainerId);
		lv.setContent(content);
		lv.setIpAdd(ipAdd);
		lv.setAtchId(av.getAtchId());
		lv.setStatus(status);
		
		int cnt = (int) service.insertLineFeed(lv);
		
		// 등록 성공 후 라인피드를 다시 가져오기
		List<LineFeedVO> lineFeedList = new ArrayList<LineFeedVO>();
		lineFeedList = service.getAllPostList(lv);
		
		req.setAttribute("lineFeedList", lineFeedList);
		
		// 4. 목록조회화면으로 이동
		req.getRequestDispatcher("/views/linefeed/jsp/list.jsp").forward(req, resp);
		
	}
}
