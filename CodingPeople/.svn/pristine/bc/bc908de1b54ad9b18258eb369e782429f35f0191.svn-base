package login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coin.service.CoinServiceImpl;
import coin.service.IcoinService;
import coin.vo.MemberVO;
import login.service.ILoginService;
import login.service.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginPro.do")
public class LoginServlet extends HttpServlet {
		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그아웃처리
		request.getRequestDispatcher("/WEB-INF/views/logoutPro.jsp")
		.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인처리
		
		//login.jsp에서 지정한 (name="id") 값으로 input값을 불러옴.
		String memId = request.getParameter("id");
		String tempPass = request.getParameter("pass");
		
		//비밀번호 암호화
		String memPass = SHA256.encodeSha256(tempPass);
		
		ILoginService service = LoginServiceImpl.getInstance();
		IcoinService coinService = CoinServiceImpl.getInstance();
		
		MemberVO mv = coinService.getMember(memId);
		
		String msg = "";
		if(service.checkMember(memId) == 1) {
			if(mv.getMsId().equals("delete")) {
				msg = "삭제된 회원입니다.";
			} else if(mv.getMsId().equals("dormancy")) {
				msg = "휴면 상태입니다.";
			} else if(memPass.equals(service.getPass(memId))) {
				HttpSession session = request.getSession(true);
				session.setAttribute("memId", memId);
				msg = "로그인 성공";
			} else {
				msg = "비밀번호가 일치하지 않습니다";
			}
		}    else {
			msg = "존재하지 않는 아이디 입니다.";
		}
		request.setAttribute("msg", msg);
		
		request.getRequestDispatcher("/WEB-INF/views/loginPro.jsp")
		.forward(request, response);
	}
}
