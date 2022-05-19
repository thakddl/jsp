package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVO;

@WebServlet("/login.member")
public class LoginMemberServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		// 1. 요청 파라미터 정보 가져오기
		MemberVO mv = new MemberVO();
		String memId = req.getParameter("mId");
		String memPass = req.getParameter("mPw");
		
		mv.setMemId(memId);
		mv.setMemPass(memPass);
		
		// 2. 서비스 객체 생성하기
		IMemberService memberService = MemberServiceImpl.getInstance();
		
		// 3. 회원정보 조회
		
		MemberVO vo = memberService.getMember(mv);
		
		req.setAttribute("vo", vo);
		
		HttpSession session = req.getSession();
		
		session.setAttribute("memVO", vo);
		

		// 4. 목록 조회화면으로 이동
		// jsp로 포워딩
		req.getRequestDispatcher("/views/signin/login_ok.jsp").forward(req, resp);
	}
	
}
