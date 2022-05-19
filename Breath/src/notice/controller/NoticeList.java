package notice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.sevice.INoticeService;
import notice.sevice.NoticeServiceImpl;
import notice.vo.NoticeVO;

@WebServlet("/NoticeList.do")
public class NoticeList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<NoticeVO> list = new ArrayList<>();
		
		INoticeService service = NoticeServiceImpl.getInstance();
		
		list = (List<NoticeVO>) service.noticeList();
		
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/views/notice/noticeList.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
