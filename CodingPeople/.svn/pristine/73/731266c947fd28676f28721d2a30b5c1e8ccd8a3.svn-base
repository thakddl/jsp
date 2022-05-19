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
import coin.service.CoinServiceImpl;
import coin.service.IcoinService;
import coin.vo.CoinHistoryVO;
import coin.vo.MemberVO;


/**
 * Servlet implementation class ReplyDelete
 */
@WebServlet("/board/ReplyDelete.do")
public class ReplyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyDelete() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//0. 요청시 데이터 가져오기
		String boardId = request.getParameter("boardId");
		String postId = request.getParameter("postId");
		String replyId = request.getParameter("replyId");
		String replyMemId = request.getParameter("replyMemId");
		
		//1. 서비스 객체 얻어오기 
		IBoardService service = BoardServiceImpl.getInstance();
		
		ReplyVO rv = new ReplyVO();
		
		rv.setBoardId(boardId);
		rv.setPostId(postId);
		rv.setReplyId(replyId);
		rv.setMemId(replyMemId);
		
		
		//2. 서비스 메소드 호출
		int cnt = service.replyDelete(rv);
		
		IcoinService coinService = CoinServiceImpl.getInstance();
		MemberVO memVO = coinService.getMember(replyMemId); //충전한 사람
		
		//충전기록VO 생성
		CoinHistoryVO cHistoryVO = new CoinHistoryVO();
		
		//충전기록값 설정
		cHistoryVO.setcHistoryNo(coinService.getChistroySeq());
		memVO = coinService.getMember(replyMemId);
		cHistoryVO.setcHistoryBalance(memVO.getMemCoin());
		cHistoryVO.setcHistoryCoin("-" + 10);
		cHistoryVO.setMemId(replyMemId);
		cHistoryVO.setcEventId("댓글작성 보상회수");
		
		
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
			//2-1. 리플 삭제시 포인트 차감
			service.minusPointReply(rv);
			service.minusCoinReply(rv);
			service.minusPointReplyHistory(replyMemId);
			service.commonMember();
			coinService.insertCoinHistory(cHistoryVO);
		} else {
			msg = "실패";
		}
		
		
		
		request.setAttribute("msg", msg);
		
		// 4. 목록 조회화면으로 이동
				
		String redirectUrl = request.getContextPath() + "/freeboard.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
		if(boardId.equals("2")) {
			redirectUrl = request.getContextPath() + "/qaboard.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
		} else if (boardId.equals("3")) {
			redirectUrl = request.getContextPath() + "/questionboard.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
		}
		response.sendRedirect(redirectUrl); // 목록조회 화면으로 리다이렉트
	}

}
