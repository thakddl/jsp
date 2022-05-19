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

@WebServlet("/delete.Member")
public class DeleteMemberServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/mypage/deleteForm.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberVO vo= (MemberVO) session.getAttribute("memVO");
		
		//서비스 객체 가져오기
		IMemberService service = MemberServiceImpl.getInstance();
		String memPass = req.getParameter("memPass");
		String passCorrect = req.getParameter("passCorrect");
		
		String memId = req.getParameter("memId");

		String msg="";
		if(memPass.equals(passCorrect)&&vo.getMemId().equals(memId)&&vo.getMemPass().equals(memPass)) {
			service.deleteMember(memId);
			msg="성공";
			session.invalidate();
		}else {
			msg="실패";
		}
		req.setAttribute("msg", msg);
		String redirectUrl = req.getContextPath()+"/index.html?msg=" 
				+ URLEncoder.encode(msg,"UTF-8");

		resp.sendRedirect(redirectUrl); //목록조회화면으로 리다이렉트
	}
}
