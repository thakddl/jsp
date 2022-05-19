package adminCategory.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminCategory.service.AdminCategoryServiceImpl;
import adminCategory.service.IAdminCategoryService;

@WebServlet("/admin/deleteCategory.do")
public class DeleteCategoryController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IAdminCategoryService service = AdminCategoryServiceImpl.getInstance();
		
		String ctgrId = req.getParameter("ctgrId");
		
		int cnt = service.deleteCategory(ctgrId);
		
		String deleteMsg = "";
		
		if (cnt>0) {
			deleteMsg="성공";
		} else {
			deleteMsg="실패";
		}
		
		req.setAttribute("deleteMsg", deleteMsg);
		req.getRequestDispatcher("/admin/SelectAllCategories.do").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
