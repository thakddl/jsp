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
import Board.VO.BoardVO;
import Reply.VO.ReplyVO;
import coin.service.CoinServiceImpl;
import coin.service.IcoinService;
import coin.vo.CoinHistoryVO;
import coin.vo.MemberVO;


/**
 * Servlet implementation class ReplySave
 */
@WebServlet("/board/ReplySave.do")
public class ReplySave extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
				
		String boardId = req.getParameter("boardId");
		String postId = req.getParameter("postId");
		String replyContent = req.getParameter("replyContent");
		String memId = req.getParameter("memId");
		
		//1. 서비스 객체 얻어오기
		IBoardService service = BoardServiceImpl.getInstance();
		
		ReplyVO rv = new ReplyVO();
		
		rv.setBoardId(boardId);
		rv.setPostId(postId);
		rv.setReplyContent(replyContent);
		rv.setMemId(memId);
		
		//2. 서비스 호출하기
		int cnt = service.insertReply(rv);
		
		IcoinService coinService = CoinServiceImpl.getInstance();
		MemberVO memVO = coinService.getMember(memId); //충전한 사람
		
		//충전기록VO 생성
		CoinHistoryVO cHistoryVO = new CoinHistoryVO();
		
		//충전기록값 설정
		cHistoryVO.setcHistoryNo(coinService.getChistroySeq());
		memVO = coinService.getMember(memId);
		cHistoryVO.setcHistoryBalance(memVO.getMemCoin());
		cHistoryVO.setcHistoryCoin("+" + 10);
		cHistoryVO.setMemId(memId);
		cHistoryVO.setcEventId("댓글작성 보상");
		
						
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
			service.plusPointReply(rv);
			service.plusCoinReply(rv);
			service.plusPointReplyHistory(memId);
			service.eliteMember();
			coinService.insertCoinHistory(cHistoryVO);
		} else {
			msg = "실패";
		}
		
		String redirectUrl = req.getContextPath() + "/freeboard.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
		if(boardId.equals("2")) {
			redirectUrl = req.getContextPath() + "/qaboard.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
		} else if (boardId.equals("3")) {
			redirectUrl = req.getContextPath() + "/questionboard.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
		}
		resp.sendRedirect(redirectUrl);
		
	}

}
