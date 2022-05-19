package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.AdminServiceImpl;
import admin.service.IAdminService;
import membership.service.IMembershipService;
import membership.service.MembershipServiceImpl;
import report.service.IReportService;
import report.service.ReportServiceImpl;

@WebServlet("/dashBoard.do")
public class DashBoard extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IAdminService adminService = AdminServiceImpl.getInstance();
		IMembershipService shipService = MembershipServiceImpl.getInstance();
		IReportService reportService = ReportServiceImpl.getInstance();
				
		int memCount = adminService.memCount();
		int shipCount = shipService.shipCount();
		int reportCount = reportService.reportCount();
		int blackCount = adminService.blackCount();
		
		req.setAttribute("memCount", memCount);
		req.setAttribute("shipCount", shipCount);
		req.setAttribute("reportCount", reportCount);
		req.setAttribute("blackCount", blackCount);
		
		req.getRequestDispatcher("/views/admin/jsp/dashBoard.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}
