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
import notice.vo.NoticeVO;

@WebServlet("/updateNotice.do")
public class UpdateNotice extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String postNum = (String) req.getParameter("postNum");
		
		INoticeService service = NoticeServiceImpl.getInstance();
		
		NoticeVO nv = new NoticeVO();
		
		nv = service.noticeDetail(postNum);
		
		req.setAttribute("nv", nv);
		
		req.getRequestDispatcher("/views/notice/updateNotice.jsp").forward(req, resp);
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int postNum = Integer.parseInt(req.getParameter("postNum"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		NoticeVO nv = new NoticeVO();
		nv.setPostNum(postNum);
		nv.setTitle(title);
		nv.setContent(content);
		
		// 테스트용 삭제 필요
		System.out.println(postNum + " / " + title + " / " + content);
		
		
		INoticeService service = NoticeServiceImpl.getInstance();
		
		int cnt = service.updateNotice(nv);
		
		req.setAttribute("nv", nv);
		
		String msg = "";
		if (cnt > 0) { 
			msg = "성공";
		} else {
			msg = "실패!";
		}
		
		String redirectUrl = req.getContextPath() + "/NoticeDetail.do?postNum=" + postNum;
		
//		req.getRequestDispatcher("/Breath/NoticeList.do").forward(req, resp);
		
		
		resp.sendRedirect(redirectUrl); // 공지사항 상세조회 화면으로 리다이렉트
		
	}
}
