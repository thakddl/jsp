package qnaboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qnaboard.service.BoardServiceImpl;
import qnaboard.service.IboardService;
import qnaboard.vo.qnaBoardVO;

@WebServlet("/List.qnaBoard")
public class BoardList extends HttpServlet { 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IboardService service = BoardServiceImpl.getInstance();
		// 최종적으로 DB에 있던 List값이 boardList에 전달된다.
		List<qnaBoardVO> boardList = service.getList();
		// HttpServletRequest req에 속성값을 지정해준다.
		req.setAttribute("boardList", boardList);
		// JSP로 forward해주면 끝
		req.getRequestDispatcher("/views/qnaboard/qnaboard.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
