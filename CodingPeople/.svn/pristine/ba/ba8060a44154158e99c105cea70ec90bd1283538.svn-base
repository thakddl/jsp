package QuestionReply.Controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QuestionBoard.Service.QuestionBoardServiceImpl;
import QuestionBoard.Service.IQuestionBoardService;
import QuestionBoard.VO.QuestionBoardVO;
import QuestionReply.VO.QuestionReplyVO;


/**
 * Servlet implementation class ReplySave
 */
@WebServlet("/questionboard/QuestionReplySave.do")
public class QuestionReplySave extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
				
		String boardId = req.getParameter("boardId");
		String postId = req.getParameter("postId");
		String replyContent = req.getParameter("replyContent");
		String memId = req.getParameter("memId");
		
		//1. 서비스 객체 얻어오기
		IQuestionBoardService service = QuestionBoardServiceImpl.getInstance();
		
		QuestionReplyVO rv = new QuestionReplyVO();
		
		rv.setBoardId(boardId);
		rv.setPostId(postId);
		rv.setReplyContent(replyContent);
		rv.setMemId(memId);
		
		//2. 서비스 호출하기
		int cnt = service.insertReply(rv);
						
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
			service.plusPointReply(rv);
			service.plusCoinReply(rv);
			service.plusPointReplyHistory(memId);
			service.eliteMember();
		} else {
			msg = "실패";
		}
		
		String redirectUrl = req.getContextPath() + "/questionboard.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
		
		resp.sendRedirect(redirectUrl);
		
	}

}
