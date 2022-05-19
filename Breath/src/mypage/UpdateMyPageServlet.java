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

@WebServlet("/updateMypage")
public class UpdateMyPageServlet extends HttpServlet{
	@Override
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberVO mv = (MemberVO) session.getAttribute("memVO");
		req.setAttribute("memVO", mv);
		
		req.getRequestDispatcher("/views/mypage/myInformation.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		//회원정보 파라미터값 가져오기
		String memId = req.getParameter("memId"); 
		String memNm = req.getParameter("memNm");
		String memPass = req.getParameter("memPass");
		String nickName = req.getParameter("nickName");
		String memAdd = req.getParameter("memAdd");
		String email = req.getParameter("email");
		String hp = req.getParameter("hp");
		
		//비밀번호 확인값 가져오기
		String memPassCorrect = req.getParameter("memPassCorrect");
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		HttpSession session = req.getSession();
		MemberVO vo = (MemberVO) session.getAttribute("memVO");
		vo.setMemId(memId);
		vo.setMemNm(memNm);
		vo.setMemPass(memPass);
		vo.setNickName(nickName);
		vo.setMemAdd(memAdd);
		vo.setEmail(email);
		vo.setHp(hp);
		
		int cnt = 0;
		if(memPassCorrect.equals(memPass)) {
			cnt = service.updateMember(vo);
		}
		
		String msg = "";
		if(cnt > 0) {
			msg = "성공";
			session.setAttribute("memVO", vo);
		}else {
			msg = "실패";
		}
		
		
		String redirectUrl = req.getContextPath()+"/updateMypage?msg="
				+URLEncoder.encode(msg, "UTF-8");

		resp.sendRedirect(redirectUrl); //목록조회화면으로 리다이렉트
	}
}
