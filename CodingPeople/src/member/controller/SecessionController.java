package member.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.IJoinMemberService;
import member.service.JoinMemberServiceImpl;

@WebServlet("/secession.do")
public class SecessionController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memId = req.getParameter("memId");
		
		IJoinMemberService service = JoinMemberServiceImpl.getInstance();
		
		int cnt = service.secessionMember(memId);
		
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		
		String redirectUrl = req.getContextPath() + "/secessionend.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
		
		resp.sendRedirect(redirectUrl); // 목록조회 화면으로 리다이렉트
		
		
	}
	
	
}
