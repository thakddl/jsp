package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.IJoinMemberService;
import member.service.JoinMemberServiceImpl;

@WebServlet(value="/Member/info.do")
public class GetMemberInfo extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public GetMemberInfo() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1.요청 파라미터 정보 가져오기
		String memId = req.getParameter("memId");
		
		// 2. 서비스 객체 생성하기
		IJoinMemberService joinMemberService = JoinMemberServiceImpl.getInstance();
		
		// 3. 파라미터를 넣어 쿼리문 실행 후 세부정보 VO에 담기
		adminMember.vo.AllMembershipInfoVO allMembershipInfoVO = joinMemberService.getMember(memId);
		
		req.setAttribute("allMembershipInfoVO", allMembershipInfoVO);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/header/userInfo.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
}
