package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.AdminServiceImpl;
import admin.service.IAdminService;

@WebServlet("/memToBlack.do")
public class MemToBlack extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String memId = req.getParameter("memId");
		
		IAdminService service = AdminServiceImpl.getInstance();
		
		int cnt = service.memToBlack(memId);
		System.out.println(cnt);
		
		
		if (cnt > 0) {
			req.setAttribute("cnt", cnt);
		} else {
			req.setAttribute("cnt", 0);
		}
		
		req.getRequestDispatcher("views/admin/jsp/memToBlack.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	

}
