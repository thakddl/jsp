package qnaboard.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qnaboard.service.BoardReplyServiceImpl;
import qnaboard.service.BoardServiceImpl;
import qnaboard.service.IBoardReplyService;
import qnaboard.service.IboardService;
import qnaboard.vo.qnaBoardReplyVO;
import qnaboard.vo.qnaBoardVO;

/**
 * Servlet implementation class QnaCRUDController
 */
@WebServlet("/detail.qnaBoard")
public class DetailBoardServlet extends HttpServlet {
    public DetailBoardServlet() {}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//게시글 상세정보
		// 1. 파라미터정보 가져오기
		String post_num = req.getParameter("post_num");
		
		// 2. 서비스 객체 가져오기
		IboardService boardService = BoardServiceImpl.getInstance();
		IBoardReplyService replyService = BoardReplyServiceImpl.getInstance();
		// 3. 게시물조회
		qnaBoardVO bv = boardService.getContent(post_num);
		
		req.setAttribute("bv", bv);
		//댓글 정보
		// 최종적으로 DB에 있던 List값이 boardList에 전달된다.
		List<qnaBoardReplyVO> boardReplyList = replyService.getReply(post_num);
		// HttpServletRequest req에 속성값을 지정해준다.
		req.setAttribute("boardReplyList",boardReplyList);
		
		// 결과를 VIEW화면에 출력하기
		req.getRequestDispatcher("/views/qnaboard/detail.jsp").forward(req, resp);
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
