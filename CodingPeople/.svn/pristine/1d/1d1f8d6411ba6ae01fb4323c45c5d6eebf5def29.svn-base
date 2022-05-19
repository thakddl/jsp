package QuestionBoard.Controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QuestionBoard.Service.QuestionBoardServiceImpl;
import QuestionBoard.Service.IQuestionBoardService;
import QuestionBoard.VO.QuestionBoardVO;

@WebServlet("/questionboard/update.do")
@MultipartConfig(fileSizeThreshold = 1024*1024*3, maxFileSize = 1024*1024*40, maxRequestSize = 1024*1024*50)
public class UpdateQuestionBoardServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 파라미터정보 가져오기
		String postId = req.getParameter("postId");
		String boardId = req.getParameter("boardId");
		
		// 파라미터 정보를 담을 vo 객체 생성
		QuestionBoardVO bv1 = new QuestionBoardVO();
		
		// vo에 필요한 정보 담기
		bv1.setPostId(postId);
		bv1.setBoardId(boardId);
		
		// 2. 서비스 객체 가져오기
		IQuestionBoardService boardService = QuestionBoardServiceImpl.getInstance();
				
		// 3. 회원정보 조회
		QuestionBoardVO bv2 = boardService.getDetail(bv1);
				
		req.setAttribute("bv", bv2);
		
		// 4. 업데이트 화면으로 포워딩
		req.getRequestDispatcher("/questionboard/updateForm.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 요청 파라미터 정보 가져오기
		String postId = req.getParameter("postId");
		String boardId = req.getParameter("boardId");
		String postTitle = req.getParameter("postTitle");
		String memId = req.getParameter("memId");
		String postUpdate = req.getParameter("postDate");
		String postContent = req.getParameter("postContent");
		
		// 2. 서비스 객체 생성하기
		IQuestionBoardService boardService = QuestionBoardServiceImpl.getInstance();
				
		// 3. 회원정보 등록
		QuestionBoardVO bv = new QuestionBoardVO();
		bv.setPostId(postId);
		bv.setBoardId(boardId);
		bv.setPostTitle(postTitle);
		bv.setMemId(memId);
		bv.setPostUpdate(postUpdate);
		bv.setPostContent(postContent);
				
		int cnt = boardService.updateText(bv);
		
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		
		req.setAttribute("msg", msg);
		
		// 4. 목록 조회화면으로 이동
//		req.getRequestDispatcher("/board/list.do").forward(req, resp);
		
		String redirectorUrl = req.getContextPath() + "/questionboard.jsp?msg=" + URLEncoder.encode(msg, "UTF-8");
		
		resp.sendRedirect(redirectorUrl); 
		
		
	}
}
