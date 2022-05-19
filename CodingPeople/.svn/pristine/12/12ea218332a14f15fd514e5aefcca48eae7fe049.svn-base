package Reply.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Board.Service.BoardServiceImpl;
import Board.Service.IBoardService;
import Reply.VO.ReplyVO;


/**
 * Servlet implementation class ReplyList
 */
@WebServlet("/ReplyList")
public class ReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//0. 요청시 데이터 가져오기 
		String boardId = request.getParameter("boardId");
		String postId = request.getParameter("postId");
		
		//1. 서비스 객체 얻어오기
		IBoardService service = BoardServiceImpl.getInstance();
		
		ReplyVO rv = new ReplyVO();
		
		rv.setBoardId(boardId);
		rv.setPostId(postId);
		
		//2. 서비스 메소드 호출
		List<ReplyVO> replyList = service.replyList(rv);
		
		//3. request에 결과 값 저장
		request.setAttribute("replyList", replyList);
		
		//4. jsp로 포워딩
		request.getRequestDispatcher("board/replyList.jsp").forward(request, response);
		
		
	}

}
