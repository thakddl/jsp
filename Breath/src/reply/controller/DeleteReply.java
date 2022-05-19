package reply.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.vo.MemberVO;
import reply.service.ILineFeedReplyService;
import reply.service.LineFeedReplyServiceImpl;
import reply.vo.ReplyVO;

@WebServlet("/delete.Reply")
public class DeleteReply extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청정보 받아오기
		
				// 현재페이지의 url 주소 가져오기
//				String url = getRequestURL(req).toString();
				
				String commNum = req.getParameter("commNum");
				String lnfdNum = req.getParameter("lnfdNum");
				String url = req.getParameter("url");
				
				// 해당 트레이너 채널에서 트레이너 아이디 가져오기
				String trainerId = url.substring(url.indexOf("="));
				
				String ipAdd = req.getRemoteAddr();
				
				// 로그인한 회원 정보 가져오기
				HttpSession session = req.getSession();
				MemberVO mv = (MemberVO) session.getAttribute("memVO");
				String memId = mv.getMemId();

				
				// 2. 서비스 객체 호출하기
				ILineFeedReplyService service = LineFeedReplyServiceImpl.getInstance();
				
				// 3. 댓글 입력하기
				ReplyVO rv = new ReplyVO();
				rv.setMemId(memId);
				rv.setCommentNum(commNum);
				rv.setStatus("4");
				rv.setIpAdd(ipAdd);
				
				try {
					service.deleteReply(rv);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				// 4. 댓글 입력 후 게시판 가져오기
				ReplyVO rv2 = new ReplyVO();
				rv2.setPostNum(lnfdNum);
				
				List<ReplyVO> replyList = new ArrayList<ReplyVO>();
				try {
					replyList = service.getAllReply(rv2);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				req.setAttribute("replyList", replyList);
				
				req.getRequestDispatcher("/views/linefeed/jsp/replyList.jsp").forward(req, resp);
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}
