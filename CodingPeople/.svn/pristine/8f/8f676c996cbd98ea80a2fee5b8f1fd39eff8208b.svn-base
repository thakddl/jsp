package adminCategory.controller;

import java.io.IOException;

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

@WebServlet("/admin/insertCategory.do")
public class InsertCategoryController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/adminCategory/adminInsertCategory.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IAdminCategoryService service = AdminCategoryServiceImpl.getInstance();
		AdminCategoryVO ctgrListVo = new AdminCategoryVO();
		
		String ctgrId = req.getParameter("ctgrId");
		String ctgrName = req.getParameter("ctgrName");
		
		ctgrListVo.setCategoryId(ctgrId);
		ctgrListVo.setCategoryName(ctgrName);
		
		int cnt = service.insertCategory(ctgrListVo);
		String msg = "";
		
		if (cnt>0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		
		req.setAttribute("insertMsg", msg);
		
		req.getRequestDispatcher("/admin/SelectAllCategories.do").forward(req, resp);
		
		
	}
	
}
