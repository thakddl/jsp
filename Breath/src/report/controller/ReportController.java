package report.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import report.vo.ReportVO;
import linefeed.service.ILineFeedService;
import linefeed.service.LineFeedServiceImpl;
import linefeed.vo.LineFeedVO;
import member.vo.MemberVO;
import report.service.IReportService;
import report.service.ReportServiceImpl;

@WebServlet("/insert.Report")
public class ReportController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청파라미터 가져오기
//		MemberVO mv = (MemberVO) req.getSession();
//		String rprtId  = mv.getMemId();
		// 임시 하드코딩
		String rprtId = "a100";
		
		// String trainerId = req.getParameter("trainerId");
		String rprtRsn = req.getParameter("rprtRsn");
		String rprtDId = req.getParameter("rprtDId");
		// 신고시 기본 상태코드
		String rprtStatus = "1";
		ReportVO rv = new ReportVO();
		
		rv.setRprtId(rprtId);
		rv.setRprtRsn(rprtRsn);
		rv.setRprtDId(rprtDId);
		rv.setRprtDt("SYSDATE");
		rv.setRprtStatus(rprtStatus);
		
		// 3.서비스 객체 생성
		IReportService reportService = ReportServiceImpl.getInstance();
		ILineFeedService service = LineFeedServiceImpl.getInstance();
		LineFeedVO lv = new LineFeedVO();
		
		// 신고이력 추가
		try {
			reportService.insertReport(rv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 4. 라인피드 게시물 출력
		String trainerId = "destiny";
		
		lv.setTrainerId(trainerId);
		List<LineFeedVO> lineFeedList = new ArrayList<LineFeedVO>();
		lineFeedList = service.getAllPostList(lv);
		
		req.setAttribute("lineFeedList", lineFeedList);
		
		req.getRequestDispatcher("/views/linefeed/jsp/list.jsp").forward(req, resp);
		
	}

}
