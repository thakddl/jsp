package QuestionBoard.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QuestionBoard.Service.QuestionBoardServiceImpl;
import QuestionBoard.Service.IQuestionBoardService;
import QuestionBoard.VO.QuestionBoardVO;
import QuestionReply.VO.QuestionReplyVO;

@WebServlet("/questionboard/detail.do")
public class DetailQuestionBoardServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 파라미터정보 가져오기
		String postId = req.getParameter("postId");
		String boardId = req.getParameter("boardId");
		String postMemId = req.getParameter("postMemId");
		
		
		// 2. 서비스 객체 가져오기
		IQuestionBoardService boardService = QuestionBoardServiceImpl.getInstance();
		
		// 파라미터 정보를 담을 vo 객체 생성
		QuestionBoardVO bv1 = new QuestionBoardVO();
		
		// vo에 필요한 정보 담기
		bv1.setPostId(postId);
		bv1.setBoardId(boardId);
		bv1.setMemId(postMemId);
		
				
		// 3-1. 조회수 1 추가
		boardService.plusPostViews(bv1);
		
		String memId = boardService.getPostMemId(bv1);
		bv1.setMemId(memId);
		
		// 3-2. 회원정보 조회
		QuestionBoardVO bv2 = boardService.getDetail(bv1);
				
		QuestionReplyVO rv = new QuestionReplyVO();
		rv.setBoardId(boardId);
		rv.setPostId(postId);
		
		List<QuestionReplyVO> replyList = new ArrayList<QuestionReplyVO>();
		
		replyList = boardService.replyList(rv);
		
		req.setAttribute("rv", rv);
		
		req.setAttribute("replyList", replyList);
		
		
		req.setAttribute("bv", bv2);
		
		// 결과를 VIEW화면에 출력하기
		req.getRequestDispatcher("/questionboard/detail.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
