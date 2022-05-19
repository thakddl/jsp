package trainerVideo.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

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

@WebServlet("/update.Video")
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
		String contentNum = req.getParameter("contentNum");
		String content = req.getParameter("content");
		String ipAdd = req.getRemoteAddr();
		
		// 2. 서비스 객체 가져오기
		ITrainerVideoService service = TrainerVideoServiceImpl.getInstance();
		IAtchFileService atchService = AtchFileServiceImpl.getInstance();
		AtchFileVO av = new AtchFileVO();
		
		// 첨부파일 목록 저장
		try {
			av = atchService.saveAtchFileList1(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TrainerVideoVO lv = new TrainerVideoVO();
		
		// 3. 게시물 정보 등록하기
		lv.setContent(content);
		lv.setIpAdd(ipAdd);
		lv.setAtchId(av.getAtchId());
		lv.setContentNum(contentNum);
		
		int cnt = service.updateVideo(lv);
		
		// 세션 값 받아오기
		HttpSession session = req.getSession();
		MemberVO mv = (MemberVO) session.getAttribute("memVO");
//		String trainerId = mv.getMemId();
		
		String msg = "";
		if(cnt>0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		
		req.setAttribute("msg", msg);
		
		String redirectUrl = req.getContextPath() + "/getAllVideoList.Video?msg=" + URLEncoder.encode(msg,"UTF-8");
		
		resp.sendRedirect(redirectUrl); // 목록조회 화면으로 리다이렉트
		
		
	}
}
