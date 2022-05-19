package member.controller;

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

@WebServlet("/updateMember")
public class UpdateMyPageServlet extends HttpServlet{
	@Override
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/views/mypage/myInformation.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String memId = req.getParameter("memId"); 
		String memNm = req.getParameter("memNm");
		String memPass = req.getParameter("memPass");
		String nickName = req.getParameter("nickName");
		String memAdd = req.getParameter("memAdd");
		String email = req.getParameter("email");
		String hp = req.getParameter("hp");
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		MemberVO vo = new MemberVO();
		vo.setMemId(memId);
		vo.setMemNm(memNm);
		vo.setMemPass(memPass);
		vo.setNickName(nickName);
		vo.setMemAdd(memAdd);
		vo.setEmail(email);
		vo.setHp(hp);
		
		
		int cnt = service.updateMember(vo);
		String msg = "";
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("memVO", vo);
		
		String redirectUrl = req.getContextPath()+"/NoticeList.do?msg=" + URLEncoder.encode(msg,"UTF-8");

		resp.sendRedirect(redirectUrl); //목록조회화면으로 리다이렉트
	}
}
