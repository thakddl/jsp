package Reply.Controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Board.Service.BoardServiceImpl;
import Board.Service.IBoardService;
import Reply.VO.ReplyVO;


/**
 * Servlet implementation class ReplyUpdate
 */
@WebServlet("/board/ReplyUpdate.do")
public class ReplyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String boardId = req.getParameter("boardId");
		String postId = req.getParameter("postId");
		String replyId = req.getParameter("replyId");
		String replyContent = req.getParameter("replyContent");
		
		
		//1. 서비스 객체 얻어오기
		IBoardService service = BoardServiceImpl.getInstance();
		
		//2. 서비스 메소드 호출
		ReplyVO rv = new ReplyVO();
		rv.setBoardId(boardId);
		rv.setPostId(postId);
		rv.setReplyId(replyId);
		rv.setReplyContent(replyContent);
		
		int res = service.replyUpdate(rv);
		
		//3. request에 값 저장
		req.setAttribute("rv", rv);
		
		//4. jsp로 포워딩
		req.getRequestDispatcher("/board/list.jsp").forward(req, resp);
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
		IBoardService service = BoardServiceImpl.getInstance();
		
		//2. 서비스 메소드 호출
		ReplyVO rv = new ReplyVO();
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
	
		String redirectUrl = request.getContextPath() + "/freeboard.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
		if(boardId.equals("2")) {
			redirectUrl = request.getContextPath() + "/qaboard.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
		} else if (boardId.equals("3")) {
			redirectUrl = request.getContextPath() + "/questionboard.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
		}
//		response.sendRedirect(redirectUrl); 
		response.sendRedirect("/close.jsp"); 
	}
}
