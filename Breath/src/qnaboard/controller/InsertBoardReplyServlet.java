package qnaboard.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qnaboard.service.BoardReplyServiceImpl;
import qnaboard.service.IBoardReplyService;
import qnaboard.vo.qnaBoardReplyVO;
import qnaboard.vo.qnaBoardVO;

@WebServlet("/InsertBoardReplyServlet.qnaBoard")
public class InsertBoardReplyServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String qbr = req.getParameter("post_num");
		
		qnaBoardReplyVO qbrV = new qnaBoardReplyVO();
		String reply=qbrV.getPost_num();
		req.setAttribute("qbrV", qbrV);
		
		if(qbr.equals(reply)) {
			req.setAttribute("qbr", qbr);
		}

		req.getRequestDispatcher("/views/qnaboard/insertReplyForm.jsp")
			.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String comment_num = req.getParameter("comment_num");
		String comm_dt = req.getParameter("comm_dt");
		String content = req.getParameter("content");
		String post_num = req.getParameter("post_num");

		//댓글 등록
		qnaBoardReplyVO bv = new qnaBoardReplyVO();
		bv.setComment_num(comment_num);
		bv.setComm_dt(comm_dt);
		bv.setContent(content);
		bv.setPost_num(post_num);
		
		// 4. 목록 조회화면으로 이동
//		req.getRequestDispatcher("/member/list.do")
//			.forward(req, resp);
//		String redirectUrl = req.getContextPath()+"/BInsertBoardReplyServlet.qnaBoard"
//				+ "?post_num="+post_num;
//		
//		resp.sendRedirect(redirectUrl); //목록조회화면으로 리다이렉트
		
	}
	
}
