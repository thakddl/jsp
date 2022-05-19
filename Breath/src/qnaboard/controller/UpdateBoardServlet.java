package qnaboard.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qnaboard.service.BoardServiceImpl;
import qnaboard.service.IboardService;
import qnaboard.vo.qnaBoardVO;

@WebServlet("/update.qnaBoard")
@MultipartConfig(
		fileSizeThreshold = 1024*1024*3
		, maxFileSize = 1024*1024*40
		, maxRequestSize = 1024*1024*50)
public class UpdateBoardServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 파라미터정보 가져오기
		String post_num = req.getParameter("post_num");
		
		// 2. 서비스 객체 가져오기
		IboardService service = BoardServiceImpl.getInstance();

		// 3. 게시글
		qnaBoardVO bv = service.getContent(post_num);
		
		req.setAttribute("bv", bv);
		
		// 4. 업데이트 화면으로 포워딩
		req.getRequestDispatcher("/views/qnaboard/updateForm.jsp")
		.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청 파라미터 정보 가져오기
		
		String post_num = req.getParameter("post_num");
		String mem_id = req.getParameter("mem_id");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String v_pass = req.getParameter("v_pass");
		String ip_add = req.getParameter("ip_add");
		String status = req.getParameter("status");
		
		// 2. 서비스 객체 새성하기
		IboardService service = BoardServiceImpl.getInstance();

		// 3. 회원정보 등록
		qnaBoardVO bv = new qnaBoardVO();
		bv.setPost_num(post_num);
		bv.setMem_id(mem_id);
		bv.setTitle(title);
		bv.setContent(content);
		bv.setV_pass(v_pass);
		bv.setIp_add(ip_add);
		bv.setStatus(status);
		
		int cnt = service.updateBoard(bv);
		
		String msg = "";
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		req.setAttribute("msg", msg);
		
		// 4. 목록 조회화면으로 이동
//		req.getRequestDispatcher("/member/list.do")
//			.forward(req, resp);
		
		String redirectUrl = req.getContextPath()+"/List.qnaBoard?msg=" 
											+ URLEncoder.encode(msg,"UTF-8");
		
		resp.sendRedirect(redirectUrl); //목록조회화면으로 리다이렉트
	}
}
