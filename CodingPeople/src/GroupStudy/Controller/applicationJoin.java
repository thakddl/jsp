package GroupStudy.Controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GroupStudy.Service.GroupStudyServiceImpl;
import GroupStudy.Service.IGroupStudyService;
import GroupStudy.VO.SMemberVO;

@WebServlet("/groupStudy/applicationJoin.do")
public class applicationJoin extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 가입 요청 ID 가져오기
		String memId = req.getParameter("memId");
		String sgroupId = req.getParameter("sGroupId");
		
		// 2. 서비스 객체 생성
		IGroupStudyService groupStudyService = GroupStudyServiceImpl.getInstance();
		
		// 3. 받아온 정보로  VO에 담기
		SMemberVO sMemberVO = new SMemberVO();
		sMemberVO.setMemId(memId);
		sMemberVO.setSgroupId(sgroupId);
		
		int cnt = groupStudyService.joinGroupStudy(sMemberVO);
		
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		req.setAttribute("msg", msg);
		
		String redirectUrl = req.getContextPath() + "/groupStudy/list.do?msg=" + URLEncoder.encode(msg,"UTF-8");
		
		resp.sendRedirect(redirectUrl); // 목록조회 화면으로 리다이렉트
	}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
