package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.AdminServiceImpl;
import admin.service.IAdminService;

@WebServlet("/blackToMem.do")
public class BlackToMem extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memId = req.getParameter("memId");
		
		IAdminService service = AdminServiceImpl.getInstance();
		
		int cnt = service.BlackToMem(memId);
		
		if (cnt > 0) {
			req.setAttribute("cnt", cnt);
		} else {
			req.setAttribute("cnt", null);
		}
		
		req.getRequestDispatcher("/views/admin/jsp/blackToMem.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
