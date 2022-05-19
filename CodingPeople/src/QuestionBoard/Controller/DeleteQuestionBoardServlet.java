package QuestionBoard.Controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import QuestionBoard.Service.QuestionBoardServiceImpl;
import QuestionBoard.Service.IQuestionBoardService;
import QuestionBoard.VO.QuestionBoardVO;

@WebServlet("/questionboard/delete.do")
public class DeleteQuestionBoardServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 파라미터정보 가져오기
		String postId = req.getParameter("postId");
		String boardId = req.getParameter("boardId");
		String postMemId = req.getParameter("postMemId");
		
		QuestionBoardVO bv1 = new QuestionBoardVO();
		bv1.setBoardId(boardId);
		bv1.setPostId(postId);
		bv1.setMemId(postMemId);
		
//		System.out.println(boardId);
//		System.out.println(postId);
//		System.out.println(postMemId);
		
		
		// 2. 서비스 객체 가져오기
		IQuestionBoardService boardService = QuestionBoardServiceImpl.getInstance();
		
		// 3. 회원정보 조회
		int cnt = boardService.deleteText(bv1);
		
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
			// 글 삭제시 포인트삭감
			boardService.minusPointPost(bv1);
			boardService.minusCoinPost(bv1);
			boardService.minusPointPostHistory(postMemId);
			boardService.commonMember();
		} else {
			msg = "실패";
		}
		
		req.setAttribute("msg", msg);
		
		
		
		
		
		// 4. 목록 조회화면으로 이동
//		req.getRequestDispatcher("/freeboard.jsp").forward(req, resp);
//		req.setAttribute("bv", bv1);
				
		String redirectUrl = req.getContextPath() + "/questionboard.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
		
		resp.sendRedirect(redirectUrl); // 목록조회 화면으로 리다이렉트
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
