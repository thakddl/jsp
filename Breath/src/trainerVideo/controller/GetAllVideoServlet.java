package trainerVideo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import linefeed.service.ILineFeedService;
import linefeed.service.LineFeedServiceImpl;
import linefeed.vo.LineFeedVO;
import member.vo.MemberVO;
import trainerVideo.service.ITrainerVideoService;
import trainerVideo.service.TrainerVideoServiceImpl;
import trainerVideo.vo.TrainerVideoVO;

@WebServlet("/getAllVideoList.Video")
public class GetAllVideoServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청 파라미터 가져오기
		// 세션 값 받아오기
		HttpSession session = req.getSession();
		MemberVO mv = (MemberVO) session.getAttribute("memVO");
//		String trainerId = mv.getMemId();
				
		String trainerId = req.getParameter("trainerId");

		// 2. 서비스 객체 생성하기

		ITrainerVideoService service = TrainerVideoServiceImpl.getInstance();
		TrainerVideoVO lv = new TrainerVideoVO();

		// 3. 비디오 게시물 출력
		lv.setTrainerId("a100");  // 나중에 trainerId로 바꿔준다.
			
		List<TrainerVideoVO> videoList = new ArrayList<TrainerVideoVO>();
		videoList = service.getAllVideoList(lv);
			
		req.setAttribute("videoList", videoList);
				
		req.getRequestDispatcher("/views/trainerHome/videoCheck.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
	}
}
