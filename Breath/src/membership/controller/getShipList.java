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

import membership.service.IMembershipService;
import membership.service.MembershipServiceImpl;
import membership.vo.MembershipVO;

@WebServlet("/getShipList.do")
public class getShipList extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 세션에서 필요한 정보 가져오기
		HttpSession session = req.getSession();
		String memId = (String)session.getAttribute("memId");
		
		IMembershipService service = MembershipServiceImpl.getInstance();
		
		List<MembershipVO> list = new ArrayList<>();
		
		list = service.getShipList(memId);
		
		req.getRequestDispatcher("/views/membership/getShipList.jsp").forward(req, resp);
	}	
}
