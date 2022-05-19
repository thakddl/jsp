package QuestionBoard.Controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QuestionBoard.Service.QuestionBoardServiceImpl;
import QuestionBoard.Service.IQuestionBoardService;
import QuestionBoard.VO.QuestionBoardVO;

@WebServlet("/questionboard/insert.do")
@MultipartConfig(fileSizeThreshold = 1024*1024*3, maxFileSize = 1024*1024*40, maxRequestSize = 1024*1024*50)
public class InsertQuestionBoardServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/questionboard/insertForm.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 요청 파라미터 정보 가져오기
		String postTitle = req.getParameter("postTitle");
		String memId = req.getParameter("memId");
		String postContent = req.getParameter("postContent");
		
		// 2. 서비스 객체 생성하기
		IQuestionBoardService boardService = QuestionBoardServiceImpl.getInstance();
						
		// 3. 회원정보 등록
		QuestionBoardVO bv = new QuestionBoardVO();
		bv.setPostTitle(postTitle);
		bv.setMemId(memId);
		bv.setPostContent(postContent);
		
		int cnt = boardService.writeText(bv);
		
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
			boardService.plusPointPost(bv);
			boardService.plusCoinPost(bv);
			boardService.plusPointPostHistory(memId);
			boardService.eliteMember();
		} else {
			msg = "실패";
		}
//		req.setAttribute("msg", msg);
		
		String redirectUrl = req.getContextPath() + "/questionboard.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
		
		resp.sendRedirect(redirectUrl); // 목록조회 화면으로 리다이렉트
	}
}
