package clientMyPage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Util.SHA256;
import clientMyPage.service.ClientMyPageServiceImpl;
import clientMyPage.service.IClientMyPageService;
import clientMyPage.vo.ClientMyPageVO;

@WebServlet("/client/UpdateMypage.do")
public class UpdateMyPageController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		IClientMyPageService service = ClientMyPageServiceImpl.getInstance();

		String memId = session.getAttribute("memId")+"";
		ClientMyPageVO mypageVo = service.getMyPage(memId);
		
		
		String page =null;
		if(mypageVo!=null) {
			page = "/readmore.jsp";
			req.setAttribute("mypageVo", mypageVo);
		} else {
			req.setAttribute("updateMsg", "회원 조회에 실패했습니다.");
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(page);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IClientMyPageService service = ClientMyPageServiceImpl.getInstance();
		ClientMyPageVO mypageVo = new ClientMyPageVO();

		String memId = req.getParameter("id");
		String inpuPass = req.getParameter("memPass");
		String hashingPass = SHA256.encodeSha256(inpuPass);
		String memName = req.getParameter("memName");
		String memBir = req.getParameter("memBir");
		String memMail = req.getParameter("memMail");
		String memTel = req.getParameter("memTel");
		String memZip = req.getParameter("memZip");
		String memAdd1 = req.getParameter("memAdd1");
		String memAdd2 = req.getParameter("memAdd2");

		mypageVo.setMemId(memId);
		mypageVo.setMemPass(hashingPass);
		mypageVo.setMemName(memName);
		mypageVo.setMemBir(memBir);
		mypageVo.setMemMail(memMail);
		mypageVo.setMemTel(memTel);
		mypageVo.setMemZip(memZip);
		mypageVo.setMemAdd1(memAdd1);
		mypageVo.setMemAdd2(memAdd2);

		req.setAttribute("mypageVo", mypageVo);
		int cnt = service.updateMyPage(mypageVo);
		String updateMsg = "";

		if (cnt > 0) {
			updateMsg = "성공";
		} else {
			updateMsg = "실패";
		}
		req.setAttribute("updateMsg", updateMsg);
		
		req.getRequestDispatcher("/readmore.jsp").forward(req, resp);
	}
}
