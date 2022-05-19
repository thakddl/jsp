package Board.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Board.Service.BoardServiceImpl;
import Board.Service.IBoardService;
import Board.VO.BoardVO;

@WebServlet(value="/board/list.do")
public class DisplayBoardServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public DisplayBoardServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IBoardService boardService = BoardServiceImpl.getInstance();
		List<BoardVO> boardList = null;
//		System.out.println("list.do boardId=" + req.getParameter("boardId"));
		if(req.getParameter("boardId") == null) {
			boardList = boardService.displayBoard();
		} else {
			
//			boardList = boardService.displayBoard();
			if(req.getParameter("boardId").equals("2")) {
				boardList = boardService.displayBoard2("2");
			} else if(req.getParameter("boardId").equals("3")) {
				boardList = boardService.displayBoard2("3");
			} else if(req.getParameter("boardId").equals("1")) {
				boardList = boardService.displayBoard2("1");
			}
		}
		//게시판.jsp에서 보낸 현재페이지 값을 저장 
		req.setAttribute("nowPage", req.getParameter("nowPage"));
		
		//현재페이지 값에 맞는 에 맞는 리스트로 변환
		//변환에 필요한 변수선언
		if(boardList.size() > 0) {
			int nowPage = 1;
			if(req.getParameter("nowPage") != null) {
				nowPage = Integer.parseInt(req.getParameter("nowPage"));
			}
			int size = boardList.size(); //총포스트 숫자
			int perPage = 10;	// 페이지당 포스트 숫자
			int firstPost = (nowPage-1)*perPage; //페이지의 첫포스트의 순번(list기준)
			int lastPost = (firstPost+perPage)>=size?(size-1):(firstPost+perPage-1);
			//현재페이지에 맞는 리스트로 변환실행
			if(lastPost == size-1) {
				boardList.add(new BoardVO()); //마지막데이터를 가져오기 위한 더미데이터
				boardList = boardList.subList(firstPost, lastPost + 1);
			} else {
				boardList = boardList.subList(firstPost, lastPost + 1);
			}
			
			//페이징버튼 리스트 만들기
			List<String> pbList = new ArrayList<>();
			int totalPageQty = 
					size/perPage + ( (size%perPage) > 0 ? 1:0 ); //총페이지
			int pageLange = 5;
			int sPageNo = 
					( nowPage - pageLange/2 ) < 1 ?
						1 : ( nowPage - pageLange/2 ); //시작페이지
			int ePageNo = 
					( sPageNo + pageLange - 1 ) > totalPageQty ?
						totalPageQty : ( sPageNo + pageLange - 1 ); //끝페이지
			if(ePageNo == totalPageQty) {
				sPageNo = totalPageQty - pageLange + 1; 
				if(sPageNo < 1) {
					sPageNo = 1;
				}
			}
			if(sPageNo > 1) {
				pbList.add("pre");
			}
			for(int i = 1; i <= totalPageQty; i++) {
				if(i >= sPageNo && i <= ePageNo) {
					pbList.add(String.valueOf(i));
				}
			}
			if(ePageNo < totalPageQty) {
				pbList.add("next");
			}
			req.setAttribute("pbList", pbList);
			req.setAttribute("pageLange", String.valueOf(pageLange) );
			req.setAttribute("totalPageQty", String.valueOf(totalPageQty) );
		}
		req.setAttribute("boardList", boardList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/list.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int sPage = Integer.parseInt(req.getParameter("page"));
		
		// 서비스 객체 얻어오기
		IBoardService service = BoardServiceImpl.getInstance();
		
		// 화면에 출력할 페이지 수
		int perPage = 2;
		
		// 한 페이지에 출력할 글 갯수
		int perList = 5;
		
		// 전체 글 갯수 데이터 얻기 - service객체 필요
		int count = service.countList();
		
		// [공식] 전체 페이지 수 계산 - 전체 페이지 수 = 전체 글 갯수/ 페이지 당 글 갯수
		// double로 소수점을 발생시켜 정확한 결과 값을 얻는다.
		int totalPage = (int) Math.ceil((double)count / (double)perList);
		
//		System.out.println("double 사용>>> " + (double)21 / (double)perList);
//		System.out.println("double 미사용>>> " + 21 / perList);
		
		// 페이지 별 게시글의 시작(start)과 끝(end) 값
		// [공식] 시작 값 구하기 (sPage(초기 시작 페이지) - 1) * perList + 1
		// [예시] sPage가 1일 때 : (1-1)*5+1 = 1
		// [예시] sPage가 2일 때 : (2-1)*5+1 = 6
		// [예시] sPage가 3일 때 : (3-1)*5+1 = 11
		// [예시] sPage가 4일 때 : (4-1)*5+1 = 16
		int start = (sPage - 1) * perList + 1;
		
		// [공식] 끝 값 구하기 start + perList - 1
		// [예시] sPage가 1일 때 : 1 + 5 - 1 = 5
		// [예시] sPage가 2일 때 : 6 + 5 - 1 = 10
		// [예시] sPage가 3일 때 : 11 + 5 - 1 = 15
		// [예시] sPage가 4일 때 : 16 + 5 - 1 = 20
		int end = start + perList - 1;
		// end = perList(현재 페이지에 표현될 글 갯수) * sPage(현재 페이지)로 사용가능
		
		// end 값이 count값보다 크게 계산되었을 경우, count값을 end값에 대입한다.
		if(end > count) end = count;
		
		// 화면에 보여지는 페이지 번호(startPage, endPage) 구하기
		// [공식] (sPage - 1) / perPage * perPage) +1;
		// [예시] sPage가 1일 때 : ((1 - 1) / 2 * 2) + 1 = 1
		// [예시] sPage가 2일 때 : ((2 - 1) / 2 * 2) + 1 = 1
		// [예시] sPage가 3일 때 : ((3 - 1) / 2 * 2) + 1 = 3
		// [예시] sPage가 4일 때 : ((4 - 1) / 2 * 2) + 1 = 3
		
		int startPage = ((sPage - 1) / perPage * perPage) + 1;
		
		// [공식] startPage + perPage) -1;
		// [예시] sPage 1,2일때 : 1 + 2 -1 = 2;
		// [예시] sPage 3,4일때 : 3 + 2 -1 = 2;
		int endPage = startPage + perPage -1;
		
		// 객체 접근하여 메소드 호출하고 결과 값(리스트 데이터) 받기 -
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		service.boardList(map);
		
		
		List<BoardVO> list = service.boardList(map);
		
		// request에 저장하고 jsp로 포워딩
		req.setAttribute("list", list);
		req.setAttribute("sPage", startPage);
		req.setAttribute("ePage", endPage);
		req.setAttribute("ttPage", totalPage);
		
		req.getRequestDispatcher("/board/list.jsp").forward(req, resp);
		
		
		
		
	}
}
