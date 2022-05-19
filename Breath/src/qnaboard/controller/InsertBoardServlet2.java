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

@WebServlet("/Binsert.qnaBoard")
@MultipartConfig(
		fileSizeThreshold = 1024*1024*3
		, maxFileSize = 1024*1024*40
		, maxRequestSize = 1024*1024*50)
public class InsertBoardServlet2 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청 파라미터 정보 가져오기
		String mem_id = req.getParameter("mem_id");
		String title = req.getParameter("title");
		String v_pass = req.getParameter("v_pass");
		String content = req.getParameter("content");

		
		// 2. 서비스 객체 새성하기
		IboardService boardService = BoardServiceImpl.getInstance();

		// 3. 게시물 등록
		qnaBoardVO bv = new qnaBoardVO();
		bv.setMem_id(mem_id);
		bv.setTitle(title);
		bv.setV_pass(v_pass);
		bv.setContent(content);
		
		HttpSession session = req.getSession();
		MemberVO mv = (MemberVO) session.getAttribute("memVO");
		req.setAttribute("memVO", mv);

		// 4. 목록 조회화면으로 이동
//		req.getRequestDispatcher("/member/list.do")
//			.forward(req, resp);
		String redirectUrl = req.getContextPath()+"/insert.qnaBoard";
		
		resp.sendRedirect(redirectUrl); //목록조회화면으로 리다이렉트
	}
}
