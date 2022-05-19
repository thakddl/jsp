package admin.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import admin.service.AdminServiceImpl;
import admin.service.IAdminService;
import admin.vo.AdminVO;

@WebServlet("/updateMem.do")
public class UpdateMem extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memId = req.getParameter("mId");

		AdminVO vo = new AdminVO();
		
		try {
			BeanUtils.populate(vo, req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		vo.setMemId(memId);
		
		IAdminService service = AdminServiceImpl.getInstance();
		
		int cnt = service.updateMember(vo);
		
		if (cnt > 0) {
			req.setAttribute("cnt", cnt);
		} else {
			req.setAttribute("cnt", null);
		}
		
		req.getRequestDispatcher("/views/admin/jsp/memUpdate.jsp").forward(req, resp);
		
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
