package notice.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.sevice.INoticeService;
import notice.sevice.NoticeServiceImpl;

@WebServlet("/deleteNotice.do")
public class DeleteNotice extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String postNum = req.getParameter("postNum");
		
//		req.setAttribute("postNum", postNum);
		
		INoticeService service = NoticeServiceImpl.getInstance();
		
		int cnt = service.deleteNotice(postNum);
		
		String msg = "";
		if (cnt > 0) { 
			msg = "성공";
		} else {
			msg = "실패!";
		}
		
		String redirectUrl = req.getContextPath() + "/NoticeList.do?msg" + URLEncoder.encode(msg, "UTF-8");
		
		resp.sendRedirect(redirectUrl); // 목록조회 화면으로 리다이렉트
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
