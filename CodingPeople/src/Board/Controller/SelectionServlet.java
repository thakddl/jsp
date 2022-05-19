package Board.Controller;

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


@WebServlet("/board/selection.do")
public class SelectionServlet  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String postId = req.getParameter("postId");
		String boardId = req.getParameter("boardId");
		String postMemId = req.getParameter("postMemId");
		String postPoint = req.getParameter("postPoint");
		String replyId = req.getParameter("replyId");
		String replyMemId = req.getParameter("replyMemId");
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		IcoinService coinService = CoinServiceImpl.getInstance();
		
		//충전기록VO 생성
		CoinHistoryVO cHistoryVO = new CoinHistoryVO();
		
		BoardVO bv = new BoardVO();	
			
		System.out.println(postPoint);
		System.out.println(postId);
		System.out.println(boardId);
		System.out.println(postMemId);
		System.out.println(replyId);
		System.out.println(replyMemId);
		// 채택
		bv.setPostId(postId);
		bv.setBoardId(boardId);
		bv = service.getDetail(bv);
		bv.setPostReplyId(replyId);
		int cnt = service.updateText(bv);
		
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
			MemberVO memVO = coinService.getMember(replyMemId); //채택된 사람
			memVO.setMemCoin(postPoint); //추가할 코인값
			//코인추가 실행
			cnt = coinService.updateCoin(memVO);
			
			if(cnt > 0) {
				//추가기록값 설정
				cHistoryVO.setcHistoryNo(coinService.getChistroySeq());
				memVO = coinService.getMember(replyMemId);
				cHistoryVO.setcHistoryBalance(memVO.getMemCoin());
				cHistoryVO.setcHistoryCoin("+" + postPoint);
				cHistoryVO.setMemId(replyMemId);
				cHistoryVO.setcEventId("답변 채택");
				
				coinService.insertCoinHistory(cHistoryVO);
				
			}
		} else {
			msg = "실패";
		}
		
		String redirectUrl = req.getContextPath() + "/board/detail.do?boardId="+ bv.getBoardId() +"&postId="+ bv.getPostId() +"&msg=" + URLEncoder.encode(msg,"UTF-8");
		
		resp.sendRedirect(redirectUrl);
	}
	
	
}
