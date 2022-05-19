package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.AdminServiceImpl;
import admin.service.IAdminService;
import admin.vo.AdminVO;

@WebServlet("/blackList.do")
public class BlackList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IAdminService service = AdminServiceImpl.getInstance();
		
		List<AdminVO> blackList = service.getBlackList();
		
		req.setAttribute("blackList", blackList);
		
		
		req.getRequestDispatcher("/views/admin/jsp/blackList.jsp").forward(req, resp);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
