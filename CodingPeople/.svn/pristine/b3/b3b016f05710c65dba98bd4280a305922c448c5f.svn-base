package adminMember.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminMember.service.AdminMemServiceImpl;
import adminMember.service.IAdminMemService;
import adminMember.vo.AllMembershipInfoVO;

@WebServlet("/admin/selectAll.do")
public class SelectAllMemberController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 서비스 객체 생성
		IAdminMemService adminMemService = AdminMemServiceImpl.getInstance();
	
		// 회원정보 조회
		List<AllMembershipInfoVO> memList = adminMemService.selectAllMember();
		
		// req객체에 저장
		req.setAttribute("memList", memList);
		
		// jsp(화면)에게 forword
		RequestDispatcher dispatcher = req.getRequestDispatcher("/memberlist.jsp");
		dispatcher.forward(req, resp);
	}
}
