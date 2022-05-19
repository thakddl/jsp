package login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.service.ILoginService;
import login.service.LoginServiceImpl;
import member.vo.JoinMemberVO;

@WebServlet("/searchId.do")
public class SerarIdServlet extends HttpServlet{
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String memName = req.getParameter("memName");
		String memBir = req.getParameter("memBir");
		
		
		String memBir1 = memBir.substring(0,4);
		String memBir2 = memBir.substring(4,6);
		String memBir3 = memBir.substring(6);
		
		String memBir4 = memBir1 +"-"+ memBir2 +"-"+ memBir3;
		
		System.out.println(memBir4);
		
		JoinMemberVO mv = new JoinMemberVO();
		mv.setMemName(memName);
		mv.setMemBir(memBir4);
		
		ILoginService loginService = LoginServiceImpl.getInstance();
		String memId = "";
		String memId1 ="";
		if (loginService.getId(mv) != null) {
			memId = loginService.getId(mv);
			memId1 = memId.substring(0,4);
		}
		
		String memId2 = memId1+"****";
		
		System.out.println(memName);
		System.out.println(memBir4);
		System.out.println(memId2);		
		
		req.setAttribute("mv", mv);
		
		String alert = "";
		if(loginService.checkMember(memId) == 1) {
			
			req.setAttribute("memId", memId2);
			req.getRequestDispatcher("/searchId.jsp").forward(req, resp);
		} else {
			memId2 = "no";
			req.setAttribute("memId", memId2);
			req.getRequestDispatcher("/searchId.jsp").forward(req, resp);
		}
		
		
		
		
		
		
		
	}
	
	
	
}
