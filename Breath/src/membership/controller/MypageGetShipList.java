package membership.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.MembershipService;
import org.apache.catalina.tribes.membership.Membership;

import member.service.MemberServiceImpl;
import member.vo.MemberVO;
import membership.service.IMembershipService;
import membership.service.MembershipServiceImpl;
import membership.vo.MembershipVO;

@WebServlet("/getShipList")
public class MypageGetShipList extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IMembershipService service = MembershipServiceImpl.getInstance();
		// 세션에서 필요한 정보 가져오기
		HttpSession session = req.getSession();
		MemberVO vo = (MemberVO) session.getAttribute("memVO"); 
		String clientId = vo.getMemId();
		List<MembershipVO> msv = (List<MembershipVO>) service.getShipList(clientId);
		req.setAttribute("msv", msv);
		req.getRequestDispatcher("/views/mypage/mypagegetshiplist.jsp").forward(req, resp);
	}	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
}
