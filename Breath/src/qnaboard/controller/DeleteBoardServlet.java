package qnaboard.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qnaboard.service.BoardServiceImpl;
import qnaboard.service.IboardService;
import qnaboard.vo.qnaBoardVO;

@WebServlet("/delete.qnaBoard")
public class DeleteBoardServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 파라미터정보 가져오기
		String post_num = req.getParameter("post_num");
		
		// 2. 서비스 객체 가져오기
		IboardService service = BoardServiceImpl.getInstance();
		
		// 3. 회원정보 조회
		int cnt = service.deleteMember(post_num);

		String msg = "";
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		// 4. 목록 조회화면으로 이동
//		req.getRequestDispatcher("/member/list.do")
//			.forward(req, resp);
		
		String redirectUrl = req.getContextPath()+"/List.qnaBoard?msg=" 
											+ URLEncoder.encode(msg,"UTF-8");
		
		resp.sendRedirect(redirectUrl); //목록조회화면으로 리다이렉트
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
