package trainerHome.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.service.AtchFileServiceImpl;
import common.service.IAtchFileService;
import common.vo.AtchFileVO;
import trainerHome.service.ITrainerHomeService;
import trainerHome.service.TrainerHomeServiceImpl;
import trainerHome.vo.TrainerHomeVO;

@WebServlet("/trainerHome/insert.do")
@MultipartConfig(fileSizeThreshold = 1024*1023*3, maxFileSize = 1024*1024*40, maxRequestSize = 1024*1024*50 )
public class InsertInfoToTrainerHomeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/trainerHome/insertForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1.요청 파라미터 정보 가져오
		String introNm = req.getParameter("introNm");
		String subContent = req.getParameter("subContent");
		String introMain = req.getParameter("introMain");
		
		//2. 서비스객체 생성하기
		ITrainerHomeService trainerHomeService = TrainerHomeServiceImpl.getInstance();
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		AtchFileVO av = new AtchFileVO();
		
		try {
			av = fileService.saveAtchFileList(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TrainerHomeVO tvo = new TrainerHomeVO();
		tvo.setIntroNm(introNm);
		tvo.setIntroSub(subContent);
		tvo.setIntroMain(introMain);
		tvo.setAtchId(av.getAtchId());
		
		int cnt = trainerHomeService.insertTrainerHome(tvo);
		
		String msg = "";
		if(cnt > 0) {
			msg ="성공";
		} else {
			msg = "실패";
		}
		
		req.setAttribute("msg", msg);
		
		String redirectUrl = req.getContextPath() + "/trainerHome/detail.do?msg=" + URLEncoder.encode(msg, "UTF-8");
		resp.sendRedirect(redirectUrl);
	}
}
