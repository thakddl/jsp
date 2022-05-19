package Board.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Board.Service.BoardServiceImpl;
import Board.Service.IBoardService;
import Board.VO.BoardVO;
import Reply.VO.ReplyVO;
import atch.Service.AtchFileServiceImpl;
import atch.Service.IAtchFileService;
import atch.VO.AtchFileVO;

@WebServlet("/board/detail.do")
public class DetailBoardServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 파라미터정보 가져오기
		String postId = req.getParameter("postId");
		String boardId = req.getParameter("boardId");
		String postMemId = req.getParameter("postMemId");
		
		
		// 2. 서비스 객체 가져오기
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		
		// 파라미터 정보를 담을 vo 객체 생성
		BoardVO bv1 = new BoardVO();
		
		// vo에 필요한 정보 담기
		bv1.setPostId(postId);
		bv1.setBoardId(boardId);
		bv1.setMemId(postMemId);
		
				
		// 3-1. 조회수 1 추가
		boardService.plusPostViews(bv1);
		
		String memId = boardService.getPostMemId(bv1);
		bv1.setMemId(memId);
		
		// 3-2. 회원정보 조회
		BoardVO bv2 = boardService.getDetail(bv1);
		
		if(bv2.getAtchFileId() > 0) { // 첨부파일이 존재하면...
			// 첨부파일 정보 조회
			AtchFileVO fileVO = new AtchFileVO();
			fileVO.setAtchFileId(bv2.getAtchFileId());
			List<AtchFileVO> atchFileList = null;
			
			try {
				atchFileList = fileService.getAtchFileList(fileVO);
				
			} catch(Exception ex) {
				ex.printStackTrace();
			}
			
			req.setAttribute("atchFileList", atchFileList);
		}
		
		ReplyVO rv = new ReplyVO();
		rv.setBoardId(boardId);
		rv.setPostId(postId);
		
		List<ReplyVO> replyList = new ArrayList<ReplyVO>();
		
		replyList = boardService.replyList(rv);
		
		req.setAttribute("rv", rv);
		
		req.setAttribute("replyList", replyList);
		
		
		req.setAttribute("bv", bv2);
		
		// 결과를 VIEW화면에 출력하기
		req.getRequestDispatcher("/board/detail.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
