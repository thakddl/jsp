package trainerVideo.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
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

@WebServlet("/delete.Video")
public class DeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청 파라미터 정보 가져오기
		String contentNum = req.getParameter("contentNum");
		
		// 2. 서비스 객체 생성하기
		ITrainerVideoService service = TrainerVideoServiceImpl.getInstance();
		
		// 세션 값 받아오기
		HttpSession session = req.getSession();
		MemberVO mv = (MemberVO) session.getAttribute("memVO");
//		trainerId = mv.getMemId();
		
		
		// 3. 게시글 삭제하기
		String status = "4"; // DB 상 삭제된 게시글의 status 정보는 4
		String trainerId = "woong"; // 나중에 trainerId로 바꿔준다.
		
		TrainerVideoVO lv = new TrainerVideoVO();
		lv.setContentNum(contentNum);
		lv.setTrainerId(trainerId);
		lv.setStatus(status);
		
		// 4. 삭제 성공 후 비디오 목록을 다시 가져오기
		int result = service.deleteVideo(lv);
				
		String msg = "";
		if(result>0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		
		req.setAttribute("msg", msg);
		
		String redirectUrl = req.getContextPath() + "/getAllVideoList.Video?msg=" + URLEncoder.encode(msg,"UTF-8");
		
		resp.sendRedirect(redirectUrl); // 목록조회 화면으로 리다이렉트
		
	}
}
