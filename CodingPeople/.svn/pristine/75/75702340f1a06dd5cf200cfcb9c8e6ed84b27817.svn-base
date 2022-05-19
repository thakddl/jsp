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
 * Servlet implementation class ReplyUpdate
 */
@WebServlet("/questionboard/QuestionReplyUpdate.do")
public class QuestionReplyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionReplyUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String boardId = req.getParameter("boardId");
		String postId = req.getParameter("postId");
		String replyId = req.getParameter("replyId");
		String replyContent = req.getParameter("replyContent");
		
		
		//1. 서비스 객체 얻어오기
		IQuestionBoardService service = QuestionBoardServiceImpl.getInstance();
		
		//2. 서비스 메소드 호출
		QuestionReplyVO rv = new QuestionReplyVO();
		rv.setBoardId(boardId);
		rv.setPostId(postId);
		rv.setReplyId(replyId);
		rv.setReplyContent(replyContent);
		
		int res = service.replyUpdate(rv);
		
		//3. request에 값 저장
		req.setAttribute("rv", rv);
		
		//4. jsp로 포워딩
		req.getRequestDispatcher("/questionboard/list.jsp").forward(req, resp);
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//0. 요청시 데이터 가져오기 
		String boardId = request.getParameter("boardId");
		String postId = request.getParameter("postId");
		String replyId = request.getParameter("replyId");
		String memId = request.getParameter("memId");
		String replyContent = request.getParameter("replyContent");
		
		//1. 서비스 객체 얻어오기
		IQuestionBoardService service = QuestionBoardServiceImpl.getInstance();
		
		//2. 서비스 메소드 호출
		QuestionReplyVO rv = new QuestionReplyVO();
		rv.setBoardId(boardId);
		rv.setPostId(postId);
		rv.setReplyId(replyId);
		rv.setMemId(memId);
		rv.setReplyContent(replyContent);
		
		int cnt = service.replyUpdate(rv);
//		service.replyUpdate(rv);
		
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
		} else {  
			msg = "실패";
		}
		//3. request에 값 저장
		request.setAttribute("rv", rv);
		
		//4. jsp로 포워딩
	
		String redirectorUrl = request.getContextPath() + "/questionboard.jsp?msg=" + URLEncoder.encode(msg, "UTF-8");
		
		response.sendRedirect(redirectorUrl); 
	}
}
