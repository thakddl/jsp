package trainerHome.controller;

import java.io.IOException;
import java.net.URLEncoder;
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
import trainerHome.service.ITrainerHomeService;
import trainerHome.service.TrainerHomeServiceImpl;
import trainerHome.vo.TrainerHomeVO;

@WebServlet("/trainerHome/update.do")
@MultipartConfig(
		fileSizeThreshold = 1024*1024*3
		, maxFileSize = 1024*1024*1024
		, maxRequestSize = 1024*1024*50)
public class updateTrainerHomeInfo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 파라미터 정보 가져오기
//		String trainerId = req.getParameter("trainerId");
		String trainerId = "a100";
		//2. 서비스 객체 가져오기
		ITrainerHomeService trainerHomeService = TrainerHomeServiceImpl.getInstance();
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		
		//3.홈정보 조회
		TrainerHomeVO tvo = trainerHomeService.getTrainer(trainerId);
		
//		if(tvo.getAtchId() > 0) {
//			AtchFileVO fileVO = new AtchFileVO();
//			fileVO.setAtchFileId(tvo.getAtchId());
//			List<AtchFileVO> atchFileList = null;
//			try {
//				atchFileList = fileService.getAtchFileList(fileVO);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			req.setAttribute("atchFileList", atchFileList);
//		}
//		
		req.setAttribute("tvo", tvo);
		
		req.getRequestDispatcher("/views/trainerHome/trainerHomeUpdate.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		HttpSession session = req.getSession();
//		MemberVO vo = (MemberVO) session.getAttribute("memVO");
//		String memId = vo.getMemId();
		
		String trainerId = "a100";
		
		//1. 요청 파라미터 정보 가져오기
		
		String introNm = req.getParameter("introNm");
		String introSub = req.getParameter("introSub");
		String introMain = req.getParameter("introMain");
		String atchFile = req.getParameter("atchFile");
		
		System.out.println(introNm);
		System.out.println(introSub);
		System.out.println(introMain);
		
		//2. 서비스객체 생성하기
		ITrainerHomeService trainerHomeService = TrainerHomeServiceImpl.getInstance();
		IAtchFileService atchService = AtchFileServiceImpl.getInstance();
		AtchFileVO atchFileVO = new AtchFileVO();
		
		//첨부파일 목록 저장
		try {
			atchFileVO = atchService.saveAtchFileList(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TrainerHomeVO tvo = new TrainerHomeVO();
		
		
		//3. 정보 수정
		tvo.setIntroNm(introNm);
		tvo.setIntroSub(introSub);
		tvo.setIntroMain(introMain);
		tvo.setAtchId(atchFileVO.getAtchId());
//		tvo.setAtchId(atchFile);
	
		
		
		int cnt = trainerHomeService.updateTrainerHome(tvo);
		
		String msg = "";
		if(cnt > 0) {
			msg ="성공";
		} else {
			msg = "실패";
		}
		
		req.setAttribute("msg", msg);
		
		//go back to trainer's main page
		String redirectUrl = req.getContextPath() + "/trainerHome/detail.do?msg=" + URLEncoder.encode(msg, "UTF-8");
		resp.sendRedirect(redirectUrl);
	}
}
