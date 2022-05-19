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
import QuestionReply.VO.QuestionReplyVO;


/**
 * Servlet implementation class ReplyDelete
 */
@WebServlet("/questionboard/QuestionReplyDelete.do")
public class QuestionReplyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionReplyDelete() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//0. 요청시 데이터 가져오기
		String boardId = request.getParameter("boardId");
		String postId = request.getParameter("postId");
		String replyId = request.getParameter("replyId");
		String replyMemId = request.getParameter("replyMemId");
		
		//1. 서비스 객체 얻어오기 
		IQuestionBoardService service = QuestionBoardServiceImpl.getInstance();
		
		QuestionReplyVO rv = new QuestionReplyVO();
		
		rv.setBoardId(boardId);
		rv.setPostId(postId);
		rv.setReplyId(replyId);
		rv.setMemId(replyMemId);
		
		
		//2. 서비스 메소드 호출
		int cnt = service.replyDelete(rv);
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		//2-1. 리플 삭제시 포인트 차감
		service.minusPointReply(rv);
		service.minusCoinReply(rv);
		service.minusPointReplyHistory(replyMemId);
		service.commonMember();
		
		
		request.setAttribute("msg", msg);
		
		// 4. 목록 조회화면으로 이동
				
		String redirectUrl = request.getContextPath() + "/questionboard.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
		
		response.sendRedirect(redirectUrl); // 목록조회 화면으로 리다이렉트
	}

}
