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

@WebServlet("/admin/SelectAllCategories.do")
public class SelectAllCategoryController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IAdminCategoryService service = AdminCategoryServiceImpl.getInstance();
		List<AdminCategoryVO> categoryList = service.selectAllCategory();
		
		req.setAttribute("categoryList", categoryList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/adminCategory/adminSelectAllCategory.jsp");
		dispatcher.forward(req, resp);
	}
}
