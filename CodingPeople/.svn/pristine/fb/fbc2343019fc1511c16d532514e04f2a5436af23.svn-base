package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.IJoinMemberService;
import member.service.JoinMemberServiceImpl;

// id 중복체크 컨트롤러
@WebServlet("/member/idCheck.do")
public class IdChkController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out =  resp.getWriter();
		IJoinMemberService joinMemberService = JoinMemberServiceImpl.getInstance();
		
		boolean isExist = joinMemberService.idCheck(req.getParameter("memId"));
		
		int cnt = 0;
		
		if(isExist) {
			cnt = 1;
		}
		out.print(cnt);
	}
/*	
 	이전ver
   @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
//		resp.setContentType("text/html; charset=utf-8"); 
		IJoinMemberService joinMemberService = JoinMemberServiceImpl.getInstance();
		
		boolean isExist = joinMemberService.idCheck(req.getParameter("memId"));
		
		int cnt = 0;
		
		if(isExist) {
			cnt = 1;
		}
		
		// 중복 아이디가 있는 경우  true를 반환. 없으면 false를 반환
		req.setAttribute("isExist", cnt);
		req.getRequestDispatcher("/membership_idCheck.jsp").forward(req, resp);		
	}*/

}
