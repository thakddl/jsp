package qnaboard.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.service.AtchFileServiceImpl;
import common.service.IAtchFileService;
import common.vo.AtchFileVO;
import member.vo.MemberVO;
import qnaboard.service.BoardServiceImpl;
import qnaboard.service.IboardService;
import qnaboard.vo.qnaBoardVO;

@WebServlet("/insert.qnaBoard")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 3, maxFileSize = 1024 * 1024 * 40, maxRequestSize = 1024 * 1024 * 50)
public class InsertBoardServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberVO mv = (MemberVO) session.getAttribute("memVO");
		req.setAttribute("memVO", mv);
		
		req.getRequestDispatcher("/views/qnaboard/insertForm.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberVO mv = (MemberVO) session.getAttribute("memVO");
		
		// 1. 요청 파라미터 정보 가져오기
		String mem_id = mv.getMemId();
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String v_pass = req.getParameter("v_pass");

		// 2. 서비스 객체 새성하기
		IboardService boardService = BoardServiceImpl.getInstance();

		// 3. 게시물 등록
		qnaBoardVO bv = new qnaBoardVO();
		bv.setMem_id(mem_id);
		bv.setTitle(title);
		bv.setContent(content);
		bv.setV_pass(v_pass);

		int cnt = boardService.insertBoard(bv);
		String msg = "";
		if (cnt > 0) {
			msg = "성공";
		} else {
			msg = "실패";
		}
		req.setAttribute("memVO", mv);
		// req.setAttribute("msg", msg);

		// 4. 목록 조회화면으로 이동
		// req.getRequestDispatcher("/member/list.do")
		// .forward(req, resp);
		String redirectUrl = req.getContextPath() + "/List.qnaBoard?msg=" + URLEncoder.encode(msg, "UTF-8");

		resp.sendRedirect(redirectUrl); // 목록조회화면으로 리다이렉트
	}
}
