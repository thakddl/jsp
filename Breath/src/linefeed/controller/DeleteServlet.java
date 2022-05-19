package linefeed.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import linefeed.service.ILineFeedService;
import linefeed.service.LineFeedServiceImpl;
import linefeed.vo.LineFeedVO;

@WebServlet("/delete.LineFeed")
public class DeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청 파라미터 정보 가져오기
		String lnfdNum = req.getParameter("lnfdNum");
		
		// 2. 서비스 객체 생성하기
		ILineFeedService service = LineFeedServiceImpl.getInstance();
		
		// 3. 게시글 삭제하기
		String status = "4"; // DB 상 삭제된 게시글의 status 정보는 4
		String trainerId = "destiny";
		
		
		LineFeedVO lv = new LineFeedVO();
		lv.setLnfdNum(lnfdNum);
		lv.setStatus(status);
		
		// 4. 삭제 성공 후 라인피드를 다시 가져오기
		int result = service.deleteLineFeed(lv);
		
		List<LineFeedVO> lineFeedList = new ArrayList<LineFeedVO>();
		
		LineFeedVO lv2 = new LineFeedVO();
		lv2.setTrainerId(trainerId);

		lineFeedList = service.getAllPostList(lv2);
		req.setAttribute("lineFeedList", lineFeedList);
		
		// 5. 게시물 리스트 화면 출력
		req.getRequestDispatcher("/views/linefeed/jsp/list.jsp").forward(req, resp);
		
	}
}
