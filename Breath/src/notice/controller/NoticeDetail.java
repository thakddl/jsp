package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.sevice.INoticeService;
import notice.sevice.NoticeServiceImpl;
import notice.vo.NoticeVO;

@WebServlet("/NoticeDetail.do")
public class NoticeDetail extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String postNum = req.getParameter("postNum");
		
		NoticeVO nv = new NoticeVO();
		
		INoticeService service = NoticeServiceImpl.getInstance();
		
		nv = service.noticeDetail(postNum);
		
		req.setAttribute("nv", nv);
		
		req.getRequestDispatcher("/views/notice/noticeDetail.jsp").forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
