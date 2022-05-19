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

@WebServlet("/insertNotice.do")
public class insertNotice extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/views/notice/insertNotice.jsp").forward(req, resp);

	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memId = req.getParameter("memId");
		String nickName = req.getParameter("nickName");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		
		NoticeVO nv = new NoticeVO();
		nv.setMemId(memId);
		nv.setNickName(nickName);
		nv.setTitle(title);
		nv.setContent(content);
		
		INoticeService service = NoticeServiceImpl.getInstance();
		
		int cnt = service.insertNotice(nv);
		
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		
		
		
		
//		req.setAttribute("", arg1);
		
		
		req.getRequestDispatcher("/NoticeList.do").forward(req, resp);
	}
}
