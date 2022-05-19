package Board.Controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Board.Service.BoardServiceImpl;
import Board.Service.IBoardService;
import Board.VO.BoardVO;
import coin.service.CoinServiceImpl;
import coin.service.IcoinService;
import coin.vo.CoinHistoryVO;
import coin.vo.MemberVO;

@WebServlet("/board/delete.do")
public class DeleteBoardServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 파라미터정보 가져오기
		String postId = req.getParameter("postId");
		String boardId = req.getParameter("boardId");
		String postMemId = req.getParameter("postMemId");
		String postPoint = req.getParameter("postPoint");
		
		BoardVO bv1 = new BoardVO();
		bv1.setBoardId(boardId);
		bv1.setPostId(postId);
		bv1.setMemId(postMemId);
		bv1.setPostPoint(postPoint);
//		System.out.println(boardId);
//		System.out.println(postId);
//		System.out.println(postMemId);
		
		
		// 2. 서비스 객체 가져오기
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		// 3. 회원정보 조회
		int cnt = boardService.deleteText(bv1);
		
		IcoinService coinService = CoinServiceImpl.getInstance();
		MemberVO memVO = coinService.getMember(postMemId); //충전한 사람
		
		//충전기록VO 생성
		CoinHistoryVO cHistoryVO = new CoinHistoryVO();
		
		//충전기록값 설정
		cHistoryVO.setcHistoryNo(coinService.getChistroySeq());
		memVO = coinService.getMember(postMemId);
		cHistoryVO.setcHistoryBalance(memVO.getMemCoin());
		cHistoryVO.setcHistoryCoin("-" + 30);
		cHistoryVO.setMemId(postMemId);
		cHistoryVO.setcEventId("글작성 보상회수");
		
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
			// 글 삭제시 포인트삭감
			boardService.minusPointPost(bv1);
			boardService.minusCoinPost(bv1);
			boardService.minusPointPostHistory(postMemId);
			boardService.commonMember();
			coinService.insertCoinHistory(cHistoryVO);
			
			if(boardId.equals("2")) {
			
			boardService.plusCoinSelection(bv1);
			
			cHistoryVO.setcHistoryNo(coinService.getChistroySeq());
			memVO = coinService.getMember(postMemId);
			cHistoryVO.setcHistoryBalance(memVO.getMemCoin());
			cHistoryVO.setcHistoryCoin("+" + bv1.getPostPoint());
			cHistoryVO.setMemId(postMemId);
			cHistoryVO.setcEventId("채택 글 삭제");
			coinService.insertCoinHistory(cHistoryVO);
			
			}
		} else {
			msg = "실패";
		}
		
		req.setAttribute("msg", msg);
		
		
		
		
		
		// 4. 목록 조회화면으로 이동
//		req.getRequestDispatcher("/freeboard.jsp").forward(req, resp);
//		req.setAttribute("bv", bv1);
		String target = "freeboard.jsp";
		if(boardId.equals("2")) {
			target = "qaboard.jsp";
		} else if(boardId.equals("3")) {
			target = "questionboard.jsp";
		}
		String redirectUrl = req.getContextPath() + "/"+target+"?msg=" + URLEncoder.encode(msg,"UTF-8");
		
		resp.sendRedirect(redirectUrl); // 목록조회 화면으로 리다이렉트
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
