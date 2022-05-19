package trainerHome.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trainer.service.TrainerServiceImpl;
import trainerHome.service.ITrainerHomeService;
import trainerHome.service.TrainerHomeServiceImpl;
import trainerHome.vo.TrainerHomeVO;

@WebServlet("/trainerHome/detail.do")
public class EachTrainerHomeInfo extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//파라미터 정보 가져오기
//		String trainerId = req.getParameter("trainerId");
		String trainerId = "a100";
		
		//2.서비스 객체 가져오기
		ITrainerHomeService trainerHomeService = TrainerHomeServiceImpl.getInstance();
		
		//3. 트레이너 홈 조회
		TrainerHomeVO tvo = trainerHomeService.eachTrainerintro(trainerId);
		
		req.setAttribute("tvo", tvo);
		
		req.getRequestDispatcher("/views/trainerHome/adChloeMain.jsp").forward(req, resp);
		

//		String redirectUrl = req.getContextPath() + "/getAllPostList.LineFeed?trainerId=" + tvo.getTrainerId();
//		resp.sendRedirect(redirectUrl); 
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
