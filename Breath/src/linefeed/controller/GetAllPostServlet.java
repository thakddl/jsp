package linefeed.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import linefeed.service.ILineFeedService;
import linefeed.service.LineFeedServiceImpl;
import linefeed.vo.LineFeedVO;

@WebServlet("/getAllPostList.LineFeed")
public class GetAllPostServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청 파라미터 가져오기
		String trainerId = req.getParameter("trainerId");

		// 2. 서비스 객체 생성하기

		ILineFeedService service = LineFeedServiceImpl.getInstance();
		LineFeedVO lv = new LineFeedVO();

		// 3. 라인피드 게시물 출력
		lv.setTrainerId("destiny");
		
		List<LineFeedVO> lineFeedList = new ArrayList<LineFeedVO>();
		lineFeedList = service.getAllPostList(lv);
		
		req.setAttribute("lineFeedList", lineFeedList);
		
		req.getRequestDispatcher("/views/linefeed/jsp/list.jsp").forward(req, resp);
	}
}
