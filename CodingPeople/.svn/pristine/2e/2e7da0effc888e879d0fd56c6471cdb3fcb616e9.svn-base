package Board.Controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Board.Service.BoardServiceImpl;
import Board.Service.IBoardService;
import Board.VO.BoardVO;
import atch.Service.AtchFileServiceImpl;
import atch.Service.IAtchFileService;
import atch.VO.AtchFileVO;
import coin.service.CoinServiceImpl;
import coin.service.IcoinService;
import coin.vo.CoinHistoryVO;
import coin.vo.MemberVO;

@WebServlet("/board/insert.do")
@MultipartConfig(fileSizeThreshold = 1024*1024*3, maxFileSize = 1024*1024*40, maxRequestSize = 1024*1024*50)
public class InsertBoardServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("insertdo.boardId" + req.getParameter("boardId"));
		req.setAttribute("boardId", req.getParameter("boardId"));
		req.getRequestDispatcher("/board/insertForm.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 요청 파라미터 정보 가져오기
		String boardId = req.getParameter("boardId");
		String postTitle = req.getParameter("postTitle");
		String memId = req.getParameter("memId");
		String postContent = req.getParameter("postContent");
		String postPoint = req.getParameter("postPoint");
		
		// 2. 서비스 객체 생성하기
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		
		AtchFileVO atchFileVO = new AtchFileVO();
		
		try {
			// 첨부파일 목록 저장(공통기능)
				atchFileVO = fileService.saveAtchFileList(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 3. 회원정보 등록
		BoardVO bv = new BoardVO();
		System.out.println("post bi=" + boardId);
		bv.setBoardId(boardId);
		bv.setPostTitle(postTitle);
		bv.setMemId(memId);
		bv.setPostContent(postContent);
		bv.setPostPoint(postPoint);
		System.out.println(atchFileVO);
		if(atchFileVO != null) {
			bv.setAtchFileId(atchFileVO.getAtchFileId());
		}
		int cnt = boardService.writeText(bv);
		
		IcoinService coinService = CoinServiceImpl.getInstance();
		MemberVO memVO = coinService.getMember(memId); //충전한 사람
		
		//충전기록VO 생성
		CoinHistoryVO cHistoryVO = new CoinHistoryVO();
		
		//충전기록값 설정
		cHistoryVO.setcHistoryNo(coinService.getChistroySeq());
		memVO = coinService.getMember(memId);
		cHistoryVO.setcHistoryBalance(memVO.getMemCoin());
		cHistoryVO.setcHistoryCoin("+" + 30);
		cHistoryVO.setMemId(memId);
		cHistoryVO.setcEventId("글작성 보상");
		
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
			boardService.plusPointPost(bv);
			boardService.plusCoinPost(bv);
			boardService.plusPointPostHistory(memId);
			boardService.eliteMember();
			coinService.insertCoinHistory(cHistoryVO);
			
			if(boardId.equals("2")) {
				
				boardService.minusCoinSelection(bv);
				
				cHistoryVO.setcHistoryNo(coinService.getChistroySeq());
				memVO = coinService.getMember(memId);
				cHistoryVO.setcHistoryBalance(memVO.getMemCoin());
				cHistoryVO.setcHistoryCoin("-" + bv.getPostPoint());
				cHistoryVO.setMemId(memId);
				cHistoryVO.setcEventId("답변 채택 사용");
				coinService.insertCoinHistory(cHistoryVO);
			}
		} else {
			msg = "실패";
		}
//		req.setAttribute("msg", msg);
		String redirectUrl = req.getContextPath() + "/freeboard.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
		if(boardId.equals("2")) {
			redirectUrl = req.getContextPath() + "/qaboard.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
		} else if (boardId.equals("3")) {
			redirectUrl = req.getContextPath() + "/questionboard.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
		}
		
		resp.sendRedirect(redirectUrl); // 목록조회 화면으로 리다이렉트
	}
}
