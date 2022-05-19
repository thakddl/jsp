package trainerVideo.controller;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.service.AtchFileServiceImpl;
import common.service.IAtchFileService;
import common.vo.AtchFileVO;
import member.vo.MemberVO;
import trainerVideo.service.ITrainerVideoService;
import trainerVideo.service.TrainerVideoServiceImpl;
import trainerVideo.vo.TrainerVideoVO;

@WebServlet("/insert.Video")
@MultipartConfig(
		fileSizeThreshold = 1024*1024*3
		, maxFileSize = 1024*1024*1024
		, maxRequestSize = 1024*1024*50)
public class InsertServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 요청 파라미터 정보 가져오기
		// 세션 값 받아오기
		HttpSession session = req.getSession();
		MemberVO mv = (MemberVO) session.getAttribute("memVO");
//		trainerId = mv.getMemId();
		String trainerId = "a100";  // 나중에 위의 주석으로 바꿔준다.
		String content = req.getParameter("content");
		String ipAdd = req.getRemoteAddr();
		
		// 2. 서비스 객체 생성하기
		ITrainerVideoService service = TrainerVideoServiceImpl.getInstance();
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		AtchFileVO av = new AtchFileVO();
		
		// 3. 비디오 게시물 등록
		
		// 첨부파일 목록 저장(공통기능)
		try {
			av = fileService.saveAtchFileList1(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TrainerVideoVO lv = new TrainerVideoVO();
		
		lv.setTrainerId(trainerId);
		lv.setContent(content);
		lv.setIpAdd(ipAdd);
		lv.setAtchId(av.getAtchId());
		
		int cnt = service.insertVideo(lv);
		
		String msg = "";
		if(cnt>0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		
		req.setAttribute("msg", msg);
		
		String redirectUrl = req.getContextPath() + "/getAllVideoList.Video?msg=" + URLEncoder.encode(msg,"UTF-8");
		
		resp.sendRedirect(redirectUrl); // 목록조회 화면으로 리다이렉트
		
//		// 등록 성공 후 비디오 목록을 다시 가져오기
//		List<TrainerVideoVO> videoList = new ArrayList<TrainerVideoVO>();
//		videoList = service.getAllVideoList(lv);
//		
//		req.setAttribute("successNum", cnt);
//		
//		// 4. 목록조회화면으로 이동
		//req.getRequestDispatcher("/views/trainerHome/videoCheck.jsp?msg=" + URLEncoder.encode(msg,"UTF-8")).forward(req, resp);
		
	}
}
