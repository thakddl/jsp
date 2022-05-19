package mypage;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import member.vo.MemberVO;

@WebServlet("/updatePass")
public class updatePasswordServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/mypage/updatePass.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//세션에 배치된 패스워드값
		String memPass = req.getParameter("memPass");
		//세션에 배치된 아이디값
		String memId = req.getParameter("memId");
		//현재 비밀번호
		String presentMemPass = req.getParameter("presentMemPass");
		//변경할 비밀번호
		String changeMemPass = req.getParameter("changeMemPass");
		//변경할 비밀번호 확인
		String correctChangeMemPass = req.getParameter("correctChangeMemPass");
		//멤버 객체 생성
		IMemberService service = MemberServiceImpl.getInstance();
	
		//VO에 세션 적용 후 아이디값과 비밀번호값 재배치
		HttpSession session = req.getSession();
		MemberVO vo = (MemberVO) session.getAttribute("memVO");
		vo.setMemId(memId);
		
		//현재 비밀번호와 확인값이 같은지 && 변경할 비밀번호와 확인할 비밀번호가 같은지 확인
		int cnt = 0;
		String msg = "";
		if((changeMemPass.equals(correctChangeMemPass))&&(memPass.equals(presentMemPass))) {
			vo.setMemPass(correctChangeMemPass);
			cnt=service.updatePass(vo);
		}
		if(cnt > 0) {
			msg="성공";
		}else {
			msg="실패";
		}
		//변경 후 세션 재배치
		session.setAttribute("memVO", vo);
		
		String redirectUrl = req.getContextPath()+"/updatePass?msg=" 
				+ URLEncoder.encode(msg,"UTF-8");
		
		resp.sendRedirect(redirectUrl);
	}
}
