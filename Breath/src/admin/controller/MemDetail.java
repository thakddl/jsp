package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.AdminServiceImpl;
import admin.service.IAdminService;
import admin.vo.AdminVO;

@WebServlet("/memDetail.do")
public class MemDetail extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String memId = req.getParameter("memId");
			
			IAdminService service = AdminServiceImpl.getInstance();
			
			AdminVO vo = service.getMember(memId);
			
			req.setAttribute("vo", vo);
			
			req.getRequestDispatcher("/views/admin/jsp/memDetail.jsp").forward(req, resp);
			
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
		}
}
