package adminCategory.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminCategory.service.AdminCategoryServiceImpl;
import adminCategory.service.IAdminCategoryService;
import adminCategory.vo.AdminCategoryVO;
import adminMember.service.AdminMemServiceImpl;
import adminMember.service.IAdminMemService;
import adminMember.vo.AllMembershipInfoVO;

@WebServlet("/admin/searchCategory.do")
public class SearchCategoryController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 검색 키워드를 파라미터로 받아옴
		String keyword = req.getParameter("keyword");
		
		// 서비스 객체 생성
		IAdminCategoryService service = AdminCategoryServiceImpl.getInstance();
		
		// searchMember 메서드에 
		List<AdminCategoryVO> ctgrList = service.searchCategory(keyword);
		
		req.setAttribute("categoryList", ctgrList);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/adminCategory/adminSelectAllCategory.jsp");
		dispatcher.forward(req, resp);
	}
}
