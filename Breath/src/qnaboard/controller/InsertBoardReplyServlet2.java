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

@WebServlet("/BInsertBoardReplyServlet.qnaBoard")
public class InsertBoardReplyServlet2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String qbr = req.getParameter("post_num");
		req.setAttribute("qbr", qbr);
		
		qnaBoardReplyVO qbrV = new qnaBoardReplyVO();
		req.setAttribute("qbrV", qbrV);
		
		req.getRequestDispatcher("/views/qnaboard/insertReplyForm.jsp")
			.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String comment_num = req.getParameter("comment_num");
		String comm_dt = req.getParameter("comm_dt");
		String content = req.getParameter("content");
		String post_num = req.getParameter("post_num");
	
		// 2. 서비스 객체 새성하기
		IBoardReplyService boardreplyService = BoardReplyServiceImpl.getInstance();

		//댓글 등록
		qnaBoardReplyVO bv = new qnaBoardReplyVO();
		bv.setComment_num(comment_num);
		bv.setComm_dt(comm_dt);
		bv.setContent(content);
		bv.setPost_num(post_num);
		
		int cnt = boardreplyService.insertBoard(bv);
		
		String msg = "";
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		req.setAttribute("msg", msg);
		// 4. 목록 조회화면으로 이동
		req.getRequestDispatcher("/detail.qnaBoard").forward(req, resp);
		
//		String redirectUrl = req.getContextPath()+"/detail.qnaBoard?post_num="+post_num+"msg="
//				+ URLEncoder.encode(msg,"UTF-8");
//		
//		resp.sendRedirect(redirectUrl); //목록조회화면으로 리다이렉트
		
	}
	
}
