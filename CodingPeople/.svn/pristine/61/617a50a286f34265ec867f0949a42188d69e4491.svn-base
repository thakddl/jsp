package Board.Controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

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

@WebServlet("/board/update.do")
@MultipartConfig(fileSizeThreshold = 1024*1024*3, maxFileSize = 1024*1024*40, maxRequestSize = 1024*1024*50)
public class UpdateBoardServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 파라미터정보 가져오기
		String postId = req.getParameter("postId");
		String boardId = req.getParameter("boardId");
		String postMemId = req.getParameter("postMemId");
		String postPoint = req.getParameter("postPoint");
		
		// 파라미터 정보를 담을 vo 객체 생성
		BoardVO bv1 = new BoardVO();
		
		// vo에 필요한 정보 담기
		bv1.setPostId(postId);
		bv1.setBoardId(boardId);
		bv1.setMemId(postMemId);
		bv1.setPostPoint(postPoint);
		
		// 2. 서비스 객체 가져오기
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		
		
		// 3. 회원정보 조회
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
		
		req.setAttribute("bv", bv2);
		
		// 4. 업데이트 화면으로 포워딩
		req.getRequestDispatcher("/board/updateForm.jsp").forward(req, resp);
		
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
		String atchFileId = req.getParameter("atchFileId");
		String postPoint = req.getParameter("postPoint");
		String beforePoint = req.getParameter("beforePoint");
		
		// 2. 서비스 객체 생성하기
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		
		AtchFileVO atchFileVO = null;
		
		try {
			// 첨부파일 목록저장(공통기능)
			atchFileVO = fileService.saveAtchFileList(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		IcoinService coinService = CoinServiceImpl.getInstance();
		
		MemberVO mv = coinService.getMember(memId); //충전한 사람
		
		CoinHistoryVO cHistoryVO = new CoinHistoryVO();
		
		// 3. 회원정보 등록
		BoardVO bv = new BoardVO();
		bv.setPostId(postId);
		bv.setBoardId(boardId);
		bv.setPostTitle(postTitle);
		bv.setMemId(memId);
		bv.setPostUpdate(postUpdate);
		bv.setPostContent(postContent);
		bv.setPostPoint(postPoint);
		if(atchFileVO == null) { // 신규 첨부파일이 존재하지 않는 경우..
			if(atchFileId != null) {
				bv.setAtchFileId(Long.parseLong(atchFileId));
			}
		} else {
			bv.setAtchFileId(atchFileVO.getAtchFileId());
		}
		
		int cnt = boardService.updateText(bv);
		System.out.println((Integer.parseInt(beforePoint) - Integer.parseInt(postPoint)));
		System.out.println(String.valueOf((Integer.parseInt(beforePoint) - Integer.parseInt(postPoint))));
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
			mv.setMemCoin(beforePoint);
			coinService.updateCoin(mv); //수정할 코인값
			mv.setMemCoin("-"+postPoint);
			coinService.updateCoin(mv); //수정할 코인값
			
			cHistoryVO.setcHistoryNo(coinService.getChistroySeq());
			mv = coinService.getMember(memId);
			cHistoryVO.setcHistoryBalance(mv.getMemCoin());
			cHistoryVO.setcHistoryCoin(String.valueOf((Integer.parseInt(beforePoint) - Integer.parseInt(postPoint))));
			cHistoryVO.setMemId(memId);
			cHistoryVO.setcEventId("채택 보상 수정");
			coinService.insertCoinHistory(cHistoryVO);
		} else {
			msg = "실패";
		}
		
		req.setAttribute("msg", msg);
		
		// 4. 목록 조회화면으로 이동
//		req.getRequestDispatcher("/board/list.do").forward(req, resp);
		
		String redirectUrl = req.getContextPath() + "/freeboard.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
		if(boardId.equals("2")) {
			redirectUrl = req.getContextPath() + "/qaboard.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
		} else if (boardId.equals("3")) {
			redirectUrl = req.getContextPath() + "/freeboard.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");
		}
		
		resp.sendRedirect(redirectUrl); 
		
		
	}
}
