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

@WebServlet("/update.LineFeed")
@MultipartConfig(
		fileSizeThreshold = 1024*1024*3
		, maxFileSize = 1024*1024*1024
		, maxRequestSize = 1024*1024*50)
public class UpdateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// req.getRequestDispatcher("views/linefeed/update.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 파라미터 값 가져오기
		String lnfdNum = req.getParameter("lnfdNum");
		String content = req.getParameter("content");
		String ipAdd = req.getRemoteAddr();
		
		// 2. 서비스 객체 가져오기
		ILineFeedService service = LineFeedServiceImpl.getInstance();
		IAtchFileService atchService = AtchFileServiceImpl.getInstance();
		AtchFileVO av = new AtchFileVO();
		
		// 첨부파일 목록 저장
		try {
			av = atchService.saveAtchFileList(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		LineFeedVO lv = new LineFeedVO();
		
		// 3. 게시물 정보 등록하기
		lv.setContent(content);
		lv.setIpAdd(ipAdd);
		lv.setAtchId(av.getAtchId());
		lv.setLnfdNum(lnfdNum);
		
		service.updateLineFeed(lv);
		
		// 등록 성공 후 라인피드를 다시 가져오기
		List<LineFeedVO> lineFeedList = new ArrayList<LineFeedVO>();
		LineFeedVO lv2 = new LineFeedVO();
		
		String trainerId = "destiny";
		lv2.setTrainerId(trainerId);
		
		lineFeedList = service.getAllPostList(lv2);
		req.setAttribute("lineFeedList", lineFeedList);
		
		// 4. 리스트 화면 출력하기
		req.getRequestDispatcher("/views/linefeed/jsp/list.jsp").forward(req, resp);;
		
		
	}
}
