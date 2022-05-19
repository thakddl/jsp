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

@WebServlet("/loginAdmin.do")
public class LoginAdmin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memId = req.getParameter("mem_id");
		String memPass = req.getParameter("mem_pass");
		String athrtCode = req.getParameter("athrt_code");
		
		AdminVO adVO = new AdminVO();
		adVO.setMemId(memId);
		adVO.setMemPass(memPass);
		adVO.setAthrtCode(athrtCode);
		
		IAdminService service = AdminServiceImpl.getInstance();
		
		int cnt = service.checkAdmin(adVO);

//		req.setAttribute("cnt", cnt);
		
		if (cnt > 0) {
			req.getRequestDispatcher("/views/admin/jsp/admin.jsp").forward(req, resp);
		}
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
}
