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

// 검색 키워드를 포함한 회원 정보 조회하는 서블릿
@WebServlet("/admin/searchMember.do")
public class SearchMemberController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 검색 키워드를 파라미터로 받아옴
		String keyword = req.getParameter("keyword");
		//System.out.println("★★★★★★★★★★★★★★★★★"+keyword);
		
		// 서비스 객체 생성
		IAdminMemService adminMemService = AdminMemServiceImpl.getInstance();
		
		// searchMember 메서드에 
		List<AllMembershipInfoVO> memList = adminMemService.searchMember(keyword);
		
		req.setAttribute("memList", memList);
		//System.out.println("★★★★★★★★★★★★★★★★★"+memList.size());
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/memberlist.jsp");
		dispatcher.forward(req, resp);
	}
}
